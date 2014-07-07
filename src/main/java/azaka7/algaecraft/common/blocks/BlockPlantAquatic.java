package azaka7.algaecraft.common.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockPlantAquatic extends BlockBush implements IGrowable {
	
	public String[] iconNames;
	public IIcon[] icons;
	
	public int growChance;
	
	public BlockPlantAquatic(int chance, String[] stateNames) {
		super(Material.water);
		iconNames = stateNames;
		growChance = chance;
        this.setTickRandomly(true);
		this.setHardness(0.0F);
        this.setStepSound(soundTypeGrass);
	}
	
	public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
        super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);

        if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9)
        {
            int l = p_149674_1_.getBlockMetadata(p_149674_2_, p_149674_3_, p_149674_4_);

            if (l < 7)
            {
                float f = this.func_149864_n(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);

                if (p_149674_5_.nextInt((int)(25.0F / f) + 1) == 0)
                {
                    ++l;
                    p_149674_1_.setBlockMetadataWithNotify(p_149674_2_, p_149674_3_, p_149674_4_, l, 2);
                }
            }
        }
    }
	
	//canBonemeal
	@Override
	public boolean func_149851_a(World world, int x, int y, int z, boolean isRemote) {
		return false;
	}
	
	//canBonemealWithChance
	@Override
	public boolean func_149852_a(World world, Random rand, int x, int y, int z) {
		
		return false;
	}
	
	//onBonemeal
	@Override
	public void func_149853_b(World world, Random rand, int x, int y, int z) {
		
	}

}
