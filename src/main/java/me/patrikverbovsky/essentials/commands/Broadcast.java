package me.patrikverbovsky.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        for (Player player: Bukkit.getServer().getOnlinePlayers()) {
            if (player.hasPermission("essentials.broadcast")) {
                if (args.length == 0) {
                    player.sendMessage("To broadcast: /broadcast <message>");
                    return false;
                }
                String message = String.join(" ", args);
                Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "[Broadcast] " + message);
                return true;
            }
        } return false;
    }
}