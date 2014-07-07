package azaka7.algaecraft.api.module;

import net.minecraft.item.Item;

public class ItemRegistryPackage {
	
	private final Item item;
	private  final String name;
	private String[] definitions;
	
	public ItemRegistryPackage(Item obj, String regnam){
		item = obj;
		name = regnam;
	}
	
	public ItemRegistryPackage setDefinition(String... def){
		this.definitions = def;
		return this;
	}
	
	public Item getItem(){
		return item;
	}
	
	public String getName(){
		return name;
	}
	
	public String[] getDefinitions(){
		return definitions;
	}
	
}
