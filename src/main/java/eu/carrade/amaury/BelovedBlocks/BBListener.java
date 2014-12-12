package eu.carrade.amaury.BelovedBlocks;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class BBListener implements Listener {
	
	private BelovedBlocks p = null;
	
	public BBListener(BelovedBlocks plugin) {
		p = plugin;
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent ev) {
		if(!ev.hasBlock() || !ev.hasItem()) return;
		
		ItemStack item = ev.getItem();
		Block block = ev.getClickedBlock();
		Material type = block.getType();
		Player player = ev.getPlayer();
		
		if(p.isValidTool(item)) {
			
			if((type == Material.DOUBLE_STEP || type == Material.DOUBLE_STONE_SLAB2)
					&& ev.getAction() == Action.RIGHT_CLICK_BLOCK) {
				
				block.setData((byte) (ev.getClickedBlock().getData() + 8));
				
				// Durability
				if(player.getGameMode() != GameMode.CREATIVE) {
					short newDurability = (short) (item.getDurability()
							+ p.increaseDurability(item.getEnchantmentLevel(Enchantment.DURABILITY)));
					
					item.setDurability(newDurability);
					player.getInventory().setItemInHand(item);
					player.updateInventory();
				}
				
				ev.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onInventoryClick(final InventoryClickEvent ev) {
		if(ev.getInventory() instanceof CraftingInventory && ev.getSlot() == 0) {
			p.getServer().getScheduler().runTaskLater(p, new Runnable() {

				@Override
				public void run() {
					for(HumanEntity viewer : ev.getViewers()) {
						if(viewer instanceof Player) {
							((Player) viewer).updateInventory();
						}
					}
				}
					
			}, 1l);
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) throws InterruptedException {
		if(e.getBlockPlaced().getType() == Material.STEP){
			if(e.getItemInHand().getDurability() == 0){
				String str = ChatColor.RESET + p.getConfig().getString("blocks.slabs.stone.name");
				if(str.equals(e.getItemInHand().getItemMeta().getDisplayName())){
					e.getBlockPlaced().setType(Material.DOUBLE_STEP);
					e.getBlockPlaced().setData((byte) 8);
				}
			}
			if(e.getItemInHand().getDurability() == 1){
				String str = ChatColor.RESET + p.getConfig().getString("blocks.slabs.sandstone.name");
				int INT = str.hashCode();
				if(e.getItemInHand().getItemMeta().getDisplayName().hashCode() == INT){
					e.getBlockPlaced().setType(Material.DOUBLE_STEP);
					e.getBlockPlaced().setData((byte) 9);
				}
			}
		}
		
		if(e.getBlockPlaced().getType() == Material.STONE_SLAB2){
			if(e.getItemInHand().getDurability() == 0){
				String str = ChatColor.RESET + p.getConfig().getString("blocks.slabs.red_sandstone.name");
				int INT = str.hashCode();
				if(e.getItemInHand().getItemMeta().getDisplayName().hashCode() == INT){
					e.getBlockPlaced().setType(Material.DOUBLE_STONE_SLAB2);
					e.getBlockPlaced().setData((byte) 8);
				}
			}
		}
	}
}
