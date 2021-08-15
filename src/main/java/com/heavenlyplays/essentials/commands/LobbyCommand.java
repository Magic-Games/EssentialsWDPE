package com.heavenlyplays.essentials.commands;

import dev.waterdog.waterdogpe.ProxyServer;
import dev.waterdog.waterdogpe.command.Command;
import dev.waterdog.waterdogpe.command.CommandSender;
import dev.waterdog.waterdogpe.command.CommandSettings;
import dev.waterdog.waterdogpe.player.ProxiedPlayer;

public class LobbyCommand extends Command {

  public LobbyCommand() {
    super("lobby", CommandSettings.builder()
     .setDescription("Command used to transfer to the lobby server")
     .build());
  }
  @Override
  public boolean onExecute(CommandSender sender, String alias, String[] args){
    if(sender.isPlayer()){
      ProxiedPlayer player = (ProxiedPlayer) sender;
      player.connect(ProxyServer.getInstance().getServerInfo("lobby"));
      return true;
    } else {
      sender.sendMessage("Please use this command ingame!");
      return false;
    }
  }
}
