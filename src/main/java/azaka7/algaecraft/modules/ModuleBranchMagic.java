package azaka7.algaecraft.modules;

import azaka7.algaecraft.api.module.Module;
import azaka7.algaecraft.api.module.ModuleBranch;

public class ModuleBranchMagic extends ModuleBranch {
	public static Module mod = new Module("magic", false);
	public static Module modHerb = new Module("herbology", true, true);
	public static Module modHieroglyph = new Module("hieroglyphics", true, false);
	public static Module modJewel = new Module("jewelry", true, false);
	public static Module modThaum = new Module("thaumics", true, false);
	
	public ModuleBranchMagic(){
		super(mod,modHerb,modHieroglyph,modJewel,modThaum);
	}
}
