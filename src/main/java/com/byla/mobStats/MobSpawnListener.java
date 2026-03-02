package com.byla.mobStats;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
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

        LivingEntity entidade = evento.getEntity();

        if (entidade.getType() == EntityType.ARMOR_STAND) return;
        if (entidade instanceof Player) return;

        if (manager.obterStats(entidade) != null) return;

        manager.atribuirStatsMob(entidade);
    }

}
