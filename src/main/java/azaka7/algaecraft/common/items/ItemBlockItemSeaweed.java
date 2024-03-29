package azaka7.algaecraft.common.items;

import azaka7.algaecraft.common.blocks.ACBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlockItemSeaweed extends ItemBlockItem {

	public ItemBlockItemSeaweed(Block block, Boolean floats, String img) {
		super(block, floats, img);
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par7 != 1)
        {
            return false;
        }
        else if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            if (ACBlocks.blockSeaweed.canPlaceBlockAt(par3World, par4, par5+1, par6))
            {
                par3World.setBlock(par4, par5 + 1, par6, ACBlocks.blockSeaweed, 0, 2);
                --par1ItemStack.stackSize;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

}
