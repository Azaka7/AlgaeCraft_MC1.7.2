package azaka7.algaecraft.config;

import net.minecraftforge.common.config.Configuration;

public class ACConfiguration {
	
	private static Configuration config;
	private static String section;
	
	public static void setup(Configuration cfg){
		config = cfg;
	}
	
	public static void startSection(String s){
		section = s;
	}
	
	public static void addComment(String s){
		config.addCustomCategoryComment(section, s);
	}
	
	public static int getInt(String s, int def){
		return config.get(section,s,def).getInt();
	}
	
	public static double getDouble(String s, double def){
		return config.get(section,s,def).getDouble(def);
	}
	
	public static boolean getBool(String s, boolean def){
		return config.get(section,s,def).getBoolean(def);
	}
	
	public static String getString(String s, String def){
		return config.get(section,s,def).getString();
	}
	
	public static int[] getIntArray(String s, int[] def){
		return config.get(section,s,def).getIntList();
	}
	
	public static double[] getDoubleArray(String s, double[] def){
		return config.get(section,s,def).getDoubleList();
	}
	
	public static boolean[] getBoolArray(String s, boolean[] def){
		return config.get(section,s,def).getBooleanList();
	}
	
	public static String[] getStringArray(String s, String[] def){
		return config.get(section,s,def).getStringList();
	}
	
	public static void endSection(){
		section = "General";
	}

}
