package io.github.hotlava03.helpsharp.Commands;

import io.github.hotlava03.helpsharp.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCmd implements CommandExecutor {
    Main plugin;
    public MainCmd(Main instance){
        plugin = instance;
    }
    public boolean onCommand(CommandSender sender, Command Command, String label, String[] args){
        Player player = (Player) sender;
        if(sender.hasPermission("helpsharp.main")) {
            if (args.length == 0)
                player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "Help" + ChatColor.DARK_GRAY + "]" + ChatColor.WHITE+" HelpSharp"+ChatColor.GRAY + " by "+ChatColor.WHITE+"HotLava03"+ChatColor.GRAY+" v"+ChatColor.WHITE+"1.0-SNAPSHOT"+ChatColor.GRAY+" \n       Type " + ChatColor.WHITE + "/" + Main.helpCommandName + ChatColor.GRAY + " for server help. \n       For specific HelpSharp plugin help, type " + ChatColor.WHITE + "/helpsharp help" + ChatColor.GRAY + ".");
            else if (args[0].equals("help"))
                player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "Help" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY + " To edit the server help command or its content, open the plugin's config. It is located in your plugins folder > HelpSharp > config.yml. \n       Type " + ChatColor.WHITE + "/" + Main.helpCommandName + ChatColor.GRAY + " for server help. \n       To reload the config, run "+ChatColor.WHITE+"/helpsharpreload"+ChatColor.GRAY+".");
            else if(!args[0].equalsIgnoreCase("reload"))
                player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "Help" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY+" Invalid usage.");
        }else{
            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "Help" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY+" You are lacking the permission "+ChatColor.WHITE+"helpsharp.main "+ChatColor.GRAY+"to run this command.");
        }
        return true;
    }
}
