package com.byla.mobStats;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
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
        if (evento.getSpawnReason() != CreatureSpawnEvent.SpawnReason.NATURAL &&
                evento.getSpawnReason() != CreatureSpawnEvent.SpawnReason.SPAWNER &&
                evento.getSpawnReason() != CreatureSpawnEvent.SpawnReason.REINFORCEMENTS) {
            return;
        }

        LivingEntity entidade = evento.getEntity();

        if (entidade.getType() == EntityType.ARMOR_STAND ||
                entidade.getType() == EntityType.PLAYER) {
            return;
        }

        if (manager.obterStats(entidade) != null) {
            return;
        }

        manager.atribuirStatsMob(entidade);
    }

}
