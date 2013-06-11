package war.common;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabMCWAR extends CreativeTabs
{
	public static final TabMCWAR INSTANCE = new TabMCWAR();
	private static ItemStack itemStack;

	public TabMCWAR()
	{
		super(CreativeTabs.getNextID(), "minecraftwars");
	}

	public static void setItemStack(ItemStack newItemStack)
	{
		if (itemStack == null)
		{
			itemStack = newItemStack;
		}
	}

	@Override
	public ItemStack getIconItemStack()
	{
		if (itemStack == null)
		{
			return new ItemStack(Block.blocksList[this.getTabIconItemIndex()]);
		}

		return itemStack;
	}
}
