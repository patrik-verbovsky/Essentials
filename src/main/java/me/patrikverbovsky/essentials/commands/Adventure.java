package me.patrikverbovsky.essentials.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Adventure implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("essentials.gma")) {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage("Set gamemode to Adventure Mode");
            } return true;
        } return false;
    }
}