package war.client.flag;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import universalelectricity.prefab.block.BlockAdvanced;

public class BlockFlag extends BlockAdvanced
{
	enum blocks
	{
		Base();
	}

	protected BlockFlag(int par1)
	{
		super(par1, Material.iron);

	}

	@Override
	public TileEntity createTileEntity(World var1, int meta)
	{
		if (meta == blocks.Base.ordinal())
		{
			return new TileEntityFlagBase();
		}
		return null;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		if (meta == blocks.Base.ordinal())
		{
			this.setBlockBounds(0, 0, 0, 1, .3f, 1);
		}
	}
}
