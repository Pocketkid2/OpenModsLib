package openmods.renderer.rotations;

import net.minecraft.client.renderer.RenderBlocks;
import openmods.geometry.Orientation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public interface IRendererSetup {
	public static final IRendererSetup NULL = new IRendererSetup() {
		@Override
		@SideOnly(Side.CLIENT)
		public RenderBlocks enter(Orientation orientation, int metadata, RenderBlocks renderer) {
			return renderer;
		}

		@Override
		@SideOnly(Side.CLIENT)
		public void exit(RenderBlocks renderer) {}
	};

	@SideOnly(Side.CLIENT)
	public RenderBlocks enter(Orientation orientation, int metadata, RenderBlocks renderer);

	@SideOnly(Side.CLIENT)
	public void exit(RenderBlocks renderer);
}
