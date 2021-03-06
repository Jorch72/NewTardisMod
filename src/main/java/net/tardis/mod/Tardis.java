package net.tardis.mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;
import net.tardis.mod.api.disguise.DisguiseRegistry;
import net.tardis.mod.client.models.exteriors.TileEntityDoorTT;
import net.tardis.mod.common.blocks.TBlocks;
import net.tardis.mod.common.commands.CommandDebug;
import net.tardis.mod.common.commands.CommandTardis;
import net.tardis.mod.common.dimensions.TDimensions;
import net.tardis.mod.common.dimensions.TDimensions.BiomeReg;
import net.tardis.mod.common.entities.EntityAdipose;
import net.tardis.mod.common.entities.EntityChair;
import net.tardis.mod.common.entities.EntityCompanion;
import net.tardis.mod.common.entities.EntityCorridor;
import net.tardis.mod.common.entities.EntityCybermanInvasion;
import net.tardis.mod.common.entities.EntityCybermanTomb;
import net.tardis.mod.common.entities.EntityDalek;
import net.tardis.mod.common.entities.EntityDalekCasing;
import net.tardis.mod.common.entities.EntityDalekSkaro;
import net.tardis.mod.common.entities.EntityLaserRay;
import net.tardis.mod.common.entities.EntityQuark;
import net.tardis.mod.common.entities.controls.ControlDimChange;
import net.tardis.mod.common.entities.controls.ControlDirection;
import net.tardis.mod.common.entities.controls.ControlDoor;
import net.tardis.mod.common.entities.controls.ControlDoorSwitch;
import net.tardis.mod.common.entities.controls.ControlFastReturn;
import net.tardis.mod.common.entities.controls.ControlFuel;
import net.tardis.mod.common.entities.controls.ControlLandType;
import net.tardis.mod.common.entities.controls.ControlLaunch;
import net.tardis.mod.common.entities.controls.ControlMag;
import net.tardis.mod.common.entities.controls.ControlMonitor;
import net.tardis.mod.common.entities.controls.ControlPhone;
import net.tardis.mod.common.entities.controls.ControlRandom;
import net.tardis.mod.common.entities.controls.ControlSonicSlot;
import net.tardis.mod.common.entities.controls.ControlStabilizers;
import net.tardis.mod.common.entities.controls.ControlTelepathicCircuts;
import net.tardis.mod.common.entities.controls.ControlWaypoint;
import net.tardis.mod.common.entities.controls.ControlX;
import net.tardis.mod.common.entities.controls.ControlY;
import net.tardis.mod.common.entities.controls.ControlZ;
import net.tardis.mod.common.entities.hellbent.EntityHellbentCorridor;
import net.tardis.mod.common.entities.hellbent.EntityHellbentDoor;
import net.tardis.mod.common.entities.vehicles.EntityBessie;
import net.tardis.mod.common.items.TItems;
import net.tardis.mod.common.protocols.ProtocolCCircuit;
import net.tardis.mod.common.protocols.ProtocolConsole;
import net.tardis.mod.common.protocols.ProtocolEnabledHADS;
import net.tardis.mod.common.protocols.ProtocolFindDimDRfit;
import net.tardis.mod.common.protocols.ProtocolLock;
import net.tardis.mod.common.protocols.ProtocolRegenRoom;
import net.tardis.mod.common.protocols.ProtocolRepair;
import net.tardis.mod.common.protocols.ProtocolSystemReadout;
import net.tardis.mod.common.protocols.ProtocolWaypoints;
import net.tardis.mod.common.protocols.TardisProtocol;
import net.tardis.mod.common.recipes.RepairRecipes;
import net.tardis.mod.common.screwdriver.ScrewdriverHandler;
import net.tardis.mod.common.strings.TStrings;
import net.tardis.mod.common.systems.SystemAntenna;
import net.tardis.mod.common.systems.SystemCCircuit;
import net.tardis.mod.common.systems.SystemDimension;
import net.tardis.mod.common.systems.SystemFlight;
import net.tardis.mod.common.systems.SystemFluidLinks;
import net.tardis.mod.common.systems.SystemStabilizers;
import net.tardis.mod.common.systems.SystemTemporalGrace;
import net.tardis.mod.common.systems.TardisSystems;
import net.tardis.mod.common.tileentity.TileEntityAlembic;
import net.tardis.mod.common.tileentity.TileEntityAlembic.AlembicRecipe;
import net.tardis.mod.common.tileentity.TileEntityComponentRepair;
import net.tardis.mod.common.tileentity.TileEntityDoor;
import net.tardis.mod.common.tileentity.TileEntityEPanel;
import net.tardis.mod.common.tileentity.TileEntityFoodMachine;
import net.tardis.mod.common.tileentity.TileEntityHellbentLight;
import net.tardis.mod.common.tileentity.TileEntityHoloprojector;
import net.tardis.mod.common.tileentity.TileEntityInteriorDoor;
import net.tardis.mod.common.tileentity.TileEntityJsonTester;
import net.tardis.mod.common.tileentity.TileEntityLight;
import net.tardis.mod.common.tileentity.TileEntityMultiblock;
import net.tardis.mod.common.tileentity.TileEntityMultiblockMaster;
import net.tardis.mod.common.tileentity.TileEntitySonicGun;
import net.tardis.mod.common.tileentity.TileEntityTardis;
import net.tardis.mod.common.tileentity.TileEntityTardisCoral;
import net.tardis.mod.common.tileentity.TileEntityUmbrellaStand;
import net.tardis.mod.common.tileentity.consoles.TileEntityTardis01;
import net.tardis.mod.common.tileentity.consoles.TileEntityTardis02;
import net.tardis.mod.common.tileentity.consoles.TileEntityTardis03;
import net.tardis.mod.common.tileentity.decoration.TileEntityAmSphere;
import net.tardis.mod.common.tileentity.decoration.TileEntityChair;
import net.tardis.mod.common.tileentity.decoration.TileEntityHelbentRoof;
import net.tardis.mod.common.tileentity.decoration.TileEntityHellbentMonitor;
import net.tardis.mod.common.tileentity.decoration.TileEntityHellbentPole;
import net.tardis.mod.common.tileentity.exteriors.TileEntityDoor01;
import net.tardis.mod.common.tileentity.exteriors.TileEntityDoor03;
import net.tardis.mod.common.tileentity.exteriors.TileEntityDoor04;
import net.tardis.mod.common.tileentity.exteriors.TileEntityDoor05;
import net.tardis.mod.common.tileentity.exteriors.TileEntityDoorCC;
import net.tardis.mod.common.tileentity.exteriors.TileEntityDoorClock;
import net.tardis.mod.common.tileentity.exteriors.TileEntityDoorWood;
import net.tardis.mod.common.world.TardisLoadingCallback;
import net.tardis.mod.common.world.WorldGenTardis;
import net.tardis.mod.config.TardisConfig;
import net.tardis.mod.handlers.GuiHandlerTardis;
import net.tardis.mod.integrations.Galacticraft;
import net.tardis.mod.network.NetworkHandler;
import net.tardis.mod.proxy.ServerProxy;
import net.tardis.mod.util.common.helpers.EntityHelper;


