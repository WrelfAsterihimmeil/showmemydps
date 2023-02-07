package com.github.soramame0256.showmemydps.GUI;

import com.github.soramame0256.showmemydps.EventListener;
import com.github.soramame0256.showmemydps.ShowMeMyDps;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.time.Instant;

public class ShowMeGUI {

    @SubscribeEvent
    public void showGUI(RenderGameOverlayEvent.Post e) {
        EventListener.DPSData dpsData = ShowMeMyDps.EVENT_LISTENER.getDpsData();
        long totalDamage = dpsData.damage;
        int hitCount = dpsData.hitCount;
        if(hitCount == 0) hitCount++;
        Instant instant = dpsData.tickHandle;
        long in = Instant.now().getEpochSecond() - instant.getEpochSecond();
        String text = "";
        text += "DPS: " + totalDamage/in + "\n";
        text += "Avg/hit: " + totalDamage/hitCount + "\n";
        text += "Total: " + totalDamage;

        WrmTextRenderer.drawString(text, 600, 300, WrmTextRenderer.WrmAlignmentX.Right, WrmTextRenderer.WrmAlignmentY.Bottom,0x55FFFF, true);
    }

    private static FontRenderer fontRenderer;
}

