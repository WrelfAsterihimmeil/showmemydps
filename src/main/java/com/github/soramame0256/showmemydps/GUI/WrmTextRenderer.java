package com.github.soramame0256.showmemydps.GUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class WrmTextRenderer {
    public enum WrmAlignmentX {
        Left, Right
    }

    public enum WrmAlignmentY {
        Top, Bottom
    }
    public static void drawString(String str, int x, int y, WrmAlignmentX alignX, WrmAlignmentY alignY, int color, boolean dropShadow)
    {
        String[] lines = str.split("\n");
        FontRenderer renderer = Minecraft.getMinecraft().fontRenderer;
        int charHeight = 10;
        int yMargin = alignY == WrmAlignmentY.Top? 11 : -11;

        for(int i = 0; i < lines.length; i++)
        {
            int lineWidth = renderer.getStringWidth(lines[i]);
            renderer.drawString(lines[i], x - (alignX == WrmAlignmentX.Left ? 0 : lineWidth ), y + i * yMargin - (alignY == WrmAlignmentY.Top? 0 : charHeight), color, dropShadow);
        }
    }
}
