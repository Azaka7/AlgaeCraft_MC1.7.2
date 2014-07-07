package azaka7.algaecraft.common.blocks;

import java.util.Random;

import azaka7.algaecraft.common.ACGameData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockAerosPlantae extends BlockBush {

	private static final Material[] canPlantOn = new Material[]{Material.sand,Material.rock,Material.ground};

	protected BlockAerosPlantae() {
		super(Material.water);
		this.setStepSound(this.soundTypeGrass);
		this.setLightLevel(0.4F);
	}
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	if(!this.canBlockStay(par1World, par2, par3, par4)){
    		this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(this,1,par1World.getBlockMetadata(par2, par3, par4)));
    		par1World.setBlock(par2, par3, par4, Blocks.water, 0, 3);
    	}
    	else if(par1World.getBlock(par2, par3-1, par4) == Blocks.air){
    		this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(this,1,par1World.getBlockMetadata(par2, par3, par4)));
    		par1World.setBlock(par2, par3, par4, Blocks.water, 0, 3);
    	}
    	if(par5Random.nextInt(10)==0 && par5Random.nextBoolean()){
    		int metadata = par1World.getBlockMetadata(par2, par3, par4);
    		this.tryToGrow(par1World,metadata,par2,par3,par4, par5Random);
    	}
        super.updateTick(par1World, par2, par3, par4, par5Random);
    }
    
    private boolean tryToGrow(World par1World, int par2Metadata, int x, int y, int z, Random r){
    	if(this.canBlockStay(par1World, x, y, z) && par2Metadata <= 7 && par2Metadata >= 4){
    		par1World.setBlock(x, y, z, this, par2Metadata-4, 2);
    		return true;
    	}
    	else if(this.canBlockStay(par1World, x, y, z) && par2Metadata <= 3 && par2Metadata >= 0 && r.nextBoolean()){
    		//System.out.println("Secrets await....");
    		return false;
    	}
    	return false;
    }
	
	public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        Block var6 = par1World.getBlock(par2, par3-1, par4);
        Block var7 = par1World.getBlock(par2, par3+1, par4);
        boolean biome = false;
        for(int i = 0; i < ACGameData.biomeIDOceanList.length; i++){
        	if(par1World.getBiomeGenForCoords(par2, par4).biomeID == ACGameData.biomeIDOceanList[i]){
        		biome = true;
        		break;
        	}
        }
        boolean block = false;
        for(int i = 0; i < this.canPlantOn .length; i++){
        	if(var6.getMaterial() == this.canPlantOn[i] && var6.isSideSolid(par1World, par2, par3, par4, ForgeDirection.UP)){
        		block = true;
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
        return block && (filter || (biome && !badfilter));
    }
	
	@Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block p_149695_5_)
    {
    	if(!this.canBlockStay(par1World, par2, par3, par4)){
    		this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(this,1,par1World.getBlockMetadata(par2, par3, par4)));
    		par1World.setBlock(par2, par3, par4, Blocks.water, 0, 3);
    	}
    }
	
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        if(super.canPlaceBlockAt(par1World, par2, par3, par4)){
        	return this.canBlockStay(par1World, par2, par3, par4);
        }
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }
	
	/**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
    	return ACGameData.coralModelID;
    }
    
    @Override
    public boolean isReplaceable(IBlockAccess world, int x, int y, int z)
    {
        return false;
    }
}
