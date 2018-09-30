package net.tardis.mod.common.blocks;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.tardis.mod.Tardis;
import net.tardis.mod.common.blocks.interfaces.INeedItem;
import net.tardis.mod.common.items.TItems;
import net.tardis.mod.common.tileentity.TileEntityComponentRepair;
import net.tardis.mod.common.tileentity.TileEntityDoor;
import net.tardis.mod.common.tileentity.TileEntityHellbentLight;
import net.tardis.mod.common.tileentity.TileEntityTardis;
import net.tardis.mod.common.tileentity.consoles.TileEntityTardis01;
import net.tardis.mod.common.tileentity.consoles.TileEntityTardis02;
import net.tardis.mod.common.tileentity.decoration.TileEntityHelbentRoof;
import net.tardis.mod.common.tileentity.decoration.TileEntityHellbentMonitor;
import net.tardis.mod.common.tileentity.decoration.TileEntityHellbentPole;
import net.tardis.mod.common.tileentity.exteriors.TileEntityDoor01;
import net.tardis.mod.common.tileentity.exteriors.TileEntityDoor03;
import net.tardis.mod.common.tileentity.exteriors.TileEntityDoor04;
import net.tardis.mod.common.tileentity.exteriors.TileEntityDoor05;
import net.tardis.mod.common.tileentity.exteriors.TileEntityDoorCC;
import net.tardis.mod.common.tileentity.exteriors.TileEntityDoorClock;


public class TBlocks {
	
	public static List<Block> blocks = new ArrayList<Block>();
	
	public static Block tardis = register(new BlockTardis(), "tardis");
	public static Block tardis_top = register(new BlockTardisTop(TileEntityDoor::new), "tardis_top");
	public static Block console = register(new BlockConsole(TileEntityTardis::new), "console");
	public static Block panel = register(new BlockBase(), "panel");
	public static Block food_machine = register(new BlockFoodMachine(), "food_machine");
	public static Block megalos = register(new BlockMegalos(), "megalos");
	public static Block holoprojector = register(new BlockHoloprojector(), "holoprojector");
	
	public static Block toyota_hexagon_1 = register(new BlockToyota(false), "toyota_hexagon_1");
	public static Block toyota_hexagon_2 = register(new BlockToyota(false), "toyota_hexagon_2");
	public static Block toyota_hexagon_3 = register(new BlockToyota(false), "toyota_hexagon_3");
	public static Block toyota_hexagon_4 = register(new BlockToyota(false), "toyota_hexagon_4");
	public static Block toyota_hexalight_1 = register(new BlockToyota(true), "toyota_hexalight_1");
	public static Block toyota_hexalight_2 = register(new BlockToyota(true), "toyota_hexalight_2");
	public static Block toyota_hexalight_3 = register(new BlockToyota(true), "toyota_hexalight_3");
	public static Block toyota_hexalight_4 = register(new BlockToyota(true), "toyota_hexalight_4");
	public static Block toyota_hexalight_off1 = register(new BlockToyota(false), "toyota_hexalight_off1");
	public static Block toyota_hexalight_off2 = register(new BlockToyota(true), "toyota_hexalight_off2");
	public static Block toyota_hexalight_off3 = register(new BlockToyota(false), "toyota_hexalight_off3");
	public static Block toyota_light_emergency = register(new BlockToyota(true), "toyota_light_emergency");
	public static Block toyota_light_off = register(new BlockToyota(false), "toyota_light_off");
	public static Block toyota_light_on = register(new BlockToyota(true), "toyota_light_on");
	public static Block toyota_upper_divider = register(new BlockToyota(false), "toyota_upper_divider");
	public static Block toyota_platform = register(new BlockToyota(false), "toyota_platform");
	public static Block toyota_platform_top = register(new BlockToyota(false), "toyota_platform_top");
	public static Block toyota_platform_light = register(new BlockToyota(true), "toyota_platform_light");
	public static Block toyota_roof = register(new BlockToyota(false), "toyota_roof");
	public static Block toyota_roof_light = register(new BlockToyota(true), "toyota_roof_light");
	public static Block toyota_wall = register(new BlockToyota(false), "toyota_wall");
	public static Block toyota_wallroundel_1 = register(new BlockToyota(true), "toyota_wallroundel_1");
	public static Block toyota_wallroundel_2 = register(new BlockToyota(false), "toyota_wallroundel_2");
	public static Block toyota_wallroundel_3 = register(new BlockToyota(true), "toyota_wallroundel_3");
	public static Block toyota_wallroundel_4 = register(new BlockToyota(false), "toyota_wallroundel_4");
	public static Block toyota_wallroundel_5 = register(new BlockToyota(false), "toyota_wallroundel_5");
	public static Block toyota_wallroundel_6 = register(new BlockToyota(false), "toyota_wallroundel_6");
	
	public static Block toyota_platform_full;
	public static Block toyota_platform_slab;
	
	public static Block sonicRedstone;
	
	public static Block electric_panel = register(new BlockEPanel(), "electric_panel");
	
	public static Block ruby_ore = register(new BlockItemDrop(TItems.ruby), "ruby_ore");
	public static Block cinnabar_ore = register(new BlockItemDrop(TItems.crushedCinnabar, 3), "cinnabar_ore");
	public static Block tardis_coral = register(new BlockTardisCoral(), "tardis_coral");
	
	public static Block alembic = register(new BlockAlembic(), "alembic");
	
