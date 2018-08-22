package net.tardis.mod.common.screwdriver;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IScrew {

	/*
	 * This method is called in onRightClick
	 */
	void performAction(World world, EntityPlayer player, EnumHand hand);

	/*
	 * This method is called in onItemUse
	 */
	void blockInteraction(World world, BlockPos pos, IBlockState state, EntityPlayer player);

	/*
	 * Interaction for entities
	 */
	void entityInteraction(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand hand);

	/*
	 * Returns the name of the sonic function
	 */
	String getName();
}
