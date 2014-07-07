package azaka7.algaecraft.common.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAirTank extends Item {
	
	public ItemAirTank(int i){
		super();
		this.setMaxDamage(i);
		this.setMaxStackSize(1);
		this.setHasSubtypes(false);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if(par3EntityPlayer.inventory.armorItemInSlot(2) != null && par3EntityPlayer.inventory.armorItemInSlot(2).getItem() instanceof ItemBCD){
			//System.out.println("found bcd");
			ItemStack bcd = par3EntityPlayer.inventory.armorItemInSlot(2);
			if(!ItemBCD.setTank(bcd, par1ItemStack)){
				//System.out.println("replacing tank");
				par1ItemStack = ItemBCD.setTankReturnOld(bcd, par1ItemStack);
			}
			else{
				par1ItemStack.stackSize = 0;
			}
		}
		return par1ItemStack;
    }
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add("Breaths: "+((getMaxDamage(par1ItemStack)-getDamage(par1ItemStack)))+"/"+(getMaxDamage(par1ItemStack)));
	}
	
	
	
}
