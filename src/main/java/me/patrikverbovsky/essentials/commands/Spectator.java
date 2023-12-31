package me.patrikverbovsky.essentials.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spectator implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("essentials.gmsp")) {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage("Set gamemode to Spectator Mode");
            }
        } return true;
    }
}