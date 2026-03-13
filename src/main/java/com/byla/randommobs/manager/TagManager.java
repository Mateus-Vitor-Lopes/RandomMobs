package com.byla.randommobs.manager;

import com.byla.randommobs.tag.TagMob;
import org.bukkit.entity.EntityType;

import java.util.HashSet;
import java.util.Set;

public class TagManager {

    public static Set<TagMob> sortearTags(EntityType tipo) {

        Set<TagMob> tags = new HashSet<>();

        Double numero = Math.random();

        //Tamanho

        if (numero < 0.3) {
            tags.add(TagMob.GRANDE);
        } else if (numero < 0.6) {
            tags.add(TagMob.PEQUENO);
        }

        //Força

        numero = Math.random();

        if (numero < 0.3) {
            tags.add(TagMob.FORTE);
        } else if (numero < 0.6) {
            tags.add(TagMob.FRACO);
        }

        //Velocidade

        numero = Math.random();

        if (numero < 0.3) {
            tags.add(TagMob.RAPIDO);
        } else if (numero < 0.6) {
            tags.add(TagMob.LENTO);
        }

        //Aggro

        numero = Math.random();

        if (numero < 0.3) {
            tags.add(TagMob.AGRESSIVO);
        } else if (numero < 0.6) {
            tags.add(TagMob.PASSIVO);
        }

        //Durabilidade

        numero = Math.random();

        if (numero < 0.3) {
            tags.add(TagMob.TANK);
        } else if (numero < 0.6) {
            tags.add(TagMob.VIDRO);
        }

        //Comportamento

        numero = Math.random();

        if (numero < 0.25) {
            tags.add(TagMob.ESCALAR);
        } else if (numero < 0.50) {
            tags.add(TagMob.EXPLOSIVO);
        } else if (numero < 0.75) {
            tags.add(TagMob.TELEPORT);
        }

        return tags;

    }
}
