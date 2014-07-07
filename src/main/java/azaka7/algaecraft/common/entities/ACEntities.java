package azaka7.algaecraft.common.entities;

import java.util.HashMap;
import java.util.Map;

import azaka7.algaecraft.config.ACConfiguration;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

public class ACEntities {
	
	public static final Map<String,Class<? extends Entity>> nameMap = new HashMap<String,Class<? extends Entity>>();
	public static final Map<String,Integer> idMap = new HashMap<String,Integer>();
	
	public static void registerEntities(){
		ACConfiguration.startSection("Entities");
		
		registerEntity(EntityLobster.class,"lobster",ACConfiguration.getInt("Lobster Entity ID", 126), 0xCC2C18, 0x0C0101);
		addSpawn(EntityLobster.class, 20, 4, 10, EnumCreatureType.waterCreature, new BiomeGenBase[]{BiomeGenBase.ocean,BiomeGenBase.beach});
		
		ACConfiguration.endSection();
	}
	
	private static void registerEntity(Class clazz, String name, int id, int c1, int c2){
		EntityRegistry.registerGlobalEntityID(clazz, name, id, c1, c2);
		nameMap.put(name, clazz);
		idMap.put(name, id);
	}
	
	private static void registerEntity(Class clazz, String name, int id){
		EntityRegistry.registerGlobalEntityID(clazz, name, id);
	}
	
	private static void addSpawn(Class clazz, int weight, int minPop, int maxPop, EnumCreatureType type, BiomeGenBase[] biomes){
		EntityRegistry.addSpawn(clazz, weight, minPop, maxPop, type, biomes);
	}
	
}
