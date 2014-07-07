package azaka7.algaecraft.client;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import azaka7.algaecraft.client.model.ModelLobster;
import azaka7.algaecraft.client.renderer.entity.RenderLobster;
import azaka7.algaecraft.client.renderer.tileentity.TileEntityRendererLobsterCage;
import azaka7.algaecraft.common.ACGameData;
import azaka7.algaecraft.common.CommonProxy;
import azaka7.algaecraft.common.entities.EntityLobster;
import azaka7.algaecraft.common.tileentity.TileEntityCage;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenders(){
		RenderingRegistry.registerEntityRenderingHandler(EntityLobster.class, new RenderLobster(new ModelLobster(), 0.8F));
		ClientRegistry.registerTileEntity(TileEntityCage.class, "lobsterCageRender", (TileEntitySpecialRenderer) new TileEntityRendererLobsterCage());
		//ClientRegistry.registerTileEntity(TileEntityWaterFilter.class, "", specialRenderer);
		
		RenderingRegistry.registerBlockHandler(new RenderBlockSimpleHandler(ACGameData.algaeModelID,false,"algae"));
		RenderingRegistry.registerBlockHandler(new RenderBlockSimpleHandler(ACGameData.coralModelID,false,"coral"));
		RenderingRegistry.registerBlockHandler(new RenderBlockSimpleHandler(ACGameData.spongeModelID,false,"sponge"));
		RenderingRegistry.registerBlockHandler(new RenderBlockSimpleHandler(ACGameData.seaweedModelID, false,"seaweed"));
		RenderingRegistry.registerBlockHandler(new RenderBlockSimpleHandler(ACGameData.waterBlockModelID, false,"water"));
	}
}
