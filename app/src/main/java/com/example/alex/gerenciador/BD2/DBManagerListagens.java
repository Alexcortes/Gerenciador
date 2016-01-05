package com.example.alex.gerenciador.BD2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alex.gerenciador.Model.AnimalModel;
import com.example.alex.gerenciador.Model.HistoricoProducao;

import java.util.ArrayList;

/**
 * Created by alex on 23/12/15.
 */
public class DBManagerListagens {
    private static DBHelper dbHelper = null;

    public DBManagerListagens(Context context){
        if (dbHelper ==  null){
            dbHelper = new DBHelper(context);
        }
    }

    public ArrayList<AnimalModel> listarVacas(){
        int i =0;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String receberLista = "SELECT brinco, nome FROM TABLE_ANIMAL ORDER BY brinco";

        Cursor cursor = db.rawQuery(receberLista, null);
        ArrayList <AnimalModel> vacas = new ArrayList<AnimalModel>();

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{
                AnimalModel vaca = new AnimalModel();
                int indexBrinco = cursor.getColumnIndex("brinco");
                int indexNome = cursor.getColumnIndex("nome");

                vaca.setBrinco(cursor.getInt(indexBrinco));
                vaca.setNome(cursor.getString(indexNome));

                vacas.add(vaca);

            }while(cursor.moveToNext());
        }


        return vacas;
    }


    public ArrayList<Integer> listarBrincos(){
        int i =0;
        String receberLista = "SELECT brinco FROM TABLE_ANIMAL ORDER BY brinco";
        ArrayList <Integer> brincos = new ArrayList<Integer>();


        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(receberLista, null);


        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{
                Integer brinco;
                int indexBrinco = cursor.getColumnIndex("brinco");

                brinco = cursor.getInt(indexBrinco);


                brincos.add(brinco);

            }while(cursor.moveToNext());
        }

        return brincos;
    }


    public ArrayList<HistoricoProducao> listarProducoes(int brinco){
        int i =0;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String receberLista = "SELECT data, producao, id FROM HISTORICO_MEDICAO WHERE brinco_animal="+brinco+ " ORDER BY id DESC";

        Cursor cursor = db.rawQuery(receberLista, null);
        ArrayList <HistoricoProducao> producoes = new ArrayList<HistoricoProducao>();

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{
                HistoricoProducao producao = new HistoricoProducao();
                int indexData = cursor.getColumnIndex("data");
                int indexProducao = cursor.getColumnIndex("producao");

                producao.setDataMedicao(cursor.getString(indexData));
                producao.setProducao(cursor.getFloat(indexProducao));

                producoes.add(producao);

            }while(cursor.moveToNext());
        }


        return producoes;
    }



    public AnimalModel detalhesVaca(int brinco){
        int brincoMae = 0;
        int idPai = 0;

        String sql = "SELECT * FROM TABLE_ANIMAL WHERE brinco = " + brinco;
        String buscaMae = "SELECT nome FROM TABLE_ANIMAL WHERE brinco = "+ brincoMae;
        String buscaPai = "SELECT nome FROM TABLE_TOURO WHERE id = "+idPai;


        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();

        AnimalModel vaca = new AnimalModel(brinco, cursor.getString(1), cursor.getInt(4), cursor.getInt(5), cursor.getInt(6), cursor.getString(7), cursor.getInt(8), cursor.getFloat(9), cursor.getFloat(10));

        brincoMae = cursor.getInt(2);
        idPai = cursor.getInt(3);;


        Cursor cursorMae = db.rawQuery(buscaMae, null);
        Cursor cursorPai = db.rawQuery(buscaPai, null);

        cursorMae.moveToFirst();
        cursorPai.moveToFirst();

        if((cursorMae.getCount()>0) && (cursorPai.getCount()>0)) {

            vaca.setMae(cursorMae.getString(0));
            vaca.setPai(cursorPai.getString(0));
        }

        return vaca;
    }






}
