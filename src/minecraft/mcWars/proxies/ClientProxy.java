package mcWars.proxies;

import mcWars.blocks.BlockRenderingHandler;
import mcWars.client.models.renderFlag;
import mcWars.tile.tileEntityFlag;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
	 @SideOnly(Side.CLIENT)
	 @ForgeSubscribe
	 public void initializeIcons(TextureStitchEvent.Post event)
	 {

	 }
	 
	 
	 @Override
	  public void registerRenderThings()
	 {
		RenderingRegistry.registerBlockHandler(new BlockRenderingHandler());
		//ClientRegistry.bindTileEntitySpecialRenderer(tileEntityCoinPress.class, new RenderCoinPress());
		ClientRegistry.bindTileEntitySpecialRenderer(tileEntityFlag.class, new renderFlag());
		
	 }
    /* @Override
	public GuiScreen getClientGui(int ID, EntityPlayer player, World world, int x, int y, int z) 
		{
			TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
			switch (ID)
			{
			case 1:
					return new guiGoldForge(player.inventory,(tileEntityGoldForge) tile_entity);
			case 2:
            	return new guiCoinPress(player.inventory,(tileEntityCoinPress) tile_entity);
            
			case 3:
				return new guiManPress(player.inventory,(tileEntityManPress) tile_entity);
			
			case 4:
  				return new guiPulverisor(player.inventory,(tileEntityPulverisor) tile_entity);

			case 5:
				return new guiBasicVault(player.inventory,(tileEntityBasicVault) tile_entity);

			case 6:
					return new guiBasicTrader(player.inventory,(tileEntityBasicTrader) tile_entity);
			case 7:
					return new guiBasicTraderShop(player.inventory,(tileEntityBasicTrader) tile_entity);
			default:
					break;
				
			
			}
			return null;
		}*/
}
