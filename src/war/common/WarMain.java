package war.common;

import java.io.File;
import java.util.logging.Logger;

import net.minecraftforge.common.Configuration;

import org.modstats.ModstatInfo;

import universalelectricity.prefab.network.PacketManager;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.NetworkMod;

@ModstatInfo(prefix = "minecraftwar")
@Mod(modid = WarMain.MOD_ID, name = WarMain.MOD_NAME, version = WarMain.VERSION, dependencies = "after:GSM-Core", useMetadata = true)
@NetworkMod(channels = { WarMain.CHANNEL }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketManager.class)
public class WarMain extends DummyModContainer
{

	// @Mod Prerequisites
	public static final String MAJOR_VERSION = "@MAJOR@";
	public static final String MINOR_VERSION = "@MINOR@";
	public static final String REVIS_VERSION = "@REVIS@";
	public static final String BUILD_VERSION = "@BUILD@";

	// @Mod
	public static final String MOD_ID = "MC_Wars";
	public static final String MOD_NAME = "Minecraft Wars";
	public static final String VERSION = MAJOR_VERSION + "." + MINOR_VERSION + "." + REVIS_VERSION + "." + BUILD_VERSION;

	// @NetworkMod
	public static final String CHANNEL = "MCWARS";

	@Metadata(WarMain.MOD_ID)
	public static ModMetadata meta;

	/* RESOURCE FILE PATHS */
	public static final String RESOURCE_PATH = "/mods/minecraftwars/";
	public static final String TEXTURE_DIRECTORY = RESOURCE_PATH + "textures/";
	public static final String GUI_DIRECTORY = TEXTURE_DIRECTORY + "gui/";
	public static final String BLOCK_TEXTURE_DIRECTORY = TEXTURE_DIRECTORY + "blocks/";
	public static final String ITEM_TEXTURE_DIRECTORY = TEXTURE_DIRECTORY + "items/";
	public static final String MODEL_TEXTURE_DIRECTORY = TEXTURE_DIRECTORY + "models/";
	public static final String TEXTURE_NAME_PREFIX = "fluidmech:";
	public static final String LANGUAGE_PATH = RESOURCE_PATH + "langs/";

	/* SUPPORTED LANGS */
	private static final String[] LANGUAGES_SUPPORTED = new String[] { "en_US" };

	/* CONFIG FILE */
	public static final Configuration CONFIGURATION = new Configuration(new File(Loader.instance().getConfigDir() + "/Minecraftwars/", WarMain.MOD_NAME + ".cfg"));

	/* START IDS */
	public final static int BLOCK_ID_PREFIX = 3100;
	public final static int ITEM_ID_PREFIX = 13200;

	@SidedProxy(clientSide = "war.client.ClientProxy", serverSide = "war.common.CommonProxy")
	public static CommonProxy proxy;

	@Instance(WarMain.MOD_NAME)
	public static WarMain instance;

	/* LOGGER - EXTENDS FORGE'S LOG SYSTEM */
	public static Logger FMLog = Logger.getLogger(WarMain.MOD_NAME);

}