	public static Block hellbent_floor = register(new BlockBase(), "hellbent_floor");
	public static Block hellbent_glass01 = register(new BlockBase(), "hellbent_glass01");
	public static Block hellbent_glass02 = register(new BlockBase(), "hellbent_glass02");
	public static Block hellbent_glass03 = register(new BlockBase(), "hellbent_glass03");
	public static Block hellbent_glass04 = register(new BlockBase(), "hellbent_glass04");
	public static Block hellbent_glass05 = register(new BlockBase(), "hellbent_glass05");
	public static Block hellbent_glass06 = register(new BlockBase(), "hellbent_glass06");
	public static Block hellbent_glass07 = register(new BlockBase(), "hellbent_glass07");
	public static Block hellbent_glass08 = register(new BlockBase(), "hellbent_glass08");
	public static Block hellbent_roundel01 = register(new BlockLight(), "hellbent_roundel01");
	public static Block hellbent_roundel02 = register(new BlockLight(), "hellbent_roundel02");
	public static Block hellbent_roundel03 = register(new BlockLight(), "hellbent_roundel03");
	public static Block hellbent_silverwall = register(new BlockBase(), "hellbent_silverwall");
	public static Block hellbent_vents = register(new BlockLight(), "hellbent_vents");
	public static Block hellbent_wall = register(new BlockBase(), "hellbent_wall");
	
	public static Block zero_room_glow = register(new BlockVerticalSlab(), "zero_room_slab");
	public static Block zero_room = register(new BlockBase(), "zero_room");
	public static Block zero_room_stairs = register(new BlockTStairs(zero_room.getDefaultState()), "zero_room_stairs");
	
	public static Block hellbent_light = register(new BlockFacingDecoration(TileEntityHellbentLight::new).setLightLevel(1F).setLightOpacity(0), "hellbent_light");
	public static Block hellbent_monitor = register(new BlockMonitor(TileEntityHellbentMonitor::new), "hellbent_monitor");
	public static Block hellbent_pole = register(new BlockDecoration(TileEntityHellbentPole::new), "hellbent_pole");
	public static Block hellbent_roof = register(new BlockDecoration(TileEntityHelbentRoof::new).setLightLevel(1F).setLightOpacity(0), "hellbent_roof");
	
	public static Block telos_sand = register(new BlockBaseSand(), "telos_sand");
	public static Block moon_dirt = register(new BlockBase(), "moon_dirt");
	
	public static Block suitcase = register(new BlockSuitcase(), "suitcase");
	//Exteriors
	public static Block tardis_top_01 = register(new BlockTardisTop(TileEntityDoor01::new), "tardis_top_01");
	public static Block tardis_top_02 = register(new BlockTardisTop(TileEntityDoor03::new), "tardis_top_02");
	public static Block tardis_top_03 = register(new BlockTardisTop(TileEntityDoor04::new), "tardis_top_03");
	public static Block tardis_top_04 = register(new BlockTardisTop(TileEntityDoor05::new), "tardis_top_04");
	public static Block tardis_top_cc = register(new BlockTardisTop(TileEntityDoorCC::new), "tardis_top_cc");
	public static Block tardis_top_clock = register(new BlockTardisTop(TileEntityDoorClock::new), "tardis_top_clock");
	
	//Consoles
	public static Block console_01 = register(new BlockConsole(TileEntityTardis01::new), "console_01");
	public static Block console_02 = register(new BlockConsole(TileEntityTardis02::new), "console_02");

	public static Block sonic_blaster = register(new BlockSonicBlaster(), "blaster_block");

	public static Block circuit_repair = register(new BlockComponentRepair(Material.IRON, TileEntityComponentRepair::new), "circuit_repair");

	public static Block json_tester = Tardis.getIsDev() ? register(new BlockJsonTester(), "json_test") : null;


	public static Block register(Block block, String name) {
		ResourceLocation rl = new ResourceLocation(Tardis.MODID, name);
        block.setTranslationKey("tardis." + name);
		block.setRegistryName(rl);
		blocks.add(block);
		if(!(block instanceof INeedItem))TItems.items.add(new ItemBlock(block).setRegistryName(rl));
		else TItems.items.add(((INeedItem)block).getItem().setRegistryName(rl));
		if(Tardis.getIsDev()) {
			try {
				File f = new File(Minecraft.getMinecraft().gameDir + "\\..\\src\\main\\resources\\assets\\tardis\\blockstates\\" + block.getRegistryName().getPath() + ".json");
				if(!f.exists()) {
					GsonBuilder gson = new GsonBuilder();
					gson.setPrettyPrinting();
					JsonWriter jw = gson.create().newJsonWriter(new FileWriter(f));
					jw.beginObject();
					jw.name("forge_marker").value(1);
					jw.name("defaults");
					jw.beginObject();
					jw.name("model").value(Tardis.MODID + ":" + "teisr");
					jw.endObject();
					jw.name("variants");
					jw.beginObject();
					jw.name("normal");
					jw.beginArray();
					jw.beginObject();
					jw.endObject();
					jw.endArray();
					jw.name("inventory");
					jw.beginArray();
					jw.beginObject();
					jw.endObject();
					jw.endArray();
					if(block instanceof BlockTardisTop) {
						for(EnumFacing face : EnumFacing.Plane.HORIZONTAL.facings()) {
							jw.name("facing=" + face.getName());
							jw.beginArray();
							jw.beginObject();
							jw.endObject();
							jw.endArray();
						}
					}
					jw.endObject();
					jw.endObject();
					jw.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return block;
	}
	
	public static void register() {}
	
}
