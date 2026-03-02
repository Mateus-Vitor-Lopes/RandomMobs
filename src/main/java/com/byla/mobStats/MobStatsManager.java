package com.byla.mobStats;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MobStatsManager {

    private final Map<UUID, MobStats> mobsStats = new HashMap<>();

    public void atribuirStatsMob(LivingEntity entidade) {
        if (entidade instanceof Player) return;

        UUID uuid = entidade.getUniqueId();
        MobStats stats = new MobStats();
        mobsStats.put(uuid, stats);
        aplicarStats(entidade, stats);
        aplicarVelocidade(entidade, stats.getVelocidade());
        aplicarTamanho(entidade, stats.getTamanho());
        aplicarArmadura(entidade, stats.getArmadura());

    }

    private void aplicarStats(LivingEntity entidade, MobStats stats) {

        AttributeInstance vidaMaxima = entidade.getAttribute(Attribute.MAX_HEALTH);

        double vidaBase = vidaMaxima.getBaseValue();
        double novaVida = vidaBase * stats.getVida();

        vidaMaxima.setBaseValue(novaVida);
        entidade.setHealth(novaVida);
    }

    private void aplicarVelocidade(LivingEntity entidade, double multiplicador) {
        try {
            double velocidadeBase = 0.3;
            double velocidadeCustomizada = velocidadeBase * multiplicador;

            entidade.getAttribute(Attribute.MOVEMENT_SPEED).setBaseValue(velocidadeCustomizada);
        } catch (Exception e) {
        }

    }

    private void aplicarArmadura(LivingEntity entidade, double armadura) {
        try {
            entidade.getAttribute(Attribute.ARMOR).setBaseValue(armadura);
        } catch (Exception e) {
        }

    }

    private void aplicarTamanho(LivingEntity entidade, double multiplicador) {
        try {
            if (entidade.getAttribute(Attribute.SCALE) == null) return;

            double tamnahoBase = 1;
            double tamanhoFinal = tamnahoBase * multiplicador;
            entidade.getAttribute(Attribute.SCALE).setBaseValue(tamanhoFinal);

        } catch (Exception e) {}
    }

}