@Mod(modid = Tardis.MODID, name = Tardis.NAME, version = Tardis.VERSION, dependencies = Tardis.DEP, updateJSON = Tardis.UPDATE_JSON_URL)
public class Tardis {

	public static final String MODID = "tardis";
	public static final String NAME = "Tardis Mod";
	public static final String DEP = "after:ic2, galacticraftcore, " + TStrings.ModIds.WEEPING_ANGELS + "; required-after:forge@[14.23.2.2638,)";
	public static final String VERSION = "0.0.8A";
	public static final String UPDATE_JSON_URL = "https://raw.githubusercontent.com/Spectre0987/TardisMod/master/update.json";

	public static Logger LOG = LogManager.getLogger(NAME);

	public static boolean hasIC2 = false;
	public static final boolean updateChangesConfig = true;
	
	public static DamageSource SUFFICATION = new DamageSource("damage.noair");

	@Instance(MODID)
	public static Tardis instance;

	@SidedProxy(clientSide = "net.tardis.mod.proxy.ClientProxy", serverSide = "net.tardis.mod.proxy.ServerProxy")
	public static ServerProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit();
		hasIC2 = Loader.isModLoaded(TStrings.ModIds.INDUSTRIAL_CRAFT);
		if (Loader.isModLoaded(TStrings.ModIds.GALACTICRAFT)) Galacticraft.preInit();
		TItems.init();
		TBlocks.register();
		BiomeReg.init();
		EntityHelper.makeGoodBiomes();
		EntityHelper.registerStatic(ControlLaunch.class, "launch_lever");
		EntityHelper.registerStatic(ControlX.class, "x_valve");
		EntityHelper.registerStatic(ControlY.class, "y_valve");
		EntityHelper.registerStatic(ControlZ.class, "z_valve");
		EntityHelper.registerStatic(ControlDimChange.class, "dim_change");
		EntityHelper.registerStatic(ControlRandom.class, "rand_control");
		EntityHelper.registerStatic(ControlDoor.class, "tardis_door");
		EntityHelper.registerStatic(ControlFuel.class, "fuel");
		EntityHelper.registerStatic(ControlLandType.class, "land_type");
		EntityHelper.registerStatic(ControlDirection.class, "direction_control");
		EntityHelper.registerStatic(ControlFastReturn.class, "tardis_fast_return");
		EntityHelper.registerStatic(ControlTelepathicCircuts.class, "telepathic_circuts");
		EntityHelper.registerStatic(ControlDoorSwitch.class, "tardis_door_control");
		EntityHelper.registerStatic(ControlPhone.class, "tardis_phone");
		EntityHelper.registerStatic(ControlMag.class, "tardis_magnitude");
		EntityHelper.registerStatic(ControlSonicSlot.class, "sonic_slot");
		EntityHelper.registerStatic(ControlStabilizers.class, "stabilizers");
		EntityHelper.registerStatic(ControlMonitor.class, "monitor");
		EntityHelper.registerStatic(ControlWaypoint.class, "waypoint_select");
		EntityHelper.registerProjectiles(EntityLaserRay.class, "cyber_ray");
		EntityHelper.registerNoSpawn(EntityCorridor.class, "toyota_corridor");
		EntityHelper.registerNoSpawn(EntityDalekCasing.class, "dalek_casing");
		EntityHelper.registerNoSpawn(EntityHellbentCorridor.class, "hellbent_corridor");
		EntityHelper.registerNoSpawn(EntityHellbentDoor.class, "hellbent_door");
		EntityHelper.registerNoSpawn(EntityBessie.class, "bessie");
		EntityHelper.registerNoSpawn(EntityCompanion.class, "companion");
		EntityHelper.registerNoSpawn(EntityDalekSkaro.class, "dalek_scaro");
		EntityHelper.registerStatic(EntityChair.class, "chair");
		
