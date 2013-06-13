package mcWars.items;

import net.minecraft.client.renderer.texture.IconRegister;
import mcWars.common.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class itemFlagPole extends Item 
{
	public itemFlagPole(int id)
	{
     super(id);
     this.setCreativeTab(mcWars.mcwTab);
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon("McWars:poleMiddle");
	}
}