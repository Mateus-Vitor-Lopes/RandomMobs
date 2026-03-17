package com.byla.randommobs.manager;

import com.byla.randommobs.mob.MobProfile;
import com.byla.randommobs.mob.MobStats;
import com.byla.randommobs.tag.TagMob;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.LivingEntity;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MobStatsManager {

    private static final Map<UUID, MobStats> statsMap = new HashMap<>();

    public static MobStats gerarStatus(LivingEntity mob, MobProfile perfil) {

        double vidaBase = mob.getAttribute(Attribute.MAX_HEALTH).getBaseValue();

        AttributeInstance atributoDano = mob.getAttribute(Attribute.ATTACK_DAMAGE);
        double danoBase;

        if (atributoDano == null) {
            danoBase = 1.0;
        } else {
            danoBase = atributoDano.getBaseValue();
        }

        double velocidadeBase = mob.getAttribute(Attribute.MOVEMENT_SPEED).getBaseValue();
        double tamanhoBase = mob.getAttribute(Attribute.SCALE).getBaseValue();

        MobStats stats = new MobStats(vidaBase, danoBase, velocidadeBase, tamanhoBase);

        aplicarTags(stats, perfil);

        return stats;
    }

    public static void aplicarTags (MobStats stats, MobProfile perfil)  {

        if (perfil.temTag(TagMob.TANK)) {stats.setVida(stats.getVida() * 2);}
        if (perfil.temTag(TagMob.VIDRO)) {stats.setVida(stats.getVida() * 0.5);}

        if (perfil.temTag(TagMob.FORTE)) {stats.setDano(stats.getDano() * 2);}
        if (perfil.temTag(TagMob.FRACO)) {stats.setDano(stats.getDano() * 0.5);}

        if (perfil.temTag(TagMob.GRANDE)) {stats.setTamanho(stats.getTamanho() * 2);}
        if (perfil.temTag(TagMob.PEQUENO)) {stats.setTamanho(stats.getTamanho() * 0.5);}

        if (perfil.temTag(TagMob.RAPIDO)) {stats.setVelocidade(stats.getVelocidade() * 2);}
        if (perfil.temTag(TagMob.LENTO)) {stats.setVelocidade(stats.getVelocidade() * 0.5);}
    }

}
