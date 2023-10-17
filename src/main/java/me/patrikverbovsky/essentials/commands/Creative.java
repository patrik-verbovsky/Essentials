package me.patrikverbovsky.essentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Creative implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("essentials.gmc")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ChatColor.RED + "Set gamemode to Creative Mode");
            } return true;
        } return false;
    }
}