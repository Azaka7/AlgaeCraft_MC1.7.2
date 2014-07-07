package azaka7.algaecraft.api;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import azaka7.algaecraft.api.Reference.*;

public class BlockReferences {

	public static final Map<String,Block> nameMap = new HashMap<String,Block>();
	
	/*Refer to AlgaeCraft blocks by referring to one of these objects.
	 * Example 1:
	 * Block block = blockLimestone.getBlock();
	 * Example 2:
	 * ItemStack stack = new ItemStack(blockLimestone.getBlock(),1,1);
	 *
	 * Refer to ItemStackObjects like so:
	 * ItemStack stack = blockLimestoneSmooth.getItemStack();
	 * 
	 */
	public static final BlockObject blockLimestone = new BlockObject("limestone");
	public static final BlockObject blockLobsterCage = new BlockObject("lobsterCage");
	public static final BlockObject blockAlgae = new BlockObject("algae");
	
	public static ItemStackObject blockLimestoneSmooth = new ItemStackObject("limestoneSmooth");
	public static ItemStackObject blockLobsterCageEmpty = new ItemStackObject("lobsterCageEmpty");
	public static ItemStackObject blockLobsterCageFull = new ItemStackObject("lobsterCageLobster");
}
