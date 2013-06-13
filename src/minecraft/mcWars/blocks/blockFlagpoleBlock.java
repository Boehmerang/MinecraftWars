package mcWars.blocks;

import mcWars.common.mcWars;
import mcWars.tile.tileEntityFlag;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class blockFlagpoleBlock extends Block implements ITileEntityProvider
{

	public blockFlagpoleBlock(int par1, Material par2Material) 
	{
		super(par1, par2Material);
		this.setCreativeTab(mcWars.mcwTab);
		this.blockHardness =  30.0F;
	}
	
	@Override
	public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLiving par5EntityLiving, ItemStack itemStack)
	{
		par1World.setBlock(x, y, z, this.blockID, 0, 1);
	}
	/**
	* The type of render function that is called for this block
	*/
	@SideOnly(Side.CLIENT)
	@Override
	public int getRenderType()
	{
	return BlockRenderingHandler.ID;
	}
	
	/**
	* Is this block (a) opaque and (B) a full 1m cube? This determines whether or not to render the shared face of two
	* adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	*/
	public boolean isOpaqueCube()
	{
	return false;
	}

	/**
	* If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	*/
	public boolean renderAsNormalBlock()
	{
	return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1)
	{
		System.out.println("Meow");
		return new tileEntityFlag();
	}
}
