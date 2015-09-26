/**
 * Plugin BelovedBlocks Copyright (C) 2014-2015 Amaury Carrade & Florian Cassayre <p/> This program
 * is free software: you can redistribute it and/or modify it under the terms of the GNU General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version. <p/> This program is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details. <p/> You should
 * have received a copy of the GNU General Public License along with this program.  If not, see
 * [http://www.gnu.org/licenses/].
 */


package eu.carrade.amaury.BelovedBlocks.blocks.stones;

import eu.carrade.amaury.BelovedBlocks.blocks.*;
import eu.carrade.amaury.BelovedBlocks.utils.*;
import org.bukkit.*;
import org.bukkit.inventory.*;

import java.util.*;


public class SmoothRedSandstoneBlock extends BelovedBlock
{

	public SmoothRedSandstoneBlock()
	{
		super("blocks.slabs.red_sandstone");

		setInternalName("red-sandstone");
	}

	@Override
	public ItemStack getItem()
	{
		ItemStack smoothRedSandstone = new ItemStack(Material.RED_SANDSTONE);
		smoothRedSandstone.setDurability((short) 2);

		return smoothRedSandstone;
	}

	@Override
	public Set<Recipe> getCraftingRecipes()
	{
		return RecipesUtils.getSquaredRecipes(getIngredient(), constructItem(2));
	}

	@Override
	public Integer getMatterRatio()
	{
		return 2;
	}

	@Override
	public ItemStack getIngredient()
	{
		return new ItemStack(Material.STONE_SLAB2);
	}

	@Override
	public SimpleBlock getPlacedBlock()
	{
		return new SimpleBlock(Material.DOUBLE_STONE_SLAB2, 8);
	}
}
