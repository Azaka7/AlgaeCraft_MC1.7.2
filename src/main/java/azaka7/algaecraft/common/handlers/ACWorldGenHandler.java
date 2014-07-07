package azaka7.algaecraft.common.handlers;

import java.util.Random;

import azaka7.algaecraft.common.world.biome.ACBiomes;
import azaka7.algaecraft.common.world.gen.layer.GenLayerAC;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.WorldTypeEvent;

public class ACWorldGenHandler implements IWorldGenerator {
	
	private static final ACWorldGenHandler INSTANCE = new ACWorldGenHandler();
	
	public static void register(){
		MinecraftForge.TERRAIN_GEN_BUS.register(INSTANCE);
		GameRegistry.registerWorldGenerator(INSTANCE, 0);
	}
	
	@SubscribeEvent
	public void handleBiomeGen(WorldTypeEvent.InitBiomeGens event){
		if(event.worldType.getWorldTypeID() == ACBiomes.ADVANCED_OCEANS.getWorldTypeID()){
			event.newBiomeGens = GenLayerAC.initializeAllBiomeGenerators(event.seed, event.worldType);
		}
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
			case -1: generateNether(world, random, chunkX * 16, chunkZ * 16);
			case 0: generateSurface(world, random, chunkX * 16, chunkZ * 16);
			case 1: generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateEnd(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private void generateSurface(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		if(world.getBiomeGenForCoords(i, j).biomeID == ACBiomes.shallowOcean.biomeID){
			
		}
	}

	private void generateNether(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		
	}
	
}
