package com.example.alex.gerenciador.Model;

import java.util.Date;

/**
 * Created by alex on 22/12/15.
 */
public class AcompanhamentoModel {
    public int id;
    public AnimalModel animal;
    public Date dataInseminacao;
    public Date dataSecagem;
    public Date dataParto;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AnimalModel getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalModel animal) {
        this.animal = animal;
    }

    public Date getDataInseminacao() {
        return dataInseminacao;
    }

    public void setDataInseminacao(Date dataInseminacao) {
        this.dataInseminacao = dataInseminacao;
    }

    public Date getDataSecagem() {
        return dataSecagem;
    }

    public void setDataSecagem(Date dataSecagem) {
        this.dataSecagem = dataSecagem;
    }

    public Date getDataParto() {
        return dataParto;
    }

    public void setDataParto(Date dataParto) {
        this.dataParto = dataParto;
    }

}



