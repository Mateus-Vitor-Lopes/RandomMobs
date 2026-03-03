package com.byla.randommobs.util;

import com.byla.randommobs.mob.MobProfile;
import org.bukkit.entity.LivingEntity;

public interface MobBehavior {

    void aplicar(LivingEntity entidade, MobProfile perfil);

}
