package azaka7.algaecraft.common.items;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemKnife extends ItemSword {

	public ItemKnife(ToolMaterial material) {
		super(material);
		this.maxStackSize = 1;
		this.setMaxDamage(150);
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
	
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
    {
		return false;
    }
	 
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return false;
	}

}
