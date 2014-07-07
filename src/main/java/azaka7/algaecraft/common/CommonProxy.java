package azaka7.algaecraft.common;

import azaka7.algaecraft.AlgaeCraft;
import azaka7.algaecraft.common.handlers.ACEventHandler;
import azaka7.algaecraft.common.items.ACItems;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class CommonProxy {
	
	public void registerEventHandler(){
		ACEventHandler.INSTANCE.initialize();
	}
	
	public void registerRenders(){}
	
}