		registerTileEntity(TileEntityTardis.class, "TileEntityTardis");
		registerTileEntity(TileEntityDoor.class, "TileEntityDoor");
		registerTileEntity(TileEntityUmbrellaStand.class, "TileEntityUmbrellaStand");
		registerTileEntity(TileEntityAlembic.class, "TileEntityAlembic");
		registerTileEntity(TileEntityFoodMachine.class, "TileEntityFoodMachine");
		registerTileEntity(TileEntityEPanel.class, "TileEntityEPanel");
		registerTileEntity(TileEntityHoloprojector.class, "TileEntityHoloprojector");
		registerTileEntity(TileEntityTardisCoral.class, "TileEntityTardisCoral");
		registerTileEntity(TileEntityLight.class, "TileEntityLight");
		registerTileEntity(TileEntityHellbentLight.class, "TileEntityHellbentLight");
		registerTileEntity(TileEntityHellbentMonitor.class, "TileEntityHellbentMonitor");
		registerTileEntity(TileEntityHellbentPole.class, "TileEntityHellbentPole");
		registerTileEntity(TileEntityHelbentRoof.class, "Tile	EntityHelbentRoof");
		registerTileEntity(TileEntityComponentRepair.class, "TileEntityComponentRepair");
		registerTileEntity(TileEntitySonicGun.class, "TileEntitySonicGun");
		registerTileEntity(TileEntityChair.class, "chair");
		registerTileEntity(TileEntityAmSphere.class, "am_sphere");
		
		registerTileEntity(TileEntityMultiblockMaster.class, "multi_master");
		registerTileEntity(TileEntityMultiblock.class, "multi");
		
		registerTileEntity(TileEntityInteriorDoor.class, "TileEntityInteriorDoor");
		
		registerTileEntity(TileEntityJsonTester.class, "TileEntityJsonTester");
		
		//Exteriors
		registerTileEntity(TileEntityDoor01.class, "TileEntityDoor01");
		registerTileEntity(TileEntityDoor03.class, "TileEntityDoor03");
		registerTileEntity(TileEntityDoor04.class, "TileEntityDoor04");
		registerTileEntity(TileEntityDoor05.class, "TileEntityDoor05");
		registerTileEntity(TileEntityDoorCC.class, "TileEntityDoorCC");
		registerTileEntity(TileEntityDoorClock.class, "TileEntityDoorClock");
		registerTileEntity(TileEntityDoorTT.class, "TileEntityDoorTT");
		registerTileEntity(TileEntityDoorWood.class, "TileEntityDoorWood");
		
		//Interiors
		registerTileEntity(TileEntityTardis01.class, "TileEntityTardis01");
		registerTileEntity(TileEntityTardis02.class, "TileEntityTardis02");
		registerTileEntity(TileEntityTardis03.class, "console_3");

		NetworkHandler.init();

		ScrewdriverHandler.init();
		
