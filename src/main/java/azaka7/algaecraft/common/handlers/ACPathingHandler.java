package azaka7.algaecraft.common.handlers;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class ACPathingHandler {
	
	public static ACPathingHandler INSTANCE = new ACPathingHandler();
	
	public List<Pos> getRangedConduitMap(World world, Pos start, Material material, int maxPathSize){
		List<Pos> map = new ArrayList<Pos>();
		
		List<Pos> checked = new ArrayList<Pos>();
		List<Pos> checking = new ArrayList<Pos>();
		List<Pos> tocheck = new ArrayList<Pos>();
		int checkingIterations = 0;
		
		checking.add(start);
		
		for(checkingIterations = 0; checkingIterations < maxPathSize; checkingIterations++){
			for(int i = 0; i < checking.size(); i++){
				Pos pos = checking.get(i);
				for(int x = -1; x <= 1; x++){
					for(int y = -1; y <= 1; y++){
						for(int z = -1; z <= 1; z++){
							//if((Math.abs(x) != Math.abs(y)) && (Math.abs(x) != Math.abs(z)) && (Math.abs(y)!=Math.abs(z))){
							//if(Math.abs(x)+Math.abs(y)+Math.abs(z) == 1){
								if(pos.addPos(x, y, z).getBlock(world).getMaterial() == material){
									boolean flag = true;
									for(int c = 0; c <checked.size(); c++){
										if(checked.get(c).same(pos.addPos(x, y, z))){
											flag = false;
										}
									}
									if(flag){
										boolean flag1 = true;
										for(int n = 0; n < tocheck.size(); n++){
											if(tocheck.get(n).same(pos)){
												flag1 = false;
												break;
											}
										}
										if(flag1) tocheck.add(pos.addPos(x, y, z));
										map.add(pos.addPos(x, y, z));
									}
								}
							//}
						}
					}
				}
				checked.add(checking.get(i));
				checking.remove(i);
			}
			if(checking.size() > 0){
				for(int c = 0; c < checking.size(); c++){
					checked.add(checking.get(c));
					checking.remove(c);
				}
			}
			if(tocheck.size()>0){
				for(int c = 0; c < tocheck.size(); c++){
					checking.add(tocheck.get(c));
					tocheck.remove(c);
				}
			}
		}
		
		return map;
	}
	
	public double getDistance(Pos pos1, Pos pos2){
		double ret = (Math.abs(pos2.x-pos1.x)^2)+(Math.abs(pos2.y-pos1.y)^2)+(Math.abs(pos2.z-pos1.z)^2);
		ret = (double) Math.sqrt(ret);
		return ret;
	}
	
	public static class Pos{
		public int x;
		public int y;
		public int z;
		
		public Pos(int i, int j, int k){
			x = i;
			y = j;
			z = k;
		}
		
		public Pos addPos(int i, int j, int k){
			return new Pos(x+i,y+j,z+k);
		}
		
		public Block getBlock(World world){
			return world.getBlock(x, y, z);
		}
		
		public boolean same(Pos pos){
			return ((this.x==pos.x)&&(this.y==pos.y)&&(this.z==pos.z));
		}
		
		@Override
		public String toString(){
			return "Pos:"+"x"+x+"y"+y+"z"+z;
		}
	}
	
}
