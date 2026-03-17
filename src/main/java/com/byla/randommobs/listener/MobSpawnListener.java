package com.byla.randommobs.listener;

import com.byla.randommobs.manager.MobStatsManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class MobSpawnListener implements Listener {
    private final MobStatsManager manager;

    public MobSpawnListener(MobStatsManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void aoSpawnarMob(CreatureSpawnEvent evento) {


    }

}