		ForgeChunkManager.setForcedChunkLoadingCallback(instance, new TardisLoadingCallback());
		
		TardisProtocol.register(new ProtocolCCircuit());
		TardisProtocol.register(new ProtocolEnabledHADS());
		TardisProtocol.register(new ProtocolSystemReadout());
		TardisProtocol.register(new ProtocolConsole());
		TardisProtocol.register(new ProtocolRegenRoom());
		TardisProtocol.register(new ProtocolLock());
		if(Loader.isModLoaded(TStrings.ModIds.DIM_DOORS)) TardisProtocol.register(new ProtocolFindDimDRfit());
		TardisProtocol.register(new ProtocolRepair());
		TardisProtocol.register(new ProtocolWaypoints());
		
		if (TardisConfig.USE_ENTITIES.entities) {
			// Register All Mobs Here.
			EntityHelper.registerMob(EntityCybermanInvasion.class, "invasion_cyberman", TardisConfig.USE_ENTITIES.cybermanSpawnChance);
			EntityHelper.registerNoSpawn(EntityDalek.class, "dalek");
			EntityHelper.registerMob(EntityQuark.class, "quark", 5);
			EntityHelper.registerNoSpawn(EntityCybermanTomb.class, "cyberman_tomb");
			EntityHelper.registerMob(EntityAdipose.class,"adipose", TardisConfig.USE_ENTITIES.adiposeSpawnChance);
		}
		proxy.preInit();
		
		TardisSystems.register("flight", SystemFlight.class);
		TardisSystems.register("dimensional", SystemDimension.class);
		TardisSystems.register("fluid_links", SystemFluidLinks.class);
		TardisSystems.register("antenna", SystemAntenna.class);
		TardisSystems.register("chameleon", SystemCCircuit.class);
		TardisSystems.register("temporal_grace", SystemTemporalGrace.class);
		TardisSystems.register("stabilizers", SystemStabilizers.class);
		
		
		GameRegistry.registerWorldGenerator(new WorldGenTardis(), 1);
		
		DisguiseRegistry.init();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandlerTardis());
		
		RepairRecipes.registerRecipe(TItems.fluid_link, TItems.mercuryBottle);
		RepairRecipes.registerRecipe(TItems.artron_capacitor, Item.getItemFromBlock(Blocks.REDSTONE_BLOCK));
		RepairRecipes.registerRecipe(TItems.demat_circut, Items.ENDER_PEARL);
		RepairRecipes.registerRecipe(TItems.antenna, TItems.circuts);
		RepairRecipes.registerRecipe(TItems.stabilizers, TItems.circuts);
		RepairRecipes.registerRecipe(TItems.time_vector_generator, Items.ENDER_PEARL);
		RepairRecipes.registerRecipe(TItems.chameleon_circuit, TItems.circuts);
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
		// Ore Dictionary
		OreDictionary.registerOre("oreUranium", TItems.power_cell);
		OreDictionary.registerOre("gemRuby", TItems.ruby);
		OreDictionary.registerOre("oreRuby", TBlocks.ruby_ore);
		OreDictionary.registerOre("dustCinnabar", TItems.crushedCinnabar);
		OreDictionary.registerOre("oreCinnabar", TBlocks.cinnabar_ore);

		//Permissions
		PermissionAPI.registerNode(TStrings.Permissions.TP_IN_TARDIS, DefaultPermissionLevel.OP, "Allows players to teleport themself in their TARDIS");
		PermissionAPI.registerNode(TStrings.Permissions.SUMMON_TARDIS, DefaultPermissionLevel.OP, "Allows players to summon a TARDIS owned by someone");
		PermissionAPI.registerNode(TStrings.Permissions.REMOVE_TARDIS, DefaultPermissionLevel.OP, "Allows players to delete a TARDIS");
		
		
		//This should be in pre-init, but it seems some mods have a weird obsession with claiming already taken ids
		TDimensions.register();
	
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
		for(ItemStack cinnabar : OreDictionary.getOres("dustCinnabar")) {
			AlembicRecipe.registerRecipe(cinnabar.getItem(), TItems.mercuryBottle);
		}
		
	}
	
	public static void registerTileEntity(Class<? extends TileEntity> clazz, String name) {
		GameRegistry.registerTileEntity(clazz, new ResourceLocation(Tardis.MODID, name));
	}
	
	public static boolean getIsDev() {
		return (Boolean)Launch.blackboard.get("fml.deobfuscatedEnvironment");
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event){
		event.registerServerCommand(new CommandTardis());
		if(Tardis.getIsDev()) {
			event.registerServerCommand(new CommandDebug());
		}
	}
}
