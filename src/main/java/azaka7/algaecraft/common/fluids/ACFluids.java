package azaka7.algaecraft.common.fluids;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ACFluids {
	public static Fluid solutionSalt = new Fluid("saltWater").setStillIcon(FluidRegistry.WATER.getStillIcon()).setFlowingIcon(FluidRegistry.WATER.getFlowingIcon()).setUnlocalizedName("tile.algaecraft_saltwater.name").setDensity(FluidRegistry.WATER.getDensity()+100);
	public static Fluid solutionNaOH = new Fluid("sodiumHydroxide").setStillIcon(FluidRegistry.WATER.getStillIcon()).setFlowingIcon(FluidRegistry.WATER.getFlowingIcon()).setUnlocalizedName("tile.algaecraft_saltwater.name").setDensity(FluidRegistry.WATER.getDensity()+100);
	
	public static void registerFluids(){
		FluidRegistry.registerFluid(solutionSalt);
		FluidRegistry.registerFluid(solutionNaOH);
	}
}
