package azaka7.algaecraft.common.blocks;

import java.util.Random;

import azaka7.algaecraft.AlgaeCraft;
import azaka7.algaecraft.api.BlockReferences;
import azaka7.algaecraft.common.ACGameData;
import azaka7.algaecraft.common.CommonProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.EnumPlantType;

public class BlockAlgae extends BlockBush {
	
	public BlockAlgae() {
		super(Material.grass);
		float var3 = 0.5F;
        float var4 = 0.015625F;
		this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var4, 0.5F + var3);
		this.setStepSound(soundTypeSnow);
	}
	
	@Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
		return EnumPlantType.Water;
    }
	
	public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
		Block below = par1World.getBlock(par2, par3-1, par4);
		
		//if(below != Blocks.water && below != BlockReferences.blockLobsterCage.getBlock()/*ACBlocks.blockLobsterCage*/){return false;}
		
		if(below.getMaterial() != Material.water || below == Blocks.flowing_water){return false;}
		
		boolean isSwamp = false;
		if(ACGameData.biomeIDSwampList.length > 1){
			for(int n = 0; n<ACGameData.biomeIDSwampList.length; n++){
				if(ACGameData.biomeIDSwampList[n]==par1World.getBiomeGenForCoords(par2, par4).biomeID|| BiomeGenBase.swampland.biomeID==par1World.getBiomeGenForCoords(par2, par4).biomeID){
					isSwamp=true;
					break;
				}
			}
		}
		if(!isSwamp){
			BiomeGenBase[] swamps = BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SWAMP);
			for(int n=0;n<swamps.length;n++){
				if(swamps[n].biomeID==par1World.getBiomeGenForCoords(par2, par4).biomeID || BiomeGenBase.swampland.biomeID==par1World.getBiomeGenForCoords(par2, par4).biomeID){
					isSwamp=true;
					break;
				}
			}
		}
		boolean filter = false;
        boolean badfilter = false;
        for(int x = -4; x <= 4; x++){
        	for(int y = -4; y <= 4; y++){
        		for(int z = -4; z <= 4; z++){
                	if(BlockWaterFilter.isLocationValid(par1World, par2, par3-1, par4, BlockWaterFilter.EnumWaterType.SWAMP, par2+x, par3+y, par4+z)){
                		filter = true;
                		break;
                	}
                	else if(BlockWaterFilter.isLocationInvalid(par1World, par2, par3-1, par4, BlockWaterFilter.EnumWaterType.SWAMP, par2+x, par3+y, par4+z)){
                		badfilter = true;
                		break;
                	}
                }
            }
        }
        //System.out.println(filter);
		return filter || (isSwamp && !badfilter);
		//return false;
    }
	
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);
        if (par5Random.nextInt(8) == 0){
        	if(this.canBlockStay(par1World, par2+1, par3, par4)&&par1World.getBlock(par2+1, par3, par4)==Blocks.air){
        		par1World.setBlock(par2+1, par3, par4, this, 0, 2);
        	}
        }
        if (par5Random.nextInt(8) == 0){
        	if(this.canBlockStay(par1World,par2-1, par3, par4)&&par1World.getBlock(par2-1, par3, par4)==Blocks.air){
        		par1World.setBlock(par2-1, par3, par4, this, 0, 2);
        	}
        }
        if (par5Random.nextInt(8) == 0){
        	if(this.canBlockStay(par1World,par2, par3, par4+1)&&par1World.getBlock(par2, par3, par4+1)==Blocks.air){
        		par1World.setBlock(par2, par3, par4+1, this, 0, 2);
        	}
        }
        if (par5Random.nextInt(8) == 0){
        	if(this.canBlockStay(par1World,par2, par3, par4-1)&&par1World.getBlock(par2, par3, par4-1)==Blocks.air){
        		par1World.setBlock(par2, par3, par4-1, this, 0, 2);
        	}
        }
    }
	
	public int getRenderType()
    {
        return ACGameData.algaeModelID;
    }
	
	public int getRenderBlockPass()
    {
		return ACBlocks.renderPass();
    }
	
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return (par1IBlockAccess.getBlock(par2, par3, par4)==Blocks.air || !par1IBlockAccess.getBlock(par2, par3, par4).isOpaqueCube()) && !(par1IBlockAccess.getBlock(par2, par3, par4)==this) || par5==1;
    }
	
	@SideOnly(Side.CLIENT)
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
		par5Entity.motionX /= 1.15;
		par5Entity.motionY /= 1.1;
		par5Entity.motionZ /= 1.15;
	}

}