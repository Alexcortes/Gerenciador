package com.example.alex.gerenciador.BD2;

import android.content.Context;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alex on 22/12/15.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static String DB_Name = "controleLeiteiro3";
    private static int DB_Version = 1;

    private static String TABLE_TOURO = "CREATE TABLE [TABLE_TOURO] (" +
            "  [id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            "  [nome] VARCHAR(50)," +
            "  [grauDeSangue] VARCHAR(10)," +
            "  [qtd_estoque] INTEGER);";

    private static String TABLE_ANIMAL = "CREATE TABLE [TABLE_ANIMAL] (" +
            "  [brinco] INTEGER NOT NULL PRIMARY KEY, " +
            "  [nome] VARCHAR(50), " +
            "  [brinco_mae] INTEGER, " +
            "  [id_pai] INTEGER CONSTRAINT [id_pai] REFERENCES [TABLE_TOURO]([id]) CONSTRAINT [brinco_mae] REFERENCES [TABLE_ANIMAL]([brinco])," +
            "  [inseminacao] int," +
            "  [grauDeSangue1] int," +
            "  [grauDeSangue2] int," +
            "  [raca] varchar(10)," +
            "  [prenha] int," +
            "  [ultima_medida] FLOAT, " +
            "  [max_medida] FLOAT);";

    private static String HISTORICO_MEDICAO = "CREATE TABLE [HISTORICO_MEDICAO] (" +
            "  [id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            "  [data] varchar(15), " +
            "  [producao] FLOAT, " +
            "  [brinco_animal] INTEGER CONSTRAINT [brinco_animal] REFERENCES [TABLE_ANIMAL]([brinco]));";

    private static String TABLE_ACOMPANHAMENTO = "CREATE TABLE [TABLE_ACOMPANHAMENTO] (" +
            "  [id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
            "  [brinco_animal] INTEGER CONSTRAINT [brinco_animal] REFERENCES [TABLE_ANIMAL]([brinco]), " +
            "  [data_inseminacao] varchar(15), " +
            "  [previsao_secagem] varchar(15), " +
            "  [previsao_parto] varchar(15));";

    public DBHelper(Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_TOURO);
        db.execSQL(TABLE_ANIMAL);
        db.execSQL(TABLE_ACOMPANHAMENTO);
        db.execSQL(HISTORICO_MEDICAO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
