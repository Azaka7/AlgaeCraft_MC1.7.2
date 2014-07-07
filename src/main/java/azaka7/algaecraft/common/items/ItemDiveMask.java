package azaka7.algaecraft.common.items;

import java.util.Map;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import azaka7.algaecraft.AlgaeCraft;
import azaka7.algaecraft.config.ACConfiguration;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class ItemDiveMask extends ItemArmor {
	
	protected static final ResourceLocation maskOverlay = new ResourceLocation(AlgaeCraft.MODID+":textures/armor/maskOverlay.png");
	
	private String armorImg;
	
	//public static boolean doNightVis = false;
	
	public ItemDiveMask(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, String armorName) {
		super(par2EnumArmorMaterial, par3, 0);
        armorImg = armorName;
        ACConfiguration.endSection();
        //doNightVis = false;
	}
	
	@SideOnly(Side.CLIENT)
    public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY){
		int k = resolution.getScaledWidth();
		int l = resolution.getScaledHeight();
		
		renderMaskOverlay(k,l);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
		/*if(!doNightVis){return;}
		
		ItemStack cure = new ItemStack(ACItems.itemScubaGoggles);
		PotionEffect vision = new PotionEffect(Potion.nightVision.id, 202, 0, true);
		vision.addCurativeItem(cure);
		if(player.isInsideOfMaterial(Material.water)){
			player.addPotionEffect(vision);//Potion.waterBreathing.getClass();
			if(world.isRemote)
			//player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 5, 0, true));
			player.getEntityData().setBoolean("AC_Inwater", true);
		}
		else if(player.getEntityData().getBoolean("AC_Inwater")){
			player.getEntityData().setBoolean("AC_Inwater", false);
			if(player.isPotionActive(Potion.nightVision)){
				if(player.getActivePotionEffect(Potion.nightVision).getDuration() <= 202){
					player.curePotionEffects(cure);
				}
			}
		}*/
    }
	
	protected void renderMaskOverlay(int par1, int par2)
    {
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        Minecraft.getMinecraft().getTextureManager().bindTexture(maskOverlay);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D, (double)par2, -90.0D, 0.0D, 1.0D);
        tessellator.addVertexWithUV((double)par1, (double)par2, -90.0D, 1.0D, 1.0D);
        tessellator.addVertexWithUV((double)par1, 0.0D, -90.0D, 1.0D, 0.0D);
        tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return AlgaeCraft.MODID+":textures/armor/"+armorImg+".png";
    }
	
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity)
    {
		return armorType == 0;
    }
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		if(ACItems.itemScubaGoggles == par1ItemStack.getItem()){
			return (ACItems.itemRubberBallG.getItem() == par2ItemStack.getItem() && ACItems.itemRubberBallG.getItemDamage() == par2ItemStack.getItemDamage()) || super.getIsRepairable(par1ItemStack,par2ItemStack) ;
		}
		else{
			return super.getIsRepairable(par1ItemStack, par2ItemStack);
		}
	}
	
	public static ItemStack upgrade(ItemStack mask){
		if(mask.getTagCompound() == null){mask.setTagCompound(new NBTTagCompound());}
		Map map = EnchantmentHelper.getEnchantments(mask);
		if(map.containsKey(Enchantment.respiration.effectId)){
			int i = (Integer) map.get(Enchantment.respiration.effectId);
			map.remove(Enchantment.respiration.effectId);
			map.put(Enchantment.respiration.effectId, (i + 1) <= 3 ? i+1 : i);
		}
		else{
			map.put(Enchantment.respiration.effectId, 1);
		}
		EnchantmentHelper.setEnchantments(map, mask);
		return mask;
	}

}