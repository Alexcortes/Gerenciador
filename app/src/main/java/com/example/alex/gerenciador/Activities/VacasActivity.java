package com.example.alex.gerenciador.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alex.gerenciador.BD2.DBManagerListagens;
import com.example.alex.gerenciador.Model.AnimalModel;
import com.example.alex.gerenciador.R;

import java.util.ArrayList;


public class VacasActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<AnimalModel> vacas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacas);
        setTitle("Vacas");

        AnimalModel animal;
        DBManagerListagens dbManagerListagens = new DBManagerListagens(this);
        ArrayList <String> listaVacas = new ArrayList<>();

        vacas = dbManagerListagens.listarVacas();


        if (vacas!=null) {

            for(int i=0; i<vacas.size(); i++){
                animal = vacas.get(i);
                listaVacas.add(Integer.toString(animal.getBrinco()) +"  -  "+animal.getNome());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaVacas);
            listView = (ListView) findViewById(R.id.listAnimais);
            listView.setAdapter(adapter);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView parent, View v, int position, long id){
                AnimalModel animal = new AnimalModel();
                int brinco;

                animal = vacas.get(position);
                brinco = animal.getBrinco();

                Intent i = new Intent(getApplicationContext(),DetalheVacaActivity.class);
                i.putExtra("Brinco", brinco);
                startActivity(i);
                finish();

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuItem addAnimal = menu.add(0,0,0,"Adicionar Vaca");
        addAnimal.setIcon(R.mipmap.ic_add);
        addAnimal.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        MenuItem addBezerra = menu.add(0,1,1, "Nova Medição");
        addBezerra.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case 0:
                startActivity(new Intent(VacasActivity.this,NovaVacaActivity.class));
                return true;

            case 1:
                startActivity(new Intent(VacasActivity.this,MedicaoActivity.class));
                return true;


        }


        return true;
    }

}

