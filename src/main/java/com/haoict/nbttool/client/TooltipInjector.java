package com.haoict.nbttool.client;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class TooltipInjector {
    @SubscribeEvent
    public static void onItemTooltip(final ItemTooltipEvent event) {
        if (Screen.hasShiftDown()) {
            if (Minecraft.getInstance().options.advancedItemTooltips) {
                ItemStack itemStack = event.getItemStack();
                CompoundTag nbtTag = itemStack.serializeNBT().getCompound("tag");
                Component tooltipComponent;
                if (Screen.hasControlDown()) {
                    tooltipComponent = Component.nullToEmpty(NbtUtils.prettyPrint(nbtTag));
                    event.getToolTip().add(tooltipComponent);
                } else {
                    tooltipComponent = NbtUtils.toPrettyComponent(nbtTag);
                    event.getToolTip().add(tooltipComponent);
                    event.getToolTip().add(new TextComponent("Hold Ctrl to see formatted text").setStyle(Style.EMPTY.withItalic(true).applyFormat(ChatFormatting.GRAY)));
                }
            } else {
                event.getToolTip().add(new TextComponent("Turn on advanced tooltips (F3+H) too see NBT Tags").setStyle(Style.EMPTY.withItalic(true).applyFormat(ChatFormatting.GRAY)));
            }
        }
    }
}
