package azaka7.algaecraft.api;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Reference {
	String object;
	
	public static class ItemObject extends Reference{
		
		ItemObject(String s){
			object = s;
		}
		
		public Item getItem(){
			try{
				return ItemReferences.nameMap.get(object);
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
	}
	
public static class ItemStackObject extends Reference{
		
		ItemStackObject(String s){
			object = s;
		}
		
		public ItemStack getItemStack(){
			try{
				return ItemReferences.nameStackMap.get(object).copy();
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
	}
	
	public static class BlockObject extends Reference{
		
		BlockObject(String s){
			object = s;
		}
		
		public Block getBlock(){
			try{
				return BlockReferences.nameMap.get(object);
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
	}
	
public static class EntityClassObject extends Reference{
		
		EntityClassObject(String s){
			object = s;
		}
		
		public Class<? extends Entity> getEntityClass(){
			try{
				return azaka7.algaecraft.common.entities.ACEntities.nameMap.get(object);
			}
			catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
	}
}
