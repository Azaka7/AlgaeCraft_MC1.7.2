package azaka7.algaecraft.api;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import azaka7.algaecraft.AlgaeCraft;
import azaka7.algaecraft.common.items.ACItems;
import azaka7.algaecraft.api.Reference.*;

public class ItemReferences {

	public static final Map<String,Item> nameMap = new HashMap<String,Item>();
	public static final Map<String,ItemStack> nameStackMap = new HashMap<String,ItemStack>();
	
	/*Refer to AlgaeCraft items by referring to one of these objects.
	 * Example 1:
	 * Item item = itemSponge.getItem();
	 * Example 2:
	 * ItemStack stack = new ItemStack(itemSponge.getItem(),1,1);
	 *
	 * Refer to ItemStackObjects like so:
	 * ItemStack stack = itemChipRediron.getItemStack();
	 * 
	 */
	public static final ItemObject itemSponge = new ItemObject("drySponge");
	public static final ItemObject itemSpongeRed = new ItemObject("drySpongeRed");
	public static final ItemObject itemGeneric = new ItemObject("genericItems");
	public static final ItemObject itemAlgaeCooked = new ItemObject("algaeCooked");
	public static final ItemObject itemSeaweedCooked = new ItemObject("seaweedCooked");
	public static final ItemObject itemSquidRaw = new ItemObject("squidRaw");
	public static final ItemObject itemSquidCooked = new ItemObject("squidFried");
	public static final ItemObject itemSquidFried = new ItemObject("drySponge");
	public static final ItemObject itemSushiRaw = new ItemObject("sushiRaw");
	public static final ItemObject itemSushiCooked = new ItemObject("sushiCooked");
	public static final ItemObject itemKnifeIron = new ItemObject("knifeIron");
	public static final ItemObject itemKnifeGold = new ItemObject("knifeGold");
	public static final ItemObject itemLobster = new ItemObject("lobster");
	public static final ItemObject itemLobsterRaw = new ItemObject("lobsterRaw");
	public static final ItemObject itemLobsterCooked = new ItemObject("lobsterCooked");
	
	public static final ItemObject itemAerosBulb = new ItemObject("drySponge");
	public static final ItemObject itemScubaGoggles = new ItemObject("drySponge");
	public static final ItemObject itemScubaBCD = new ItemObject("drySponge");
	public static final ItemObject itemAirTankSmall = new ItemObject("drySponge");
	public static final ItemObject itemWetsuit = new ItemObject("drySponge");
	public static final ItemObject itemFlippers = new ItemObject("drySponge");
	public static final ItemObject itemFlask = new ItemObject("drySponge");
	public static final ItemObject itemRedironElectrolyzer = new ItemObject("drySponge");
	
	//ItemStacks
	public static final ItemStackObject itemChipRediron = new ItemStackObject("redironChip");
	public static final ItemStackObject itemGuayuleBranch = new ItemStackObject("guayuleBranch");
	public static final ItemStackObject itemLobsterBoiled = new ItemStackObject("lobsterBoiled");
	public static final ItemStackObject itemNeopreneTextile = new ItemStackObject("neopreneTextile");
	public static final ItemStackObject itemRubberBall = new ItemStackObject("rubberBall");
	public static final ItemStackObject itemRubberRaw = new ItemStackObject("rubberRaw");
	
	
}
