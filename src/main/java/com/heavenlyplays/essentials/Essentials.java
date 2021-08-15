package com.heavenlyplays.essentials;

import dev.waterdog.waterdogpe.plugin.Plugin;
import com.heavenlyplays.essentials.commands.*;

public class Essentials extends Plugin {

  @Override
  public void onEnable(){
    //Lobby Command
    this.getProxy().getCommandMap().registerCommand(new LobbyCommand());
  }
}
