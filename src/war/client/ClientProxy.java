package war.client;

import war.common.CommonProxy;

public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit()
	{

	}

	@Override
	public void Init()
	{
		// ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPipe.class, new RenderPipe());

		// MinecraftForgeClient.registerItemRenderer(FluidMech.blockPipe.blockID, new
		// ItemRenderHelper());

		// RenderingRegistry.registerBlockHandler(new BlockRenderHelper());
	}

	@Override
	public void postInit()
	{

	}
}
