package com.heavenlyplays.essentials.commands;

import dev.waterdog.waterdogpe.ProxyServer;
import dev.waterdog.waterdogpe.command.Command;
import dev.waterdog.waterdogpe.command.CommandSender;
import dev.waterdog.waterdogpe.command.CommandSettings;
import dev.waterdog.waterdogpe.player.ProxiedPlayer;

public class DisconnectCommand extends Command {

    public DisconnectCommand() {
      super("disconnect", CommandSettings.builder()
      .setDescription("Kick a player from the server")
      .setPermission("waterdog.command.kick")
      .setUsageMessage("kick <player> <reason>").build());
    }

    @Override
    public boolean onExecute(CommandSender sender, String alias, String[] args) {
      if (args.length < 2) {
        return false;
      }

      String playerName = args[0];
      ProxiedPlayer player = ProxyServer.getInstance().getPlayer(playerName);
      if (player == null) {
        sender.sendMessage("§cPlayer not Found!");
        return true;
      }

      sender.sendMessage("§aPlayer kicked successfully.");
      player.disconnect(String.join(" ", args));
      return true;
    }
}
