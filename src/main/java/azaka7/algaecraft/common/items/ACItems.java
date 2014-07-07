package azaka7.algaecraft.common.items;

import java.util.HashMap;
import java.util.Map;

import azaka7.algaecraft.AlgaeCraft;
import azaka7.algaecraft.api.ItemReferences;
import azaka7.algaecraft.api.module.ItemRegistryPackage;
import azaka7.algaecraft.api.module.Module;
import azaka7.algaecraft.common.potion.ACPotions;
import azaka7.algaecraft.modules.ACModules;
import azaka7.algaecraft.modules.ModuleBranchScience;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

public class ACItems {
	
	public static final ArmorMaterial materialThin = EnumHelper.addArmorMaterial("thin", 4, new int[]{1,2,1,1}, 10);
	public static final ArmorMaterial materialDryIron = EnumHelper.addArmorMaterial("dryIron", 14, new int[]{2,5,4,2}, 9);
	public static final ArmorMaterial materialDryGold = EnumHelper.addArmorMaterial("dryGold", 6, new int[]{2,4,2,1}, 20);
	public static final ArmorMaterial materialDryDiamond = EnumHelper.addArmorMaterial("dryDiamond", 30, new int[]{3,7,5,3}, 12);
	
	public static Item itemSponge = new ItemSponge("")
		.setUnlocalizedName(name("drySponge"))
		.setCreativeTab(AlgaeCraft.modTab);;
	public static Item itemSpongeRed = new ItemSponge("Red")
		.setUnlocalizedName(name("drySpongeRed"))
		.setCreativeTab(AlgaeCraft.modTab);;
	public static Item itemAlgaeCooked = new ItemFood(2, 0.2F, false)
		.setPotionEffect(Potion.hunger.getId(), 5, 0, 0.2F)
		.setUnlocalizedName(name("itemAlgaeCooked"))
		.setTextureName(AlgaeCraft.MODID+":algaeChips")
		.setCreativeTab(AlgaeCraft.modTab);
	public static Item itemSeaweedCooked = new ItemFood(3, 0.3F, false)
		.setUnlocalizedName(name("itemSeaweedCooked"))
		.setTextureName(AlgaeCraft.MODID+":seaweedCooked")
		.setCreativeTab(AlgaeCraft.modTab);
	public static Item itemSquidRaw = new ItemFood(4, 0.5F, false)
		.setPotionEffect(Potion.hunger.getId(), 6, 0, 0.3F)
		.setUnlocalizedName(name("itemSquidRaw"))
		.setTextureName(AlgaeCraft.MODID+":rawSquid")
		.setCreativeTab(AlgaeCraft.modTab);
	public static Item itemSquidCooked = new ItemFood(7, 0.7F, true)
		.setUnlocalizedName(name("itemSquidCooked"))
		.setTextureName(AlgaeCraft.MODID+":calamariSeared")
		.setCreativeTab(AlgaeCraft.modTab);
	public static Item itemSquidFried = new ItemSoup(9)
		.setTextureName(AlgaeCraft.MODID+":calamari")
		.setCreativeTab(AlgaeCraft.modTab)
		.setUnlocalizedName(name("itemSquidFried"));
	public static Item itemSushiRaw = new ItemFood(6, 0.6F, false)
		.setUnlocalizedName(name("sushiRaw"))
		.setTextureName(AlgaeCraft.MODID+":sushiRaw")
		.setCreativeTab(AlgaeCraft.modTab);
	public static Item itemSushiCooked = new ItemFood(9, 0.9F, true)
		.setUnlocalizedName(name("sushiCooked"))
		.setTextureName(AlgaeCraft.MODID+":sushiCooked")
		.setCreativeTab(AlgaeCraft.modTab);
	public static Item itemKnifeIron = new ItemKnife(Item.ToolMaterial.STONE)
		.setTextureName(AlgaeCraft.MODID+":knife")
		.setCreativeTab(AlgaeCraft.modTab)
		.setUnlocalizedName(name("itemKnife"));
	public static Item itemKnifeGold = new ItemKnife(Item.ToolMaterial.GOLD)
		.setTextureName(AlgaeCraft.MODID+":knifeGold")
		.setCreativeTab(AlgaeCraft.modTab)
		.setUnlocalizedName(name("itemKnifeGold"));
	public static Item itemLobster = new ItemLobster()
		.setTextureName(AlgaeCraft.MODID+":lobsterItem")
		.setCreativeTab(AlgaeCraft.modTab)
		.setUnlocalizedName(name("itemLobster"));
	public static Item itemLobsterRaw = new ItemFood(2, 0.1F, false)
		.setTextureName(AlgaeCraft.MODID+":lobsterRaw")
		.setCreativeTab(AlgaeCraft.modTab)
		.setUnlocalizedName(name("itemLobsterRaw"));
	public static Item itemLobsterCooked = new ItemFood(8, 0.4F, true)
		.setTextureName(AlgaeCraft.MODID+":lobsterCooked")
		.setCreativeTab(AlgaeCraft.modTab)
		.setUnlocalizedName(name("itemLobsterCooked"));
	public static Item itemAerosBulb = new ItemAerosBulb()
		.setTextureName(AlgaeCraft.MODID+":waterBreathPearl")
		.setCreativeTab(AlgaeCraft.modTab)
		.setUnlocalizedName(name("itemAerosBulb"));
	public static Item itemScubaGoggles = new ItemDiveMask(materialThin, 0, "scubaEssentials")
		.setTextureName(AlgaeCraft.MODID+":scubaItemMask")
		.setCreativeTab(AlgaeCraft.modTab)
		.setUnlocalizedName(name("itemDiveMask"));
	public static Item itemScubaBCD = new ItemBCD(materialThin, 0, "scubaBcdArmor")
		.setTextureName(AlgaeCraft.MODID+":itemBCD")
		.setCreativeTab(AlgaeCraft.modTab)
		.setUnlocalizedName(name("itemBCD"));
	public static Item itemAirTankSmall = new ItemAirTank(200)
		.setTextureName(AlgaeCraft.MODID+":itemAirtank")
		.setCreativeTab(AlgaeCraft.modTab)
		.setUnlocalizedName(name("itemAirTankSmall"));
	public static Item itemWetsuit = new ItemWetsuit(materialThin, 0)
		.setCreativeTab(AlgaeCraft.modTab)
		.setUnlocalizedName(name("itemWetsuit"));
	public static Item itemFlippers = new ItemFlippers(materialThin, 0, "flippersArmor")
		.setCreativeTab(AlgaeCraft.modTab)
		.setTextureName(AlgaeCraft.MODID+":flippersItem")
		.setUnlocalizedName(name("itemFlippers"));
	private static final PotionEffect greekFire = constructMultiEffect(new PotionEffect(Potion.poison.id, 60, 4), new PotionEffect(Potion.blindness.id, 60), new PotionEffect(Potion.nightVision.id, 60), new PotionEffect(Potion.moveSpeed.id, 60, 2));
	public static Item itemFlask = new ItemFlask((Item) null,
			new       String[]{"Empty","Water",                                           "Salt",                                    "NaOH",                                     "CaOH", "H2CO3", "GreekFire",                                     "Oil",                                     "Redstone",                                    "Glowstone",                                 "Ender"},
			new PotionEffect[]{null,    new PotionEffect(Potion.fireResistance.id, 50, 1), new PotionEffect(Potion.hunger.id, 300, 2), new PotionEffect(Potion.wither.id, 40, 2), null,   null,    new PotionEffect(ACPotions.greekFire.id, 160),   new PotionEffect(Potion.digSpeed.id, 100), new PotionEffect(Potion.moveSpeed.id, 100, 2), new PotionEffect(Potion.nightVision.id, 200), new PotionEffect(Potion.invisibility.id, 100, 1, true)})
		.setCreativeTab(AlgaeCraft.modTab)
		.setUnlocalizedName(name("itemFlask"));
	public static Item itemFlaskFake = new ItemFlask(itemFlask,
			new       String[]{"Empty","Water",                                           "Salt",                                    "NaOH",                                     "CaOH", "H2CO3", "GreekFire",                                     "Oil",                                     "Redstone",                                    "Glowstone",                                 "Ender"},
			new PotionEffect[]{null,    new PotionEffect(Potion.fireResistance.id, 50, 1), new PotionEffect(Potion.hunger.id, 300, 2), new PotionEffect(Potion.wither.id, 40, 2), null,   null,    new PotionEffect(ACPotions.greekFire.id, 160),   new PotionEffect(Potion.digSpeed.id, 100), new PotionEffect(Potion.moveSpeed.id, 100, 2), new PotionEffect(Potion.nightVision.id, 200), new PotionEffect(Potion.invisibility.id, 100, 1, true)})
		.setUnlocalizedName(name("itemFlaskFake"));
	public static Item itemRedironElectrolyzer= new ItemDamageableCrafting(200, false, true)
		.setCreativeTab(AlgaeCraft.modTab)
		.setTextureName(AlgaeCraft.MODID+":redstoneElectrolyzer")
		.setUnlocalizedName(name("itemRedironElectrolyzer"));
	public static Item itemQuicklime = new ItemHydrophile(0.25F,0)
		.setCreativeTab(AlgaeCraft.modTab)
		.setTextureName(AlgaeCraft.MODID+":quicklime")
		.setUnlocalizedName(name("itemQuicklime"));
	/*/ Make the files of these items force-update themselves to new items.
	public static Item itemLobsterBoiled;
	public static Item itemChipRediron;
	public static Item itemGuayuleBranch;
	public static Item itemRubberRaw;
	public static Item itemRubberBall;
	public static Item itemNeopreneTextile;
	////////////////////////////////////////////////////////*/
	
