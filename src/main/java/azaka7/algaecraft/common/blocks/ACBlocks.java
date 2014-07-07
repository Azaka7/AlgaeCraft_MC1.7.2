package azaka7.algaecraft.common.blocks;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.google.common.collect.ObjectArrays;

import azaka7.algaecraft.AlgaeCraft;
import azaka7.algaecraft.api.BlockReferences;
import azaka7.algaecraft.api.ItemReferences;
import azaka7.algaecraft.common.items.ACItems;
import azaka7.algaecraft.common.items.ItemBlockItem;
import azaka7.algaecraft.common.items.ItemBlockItemMetadata;
import azaka7.algaecraft.common.items.ItemBlockItemSeaweed;
import azaka7.algaecraft.common.items.ItemBlockMetadata;
import azaka7.algaecraft.common.items.ItemSlabLimestone;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemCloth;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class ACBlocks {
	public static Block blockAlgae = new BlockAlgae()
		.setBlockTextureName(AlgaeCraft.MODID+":algae")
		.setCreativeTab(AlgaeCraft.modTab)
		.setBlockName(name("algae"));
	public static Block blockSpongeSpore = new BlockSpongeSpore(Blocks.sponge, ACItems.itemSponge)
		.setCreativeTab(AlgaeCraft.modTab)
		.setBlockName(name("spongeSpore"));
	public static Block blockSpongeRed = new BlockGeneric(Material.sponge)
		.setHardness(0.6F)
		.setStepSound(Block.soundTypeGrass)
		.setBlockTextureName(AlgaeCraft.MODID+":spongeRed")
		.setCreativeTab(AlgaeCraft.modTab)
		.setBlockName(name("spongeRed"));
	public static Block blockSpongeRedSpore = new BlockSpongeSpore(blockSpongeRed, ACItems.itemSpongeRed)
		.setCreativeTab(AlgaeCraft.modTab)
		.setBlockName(name("spongeSporeRed"));
	public static Block blockSeaweed = new BlockSeaweed()
		.setCreativeTab(AlgaeCraft.modTab)
		.setBlockTextureName(AlgaeCraft.MODID+":seaweed")
		.setBlockName(name("seaweed"));
	public static Block blockCoral = new BlockCoral()
		.setCreativeTab(AlgaeCraft.modTab)
		.setBlockName(name("coral"));
	public static Block blockLobsterCage= new BlockLobsterCage()
		.setBlockTextureName(AlgaeCraft.MODID+":lobsterCage")
		.setCreativeTab(AlgaeCraft.modTab)
		.setBlockName(name("lobsterCage"));
	public static Block blockPlantBreath;
	public static Block blockFilter = new BlockWaterFilter()
		.setCreativeTab(AlgaeCraft.modTab).setHardness(5.0F).setResistance(5.0F).setStepSound(Block.soundTypeMetal)
		.setBlockName(name("waterFilter"));
	public static Block blockSediment = new BlockGenericMultidrop(Material.clay,
			new ItemStack[]{
				new ItemStack(Blocks.dirt), 
				new ItemStack(Items.clay_ball, 4),
				new ItemStack(Blocks.sand),
				new ItemStack(Blocks.gravel)},
			new ItemStack(Items.gold_ingot, 2),
			new ItemStack(Items.gold_nugget, 4),
			new ItemStack(Items.gold_nugget, 3),
			new ItemStack(Items.gold_nugget, 2),
			new ItemStack(Items.arrow, 16),
			new ItemStack(Items.arrow, 8),
			new ItemStack(Items.arrow, 4),
			new ItemStack(Items.arrow, 2),
			new ItemStack(Items.boat),
			new ItemStack(Items.bone, 4),
			new ItemStack(Items.bone, 4),
			new ItemStack(Items.bowl, 3),
			new ItemStack(Items.brick, 8),
			new ItemStack(Items.cauldron),
			new ItemStack(Items.water_bucket),
			new ItemStack(Items.water_bucket),
			new ItemStack(Items.compass),
			new ItemStack(Items.book, 3),
			new ItemStack(Items.clock),
			new ItemStack(Items.diamond),
			new ItemStack(Items.experience_bottle, 2),
			new ItemStack(Items.emerald),
			new ItemStack(Items.iron_ingot, 4),
			new ItemStack(Items.ender_pearl),
			new ItemStack(Items.rotten_flesh, 8),
			new ItemStack(Items.rotten_flesh, 8),
			new ItemStack(Items.rotten_flesh, 8),
			new ItemStack(Items.wooden_sword, 1, Items.wooden_sword.getMaxDamage()-1),
			new ItemStack(Items.stone_shovel, 1, Items.stone_shovel.getMaxDamage()-1),
			new ItemStack(Items.golden_hoe, 1, Items.golden_hoe.getMaxDamage()-1),
			new ItemStack(Items.iron_pickaxe, 1, Items.iron_pickaxe.getMaxDamage()-1),
			new ItemStack(Items.name_tag),
			new ItemStack(Items.poisonous_potato, 3),
			new ItemStack(Items.saddle),
			new ItemStack(Items.bow, 1, Items.bow.getMaxDamage()),
			new ItemStack(Items.potionitem))
		.setBlockName(name("sediment"))
		.setBlockTextureName(AlgaeCraft.MODID+":sediment")
		.setCreativeTab(AlgaeCraft.modTab)
		.setHardness(0.5F).setStepSound(Block.soundTypeSand);
	public static Block blockLimestone = new BlockGenericMetadata(Material.rock,new String[]{"limestone","limestoneBrick","limestoneChiseled","limestoneTile"},new int[]{2})
		.setCreativeTab(AlgaeCraft.modTab).setStepSound(Block.soundTypePiston).setHardness(0.8F)
		.setBlockName(name("limestone"));
	public static Block blockLimestoneStairs = new BlockStairsAC(blockLimestone, 0)
		.setCreativeTab(AlgaeCraft.modTab).setStepSound(Block.soundTypePiston).setHardness(0.8F)
		.setBlockName(name("limestoneStairs"));
	public static Block blockLimestoneStairsBrick = new BlockStairsAC(blockLimestone, 1)
		.setCreativeTab(AlgaeCraft.modTab).setStepSound(Block.soundTypePiston).setHardness(0.8F)
		.setBlockName(name("limestoneBrickStairs"));
	public static BlockSlab blockLimestoneSlab = (BlockSlab) new BlockSlabLimestone(false)
		.setCreativeTab(AlgaeCraft.modTab).setStepSound(Block.soundTypePiston).setHardness(0.8F)
		.setBlockName(name("limestoneSlab"));
	public static BlockSlab blockLimestoneSlabDouble = (BlockSlab) new BlockSlabLimestone(true)
		.setStepSound(Block.soundTypePiston).setHardness(0.8F)
		.setBlockName(name("limestoneSlabDouble"));
	
	public static Block blockGuayule;
	public static Block blockAirCompressor;
	
	public static void registerBlocks(){
		registerBlock(blockLimestone, "limestone", ItemBlockMetadata.class, new String[]{"limestone","limestoneBrick","limestoneChiseled","limestoneTile"});
		registerBlockStack(new ItemStack(blockLimestone, 1, 1), "limestoneBrick");
		registerBlockStack(new ItemStack(blockLimestone, 1, 2), "limestoneChiseled");
		registerBlockStack(new ItemStack(blockLimestone, 1, 3), "limestoneTile");
		
		String[] filterNames = new String[16];
		for(int i = 0; i < 16 && i < BlockWaterFilter.EnumWaterType.values().length; i++){
			filterNames[i] = BlockWaterFilter.EnumWaterType.values()[i].name;
		}
		registerBlock(blockFilter, "waterFilter", ItemBlockMetadata.class, filterNames);
		registerBlockStack(new ItemStack(blockFilter, 1, 0), "filterEnder");
		registerBlockStack(new ItemStack(blockFilter, 1, 1), "filterFresh");
		registerBlockStack(new ItemStack(blockFilter, 1, 1), "filterOcean");
		registerBlockStack(new ItemStack(blockFilter, 1, 1), "filterSpororus");
		
		registerBlock(blockLobsterCage,"lobsterCage");
		registerBlockStack(new ItemStack(blockLobsterCage,1,1),"lobsterCageLobster");
		
		registerBlock(blockSpongeRed, "spongeRed");
		registerBlock(blockSediment, "sediment");
		
		registerBlock(blockLimestoneStairs,"limestoneStairs");
		registerBlock(blockLimestoneStairsBrick, "limestoneBrickStairs");
		
		registerBlock(blockSeaweed, "seaweed", ItemBlockItemSeaweed.class, Boolean.FALSE, new String("seaweedItem"));
		registerBlock(blockSpongeSpore, "spongeSpore", ItemBlockItem.class, Boolean.FALSE, new String("spongeSeed"));
		registerBlock(blockSpongeRedSpore, "spongeRedSpore", ItemBlockItem.class, Boolean.FALSE, new String("spongeRedSeed"));
		registerBlock(blockCoral, "coral", ItemBlockItemMetadata.class, Boolean.FALSE, new String[]{"coral_orange","coral_purple","coral_brainI","coral_blue","coral_orange_small","coral_purple_small","coral_brain_smallI","coral_blue_small"});
		registerBlock(blockAlgae, "algae", ItemBlockItem.class, Boolean.TRUE, new String("algaeBall"));
	
		registerBlock(blockLimestoneSlab, "limestoneSlab", ItemSlabLimestone.class, (BlockSlab) blockLimestoneSlab, (BlockSlab) blockLimestoneSlabDouble, false);
		registerBlock(blockLimestoneSlabDouble, "limestoneSlabDouble", ItemSlabLimestone.class, (BlockSlab) blockLimestoneSlab, (BlockSlab) blockLimestoneSlabDouble, true);
		registerBlockStack(new ItemStack(blockLimestoneSlab, 1, 1), "limestoneSlabBrick");
		registerBlockStack(new ItemStack(blockLimestoneSlab, 1, 3), "limestoneSlabTile");
	}
	
	//used to register blocks that are required by items
	public static void registerPreItemBlocks(){
		
	}
	
	
	
	///////////////////////////////////////////////////////////////////////
	
	private static void registerBlock(Block block, String name){
		registerBlock(block, name, ItemBlock.class);
	}
	
	private static void registerBlock(Block block, String name, Class<? extends ItemBlock> item){
		GameRegistry.registerBlock(block, item, name, AlgaeCraft.MODID);

		BlockReferences.nameMap.put(name, block);
	}
	
	private static void registerBlockStack(ItemStack block, String name){
		GameRegistry.registerCustomItemStack(name, block);
		ItemReferences.nameStackMap.put(name, block);
	}
	
	private static void registerBlock(Block block, String name, Class<? extends ItemBlock> item, Object arg1){
		GameRegistry.registerBlock(block, item, name, AlgaeCraft.MODID, arg1);

		BlockReferences.nameMap.put(name, block);
	}
	
	private static void registerBlock(Block block, String name, Class<? extends ItemBlock> item, Object arg1, Object arg2){
		GameRegistry.registerBlock(block, item, name, AlgaeCraft.MODID, arg1, arg2);

		BlockReferences.nameMap.put(name, block);
	}
	
	private static void registerBlock(Block block, String name, Class<? extends ItemBlock> item, Object arg1, Object arg2, Object arg3){
		GameRegistry.registerBlock(block, item, name, AlgaeCraft.MODID, arg1, arg2, arg3);

		BlockReferences.nameMap.put(name, block);
	}
	
	public static int renderPass(){
		return Minecraft.getMinecraft().isFancyGraphicsEnabled() ? 1 : 0;
	}
	
	private static String name(String s){
		return AlgaeCraft.MODID+"_"+s;
	}
	
}
