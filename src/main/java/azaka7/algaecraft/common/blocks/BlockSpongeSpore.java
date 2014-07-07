package azaka7.algaecraft.common.blocks;

import java.util.Random;

import azaka7.algaecraft.common.ACGameData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSpongeSpore extends BlockBush {
	
	public Material[] canPlantOn = new Material[]{Material.clay, Material.grass, Material.ground, Material.rock, Material.sand};
	
	public final Block parent;
	public final Item item;
	
	public BlockSpongeSpore(Block sponge, Item itemSponge){
		super(Material.water);
		this.setStepSound(Block.soundTypeGrass);
		parent = sponge;
		item = itemSponge;
	}
	
	@Override
    public boolean isReplaceable(IBlockAccess world, int x, int y, int z)
    {
        return false;
    }
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
		if (!par1World.isRemote)
        {
        if (!this.canBlockStay(par1World, par2, par3, par4))
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlock(par2, par3, par4, Blocks.water, 0, 2);
        }
        if((par5Random.nextInt(10-(Math.round(par1World.getBlockLightValue(par2, par3, par4)/5)))==0)){
    		if(par1World.getBlock(par2, par3, par4)==this && par1World.getBlockMetadata(par2, par3, par4)<=1){
    			par1World.setBlock(par2, par3, par4, this, par1World.getBlockMetadata(par2, par3, par4)+1, 2);
    		}
    		else if(par1World.getBlock(par2, par3, par4)==this && par1World.getBlockMetadata(par2, par3, par4)==2){
    			par1World.setBlock(par2, par3, par4, parent, 0, 2);
    		}
    	}
        }
    }
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block p_149695_5_)
    {
        if (!this.canBlockStay(par1World, par2, par3, par4))
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlock(par2, par3, par4, Blocks.water, 0, 3);
        }
    }
	
	public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        Block below = par1World.getBlock(par2, par3-1, par4);
        Block above = par1World.getBlock(par2, par3+1, par4);
        boolean biome = false;
        for(int i = 0; i < ACGameData.biomeIDOceanList.length; i++){
        	if(par1World.getBiomeGenForCoords(par2, par4).biomeID == ACGameData.biomeIDOceanList[i]){
        		biome = true;
        		break;
        	}
        }
        boolean block = false;
        for(int i = 0; i < canPlantOn.length; i++){
        	if(below.getMaterial() == canPlantOn[i]){
        		block = true;
        		break;
        	}
        }
        /*if(block&&(var7 == Block.waterMoving.blockID||var7 == Block.waterStill.blockID)){
        	if(biome && !(BlockFilter.isBlockFiltered(par1World, par2, par3, par4, 1)||BlockFilter.isBlockFiltered(par1World, par2, par3, par4, 2))){
        		
        		return true;
        	}
        	if(BlockFilter.isBlockFiltered(par1World, par2, par3, par4, 0)||BlockFilter.isBlockFiltered(par1World, par2, par3, par4, 3)){
        		return true;
        	}
        }*/
        return block;// && biome;
    }
    
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        if(super.canPlaceBlockAt(par1World, par2, par3, par4)){
        	return this.canBlockStay(par1World, par2, par3, par4);
        }
        return false;
    }
	
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
		Random rand = par1World.rand;
        if(par5 == 0){
        	this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(this, 1));
        }
        if(par5 == 1){
        	if(rand.nextBoolean()){
        		this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(this, 2));
        	}else{
        		this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(this.item, 1));
        	}
        }
        if(par5 == 2){
        	if(rand.nextBoolean()){
        		this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(this, 3));
        	}else{
        		this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(this.item, 1));
        		this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(this, 1));
        	}
        }
    }
	
	//Rendering
	
	@Override
    public IIcon getIcon(int par1, int par2)
    {
		return parent.getIcon(par1, par2);
    }
	
	public int getRenderType()
    {
        return ACGameData.spongeModelID;
    }
	
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }
	
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
    	int m = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
    	float par5 = 0;
    	float par6 = 0;
    	float par7 = 1;
    	float parH = 1;
    	float par8 = 1;
    	
    	if (m==0){//0.375F, 0.0F, 0.375F, 0.625F, 0.25F, 0.625F
    		par5 = 0.375F;
        	par6 = 0.375F;
        	par7 = 0.625F;
        	parH = 0.25F;
        	par8 = 0.625F;
    	}
    	else if (m==1){//0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F
    		par5 = 0.25F;
        	par6 = 0.25F;
        	par7 = 0.75F;
        	parH = 0.5F;
        	par8 = 0.75F;
    	}
    	else if (m==2){//0.125F, 0.0F, 0.125F, 0.875F, 0.75F, 0.875F
    		par5 = 0.125F;
        	par6 = 0.125F;
        	par7 = 0.875F;
        	parH = 0.75F;
        	par8 = 0.875F;
    	}
    	
    	this.setBlockBounds(par5, 0.0F, par6, par7, parH, par8);
    }
}