	public static ItemGenericItems itemGeneric = (ItemGenericItems) new ItemGenericItems().setUnlocalizedName(name("genericItems")).setCreativeTab(AlgaeCraft.modTab);;
	public static ItemStack itemLobsterBoiledG = itemGeneric.addGenericItem(0, "lobsterBoiled", "lobsterBoiledItem");
	public static ItemStack itemChipRedironG = itemGeneric.addGenericItem(1, "redironChip", "chipRediron");
	public static ItemStack itemGuayuleBranchG = itemGeneric.addGenericItem(2, "guayuleBranch", "guayuleBranches");
	public static ItemStack itemRubberRawG = itemGeneric.addGenericItem(3, "rubberRaw", "rubberRaw");
	public static ItemStack itemRubberBallG = itemGeneric.addGenericItem(4, "rubberBall", "rubberBall");
	public static ItemStack itemNeopreneTextileG = itemGeneric.addGenericItem(5, "neopreneTextile", "neopreneTextile");
	
	public static void registerItems(){
		//FMLInterModComms.
		String modId = AlgaeCraft.MODID;
		//Items
		registerItem(itemSponge, "drySponge", modId,"materialSponge");
		registerItem(itemSpongeRed, "drySpongeRed", modId,"materialSpongeRed");
		registerItem(itemGeneric, "genericItems", modId,"materialAlgaecraftGenericItems");
		registerItem(itemAlgaeCooked, "algaeCooked", modId,"foodAlgaeCooked", "foodCookedAlgae");
		registerItem(itemSeaweedCooked, "seaweedCooked", modId,"foodSeaweedCooked", "foodCookedSeaweed");
		registerItem(itemSquidRaw, "squidRaw", modId,"foodRawSquid", "foodSquidRaw", "foodRawCalamari", "foodCalamariRaw");
		registerItem(itemSquidCooked, "squidCooked", modId,"foodCookedSquid","foodSquidCooked","foodCalamariCooked","foodCookedCalamari");
		registerItem(itemSquidFried, "squidFried", modId,"foodCalamariRingsCooked", "foodCookedCalamariRings", "foodFriedCalamariRings");
		registerItem(itemSushiRaw, "sushiRaw", modId,"foodSushiRaw","foodRawSushi");
		registerItem(itemSushiCooked, "sushiCooked", modId,"foodSushiCooked","foodCookedSushi");
		registerItem(itemKnifeIron, "knifeIron", modId,"weaponKnifeIron","toolKnifeIron","itemKnifeIron","weaponIronKnife","toolIronKnife","itemIronKnife");
		registerItem(itemKnifeGold, "knifeGold", modId,"weaponKnifeGold","toolKnifeGold","itemKnifeGold","weaponGoldKnife","toolGoldKnife","itemGoldKnife");
		registerItem(itemLobster, "lobster", modId,"mobLobster","itemLobster","entityLobster","materialLobster");
		registerItem(itemLobsterRaw, "lobsterRaw", modId,"foodLobsterRaw","foodRawLobster");
		registerItem(itemLobsterCooked, "lobsterCooked", modId, "foodLobsterCooked","foodCookedLobster","foodBoiledLobster","foodLobsterBoiled");
		
		registerItemStack(ACItems.itemChipRedironG,"redironChip", "chipRediron","chipRedironBasic");
		registerItemStack(ACItems.itemLobsterBoiledG,"lobsterBoiled", "materialLobsterCooked", "materialCookedLobster");
		
		////////////MODULES////////////////////////
		Module module = ACModules.branchScience.modules.get(0);
		if(ACModules.branchScience.active){
			registerItemStack(ACItems.itemGuayuleBranchG,"guayuleBranch", "woodenStickGuayule", "woodenGuayuleStick", "woodenGuayuleBranch");		registerItemStack(ACItems.itemNeopreneTextileG,"neopreneTextile", "materialNeoprene", "materialNeopreneTextile");
			registerItemStack(ACItems.itemRubberBallG,"rubberBall","materialRubber","materialRubberBall","itemRubber","itemRubberBall");
			registerItemStack(ACItems.itemRubberRawG,"rubberRaw","materialRawRubber","materalRubberRaw","materialStickyResin");
			
			module.registerItems(
					new ItemRegistryPackage(itemFlask, "flask")
						.setDefinition("toolFlask","itemFlask"),
					new ItemRegistryPackage(itemRedironElectrolyzer, "electrolyzerRediron")
						.setDefinition("toolElectrolyzer","toolElectrolyzerRediron"),
					new ItemRegistryPackage(itemQuicklime,"quicklime")
						.setDefinition("itemQuicklime", "dustQuicklime"));
			
			//Smelting
			GameRegistry.addSmelting(itemRubberRawG, itemRubberBallG, 0.4F);
		}
		module = ((ModuleBranchScience) ACModules.branchScience).modScuba;
		if(module.isActive()){
			//Items
			module.registerItems(
				new ItemRegistryPackage(itemScubaGoggles, "diveMask")
					.setDefinition("maskDive","helmetDiveMask"),
				new ItemRegistryPackage(itemWetsuit, "wetsuit")
					.setDefinition("wetsuit", "armorWetsuit"),
				new ItemRegistryPackage(itemScubaBCD, "bcd")
					.setDefinition("armorBCD","scubaBCD"),
				new ItemRegistryPackage(itemAirTankSmall,"airTank")
					.setDefinition("toolAirTank","itemAirTank"),
				new ItemRegistryPackage(itemFlippers,"flippers")
					.setDefinition("armorFlippers")
			);
			registerItemStack(ACItems.itemNeopreneTextileG, "neopreneTextile", "materialNeoprene");
			
			for(int i = 0; i < 16; i ++){
				for(int damage = 0; damage < itemWetsuit.getMaxDamage(); damage++){
					ItemStack stack = new ItemStack(itemWetsuit,1,damage);
					((ItemWetsuit) itemWetsuit).colorize(stack,i);
					GameRegistry.addShapelessRecipe(stack, new Object[]{new ItemStack(itemWetsuit, 1, damage),new ItemStack(Items.dye, 1, i)});
				}
			}
		}
		module = ACModules.branchMagic.getModule("herbology");
		if(module.isActive()){
			module.registerItems(
					new ItemRegistryPackage(itemAerosBulb, "aerosBulb")
						.setDefinition("bulbAeros","foodAerosBulb")
					
					);
		}
		
		
	}
	
