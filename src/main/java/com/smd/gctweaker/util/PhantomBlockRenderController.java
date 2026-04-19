package com.smd.gctweaker.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class PhantomBlockRenderController {

    private IBlockState state;
    private BlockPos pos;
    private long endTime;
    private boolean active;

    private int lightLevel = 0xF000F0;

    public void startRender(IBlockState state, BlockPos pos, long durationMillis) {
        startRender(state, pos, durationMillis, 0xF000F0);
    }

    public void startRender(IBlockState state, BlockPos pos, long durationMillis, int lightLevel) {
        this.state = state;
        this.pos = pos;
        this.endTime = System.currentTimeMillis() + durationMillis;
        this.lightLevel = lightLevel;
        this.active = true;
    }

    public void stopRender() {
        this.active = false;
    }

    public void render(RenderWorldLastEvent event) {
        if (!active || System.currentTimeMillis() > endTime) {
            active = false;
            return;
        }

        Minecraft mc = Minecraft.getMinecraft();
        World world = mc.world;
        BlockRendererDispatcher dispatcher = mc.getBlockRendererDispatcher();

        GlStateManager.pushMatrix();
        GlStateManager.disableLighting();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(
                GlStateManager.SourceFactor.SRC_ALPHA,
                GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA
        );
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.5F);

        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,
                (float) (lightLevel & 0xFFFF),
                (float) (lightLevel >> 16));

        GlStateManager.translate(
                pos.getX() - mc.getRenderManager().viewerPosX,
                pos.getY() - mc.getRenderManager().viewerPosY,
                pos.getZ() - mc.getRenderManager().viewerPosZ
        );

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();
        buffer.begin(7, DefaultVertexFormats.BLOCK);
        dispatcher.getBlockModelRenderer().renderModel(
                world,
                dispatcher.getModelForState(state),
                state,
                BlockPos.ORIGIN,
                buffer,
                false
        );
        tessellator.draw();

        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();
    }
}
