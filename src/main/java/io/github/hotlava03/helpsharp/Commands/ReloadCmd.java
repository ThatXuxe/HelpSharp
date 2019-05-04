class ReloadCmd extends CommandExecutor
{ 
  Main plugin;

	public ReloadCmd(Main instance)
	{
	     plugin = instance;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] names)
    {
        Player player = (Player) sender;
        if(!sender.hasPermission("helpsharp.reload")){
            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "Help" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY+" You are lacking the permission "+ChatColor.WHITE+"helpsharp.reload "+ChatColor.GRAY+"to run this command.");
            return true;
        }
        plugin.reload();
        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "Help" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY+" Config reloaded successfully.");
        return true;
    }
}