	private static PotionEffect constructMultiEffect(PotionEffect... potionEffect) {
		if(potionEffect.length == 1){return potionEffect[0];}
		PotionEffect effect = potionEffect[0];
		for(int i = 1; i < potionEffect.length; i++){
			effect.combine(potionEffect[i]);
		}
		return effect;
	}

	private static void registerItem(Item item, String name, String modId, String... oreDict){
		GameRegistry.registerItem(item, name, modId);
		for(int i = 0; i<oreDict.length; i++){
			OreDictionary.registerOre(oreDict[i], item);
		}
		ItemReferences.nameMap.put(name, item);
	}
	
	private static void registerItemStack(ItemStack stack, String name, String... oreDict){
		GameRegistry.registerCustomItemStack(name, stack);
		for(int i = 0; i<oreDict.length; i++){
			OreDictionary.registerOre(oreDict[0], stack);
		}
		ItemReferences.nameStackMap.put(name, stack);
		OreDictionary.registerOre("item"+Character.toUpperCase(name.charAt(0))+name.substring(1),stack);
	}
	
	public static class ArmorMaterials{
		public static final ItemArmor.ArmorMaterial materialThin = EnumHelper.addArmorMaterial("thin", 4, new int[]{1,2,1,1}, 10);
		public static final ItemArmor.ArmorMaterial materialDryIron = EnumHelper.addArmorMaterial("dryIron", 14, new int[]{2,5,4,2}, 9);
		public static final ItemArmor.ArmorMaterial materialDryGold = EnumHelper.addArmorMaterial("dryGold", 6, new int[]{2,4,2,1}, 20);
		public static final ItemArmor.ArmorMaterial materialDryDiamond = EnumHelper.addArmorMaterial("dryDiamond", 30, new int[]{3,7,5,3}, 12);
	}
	
	private static String name(String s){
		return AlgaeCraft.MODID+"_"+s;
	}
}
