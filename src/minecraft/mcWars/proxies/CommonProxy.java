package mcWars.proxies;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class CommonProxy
{
	public void registerRenderThings()
	{
	}
	
	@SideOnly(Side.CLIENT)
	@ForgeSubscribe
	public void initializeIcons(TextureStitchEvent.Post event) 
	{
	}
}
