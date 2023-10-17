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
                    player.sendMessage("You have been healed.");
                    player.setHealth(20);
                    player.setFoodLevel(20);
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        target.setHealth(20);
                        target.setFoodLevel(20);
                        target.sendMessage("You have been healed.");
                        player.sendMessage("You healed " + args[0] + ".");
                    } else {
                        player.sendMessage("The player " + args[0] + " is not on the server.");
                    }
                } else {
                    player.sendMessage("Use /heal <player>.");
                }
            } else {
                player.sendMessage( ChatColor.RED + "You don't have the permission for this command.");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You can only use this command as a player.");
        } return false;
    }
}