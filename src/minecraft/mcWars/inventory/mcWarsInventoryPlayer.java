package mcWars.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

public class mcWarsInventoryPlayer extends InventoryPlayer
{
	
	public ItemStack[] wallet = new ItemStack[6];

	public mcWarsInventoryPlayer(EntityPlayer par1EntityPlayer) 
	{
		super(par1EntityPlayer);
		// TODO Auto-generated constructor stub
	}

}
