package azaka7.algaecraft.common.world.biome;

import azaka7.algaecraft.common.world.WorldTypeAC;
import azaka7.algaecraft.common.world.gen.layer.GenLayerOceanModded;
import azaka7.algaecraft.config.ACConfiguration;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenOcean;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

public class ACBiomes {
	
	static final BiomeGenBase.Height height_Lake = new BiomeGenBase.Height(-0.4F, 0.02F);
	static final BiomeGenBase.Height height_ShallowOcean = new BiomeGenBase.Height(-0.5F, 0.2F);
	static final BiomeGenBase.Height height_AbyssalOcean = new BiomeGenBase.Height(-1.9F, 0.6F);
	//725,1100
	public static BiomeGenBase greatLake;
	public static BiomeGenBase greatLakeFlowered;
	//public static BiomeGenBase greatLakeIce;
	//public static BiomeGenBase saltLakeIce;
	public static BiomeGenBase shallowOcean;
	public static BiomeGenBase abyssalOcean;
	
	public static final WorldType ADVANCED_OCEANS = new WorldTypeAC("advanced_oceans");;
	
	public ACBiomes(){
	}
	
	public static void initBiomes(){
		greatLake = new BiomeGenGreatLake(getOpenID("Great Lake ID (+128 = Flowered)", 100), true, false).setHeight(height_Lake).setColor(48).setBiomeName("Great Lake");
		greatLakeFlowered = new BiomeGenGreatLake(greatLake.biomeID+128, true, true).setHeight(height_Lake).setColor(48).setBiomeName("Flowered Great Lake");
		
		shallowOcean = new BiomeGenOcean(getOpenID("Shallow Ocean ID", 101)).setHeight(height_ShallowOcean).setColor(48).setBiomeName("Shallow Ocean");
		abyssalOcean = new BiomeGenOcean(getOpenID("Abyssal Ocean ID", 102)).setHeight(height_AbyssalOcean).setColor(48).setBiomeName("Abyssal Ocean");
		
		GenLayerOceanModded.oceans.add(BiomeGenBase.ocean);
		GenLayerOceanModded.oceans.add(BiomeGenBase.deepOcean);
		GenLayerOceanModded.oceans.add(abyssalOcean);
		GenLayerOceanModded.oceans.add(shallowOcean);
		//greatLakeIce = new BiomeGenGreatLake(getOpenID("Frozen Great Lake ID", 101), true, true).setHeight(height_Lake).setColor(3233098).setBiomeName("Frozen Great Lake");
		//saltLakeIce = new BiomeGenGreatLake(greatLake.biomeID, false, true).setHeight(height_LakeSalt).setColor(3233098);
		
		BiomeManager.addSpawnBiome(greatLake);
		//BiomeManager.addSpawnBiome(greatLakeIce);
		BiomeManager.oceanBiomes.add(abyssalOcean);
		BiomeManager.oceanBiomes.add(shallowOcean);
		BiomeManager.coolBiomes.add(new BiomeManager.BiomeEntry(greatLake,10));
		BiomeManager.warmBiomes.add(new BiomeManager.BiomeEntry(greatLake,10));
		//BiomeManager.icyBiomes.add(new BiomeManager.BiomeEntry(greatLakeIce,10));
	}
	
	private static int getOpenID(String biome, int def){
		BiomeGenBase[] array = BiomeGenBase.getBiomeGenArray();
		ACConfiguration.startSection("Biomes");
		ACConfiguration.addComment("Base Biome IDs determine 'mutated' biomes. Base ID +128 = mutated ID");
		int configID = ACConfiguration.getInt(biome, def);
		
		if(array[configID] == null){
			return configID;
		}
		
		for(int i = array.length-1; i > 0; i--){
			if(array[i] != null){
				return i;
			}
		}
		ACConfiguration.endSection();
		return 127;
	}
	
}
