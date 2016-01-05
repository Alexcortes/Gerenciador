package com.example.alex.gerenciador.BD2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alex.gerenciador.Model.AnimalModel;
import com.example.alex.gerenciador.Model.HistoricoProducao;

/**
 * Created by alex on 29/12/15.
 */
public class DBManagerAdicoes {
    private static DBHelper dbHelper = null;

    public DBManagerAdicoes(Context context){
        if (dbHelper ==  null){
            dbHelper = new DBHelper(context);
        }
    }

    public void addVaca(AnimalModel vaca){
        String adicionar = "INSERT INTO TABLE_ANIMAL (brinco, nome, brinco_mae, id_pai, inseminacao, grauDeSangue1, grauDeSangue2, raca ,prenha, ultima_medida, max_medida) VALUES" +
                " ("+vaca.getBrinco()+",'"+vaca.getNome()+"', 0, -1, 0,"+vaca.getgDS1()+", "+vaca.getgDS2()+", '"+vaca.getRaca()+"', 0, 0, 0 )";

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL(adicionar);
    }

    public void addMedicao(HistoricoProducao producao){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String adicionarProducao = "INSERT INTO HISTORICO_MEDICAO (brinco_animal, data, producao) VALUES" +
                " ("+producao.getBrincoAnimal()+",'"+producao.getDataMedicao()+"', "+producao.getProducao()+")";

        db.execSQL(adicionarProducao);

        String atualizarAnimal = "UPDATE TABLE_ANIMAL SET ultima_medida="+producao.getProducao()+" , max_medida="+producoes(producao.getBrincoAnimal())+" WHERE brinco = "+producao.getBrincoAnimal();

            db.execSQL(atualizarAnimal);

}

    private float producoes(int brinco){
        float max = 0;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String recebeMax = "SELECT Max(producao) FROM HISTORICO_MEDICAO WHERE brinco_animal = "+brinco;

        Cursor cursor = db.rawQuery(recebeMax, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            max = cursor.getFloat(0);
        }

        return max;
    }

}
