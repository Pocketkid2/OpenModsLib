package openmods.proxy;

import com.google.common.base.Optional;
import java.io.File;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.server.FMLServerHandler;
import openmods.config.game.ICustomItemModelProvider;
import openmods.gui.CommonGuiHandler;

public final class OpenServerProxy implements IOpenModsProxy {

	@Override
	public EntityPlayer getThePlayer() {
		return null;
	}

	@Override
	public boolean isClientPlayer(Entity player) {
		return false;
	}

	@Override
	public long getTicks(World worldObj) {
		return worldObj.getTotalWorldTime();
	}

	@Override
	public World getClientWorld() {
		return null;
	}

	@Override
	public World getServerWorld(int id) {
		return DimensionManager.getWorld(id);
	}

	@Override
	public File getMinecraftDir() {
		// TODO may as well be used for client side
		return FMLServerHandler.instance().getServer().getFile("");
	}

	@Override
	public String getLogFileName() {
		return "ForgeModLoader-server-0.log";
	}

	@Override
	public Optional<String> getLanguage() {
		return Optional.absent();
	}

	@Override
	public IGuiHandler wrapHandler(IGuiHandler modSpecificHandler) {
		return new CommonGuiHandler(modSpecificHandler);
	}

	@Override
	public void preInit() {}

	@Override
	public void init() {}

	@Override
	public void postInit() {}

	@Override
	public void setNowPlayingTitle(String nowPlaying) {}

	@Override
	public EntityPlayer getPlayerFromHandler(INetHandler handler) {
		if (handler instanceof NetHandlerPlayServer) return ((NetHandlerPlayServer)handler).playerEntity;

		return null;
	}

	@Override
	public void bindItemModelToItemMeta(Item item, int metadata, ResourceLocation model) {}

	@Override
	public void registerCustomItemModel(Item item, int metadata, ResourceLocation resourceLocation) {}

	@Override
	public void runCustomItemModelProvider(ResourceLocation itemLocation, Item item, Class<? extends ICustomItemModelProvider> providerCls) {}
}
