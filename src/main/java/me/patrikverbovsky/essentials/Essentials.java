package me.patrikverbovsky.essentials;

import org.bukkit.plugin.java.JavaPlugin;
import me.patrikverbovsky.essentials.commands.*;

public final class Essentials extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("fly").setExecutor(new Fly());
        this.getCommand("disablefly").setExecutor(new DisableFly());
        this.getCommand("tp").setExecutor(new Teleport());
        this.getCommand("tpall").setExecutor(new TeleportAll());
        this.getCommand("gms").setExecutor(new Survival());
        this.getCommand("gmc").setExecutor(new Creative());
        this.getCommand("gma").setExecutor(new Adventure());
        this.getCommand("gmsp").setExecutor(new Spectator());
        this.getCommand("broadcast").setExecutor(new Broadcast());
        this.getCommand("heal").setExecutor(new Heal());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
