package com.haoict.nbttool.commands;

import com.haoict.nbttool.utils.SendMessage;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.MessageArgument;

public class NBTToolCommands {
  public static void register(CommandDispatcher<CommandSource> dispatcher) {
    LiteralArgumentBuilder<CommandSource> tiabCommands
        = Commands.literal("nbttool")
        .requires((commandSource) -> commandSource.hasPermissionLevel(2))
        .then(Commands.literal("edit")
            .then(Commands.argument("timeToAdd", MessageArgument.message())
                .executes((ctx) -> {
                  SendMessage.sendMessage(ctx.getSource().asPlayer(), "Not supported yet!");
                  return 0;
                })
            ));

    dispatcher.register(tiabCommands);
  }
}
