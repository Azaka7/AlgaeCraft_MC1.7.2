package azaka7.algaecraft;

import java.lang.reflect.Field;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.RegistryNamespaced;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraftforge.common.config.Configuration;
import azaka7.algaecraft.client.ClientProxy;
import azaka7.algaecraft.common.ACGameData;
import azaka7.algaecraft.common.CommonProxy;
import azaka7.algaecraft.common.TabAlgaeCraft;
import azaka7.algaecraft.common.blocks.ACBlocks;
import azaka7.algaecraft.common.entities.ACEntities;
import azaka7.algaecraft.common.fluids.ACFluids;
import azaka7.algaecraft.common.handlers.ACKeyBindingHandler;
import azaka7.algaecraft.common.handlers.ACPacketHandler;
import azaka7.algaecraft.common.handlers.ACTickHandler;
import azaka7.algaecraft.common.handlers.ACWorldGenHandler;
import azaka7.algaecraft.common.items.ACItems;
import azaka7.algaecraft.common.network.KeyBindingPacket;
import azaka7.algaecraft.common.potion.ACPotions;
import azaka7.algaecraft.common.world.biome.ACBiomes;
import azaka7.algaecraft.config.ACConfiguration;
import azaka7.algaecraft.modules.ACModules;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = AlgaeCraft.MODID, name = "AlgaeCraft", version = AlgaeCraft.VERSION)
public class AlgaeCraft {
	public static final String MODID = "algaecraft";
	public static final String VERSION = "2.0.0";
	
	public static AlgaeCraft instance = new AlgaeCraft();
	public static CreativeTabs modTab = new TabAlgaeCraft();
	
	public CommonProxy proxy;
	
	public static ACPacketHandler network = new ACPacketHandler();
	
	@EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		ACConfiguration.setup(config);
		
		ACModules.initialize();
		
		ACGameData.instance.configure();
		
		try {
			ACPotions.registerPotions();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ACBiomes.initBiomes();
		ACWorldGenHandler.register();
		
		ACItems.registerItems();
		ACBlocks.registerBlocks();
		ACEntities.registerEntities();
		
		proxy = event.getSide()==Side.CLIENT ? new ClientProxy() : new CommonProxy();
		
		ACKeyBindingHandler.INSTANCE.initialize();
		ACTickHandler.INSTANCE.initialize();
		proxy.registerEventHandler();
		proxy.registerRenders();
		
		config.save();
    }
	
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
		network.initialise();
		network.registerPacket(KeyBindingPacket.class);
    }
	
	@EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
		network.postInitialise();
		ACFluids.registerFluids();
    }
	/* Language File Syntax:
	 * Blocks: tile.unlocalizedName.name=Localized Name

-         Items: item.unlocalizedName.name=Localized Name

-         Entities: entity.unlocalizedName.name=Localized Name

-         Metadata Blocks: tile.unlocalizedBlockName.unlocalizedItemBlockForMetadataName.name=Localized Name

-         Metadata Items: item.unlocalizedItemName.itemMetadataName.name=Localized Name

tile.tutorialBlock.world.name=Tutorial Block
tile.tutorialBlock.nether.name=Nether Tutorial Block
tile.portalTutorialBlock.name=Portal Tutorial Block
 
item.tutorialItem.first.name=First Tutorial Item
item.tutorialItem.second.name=Second Tutorial Item
 
entity.tutorial mob.name=Tutorial Mob
*/
}
