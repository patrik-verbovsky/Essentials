package me.patrikverbovsky.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportAll implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("essentials.tpall")) {
                if (Bukkit.getServer().getOnlinePlayers().size() == 1) {
                    player.sendMessage("No other players are on the server right now.");
                } else if(Bukkit.getServer().getOnlinePlayers().size() > 1) {
                    int numOfPlayers = 0;
                    for(Player p : Bukkit.getServer().getOnlinePlayers()) {
                        p.teleport(player.getLocation());
                        numOfPlayers++;
                    } player.sendMessage("Teleported " + (numOfPlayers - 1) + " players to you.");
                }
            }
        } return true;
    }
}