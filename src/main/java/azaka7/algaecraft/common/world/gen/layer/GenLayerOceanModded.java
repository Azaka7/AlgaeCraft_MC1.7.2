package azaka7.algaecraft.common.world.gen.layer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeManager;

public class GenLayerOceanModded extends GenLayer {
	
	public static List<BiomeGenBase> oceans = new ArrayList<BiomeGenBase>();
	
	private static boolean loadedOceans = false;
	private static List<BiomeGenBase> mountainOceans = new ArrayList<BiomeGenBase>();
	private static List<BiomeGenBase> shallowOceans = new ArrayList<BiomeGenBase>();
	private static List<BiomeGenBase> averageOceans = new ArrayList<BiomeGenBase>();
	private static List<BiomeGenBase> deepOceans = new ArrayList<BiomeGenBase>();

    private static final Random rand = new Random();
    
    public GenLayerOceanModded(long l, GenLayer par){
        super(l);
        this.parent = par;
        
        rand.setSeed(this.baseSeed);
    }

	@Override
	public int[] getInts(int par1, int par2, int par3, int par4) {
        if(!loadedOceans){
            for(int c = 0; c < oceans.size(); c++){
            	float f = getAvgHeight(oceans.get(c));
            	if(-2.0 <= f && f < -1.5){deepOceans.add(oceans.get(c));}
            	else if(-1.5 <= f && f < -0.5){averageOceans.add(oceans.get(c));}
            	else if(-0.5 <= f && f < 0.5){shallowOceans.add(oceans.get(c));}
            	else{mountainOceans.add(oceans.get(c));}
            }
            
            if(mountainOceans.size()>0){
            	System.out.println("Mountain:");
            	for(int n = 0; n < mountainOceans.size(); n++){
            		System.out.println(mountainOceans.get(n).biomeName);
            	}
            }
            if(shallowOceans.size()>0){
            	System.out.println("Shallows:");
            	for(int n = 0; n < shallowOceans.size(); n++){
            		System.out.println(shallowOceans.get(n).biomeName);
            	}
            }
            if(averageOceans.size()>0){
            	System.out.println("Average:");
            	for(int n = 0; n < averageOceans.size(); n++){
            		System.out.println(averageOceans.get(n).biomeName);
            	}
            }
            if(deepOceans.size()>0){
            	System.out.println("Deeps:");
            	for(int n = 0; n < deepOceans.size(); n++){
            		System.out.println(deepOceans.get(n).biomeName);
            	}
            }
            
            loadedOceans = true;
        }
        /*
        int i1 = par1 - 1;
        int j1 = par2 - 1;
        int k1 = par3 + 2;
        int l1 = par4 + 2;*/
        /*int[] aint =*/ return this.getIntsDeep(par1, par2, par3, par4);
        /*int[] aint1 = IntCache.getIntCache(par3 * par4);

        for (int i2 = 0; i2 < par4; ++i2)
        {
            for (int j2 = 0; j2 < par3; ++j2)
            {
                int k3 = aint[j2 + 1 + (i2 + 1) * k1];
                
                aint1[j2 + i2 * par3] = k3;
            }
        }

        return aint1;*/
	}
	
