package com.smd.gctweaker.handler;

import com.smd.gctweaker.util.PhantomBlockRenderController;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(value = Side.CLIENT)
@SideOnly(Side.CLIENT)
public class RenderEventHandler {

    public static PhantomBlockRenderController controller = new PhantomBlockRenderController();

    @SubscribeEvent
    public static void onRenderWorldLast(RenderWorldLastEvent event) {
        controller.render(event);
    }
}


