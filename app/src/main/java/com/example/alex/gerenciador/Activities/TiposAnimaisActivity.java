package com.example.alex.gerenciador.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.alex.gerenciador.R;

/**
 * Created by alex on 28/12/15.
 */
public class TiposAnimaisActivity extends AppCompatActivity {
    Button vaca;
    Button bezerra;
    Button touro;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiposanimais);
        setTitle("Escolha uma opção");

        vaca = (Button) findViewById(R.id.BTNVacas);
        bezerra = (Button) findViewById(R.id.BTNBezerras);
        touro = (Button) findViewById(R.id.BTNTouros);



        vaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TiposAnimaisActivity.this,VacasActivity.class));
            }
        });

    }


}
