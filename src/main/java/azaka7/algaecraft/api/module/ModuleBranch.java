package azaka7.algaecraft.api.module;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import azaka7.algaecraft.AlgaeCraft;
import azaka7.algaecraft.api.BlockReferences;
import azaka7.algaecraft.api.ItemReferences;
import azaka7.algaecraft.config.ACConfiguration;

public class ModuleBranch {
	public List<Module> modules = new ArrayList<Module>();
	
	public boolean active;
	
	public ModuleBranch(Module... mods){
		for(Module mod : mods){
			modules.add(mod);
		}
		active = mods[0].isActive();
	}
	
	public void register(){
		ACConfiguration.startSection(capitalize("Module " + modules.get(0).name));
		ACConfiguration.addComment("Set \"Active\" to False to disable entire branch.");
		modules.get(0).setActive(ACConfiguration.getBool("Active", active));
		active = modules.get(0).isActive();
		for(int i = 1; i < modules.size(); i++){
			modules.get(i).setActive(ACConfiguration.getBool(capitalize(modules.get(i).name), modules.get(i).isActive()));
		}
		ACConfiguration.endSection();
	}
	
	public Module registerItems(Module thism, ItemRegistryPackage... toRegister){
		if(!this.active && thism.toggleable){return thism;}
		
		for(ItemRegistryPackage itemInfo : toRegister){
			GameRegistry.registerItem(itemInfo.getItem(), itemInfo.getName(), AlgaeCraft.MODID);
			ItemReferences.nameMap.put(thism.name, itemInfo.getItem());
			
			for(String definition : itemInfo.getDefinitions()){
				OreDictionary.registerOre(definition, itemInfo.getItem());
			}
		}
		
		return thism;
	}
	
	public Module registerBlocks(Module thism, BlockRegistryPackage... toRegister){
		if(!this.active && thism.toggleable){return thism;}
		
		for(BlockRegistryPackage blockInfo : toRegister){
			GameRegistry.registerBlock(blockInfo.getBlock(), blockInfo.getItemBlock(), blockInfo.getName(), AlgaeCraft.MODID, blockInfo.getCtorArgs());
			BlockReferences.nameMap.put(thism.name, blockInfo.getBlock());
			
			for(String definition : blockInfo.getDefinitions()){
				OreDictionary.registerOre(definition, blockInfo.getBlock());
			}
		}
		
		return thism;
	}
	
	public Module getModule(String s){
		if(!active){
			return modules.get(0);
		}
		for(Module mod : modules){
			if(mod.name == s){
				return mod;
			}
		}
		return null;
	}
	
	private String capitalize(String s){
		String ret = s;
		char c = s.charAt(0);
		c = Character.toUpperCase(c);
		ret = s.substring(1);
		ret = c+ret;
		return ret;
	}
}
