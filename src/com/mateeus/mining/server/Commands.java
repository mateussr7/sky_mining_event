package com.mateeus.mining.server;

import com.mateeus.mining.commands.EventCommands;
import com.mateeus.mining.commands.MarketCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    //Comandos
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        //Comando /mercado
        if(command.getName().equalsIgnoreCase("mercado")){
            if(sender instanceof Player){
                Player player = (Player)sender;
                MarketCommand.openInventory(player);
            }
        }

        //Comando /miningevent
        if(command.getName().equalsIgnoreCase("minningevent")){
            if(sender.hasPermission("market-admin")){
                if(args[0].equalsIgnoreCase("start")){
                    EventCommands.deployEvent();
                    return true;
                }else if(args[0].equalsIgnoreCase("finish")){
                    EventCommands.cancellEvent();
                    return false;
                }
                return false;
            }
        }

        return false;
    }
}
