package com.byla.mobStats;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class MobDamageListener implements Listener {
    private final MobStatsManager manager;

    public MobDamageListener(MobStatsManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void aoCausarDano (EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Mob agressor)) {
            return;
        }

        MobStats stats = manager.obterStats(agressor);
        if (stats == null) {
            return;
        }

        double danoCustomizado = event.getDamage() * stats.getDano();
        event.setDamage(danoCustomizado);
    }

    @EventHandler
    public void aoReceberDano (EntityDamageByEntityEvent event) {
        LivingEntity vitima = (LivingEntity) event.getEntity();

        if (!(vitima instanceof Mob)) {
            return;
        }

        MobStats stats = manager.obterStats(vitima);
        if (stats == null) {
            return;
        }

        double reducao = stats.getArmadura() / 100.0;
        double danoDivido = event.getDamage() * (1.0 - reducao);
        event.setDamage(Math.max(0.5, danoDivido));

    }

}