	private int[] getIntsDeep(int par1, int par2, int par3, int par4){
		int i1 = par1 - 1;
        int j1 = par2 - 1;
        int k1 = par3 + 2;
        int l1 = par4 + 2;
        int[] aint = this.getIntsAvg(i1, j1, k1, l1);
        int[] aint1 = IntCache.getIntCache(par3 * par4);

        for (int i2 = 0; i2 < par4; ++i2)
        {
            for (int j2 = 0; j2 < par3; ++j2)
            {
                int k2 = aint[j2 + 1 + (i2 + 1 - 1) * (par3 + 2)];
                int l2 = aint[j2 + 1 + 1 + (i2 + 1) * (par3 + 2)];
                int i3 = aint[j2 + 1 - 1 + (i2 + 1) * (par3 + 2)];
                int j3 = aint[j2 + 1 + (i2 + 1 + 1) * (par3 + 2)];
                int k3 = aint[j2 + 1 + (i2 + 1) * k1];
                int l3 = 0;

                if (averageOceans.size() > 0 ? averageOceans.contains(BiomeGenBase.getBiome(k2<256 ? k2 : 255)) : k2 == 0)
                {
                	//System.out.println("average");
                    ++l3;
                }

                if (averageOceans.size() > 0 ? averageOceans.contains(BiomeGenBase.getBiome(l2<256 ? l2 : 255)) : l2 == 0)
                {
                	//System.out.println("average");
                    ++l3;
                }

                if (averageOceans.size() > 0 ? averageOceans.contains(BiomeGenBase.getBiome(i3<256 ? i3 : 255)) : i3 == 0)
                {
                	//System.out.println("average");
                    ++l3;
                }

                if (averageOceans.size() > 0 ? averageOceans.contains(BiomeGenBase.getBiome(j3<256 ? j3 : 255)) : j3 == 0)
                {
                	//System.out.println("average");
                    ++l3;
                }

                if ((averageOceans.size() > 0 ? averageOceans.contains(BiomeGenBase.getBiome(k3<256 ? k3 : 255)) : k3 == 0)&& l3 > 2)
                {
                	//System.out.println("average");
                	if(deepOceans.size()>0){
                		int i = deepOceans.get(rand.nextInt(deepOceans.size())).biomeID;
                		aint1[j2 + i2 * par3] = i;
                	}
                	else aint1[j2 + i2 * par3] = 0;
                }
                else
                {
                	//System.out.println("not average");
                    aint1[j2 + i2 * par3] = k3;
                }
            }
        }

        return aint1;
    }
	
	private int[] getIntsAvg(int par1, int par2, int par3, int par4){
		int i1 = par1 - 1;
        int j1 = par2 - 1;
        int k1 = par3 + 2;
        int l1 = par4 + 2;
        int[] aint = this.getIntsShallow(i1, j1, k1, l1);
        int[] aint1 = IntCache.getIntCache(par3 * par4);

        for (int i2 = 0; i2 < par4; ++i2)
        {
            for (int j2 = 0; j2 < par3; ++j2)
            {
                int k2 = aint[j2 + 1 + (i2 + 1 - 1) * (par3 + 2)];
                int l2 = aint[j2 + 1 + 1 + (i2 + 1) * (par3 + 2)];
                int i3 = aint[j2 + 1 - 1 + (i2 + 1) * (par3 + 2)];
                int j3 = aint[j2 + 1 + (i2 + 1 + 1) * (par3 + 2)];
                int k3 = aint[j2 + 1 + (i2 + 1) * k1];
                int l3 = 0;

                if (shallowOceans.size() > 0 ? shallowOceans.contains(BiomeGenBase.getBiome(k2<256 ? k2 : 255)) : k2 == 0)
                {
                	//System.out.println("shallow");
                    ++l3;
                }

                if (shallowOceans.size() > 0 ? shallowOceans.contains(BiomeGenBase.getBiome(l2<256 ? l2 : 255)) : l2 == 0)
                {
                	//System.out.println("shallow");
                    ++l3;
                }

                if (shallowOceans.size() > 0 ? shallowOceans.contains(BiomeGenBase.getBiome(i3<256 ? i3 : 255)) : i3 == 0)
                {
                	//System.out.println("shallow");
                    ++l3;
                }

                if (shallowOceans.size() > 0 ? shallowOceans.contains(BiomeGenBase.getBiome(j3<256 ? j3 : 255)) : j3 == 0)
                {
                	//System.out.println("shallow");
                    ++l3;
                }

                if ((shallowOceans.size() > 0 ? shallowOceans.contains(BiomeGenBase.getBiome(k3<256 ? k3 : 255)) : k3 == 0)&& l3 > 2)
                {
                	//System.out.println("shallow");
                	if(averageOceans.size()>0){
                		int i = averageOceans.get(rand.nextInt(averageOceans.size())).biomeID;
                		aint1[j2 + i2 * par3] = i;
                	}
                	else aint1[j2 + i2 * par3] = 0;
                }
                else
                {
                	//System.out.println("not shallow");
                    aint1[j2 + i2 * par3] = k3;
                }
            }
        }

        return aint1;
    }
	
