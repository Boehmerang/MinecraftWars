package mcWars.client.models;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class renderFlag extends TileEntitySpecialRenderer
{
    public static final ModelFlag modelFlag = new ModelFlag();
    public static int flagModelID = RenderingRegistry.getNextAvailableRenderId();
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,	double d2, float f) 
	{
		// TODO Auto-generated method stub
		int rotation = 0;
		if(tileentity.worldObj != null)
		{
			int temp = tileentity.getBlockMetadata();
			switch (temp)
			{
				case 0:
					rotation = 180;
					break;
				case 1:
					rotation = 0;
					break;
				case 2:
					rotation = 90;
					break;
				case 3:
					rotation = 270;
					break;
				default:
					rotation = 0;
					break;
			}				
		}
		bindTextureByName("/mods/mcWars/textures/models/MurderFlag.png"); //texture
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d0 + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);
		GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
		modelFlag.render(0.0625F);
		GL11.glPopMatrix(); //end
    }
}


