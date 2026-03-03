package com.byla.randommobs;

import com.byla.randommobs.listener.MobDamageListener;
import com.byla.randommobs.listener.MobSpawnListener;
import com.byla.randommobs.manager.MobStatsManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomMobs extends JavaPlugin {

    private MobStatsManager manager;

    @Override
    public void onEnable() {
        manager = new MobStatsManager();

        getServer().getPluginManager().registerEvents(
                new MobSpawnListener(manager),
                this
        );
        getServer().getPluginManager().registerEvents(
                new MobDamageListener(manager),
                this
        );

        getLogger().info("§a━━━━━━━━━━━━━━━━━━");
        getLogger().info("§aMobStats ativado!");
        getLogger().info("§a✓ Stats aleatórios habilitados");
        getLogger().info("§a━━━━━━━━━━━━━━━━━━");
    }

    @Override
    public void onDisable() {

        getLogger().info("§cMobStats desativado!");
    }
}