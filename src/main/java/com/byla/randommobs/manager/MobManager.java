package com.byla.randommobs.manager;

import com.byla.randommobs.mob.MobProfile;
import org.bukkit.entity.LivingEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MobManager {

    private static final Map<UUID, MobProfile> perfis = new HashMap<>();

    public static void registrar(LivingEntity entidade, MobProfile perfil) {
        perfis.put(entidade.getUniqueId(), perfil);
    }

    public static MobProfile getProfile (LivingEntity entida) {
        return perfis.get(entida.getUniqueId());
    }


}
