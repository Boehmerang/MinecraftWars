package mcWars.blocks;

import org.lwjgl.opengl.GL11;

import mcWars.client.models.ModelFlag;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class BlockRenderingHandler implements ISimpleBlockRenderingHandler
{
	public static BlockRenderingHandler instance = new BlockRenderingHandler();
	public static final int ID = RenderingRegistry.getNextAvailableRenderId();
	
	public static ModelFlag flag = new ModelFlag();
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) 
	{
		GL11.glPushMatrix(); 
		GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);

		if (block instanceof blockFlagpoleBlock)
		{
	        GL11.glBindTexture(GL11.GL_TEXTURE_2D, FMLClientHandler.instance().getClient().renderEngine.getTexture("mods/mcWars/textures/models/MurderFlag.png"));
			GL11.glTranslatef((float) 0.0F, (float) 0.3F, (float) 0.0F);
			GL11.glRotatef(180f, 90f, 0f, 1f);
	        flag.render(0.0400F);
	        GL11.glPopMatrix();
		}
		
	}
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) 
	{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean shouldRender3DInInventory() 
	{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return ID;
	}
}