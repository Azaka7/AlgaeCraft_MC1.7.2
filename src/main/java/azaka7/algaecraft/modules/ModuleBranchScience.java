package azaka7.algaecraft.modules;

import azaka7.algaecraft.api.module.Module;
import azaka7.algaecraft.api.module.ModuleBranch;

public class ModuleBranchScience extends ModuleBranch {
	
	public static Module mod = new Module("science", false);
	public static Module modScuba = new Module("scuba", true, true);
	public static Module modChem = new Module("chemistry", true, false);
	public static Module modMach = new Module("machines", true, false);
	public static Module modHydro = new Module("hydrodynamics", true, false);
	
	public ModuleBranchScience(){
		super(mod,modScuba,modChem,modMach,modHydro);
	}
	
}
