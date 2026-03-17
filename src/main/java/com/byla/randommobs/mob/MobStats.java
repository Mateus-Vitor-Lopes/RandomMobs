package com.byla.randommobs.mob;

public class MobStats {
    private double vida;
    private double dano;
    private double velocidade;
    private double tamanho;

    public MobStats(double vida, double dano, double velocidade, double tamanho) {

        this.vida = vida;
        this.dano = dano;
        this.velocidade = velocidade;
        this.tamanho = tamanho;

    }

    public double getVida() {return vida;}

    public double getDano() {
        return dano;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setVida(double vida) {this.vida = vida;}

    public void setDano(double dano) {this.dano = dano;}

    public void setVelocidade(double velocidade) {this.velocidade = velocidade;}

    public void setTamanho(double tamanho) {this.tamanho = tamanho;}
}
