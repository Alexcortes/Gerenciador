package com.example.alex.gerenciador.Model;

import java.util.Date;

/**
 * Created by alex on 22/12/15.
 */
public class AnimalModel {
    public int brinco;
    public String nome;
    public String mae;
    public String pai;
    public int inseminacao;
    public int gDS1;
    public int gDS2;
    public String raca;
    public int prenhez;
    public float maxMedProducao;
    public float ultMedProducao;

    public AnimalModel(int brinco, String nome, int inseminacao, int gDS1, int gDS2, String raca, int prenhez, float maxMedProducao, float ultMedProducao) {
        this.brinco = brinco;
        this.nome = nome;
        this.inseminacao = inseminacao;
        this.gDS1 = gDS1;
        this.gDS2 = gDS2;
        this.raca = raca;
        this.prenhez = prenhez;
        this.maxMedProducao = maxMedProducao;
        this.ultMedProducao = ultMedProducao;
    }

    public AnimalModel() {
    }

    public int getBrinco() {
        return brinco;
    }

    public void setBrinco(int brinco) {
        this.brinco = brinco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public int getInseminacao() {
        return inseminacao;
    }

    public void setInseminacao(int inseminacao) {
        this.inseminacao = inseminacao;
    }

    public int getgDS1() {
        return gDS1;
    }

    public void setgDS1(int gDS1) {
        this.gDS1 = gDS1;
    }

    public int getgDS2() {
        return gDS2;
    }

    public void setgDS2(int gDS2) {
        this.gDS2 = gDS2;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getPrenhez() {
        return prenhez;
    }

    public void setPrenhez(int prenhez) {
        this.prenhez = prenhez;
    }

    public float getMaxMedProducao() {
        return maxMedProducao;
    }

    public void setMaxMedProducao(float maxMedProducao) {
        this.maxMedProducao = maxMedProducao;
    }

    public float getUltMedProducao() {
        return ultMedProducao;
    }

    public void setUltMedProducao(float ultMedProducao) {
        this.ultMedProducao = ultMedProducao;
    }
}
