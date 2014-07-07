package azaka7.algaecraft.common.blocks;

import java.util.Random;

import azaka7.algaecraft.AlgaeCraft;
import azaka7.algaecraft.common.ACGameData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockSeaweed extends Block {
	
	public Material[] canPlantOn = new Material[]{Material.clay, Material.grass, Material.ground, Material.rock, Material.sand};
	
	protected BlockSeaweed() {
		super(Material.water);
		this.setStepSound(soundTypeGrass);
	}
	
	public boolean isBlockReplaceable(World world, int x, int y, int z)
    {
    	return false;
    }
	
	@Override
	public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
		Block blockBelow = par1World.getBlock(par2, par3-1, par4);
		//boolean belowIsHard = (blockIDBelow == Block.cobblestone.blockID || blockIDBelow == Block.stone.blockID || blockIDBelow == Block.cobblestoneMossy.blockID || blockIDBelow == Block.gravel.blockID || blockIDBelow == Block.sandStone.blockID);
		boolean aboveIsWater = (par1World.getBlock(par2, par3+1, par4) == Blocks.water || par1World.getBlock(par2, par3+1, par4) == Blocks.flowing_water);
		boolean belowIsSeaweed = (par1World.getBlock(par2, par3-1, par4)==this);
		boolean aboveIsSeaweed = (par1World.getBlock(par2, par3+1, par4)==this);
		boolean biome = false;
        for(int i = 0; i < ACGameData.biomeIDOceanList.length; i++){
        	if(par1World.getBiomeGenForCoords(par2, par4).biomeID == ACGameData.biomeIDOceanList[i]){
        		biome = true;
        		break;
        	}
        }
        boolean belowIsHard = false;
        for(int i = 0; i < canPlantOn.length; i++){
        	if(blockBelow.getMaterial() == canPlantOn[i]){
        		belowIsHard = true;
        		break;
        	}
        }
        boolean filter = false;
        boolean badfilter = false;
        for(int x = -4; x <= 4; x++){
        	for(int y = -4; y <= 4; y++){
        		for(int z = -4; z <= 4; z++){
                	if(BlockWaterFilter.isLocationValid(par1World, par2, par3, par4, BlockWaterFilter.EnumWaterType.OCEAN, par2+x, par3+y, par4+z)){
                		filter = true;
                		break;
                	}
                	else if(BlockWaterFilter.isLocationInvalid(par1World, par2, par3, par4, BlockWaterFilter.EnumWaterType.OCEAN, par2+x, par3+y, par4+z)){
                		badfilter = true;
                		break;
                	}
                }
            }
        }
        boolean block = (belowIsHard||belowIsSeaweed) && (aboveIsWater||aboveIsSeaweed);
        return block && (filter || (biome && !badfilter));
        /*
        if((belowIsHard||belowIsSeaweed)&&(aboveIsWater||aboveIsSeaweed)){
        	if(biome &&!(BlockFilter.isBlockFiltered(par1World, par2, par3, par4, 1)||BlockFilter.isBlockFiltered(par1World, par2, par3, par4, 2))){
        		return true;
        	}
        	if(BlockFilter.isBlockFiltered(par1World, par2, par3, par4, 0)||BlockFilter.isBlockFiltered(par1World, par2, par3, par4, 3)){
        		return true;
        	}
        }
        return false;*/
    }
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		return this.canBlockStay(par1World, par2, par3, par4);
	}
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block p_149695_5_)
    {
		if(!this.canBlockStay(par1World, par2, par3, par4)){
			this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(this));
			par1World.setBlock(par2, par3, par4, Blocks.water, 0, 3);
		}
    }
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
        	if(!this.canBlockStay(par1World, par2, par3, par4)){
        		this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(this));
    			par1World.setBlock(par2, par3, par4, Blocks.water, 0, 3);
    		}
        	if((par5Random.nextInt(8)==1) && (par5Random.nextInt(200)>(par5Random.nextInt(50)+150))){
        		if(this.canPlaceBlockAt(par1World, par2, par3+1, par4)){
        			par1World.setBlock(par2, par3+1, par4, this, 0, 3);
        		}
        	}
        }
    }
	
	public void onBlockHarvested(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer) {
		if (!par1World.isRemote){
			if(!par6EntityPlayer.capabilities.isCreativeMode){
			super.dropBlockAsItem(par1World, par2, par3, par4, par5, 1);}
		}
	}
	
	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, Block block, int par6){
		par1World.setBlock(par2, par3, par4, Blocks.water, 0, 3);
	}
	
	public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
	public boolean isOpaqueCube()
    {
        return false;
    }
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	public int getRenderType()
    {
        //return 6;
		return ACGameData.seaweedModelID;
    }
	
	public int getRenderBlockPass()
    {
        return 1;
    }

}
