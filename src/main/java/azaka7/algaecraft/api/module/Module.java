package azaka7.algaecraft.api.module;

import azaka7.algaecraft.AlgaeCraft;
import azaka7.algaecraft.api.BlockReferences;
import azaka7.algaecraft.api.ItemReferences;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class Module {
	
	public final String name;
	public final boolean toggleable;
	
	private boolean active;
	
	public Module(String s){
		this(s, true);
	}
	
	public Module(String s, boolean b){
		this(s, b, !b);
	}
	public Module(String s, boolean b, boolean b2){
		name = s;
		toggleable = b;
		active = b2;
	}
	
	public void setActive(boolean b){
		if(toggleable){
			active = b;
		}
	}
	
	public boolean isActive(){
		return active || !toggleable;
	}
	
	public Module registerItems(ItemRegistryPackage... toRegister){
		if(!this.active && this.toggleable){return this;}
		
		for(ItemRegistryPackage itemInfo : toRegister){
			GameRegistry.registerItem(itemInfo.getItem(), itemInfo.getName(), AlgaeCraft.MODID);
			ItemReferences.nameMap.put(name, itemInfo.getItem());
			
			for(String definition : itemInfo.getDefinitions()){
				OreDictionary.registerOre(definition, itemInfo.getItem());
			}
		}
		
		return this;
	}
	
	public Module registerBlocks(BlockRegistryPackage... toRegister){
		if(!this.active && this.toggleable){return this;}
		
		for(BlockRegistryPackage blockInfo : toRegister){
			GameRegistry.registerBlock(blockInfo.getBlock(), blockInfo.getItemBlock(), blockInfo.getName(), AlgaeCraft.MODID, blockInfo.getCtorArgs());
			BlockReferences.nameMap.put(name, blockInfo.getBlock());
			
			for(String definition : blockInfo.getDefinitions()){
				OreDictionary.registerOre(definition, blockInfo.getBlock());
			}
		}
		
		return this;
	}
	
}
