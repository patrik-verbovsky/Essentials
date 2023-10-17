package me.patrikverbovsky.essentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("essentials.fly")) {
                player.setAllowFlight(true);
                player.setFlying(true);
                player.sendMessage("Set flying to Enabled");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You need to be a player to use this command.");
            return true;
        } return false;
    }
}