package com.example.alex.gerenciador.Model;

import java.util.Date;

/**
 * Created by alex on 22/12/15.
 */
public class HistoricoProducao {
    public int id;
    public int brincoAnimal;
    public String dataMedicao;
    public float producao;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrincoAnimal() {
        return brincoAnimal;
    }

    public void setBrincoAnimal(int brincoAnimal) {
        this.brincoAnimal = brincoAnimal;
    }

    public String getDataMedicao() {
        return dataMedicao;
    }

    public void setDataMedicao(String dataMedicao) {
        this.dataMedicao = dataMedicao;
    }

    public float getProducao() {
        return producao;
    }

    public void setProducao(float producao) {
        this.producao = producao;
    }
}
