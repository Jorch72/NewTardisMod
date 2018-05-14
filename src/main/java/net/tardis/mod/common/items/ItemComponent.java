package net.tardis.mod.common.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.tardis.mod.info.CrashType;

/**
 * All TARDIS Components must extend this class
 * @author Spectre
 *
 */
public abstract class ItemComponent extends Item{

	public ItemComponent() {}
	
	
	public abstract ItemStack damageItem(CrashType type,ItemStack stack);
	
	
}
