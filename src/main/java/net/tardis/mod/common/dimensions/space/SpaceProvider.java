package net.tardis.mod.common.dimensions.space;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.tardis.mod.client.renderers.sky.RenderVoid;
import net.tardis.mod.common.dimensions.TDimensions;

public class SpaceProvider extends WorldProvider{

	public SpaceProvider() {}
	
	@Override
	public DimensionType getDimensionType() {
		return TDimensions.spaceType;
	}

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorSpace(this.world);
	}

	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		return 0.5F;
	}

	@Override
	public boolean canRespawnHere() {
		return false;
	}

	@Override
	public float getCloudHeight() {
		return 1000;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IRenderHandler getCloudRenderer() {
        return new RenderVoid();
	}

	@Override
	public boolean shouldMapSpin(String entity, double x, double z, double rotation) {
		return true;
	}

	@Override
	public void calculateInitialWeather() {}

	@Override
	public void updateWeather() {}

	@Override
	public boolean canBlockFreeze(BlockPos pos, boolean byWater) {
		return false;
	}

	@Override
	public void onPlayerAdded(EntityPlayerMP player) {
		super.onPlayerAdded(player);
		player.setNoGravity(true);
	}

	@Override
	public void onPlayerRemoved(EntityPlayerMP player) {
		super.onPlayerRemoved(player);
		player.setNoGravity(false);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IRenderHandler getSkyRenderer() {
		return new RenderSpace();
	}
	
	@Override
	public WorldSleepResult canSleepAt(EntityPlayer player, BlockPos pos) {
		return WorldSleepResult.DENY;
	}

}
