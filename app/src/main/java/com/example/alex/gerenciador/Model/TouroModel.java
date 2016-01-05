package com.example.alex.gerenciador.Model;

/**
 * Created by alex on 22/12/15.
 */
public class TouroModel {
    public int id;
    public String nome;
    public int qtdEstoque;
    public String grauDeSangue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getGrauDeSangue() {
        return grauDeSangue;
    }

    public void setGrauDeSangue(String grauDeSangue) {
        this.grauDeSangue = grauDeSangue;
    }
}
