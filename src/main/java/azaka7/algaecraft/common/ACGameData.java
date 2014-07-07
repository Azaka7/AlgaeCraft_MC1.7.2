package azaka7.algaecraft.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cpw.mods.fml.client.registry.RenderingRegistry;
import azaka7.algaecraft.common.blocks.ACBlocks;
import azaka7.algaecraft.config.ACConfiguration;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;

public class ACGameData {
public static ACGameData instance = new ACGameData();
	
public static Map<String, Integer[]> intArrays = new HashMap<String, Integer[]>();
public static Map<String, Boolean> booleans = new HashMap<String, Boolean>();

public static int[] reefType;
public static boolean canReefHaveFancyStone;
//public static boolean allowMagicCoral;
public static boolean generateAbyssalOcean;
public static int abyssalOceanBiomeID;
public static int[] biomeIDSwampList;
public static int[] biomeIDOceanList;

//public static List<Block> canPlantCoralOn = new ArrayList<Block>();
//public static List<Block> canPlantSpongeOn = new ArrayList<Block>();
//public static List<Block> canPlantSeaweedOn = new ArrayList<Block>();

public static String[] knifeRecipe;

public static int entityMeatySquidID;
public static int entityLobsterID;
public static int entityFishID;

public static int waterLightDecrement;
public static boolean usesFogClarityAPI;

public static boolean specialCoralRender;

public static int algaeModelID;
public static int spongeModelID;
public static int coralModelID;
public static int seaweedModelID;

public static int waterBlockModelID;

private static final Class<?>[][] paramTypes = new Class[][] {{EnumCreatureType.class, Class.class, int.class, Material.class, boolean.class, boolean.class}};
public static final EnumCreatureType ambientWater = EnumHelper.addEnum(paramTypes, EnumCreatureType.class, "ambientWaterFish", EntityWaterMob.class, 40, Material.water, true, false);


	public void configure(){
		ACConfiguration.startSection("Biome Definitions");
		biomeIDSwampList = ACConfiguration.getIntArray("Swamp Biome IDs", new int[]{BiomeGenBase.swampland.biomeID});
		biomeIDOceanList = ACConfiguration.getIntArray("Ocean Biome IDs", new int[]{BiomeGenBase.ocean.biomeID,BiomeGenBase.deepOcean.biomeID});
		
		ACConfiguration.startSection("Model IDs");
		ACConfiguration.addComment("Leave ModelID as -1 to have Forge determine an available ID. Specify a value at your own discretion.");
		specialCoralRender = ACConfiguration.getBool("Enable Special Water Plant/Coral Rendering", false);
		algaeModelID = ACConfiguration.getInt("Algae Model ID", -1);
		if(algaeModelID < 0){algaeModelID = RenderingRegistry.getNextAvailableRenderId();}
		coralModelID = ACConfiguration.getInt("Coral Model ID", -1);
		if(coralModelID < 0){coralModelID = RenderingRegistry.getNextAvailableRenderId();}
		spongeModelID = ACConfiguration.getInt("Sponge Spore Model ID", -1);
		if(spongeModelID < 0){spongeModelID = RenderingRegistry.getNextAvailableRenderId();}
		seaweedModelID = ACConfiguration.getInt("Seaweed Model ID", -1);
		if(seaweedModelID < 0){seaweedModelID = RenderingRegistry.getNextAvailableRenderId();}
		waterBlockModelID = ACConfiguration.getInt("Special Wet Blocks Model ID", -1);
		if(waterBlockModelID < 0){waterBlockModelID = RenderingRegistry.getNextAvailableRenderId();}
		
		
		ACConfiguration.endSection();
	}
}