	private int[] getIntsShallow(int par1, int par2, int par3, int par4){
		int i1 = par1 - 1;
        int j1 = par2 - 1;
        int k1 = par3 + 2;
        int l1 = par4 + 2;
        int[] aint = this.getIntsMountain(i1, j1, k1, l1);
        int[] aint1 = IntCache.getIntCache(par3 * par4);

        for (int i2 = 0; i2 < par4; ++i2)
        {
            for (int j2 = 0; j2 < par3; ++j2)
            {
                int k2 = aint[j2 + 1 + (i2 + 1 - 1) * (par3 + 2)];
                int l2 = aint[j2 + 1 + 1 + (i2 + 1) * (par3 + 2)];
                int i3 = aint[j2 + 1 - 1 + (i2 + 1) * (par3 + 2)];
                int j3 = aint[j2 + 1 + (i2 + 1 + 1) * (par3 + 2)];
                int k3 = aint[j2 + 1 + (i2 + 1) * k1];
                int l3 = 0;

                if (mountainOceans.size() > 0 ? mountainOceans.contains(BiomeGenBase.getBiome(k2<256 ? k2 : 255)) : k2 == 0)
                {
                	//System.out.println("mountain");
                    ++l3;
                }

                if (mountainOceans.size() > 0 ? mountainOceans.contains(BiomeGenBase.getBiome(l2<256 ? l2 : 255)) : l2 == 0)
                {
                	//System.out.println("mountain");
                    ++l3;
                }

                if (mountainOceans.size() > 0 ? mountainOceans.contains(BiomeGenBase.getBiome(i3<256 ? i3 : 255)) : i3 == 0)
                {
                	//System.out.println("mountain");
                    ++l3;
                }

                if (mountainOceans.size() > 0 ? mountainOceans.contains(BiomeGenBase.getBiome(j3<256 ? j3 : 255)) : j3 == 0)
                {
                	//System.out.println("mountain");
                    ++l3;
                }

                if ((mountainOceans.size() > 0 ? mountainOceans.contains(BiomeGenBase.getBiome(k3<256 ? k3 : 255)) : k3 == 0) && l3 > 2)
                {
                	//System.out.println("mountain");
                	if(shallowOceans.size() > 0){
                		int i = shallowOceans.get(rand.nextInt(shallowOceans.size())).biomeID;
                		aint1[j2 + i2 * par3] = i;
                	}
                	else aint1[j2 + i2 * par3] = 0;
                }
                else
                {
                	//System.out.println("not mountain");
                    aint1[j2 + i2 * par3] = k3;
                }
            }
        }

        return aint1;
    }
	
	private int[] getIntsMountain(int par1, int par2, int par3, int par4){
		int i1 = par1 - 1;
        int j1 = par2 - 1;
        int k1 = par3 + 2;
        int l1 = par4 + 2;
        int[] aint = this.parent.getInts(i1, j1, k1, l1);
        int[] aint1 = IntCache.getIntCache(par3 * par4);

        for (int i2 = 0; i2 < par4; ++i2)
        {
            for (int j2 = 0; j2 < par3; ++j2)
            {
                int k3 = aint[j2 + 1 + (i2 + 1) * k1];

                if (k3 == BiomeGenBase.ocean.biomeID || k3 == BiomeGenBase.deepOcean.biomeID)
                {
                	if(mountainOceans.size() > 0){
                		int i = mountainOceans.get(rand.nextInt(mountainOceans.size())).biomeID;
                		aint1[j2 + i2 * par3] = i;
                	}
                	else aint1[j2 + i2 * par3] = 0;
                }
                else
                {
                    aint1[j2 + i2 * par3] = k3;
                }
            }
        }

        return aint1;
    }
	
	private float getAvgHeight(BiomeGenBase biome){
		float f = biome.rootHeight;
		f *= 2;
		f += biome.heightVariation;
		f /= 2;
		return f;
	}
    
    
}
