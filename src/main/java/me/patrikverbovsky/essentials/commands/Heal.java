package me.patrikverbovsky.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("essentials.heal")) {
                if (args.length == 0) {
                    player.sendMessage(ChatColor.YELLOW + "You have been successfully healed!");
                    player.setFoodLevel(20);
                    player.setHealth(20);
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        target.setHealth(20);
                        target.setFoodLevel(20);
                        target.sendMessage(ChatColor.YELLOW + "You were healed!");
                        player.sendMessage(ChatColor.YELLOW + "You healed the Player " + target.getPlayerListName());
                    } else {
                        player.sendMessage(ChatColor.RED + "The player" + args[0] + " is not on the server!");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Please use /heal <player>!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "I'm sorry, but you do not have the permission to perform this command.");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You can only use this command as a player!");
        } return false;
    }
}
