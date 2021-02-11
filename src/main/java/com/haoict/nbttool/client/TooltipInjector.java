package com.haoict.nbttool.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class TooltipInjector {
  @SubscribeEvent
  public static void onItemTooltip(final ItemTooltipEvent event) {
    if (Screen.hasShiftDown() && Minecraft.getInstance().gameSettings.advancedItemTooltips) {
      ItemStack itemStack = event.getItemStack();
      CompoundNBT nbtTag = itemStack.serializeNBT().getCompound("tag");
      event.getToolTip().add(nbtTag.toFormattedComponent());
    }
  }
}
