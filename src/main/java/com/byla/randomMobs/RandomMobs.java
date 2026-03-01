package com.byla.randomMobs;

import com.byla.mobStats.MobDamageListener;
import com.byla.mobStats.MobSpawnListener;
import com.byla.mobStats.MobStatsManager;
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
        if (manager != null) {
            manager.removerTodosStats();
        }
        getLogger().info("§cMobStats desativado!");
    }

    public MobStatsManager getManager() {
        return manager;
    }
}