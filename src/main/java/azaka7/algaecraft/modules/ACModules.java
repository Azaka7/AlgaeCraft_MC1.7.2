package azaka7.algaecraft.modules;

import azaka7.algaecraft.api.module.Module;
import azaka7.algaecraft.api.module.ModuleBranch;

public class ACModules {
	
	public static ModuleBranch branchScience;
	public static ModuleBranch branchMagic;
	public static ModuleBranch branchNature;
	
	public static ModuleBranch branchAtlantian;
	
	
	
	public static void initialize(){
		branchScience = new ModuleBranchScience();
		branchScience.register();
		
		branchMagic = new ModuleBranchMagic();
		branchMagic.register();
		
		branchNature = new ModuleBranch(
				new Module("nature", false),
				new Module("creatures", true, false),
				new Module("plants", true, false),
				new Module("foods", true, false),
				new Module("biomes", false, false));
		branchNature.register();
		
		branchAtlantian = new ModuleBranch(
				new Module("atlantian", false),
				new Module("future", true, false),
				new Module("alchemy", true, false),
				new Module("bosses", true, false),
				new Module("hadal", true, false));
		branchAtlantian.register();
	}
	
}
