package com.byla.randommobs.mob;

public class MobStats {
    private double vida;
    private double dano;
    private double velocidade;
    private double tamanho;
    private double armadura;

    public MobStats() {

        this.vida = gerarMultiplicador();
        this.dano = gerarMultiplicador();
        this.velocidade = gerarMultiplicador();
        this.tamanho = gerarMultiplicador();
        this.armadura = gerarMultiplicador();

    }

    private double gerarMultiplicador() {
        double[] opcoes = {0.5, 0.75, 1.0, 1.5};
        return opcoes[(int) (Math.random() * opcoes.length)];
    }

    public double getVida() {
        return vida;
    }

    public double getDano() {
        return dano;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public double getTamanho() {
        return tamanho;
    }

    public double getArmadura() {
        return armadura;
    }

    @Override
    public String toString() {
        return "MobStats{" +
                "vida=" + String.format("%.1f", vida) + "x" +
                ", dano=" + String.format("%.1f", dano) + "x" +
                ", velocidade=" + String.format("%.1f", velocidade) + "x" +
                ", armadura=" + String.format("%.1f", armadura * 100) + "%" +
                '}';
    }
}
