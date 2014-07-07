package azaka7.algaecraft.api.module;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class BlockRegistryPackage {
	
	private final Block block;
	private final String name;
	private final Class<? extends ItemBlock> item;
	private final Object[] ctorArgs;
	private String[] definitions;
	
	
	public BlockRegistryPackage(Block obj, String regnam){
		this(obj, regnam, ItemBlock.class);
	}
	
	public BlockRegistryPackage(Block obj, String regnam, Class<? extends ItemBlock> clazz, Object... args){
		block = obj;
		name = regnam;
		item = clazz;
		ctorArgs = args;
	}
	
	public BlockRegistryPackage setDefinitions(String[] def){
		this.definitions = def;
		return this;
	}
	
	public Block getBlock(){
		return block;
	}
	
	public String getName(){
		return name;
	}
	
	public Class<? extends ItemBlock> getItemBlock(){
		return item;
	}
	
	public Object[] getCtorArgs(){
		return ctorArgs;
	}
	
	public String[] getDefinitions(){
		return definitions;
	}
	
}
