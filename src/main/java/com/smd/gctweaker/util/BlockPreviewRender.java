package com.smd.gctweaker.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class BlockPreviewRender {

    private final VirtualWorld virtualWorld = new VirtualWorld();

    private final Map<BlockPos, IBlockState> previewCache = new HashMap<>();
    private final Map<BlockPos, TileEntity> tileEntityCache = new HashMap<>();

    private int lightLevel = 0xF000F0;

    public void setLightLevel(int lightLevel) {
        this.lightLevel = lightLevel;
    }

    public void cachePhantomBlock(BlockPos pos, IBlockState state) {
        previewCache.put(pos, state);
        virtualWorld.setVirtualBlock(pos, state);
    }

    public void cachePhantomTileEntity(BlockPos pos, TileEntity tileEntity) {
        tileEntityCache.put(pos, tileEntity);
        virtualWorld.setVirtualTileEntity(pos, tileEntity);
    }

    public void clearCache() {
        previewCache.clear();
        tileEntityCache.clear();
    }

    public void renderCachedBlocks() {
        Minecraft mc = Minecraft.getMinecraft();
        BlockRendererDispatcher dispatcher = mc.getBlockRendererDispatcher();

        for (Map.Entry<BlockPos, IBlockState> entry : previewCache.entrySet()) {
            BlockPos pos = entry.getKey();
            IBlockState state = entry.getValue();

            GlStateManager.pushMatrix();
            GlStateManager.translate(
                    pos.getX() - mc.getRenderManager().viewerPosX,
                    pos.getY() - mc.getRenderManager().viewerPosY,
                    pos.getZ() - mc.getRenderManager().viewerPosZ
            );

            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,
                    (float) (lightLevel & 0xFFFF),
                    (float) (lightLevel >> 16));

            GlStateManager.enableBlend();
            GlStateManager.blendFunc(
                    GlStateManager.SourceFactor.SRC_ALPHA,
                    GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA
            );

            GlStateManager.disableLighting();
            GlStateManager.color(1.0F, 1.0F, 1.0F, 0.5F);

            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder buffer = tessellator.getBuffer();
            buffer.begin(7, DefaultVertexFormats.BLOCK);
            dispatcher.getBlockModelRenderer().renderModel(
                    virtualWorld,
                    dispatcher.getModelForState(state),
                    state,
                    BlockPos.ORIGIN,
                    buffer,
                    false
            );
            tessellator.draw();

            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }

        for (Map.Entry<BlockPos, TileEntity> entry : tileEntityCache.entrySet()) {
            BlockPos pos = entry.getKey();
            TileEntity tileEntity = entry.getValue();

            GlStateManager.pushMatrix();
            GlStateManager.translate(
                    pos.getX() - mc.getRenderManager().viewerPosX,
                    pos.getY() - mc.getRenderManager().viewerPosY,
                    pos.getZ() - mc.getRenderManager().viewerPosZ
            );

            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,
                    (float) (lightLevel & 0xFFFF),
                    (float) (lightLevel >> 16));

            GlStateManager.enableBlend();
            GlStateManager.blendFunc(
                    GlStateManager.SourceFactor.SRC_ALPHA,
                    GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA
            );
            GlStateManager.disableLighting();
            GlStateManager.color(1.0F, 1.0F, 1.0F, 0.5F);

            TileEntityRendererDispatcher.instance.render(tileEntity, 0, 0, 0, 0);

            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }
}
