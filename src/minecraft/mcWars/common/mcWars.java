package mcWars.common;

import mcWars.blocks.BlockRenderingHandler;
import mcWars.blocks.blockFlagpoleBlock;
import mcWars.client.models.renderFlag;
import mcWars.items.itemFlagPole;
import mcWars.items.itemFlagPoleBase;
import mcWars.items.itemFlagPoleTop;
import mcWars.network.ConnectionManager;
import mcWars.tile.tileEntityFlag;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mcWars.proxies.CommonProxy;
import mcWars.proxies.ClientProxy;



@Mod(modid = "McWars", name = "Minecraft-Wars", version = "0.0.1")
@NetworkMod(channels = {"McWars","mcWarsPlayer"}, clientSideRequired = true, serverSideRequired = false/*, packetHandler = PacketManager.class*/, connectionHandler=ConnectionManager.class)



public class mcWars 
{
	public static Item						itemFlagPoleBase;
	public static Item						itemFlagPole;
	public static Item						itemFlagPoleTop;
	public static Block						blockFlagPole;
	@Instance("mcWars")
	public static mcWars instance = new mcWars();
	
	@SidedProxy(clientSide = "mcWars.proxies.ClientProxy", serverSide = "mcWars.proxies.CommonProxy")
    public static CommonProxy proxy;
	
	public static CreativeTabs mcwTab = new CreativeTabs("Minecraft-Wars") 
    {
        public ItemStack getIconItemStack() 
        {
                return new ItemStack(mcWars.itemFlagPoleTop, 1, 0);
        }
        public String getTranslatedTabLabel()
    	{
    		return "Minecraft-Wars"; // The name of the tab ingame
    	}
    };
	@Mod.PreInit()
	public void PreInitMurderCoins(FMLPreInitializationEvent e)
	{	
		Side side = e.getSide();
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		itemRegistration();
		tileEntityRegisters();
		blockRegistration();
	}
	
	@Mod.Init
	public void load(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(proxy);
		LanguageRegistry.instance().addStringLocalization("itemGroup.mcWars", "en_US", "Minecraft-Wars");
		proxy.registerRenderThings();
	}
	
	public void itemRegistration()
	{
		itemFlagPoleTop = new itemFlagPoleTop(3001).setUnlocalizedName("Flag-Pole Top");
		itemFlagPole = new itemFlagPole(3002).setUnlocalizedName("Flag-Pole");
		itemFlagPoleBase = new itemFlagPoleBase(3003).setUnlocalizedName("Flag-Pole Base");
	}
	
	public void blockRegistration()
	{
		blockFlagPole = new blockFlagpoleBlock(3004, Material.anvil).setUnlocalizedName("Flag");
		GameRegistry.registerBlock(blockFlagPole);
	}
	
	
	public void tileEntityRegisters()
	{
		
		GameRegistry.registerTileEntity(tileEntityFlag.class, "TileFlag");
	}
	/*
	 @SideOnly(Side.CLIENT)
	 public void registerRenderThings()
	 {
		RenderingRegistry.registerBlockHandler(new BlockRenderingHandler());
		//ClientRegistry.bindTileEntitySpecialRenderer(tileEntityCoinPress.class, new RenderCoinPress());
		ClientRegistry.bindTileEntitySpecialRenderer(tileEntityFlag.class, new renderFlag());
		
	 }
	 */
}
