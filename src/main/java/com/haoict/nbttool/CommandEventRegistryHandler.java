package com.haoict.nbttool;

import com.haoict.nbttool.commands.NBTToolCommands;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CommandEventRegistryHandler {
  @SubscribeEvent
  public static void onRegisterCommandEvent(RegisterCommandsEvent event) {
    CommandDispatcher<CommandSource> commandDispatcher = event.getDispatcher();
    NBTToolCommands.register(commandDispatcher);
  }
}
