package azaka7.algaecraft.common.potion;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cpw.mods.fml.common.registry.LanguageRegistry;
import azaka7.algaecraft.config.ACConfiguration;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.DamageSource;

public class ACPotions {
	
	public static final String aerosEffect;
	
	public static Potion aqueous;
	public static Potion greekFire;
	
	public static void registerPotions() throws Exception{
		ACConfiguration.startSection("Potions");
		aqueous = new PotionAqueous(ACConfiguration.getInt("Aqueous Potion Effect ID", getAvailablePotionID()));
		greekFire = new PotionGreekFire(ACConfiguration.getInt("Greek Fire Effect ID", getAvailablePotionID()));
		
		Field f1 = PotionHelper.class.getDeclaredField(getObfuscatedString("potionRequirements"));
		f1.setAccessible(true);
		HashMap list1 = (HashMap) f1.get(PotionHelper.class);
		list1.put(Integer.valueOf(aqueous.getId()), "0 & 1 & 2 & 3 & 0+6");
		
		Field f2 = PotionHelper.class.getDeclaredField(getObfuscatedString("potionAmplifiers"));
		f2.setAccessible(true);
		HashMap list2 = (HashMap) f2.get(PotionHelper.class);
		list2.put(Integer.valueOf(aqueous.getId()), "5");
	}
	
	static{
		//PotionHelper.field_151423_m should be puffer fish
		aerosEffect = "+0+1+2+3&4-4+13";
	}
	
	private static String getObfuscatedString(String s){
		//update for each version of Minecraft. currently for MC1.7.2
		if(PotionHelper.class.getName() == "net.minecraft.potion.PotionHelper"){
			return s;
		}
		
		if(s == "potionRequirements"){
			return "field_77927_l";
		}
		if(s == "potionAmplifiers"){
			return "field_77928_m";
		}
		return "potionRequirements";
	}
	
	public static int getAvailablePotionID(){
		for(int c = 1; c < Potion.potionTypes.length; c++){
			if(Potion.potionTypes[c] == null){
				return c;
			}
		}
		return Potion.potionTypes.length-1;
	}
	
	public static void setFinalStatic(Field field, Object newValue, Potion potion) throws Exception {
	      field.setAccessible(true);

	      Field modifiersField = Field.class.getDeclaredField("modifiers");
	      modifiersField.setAccessible(true);
	      modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

	      field.set(potion, newValue);
	      }
	

	public static void setPotionIconIndex(int i1, int i2, Potion pot) throws Exception{
		ACPotions.setFinalStatic(Potion.class.getDeclaredField("statusIconIndex"), i1 + i2 * 8, pot);
	}
	
	public static class PotionAqueous extends Potion{

		protected PotionAqueous(int par1) {
			super(par1, false, 0x0000CC);
			this.setPotionName("potion.aqueous");
			try {
				ACPotions.setPotionIconIndex(0, 2, this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public boolean isReady(int par1, int par2)
	    {
			return true;
	    }
		
		public void performEffect(EntityLivingBase par1EntityLivingBase, int par2)
	    {
			par1EntityLivingBase.setAir(300);
			
			int dur = par1EntityLivingBase.getActivePotionEffect(aqueous).getDuration();
			int amp = par2;
			
			if(par1EntityLivingBase.isInWater() && amp > 0){
        		par1EntityLivingBase.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 20, amp-1));
        	}
			
			int k = 15 >> amp;
            if(k > 0 ? dur % k == 0 : true){
            	if(par1EntityLivingBase.isInWater()){
            		if(par1EntityLivingBase.getHealth() +1 <= par1EntityLivingBase.getMaxHealth())
            		par1EntityLivingBase.setHealth(par1EntityLivingBase.getHealth()+1);
            	}
            }
	    }
		
	}
	
	public static class PotionGreekFire extends Potion{

		protected PotionGreekFire(int par1) {
			super(par1, false, 0x6FFF20);
			this.setPotionName("potion.greekFire");
			try {
				ACPotions.setPotionIconIndex(7, 1, this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public boolean isReady(int par1, int par2)
	    {
			return true;
	    }
		
		public void performEffect(EntityLivingBase par1EntityLivingBase, int par2)
	    {
			par1EntityLivingBase.attackEntityFrom(DamageSource.magic, 1);
			par1EntityLivingBase.setFire(5);
	    }
		
	}
	
	public class ACPotionEffects{
		PotionEffect effectAqueous = new PotionEffect(0, 0, 0, false);
	}
	
}
