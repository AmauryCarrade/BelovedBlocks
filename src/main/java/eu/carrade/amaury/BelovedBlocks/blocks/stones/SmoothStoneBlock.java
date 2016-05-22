/**
 * Plugin BelovedBlocks Copyright (C) 2014-2015 Amaury Carrade & Florian Cassayre
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program.  If
 * not, see [http://www.gnu.org/licenses/].
 */
package eu.carrade.amaury.BelovedBlocks.blocks.stones;

import eu.carrade.amaury.BelovedBlocks.BBConfig;
import eu.carrade.amaury.BelovedBlocks.blocks.WorldBlock;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

public class SmoothStoneBlock extends SmoothDoubleSlab
{

    public SmoothStoneBlock()
    {
        super("stone", Material.STONE, 6, BBConfig.BLOCKS.SLABS.STONE);
    }

    @Override
    public ItemStack getIngredient()
    {
        return new ItemStack(Material.STEP);
    }

    @Override
    public WorldBlock getPlacedBlock(BlockFace facing)
    {
        return new WorldBlock(Material.DOUBLE_STEP, 8);
    }
}
