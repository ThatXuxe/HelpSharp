package io.github.hotlava03.helpsharp;

import io.github.hotlava03.helpsharp.Commands.MainCmd;
import io.github.hotlava03.helpsharp.Commands.ServHelpCmd;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin implements CommandExecutor {
    public static String helpCommandName;
    public static FileConfiguration config;
    private Logger logger;

    @Override
    public void onEnable(){
        logger = getLogger();
        saveDefaultConfig();
        reloadConfig();
        logger.info("Thank you for using HelpSharp 1.0-SNAPSHOT by HotLava03. Plugin is loading...");
        config = this.getConfig();
        helpCommandName = config.getString("helpCmdName");
        this.getCommand("helpsharpreload").setExecutor(new ReloadCmd(this));
        this.getCommand("helpsharp").setExecutor(new MainCmd(this));
        this.getCommand(helpCommandName).setExecutor(new ServHelpCmd(this));
    }

    public boolean reload(){
        reloadConfig();
        return true;
    }
}
