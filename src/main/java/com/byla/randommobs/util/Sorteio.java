package com.byla.randommobs.util;

public interface Sorteio {

    default double gerarNumero() {
        return Math.random();
    }

}
