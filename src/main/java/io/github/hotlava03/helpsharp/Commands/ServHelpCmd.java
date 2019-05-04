package io.github.hotlava03.helpsharp.Commands;

import io.github.hotlava03.helpsharp.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class ServHelpCmd implements CommandExecutor {
    Main plugin;
    public ServHelpCmd(Main instance){
        plugin = instance;
    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        Player player = (Player) sender;
        String servHelpCmd = null;
        try {
            servHelpCmd = Main.config.getString("servHelpCmd");
        }catch(Exception e){
            player.sendMessage(ChatColor.DARK_RED+"An error has occured while loading the help message from the plugin's config. Please contact an administrator on your server, or if you are one, please check the console.");
            Logger logger = plugin.getLogger();
            logger.severe("Error while loading the help message from HelpSharp's config:\n"+e);
            return true;
        }
        servHelpCmd = servHelpCmd.replaceAll("&","\u00a7");
        String serverName = Main.config.getString("serverName");
        player.sendMessage(ChatColor.DARK_GRAY+"["+ChatColor.BLUE+"Help"+ChatColor.DARK_GRAY+"] "+ChatColor.GRAY+serverName+" help:\n"+ChatColor.RESET+servHelpCmd);
        return true;
    }
}
