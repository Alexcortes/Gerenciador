package com.example.alex.gerenciador.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alex.gerenciador.BD2.DBManagerAdicoes;
import com.example.alex.gerenciador.BD2.DBManagerListagens;
import com.example.alex.gerenciador.Model.HistoricoProducao;
import com.example.alex.gerenciador.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by alex on 29/12/15.
 */
public class MedicaoActivity extends AppCompatActivity {
    Spinner spBrincos;
    EditText txtProducao;
    TextView txtData;
    Button btnNova;
    Button btnFim;
    ArrayList<Integer> brincos;
    Toast toast = Toast.makeText(getApplicationContext(), "Preencha o campo Produção", Toast.LENGTH_LONG);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicao);



        final HistoricoProducao novaMedida = new HistoricoProducao();

        DBManagerListagens db = new DBManagerListagens(this);

        Date hoje = new Date();
        SimpleDateFormat df;
        df = new SimpleDateFormat("dd/MM/yyyy");
        String data = df.format(hoje);

        spBrincos = (Spinner) findViewById(R.id.spBrincos);
        txtProducao = (EditText) findViewById(R.id.txtProducao);
        txtData = (TextView) findViewById(R.id.txtData);
        btnNova = (Button) findViewById(R.id.BTNNova);
        btnFim = (Button) findViewById(R.id.BTNFim);


        novaMedida.setDataMedicao(data);


        txtData.setText(novaMedida.getDataMedicao());


        brincos = db.listarBrincos();
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, brincos);

        spBrincos.setAdapter(adapter);


        spBrincos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                novaMedida.setBrincoAnimal(brincos.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnNova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(txtProducao.getText().toString())) {
                    toast.show();
                }else{
                    finalizar(novaMedida);

                    startActivity(new Intent(MedicaoActivity.this, MedicaoActivity.class));
                    finish();
                }
            }
        });

        btnFim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(txtProducao.getText().toString())) {
                    toast.show();
                }else{
                    finalizar(novaMedida);

                    startActivity(new Intent(MedicaoActivity.this, VacasActivity.class));
                    finish();
                }
            }
        });

    }



    private void finalizar(HistoricoProducao novaMedida){
        DBManagerAdicoes db = new DBManagerAdicoes(this);

        novaMedida.setProducao(Float.parseFloat(txtProducao.getText().toString()));

        db.addMedicao(novaMedida);

    }
}
