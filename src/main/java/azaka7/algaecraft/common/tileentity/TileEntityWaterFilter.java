package azaka7.algaecraft.common.tileentity;

import java.util.ArrayList;
import java.util.List;

import azaka7.algaecraft.common.handlers.ACPathingHandler;
import azaka7.algaecraft.common.handlers.ACPathingHandler.Pos;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;

public class TileEntityWaterFilter extends TileEntity {
	
	private List<ACPathingHandler.Pos> pathmap = new ArrayList<ACPathingHandler.Pos>();
	
	private boolean worldloadInit = true;
	
	public void updateEntity()
    {
		if (this.worldObj.getTotalWorldTime() % 80L == 0L)
        {
			//System.out.println("Time: "+Minecraft.getMinecraft().getIntegratedServer().getTickCounter());
			this.pathmap.clear();
			ACPathingHandler.Pos pos = new ACPathingHandler.Pos(this.xCoord,this.yCoord,this.zCoord);
			this.pathmap.addAll(ACPathingHandler.INSTANCE.getRangedConduitMap(this.worldObj, pos, Material.water, 5));
        }
		if(worldloadInit/* && Minecraft.getMinecraft().getIntegratedServer().getTickCounter() < 50*/){
			this.pathmap.clear();
			ACPathingHandler.Pos pos = new ACPathingHandler.Pos(this.xCoord,this.yCoord,this.zCoord);
			this.pathmap.addAll(ACPathingHandler.INSTANCE.getRangedConduitMap(this.worldObj, pos, Material.water, 5));
			worldloadInit = false;
		}
    }
	
	public boolean isPosInPathmap(int x, int y, int z){
		for(int i = 0; i < this.pathmap.size(); i++){
			if(this.pathmap.get(i).same(new Pos(x,y,z))){
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<ACPathingHandler.Pos> getPathmap(){
		return (ArrayList<Pos>) this.pathmap;
	}
	
}
