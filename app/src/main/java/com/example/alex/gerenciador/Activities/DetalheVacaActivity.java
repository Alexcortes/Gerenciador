package com.example.alex.gerenciador.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.alex.gerenciador.BD2.DBManagerListagens;
import com.example.alex.gerenciador.Model.AnimalModel;
import com.example.alex.gerenciador.R;

/**
 * Created by alex on 23/12/15.
 */
public class DetalheVacaActivity extends AppCompatActivity {
    TextView txtBrinco;
    TextView txtGDS;
    TextView txtUltimaMedida;
    TextView txtMaxMedida;
    int brinco;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_detalhevaca);

        txtBrinco = (TextView) findViewById(R.id.txtBrinco);
        txtGDS = (TextView) findViewById(R.id.txtGDS);
        txtUltimaMedida = (TextView) findViewById(R.id.txtUltimaMedida);
        txtMaxMedida = (TextView) findViewById(R.id.txtMaxMedida);

        AnimalModel vaca = new AnimalModel();

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            vaca.setBrinco(extras.getInt("Brinco"));
        }

        vaca = buscaDetahes(vaca.getBrinco());
        brinco = vaca.getBrinco();
        atualizarValores(vaca);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuItem addBezerra = menu.add(0,0,0, "Histórico de produção");
        addBezerra.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                Intent i = new Intent(getApplicationContext(),VacasActivity.class);
                startActivity(i);
                finish();
            return true;

            case 0:
                Intent j = new Intent(getApplicationContext(),GraficoActivity.class);
                j.putExtra("Brinco", brinco);
                startActivity(j);
                return true;


        }


        return true;
    }

    private AnimalModel buscaDetahes(int brinco){
        AnimalModel vaca = new AnimalModel();
        DBManagerListagens db = new DBManagerListagens(this);


        vaca = db.detalhesVaca(brinco);

        return vaca;
    }

    private void atualizarValores(AnimalModel vaca){
        setTitle(vaca.getNome());


        txtBrinco.setText(Integer.toString(vaca.getBrinco()));
        txtGDS.setText(Integer.toString(vaca.getgDS1())+"/"+Integer.toString(vaca.getgDS2())+" "+vaca.getRaca());
        txtUltimaMedida.setText(Float.toString(vaca.getUltMedProducao()));
        txtMaxMedida.setText(Float.toString(vaca.getMaxMedProducao()));

    }
}
