package azaka7.algaecraft.common.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemDamageableCrafting extends Item {
	private boolean leavesCrafting;
	
	ItemDamageableCrafting(int md, boolean leave, boolean reparable){
		this.setMaxDamage(md);
		leavesCrafting = leave;
		this.hasSubtypes = false;
		this.maxStackSize = 1;
		this.canRepair = reparable;
	}
	
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
    {
		return leavesCrafting;
    }
	
	public boolean hasContainerItem()
    {
        return true;
    }
	
	public ItemStack getContainerItemStack(ItemStack itemStack)
    {
		itemStack.setItemDamage(itemStack.getItemDamage()+1);
		return itemStack;
    }
}
