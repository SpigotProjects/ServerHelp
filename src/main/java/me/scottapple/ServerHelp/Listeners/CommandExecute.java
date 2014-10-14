package me.scottapple.ServerHelp.Listeners;


import me.scottapple.ServerHelp.ServerHelp;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
//
public class CommandExecute implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ServerHelp.getMessage("You must be a player to use this command."));
            return true;
        }
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("donate") && player.hasPermission("serverhelp.donate")) {
            player.sendMessage(ServerHelp.getMessage(ChatColor.translateAlternateColorCodes('&', ServerHelp.getPlugin().getConfig().getString("Messages.DonateMsg"))));
        } else if (cmd.getName().equalsIgnoreCase("youtube") && player.hasPermission("serverhelp.youtube")) {
            player.sendMessage(ServerHelp.getMessage(ChatColor.translateAlternateColorCodes('&', ServerHelp.getPlugin().getConfig().getString("Messages.YoutubeMsg"))));
        } else if (cmd.getName().equalsIgnoreCase("website") && player.hasPermission("serverhelp.website")) {
            player.sendMessage(ServerHelp.getMessage(ChatColor.translateAlternateColorCodes('&', ServerHelp.getPlugin().getConfig().getString("Messages.WebsiteMsg"))));
        } else if (cmd.getName().equalsIgnoreCase("facebook") && player.hasPermission("serverhelp.facebook")) {
            player.sendMessage(ServerHelp.getMessage(ChatColor.translateAlternateColorCodes('&', ServerHelp.getPlugin().getConfig().getString("Messages.FacebookMsg"))));
        } else if (cmd.getName().equalsIgnoreCase("twitter") && player.hasPermission("serverhelp.twitter")) {
            player.sendMessage(ServerHelp.getMessage(ChatColor.translateAlternateColorCodes('&', ServerHelp.getPlugin().getConfig().getString("Messages.TwitterMsg"))));
        } else if (cmd.getName().equalsIgnoreCase("commands") && player.hasPermission("serverhelp.commands")) {
            player.sendMessage(ServerHelp.getMessage(ChatColor.translateAlternateColorCodes('&', ServerHelp.getPlugin().getConfig().getString("Messages.CommandsMsg"))));
        } else if (cmd.getName().equalsIgnoreCase("email") && player.hasPermission("serverhelp.email")) {
            player.sendMessage(ServerHelp.getMessage(ChatColor.translateAlternateColorCodes('&', ServerHelp.getPlugin().getConfig().getString("Messages.EmailMsg"))));
        } else if (cmd.getName().equalsIgnoreCase("staff") && player.hasPermission("serverhelp.staff")) {
            player.sendMessage(ServerHelp.getMessage(ChatColor.translateAlternateColorCodes('&', ServerHelp.getPlugin().getConfig().getString("Messages.StaffMsg"))));
        } else if (cmd.getName().equalsIgnoreCase("tutorial") && player.hasPermission("serverhelp.tutorial")) {
            player.sendMessage(ServerHelp.getMessage(ChatColor.translateAlternateColorCodes('&', ServerHelp.getPlugin().getConfig().getString("Messages.TutorialMsg"))));
        } else if (cmd.getName().equalsIgnoreCase("teamspeak") && player.hasPermission("serverhelp.teamspeak")) {
            player.sendMessage(ServerHelp.getMessage(ChatColor.translateAlternateColorCodes('&', ServerHelp.getPlugin().getConfig().getString("Messages.TeamspeakMsg"))));
        } else if (cmd.getName().equalsIgnoreCase("mumble") && player.hasPermission("serverhelp.mumble")) {
            player.sendMessage(ServerHelp.getMessage(ChatColor.translateAlternateColorCodes('&', ServerHelp.getPlugin().getConfig().getString("Messages.MumbleMsg"))));
        } else if (cmd.getName().equalsIgnoreCase("shreload") && player.hasPermission("serverhelp.reload")) {
            ServerHelp.getPlugin().reloadConfig();
        } else if (cmd.getName().equalsIgnoreCase("vote") && player.hasPermission("serverhelp.vote")) {
            player.sendMessage(ServerHelp.getMessage(ChatColor.translateAlternateColorCodes('&', ServerHelp.getPlugin().getConfig().getString("Messages.VoteMsg"))));
        } else if (cmd.getName().equalsIgnoreCase("thread") && player.hasPermission("serverhelp.thread")) {
            player.sendMessage(ServerHelp.getMessage(ChatColor.translateAlternateColorCodes('&', ServerHelp.getPlugin().getConfig().getString("Messages.ThreadMsg"))));
        } else if (cmd.getName().equalsIgnoreCase("link") && player.hasPermission("serverhelp.link")) {
            player.sendMessage(ServerHelp.getMessage(ChatColor.translateAlternateColorCodes('&', ServerHelp.getPlugin().getConfig().getString("Messages.LinkMsg"))));
        } else {
            player.sendMessage(ServerHelp.getMessage(ChatColor.translateAlternateColorCodes('&', ServerHelp.getPlugin().getConfig().getString("Messages.NoPermMsg"))));
        }
        return true;
    }
}
