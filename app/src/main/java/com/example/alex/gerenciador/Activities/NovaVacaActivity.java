package com.example.alex.gerenciador.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.alex.gerenciador.BD2.DBManagerAdicoes;
import com.example.alex.gerenciador.BD2.DBManagerListagens;
import com.example.alex.gerenciador.Model.AnimalModel;
import com.example.alex.gerenciador.R;

/**
 * Created by alex on 22/12/15.
 */
public class NovaVacaActivity extends AppCompatActivity {
    EditText txtNBrinco;
    EditText txtNome;
    EditText txtGDS1;
    EditText txtGDS2;
    Button btnSalvar;
    Spinner spRaca;
    String raca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novavaca);
        setTitle("Adicionar animal");


        btnSalvar = (Button) findViewById(R.id.btnSalvarAnimal);
        txtNBrinco = (EditText) findViewById(R.id.txtNBrinco);
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtGDS1 = (EditText) findViewById(R.id.txtGDS1);
        txtGDS2 = (EditText) findViewById(R.id.txtGDS2);
        spRaca = (Spinner) findViewById(R.id.spRaca);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.racas_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spRaca.setAdapter(adapter);

        spRaca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    raca = "Holandes";
                } else if (position == 1) {
                    raca = "Gir";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        btnSalvar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AnimalModel novaVaca = new AnimalModel();
                DBManagerAdicoes dbManagerAdicoes = new DBManagerAdicoes(NovaVacaActivity.this);

                novaVaca.setBrinco(Integer.parseInt(txtNBrinco.getText().toString()));
                novaVaca.setNome(txtNome.getText().toString());
                novaVaca.setgDS1(Integer.parseInt(txtGDS1.getText().toString()));
                novaVaca.setgDS2(Integer.parseInt(txtGDS2.getText().toString()));
                novaVaca.setRaca(raca);

                dbManagerAdicoes.addVaca(novaVaca);


                startActivity(new Intent(NovaVacaActivity.this, VacasActivity.class));
                finish();
            }
        });


    }



}
