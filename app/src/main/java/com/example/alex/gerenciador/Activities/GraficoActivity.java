package com.example.alex.gerenciador.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.alex.gerenciador.BD2.DBManagerListagens;
import com.example.alex.gerenciador.Model.AnimalModel;
import com.example.alex.gerenciador.Model.HistoricoProducao;
import com.example.alex.gerenciador.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by alex on 29/12/15.
 */
public class GraficoActivity extends AppCompatActivity {
    ProgressBar pbProducao1;
    ProgressBar pbProducao2;
    ProgressBar pbProducao3;
    ProgressBar pbProducao4;
    ProgressBar pbProducao5;
    ProgressBar pbProducao6;
    ProgressBar pbProducao7;
    ProgressBar pbProducao8;
    ProgressBar pbProducao9;
    ProgressBar pbProducao10;
    TextView txtData1;
    TextView txtData2;
    TextView txtData3;
    TextView txtData4;
    TextView txtData5;
    TextView txtData6;
    TextView txtData7;
    TextView txtData8;
    TextView txtData9;
    TextView txtData10;
    TextView txtErro;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);
        int brinco=0;
        ArrayList<HistoricoProducao> producoes = new ArrayList<HistoricoProducao>();
        DBManagerListagens dbListagens = new DBManagerListagens(this);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            brinco = extras.getInt("Brinco");
        }

        pbProducao1 = (ProgressBar) findViewById(R.id.pbProducao1);
        pbProducao2 = (ProgressBar) findViewById(R.id.pbProducao2);
        pbProducao3 = (ProgressBar) findViewById(R.id.pbProducao3);
        pbProducao4 = (ProgressBar) findViewById(R.id.pbProducao4);
        pbProducao5 = (ProgressBar) findViewById(R.id.pbProducao5);
        pbProducao6 = (ProgressBar) findViewById(R.id.pbProducao6);
        pbProducao7 = (ProgressBar) findViewById(R.id.pbProducao7);
        pbProducao8 = (ProgressBar) findViewById(R.id.pbProducao8);
        pbProducao9 = (ProgressBar) findViewById(R.id.pbProducao9);
        pbProducao10 = (ProgressBar) findViewById(R.id.pbProducao10);

        txtData1 = (TextView) findViewById(R.id.txtData1);
        txtData2 = (TextView) findViewById(R.id.txtData2);
        txtData3 = (TextView) findViewById(R.id.txtData3);
        txtData4 = (TextView) findViewById(R.id.txtData4);
        txtData5 = (TextView) findViewById(R.id.txtData5);
        txtData6 = (TextView) findViewById(R.id.txtData6);
        txtData7 = (TextView) findViewById(R.id.txtData7);
        txtData8 = (TextView) findViewById(R.id.txtData8);
        txtData9 = (TextView) findViewById(R.id.txtData9);
        txtData10 = (TextView) findViewById(R.id.txtData10);
        txtErro = (TextView) findViewById(R.id.txtErroMedicao);


        producoes = dbListagens.listarProducoes(brinco);

        if(producoes.size()>0) {
            switch (producoes.size()) {
                case 1:
                    txtData1.setText(producoes.get(0).getDataMedicao());
                    pbProducao1.setProgress((int) (producoes.get(0).getProducao() * 100));

                    txtData2.setVisibility(View.INVISIBLE);
                    txtData3.setVisibility(View.INVISIBLE);
                    txtData4.setVisibility(View.INVISIBLE);
                    txtData5.setVisibility(View.INVISIBLE);
                    txtData6.setVisibility(View.INVISIBLE);
                    txtData7.setVisibility(View.INVISIBLE);
                    txtData8.setVisibility(View.INVISIBLE);
                    txtData9.setVisibility(View.INVISIBLE);
                    txtData10.setVisibility(View.INVISIBLE);

                    pbProducao2.setVisibility(View.INVISIBLE);
                    pbProducao3.setVisibility(View.INVISIBLE);
                    pbProducao4.setVisibility(View.INVISIBLE);
                    pbProducao5.setVisibility(View.INVISIBLE);
                    pbProducao6.setVisibility(View.INVISIBLE);
                    pbProducao7.setVisibility(View.INVISIBLE);
                    pbProducao8.setVisibility(View.INVISIBLE);
                    pbProducao9.setVisibility(View.INVISIBLE);
                    pbProducao10.setVisibility(View.INVISIBLE);

                    txtErro.setVisibility(View.GONE);
                    break;

                case 2:
                    txtData1.setText(producoes.get(0).getDataMedicao());
                    pbProducao1.setProgress((int) (producoes.get(0).getProducao() * 100));

                    txtData2.setText(producoes.get(1).getDataMedicao());
                    pbProducao2.setProgress((int) (producoes.get(1).getProducao() * 100));

                    txtData3.setVisibility(View.INVISIBLE);
                    txtData4.setVisibility(View.INVISIBLE);
                    txtData5.setVisibility(View.INVISIBLE);
                    txtData6.setVisibility(View.INVISIBLE);
                    txtData7.setVisibility(View.INVISIBLE);
                    txtData8.setVisibility(View.INVISIBLE);
                    txtData9.setVisibility(View.INVISIBLE);
                    txtData10.setVisibility(View.INVISIBLE);

                    pbProducao3.setVisibility(View.INVISIBLE);
                    pbProducao4.setVisibility(View.INVISIBLE);
                    pbProducao5.setVisibility(View.INVISIBLE);
                    pbProducao6.setVisibility(View.INVISIBLE);
                    pbProducao7.setVisibility(View.INVISIBLE);
                    pbProducao8.setVisibility(View.INVISIBLE);
                    pbProducao9.setVisibility(View.INVISIBLE);
                    pbProducao10.setVisibility(View.INVISIBLE);

                    txtErro.setVisibility(View.GONE);
                    break;

                case 3:
                    txtData1.setText(producoes.get(0).getDataMedicao());
                    pbProducao1.setProgress((int) (producoes.get(0).getProducao() * 100));

                    txtData2.setText(producoes.get(1).getDataMedicao());
                    pbProducao2.setProgress((int) (producoes.get(1).getProducao() * 100));

                    txtData3.setText(producoes.get(2).getDataMedicao());
                    pbProducao3.setProgress((int) (producoes.get(2).getProducao() * 100));

                    txtData4.setVisibility(View.INVISIBLE);
                    txtData5.setVisibility(View.INVISIBLE);
                    txtData6.setVisibility(View.INVISIBLE);
                    txtData7.setVisibility(View.INVISIBLE);
                    txtData8.setVisibility(View.INVISIBLE);
                    txtData9.setVisibility(View.INVISIBLE);
                    txtData10.setVisibility(View.INVISIBLE);

                    pbProducao4.setVisibility(View.INVISIBLE);
                    pbProducao5.setVisibility(View.INVISIBLE);
                    pbProducao6.setVisibility(View.INVISIBLE);
                    pbProducao7.setVisibility(View.INVISIBLE);
                    pbProducao8.setVisibility(View.INVISIBLE);
                    pbProducao9.setVisibility(View.INVISIBLE);
                    pbProducao10.setVisibility(View.INVISIBLE);

                    txtErro.setVisibility(View.GONE);
                    break;

                case 4:
                    txtData1.setText(producoes.get(0).getDataMedicao());
                    pbProducao1.setProgress((int) (producoes.get(0).getProducao() * 100));

                    txtData2.setText(producoes.get(1).getDataMedicao());
                    pbProducao2.setProgress((int) (producoes.get(1).getProducao() * 100));

                    txtData3.setText(producoes.get(2).getDataMedicao());
                    pbProducao3.setProgress((int) (producoes.get(2).getProducao() * 100));

                    txtData4.setText(producoes.get(3).getDataMedicao());
                    pbProducao4.setProgress((int) (producoes.get(3).getProducao() * 100));

                    txtData5.setVisibility(View.INVISIBLE);
                    txtData6.setVisibility(View.INVISIBLE);
                    txtData7.setVisibility(View.INVISIBLE);
                    txtData8.setVisibility(View.INVISIBLE);
                    txtData9.setVisibility(View.INVISIBLE);
                    txtData10.setVisibility(View.INVISIBLE);

                    pbProducao5.setVisibility(View.INVISIBLE);
                    pbProducao6.setVisibility(View.INVISIBLE);
                    pbProducao7.setVisibility(View.INVISIBLE);
                    pbProducao8.setVisibility(View.INVISIBLE);
                    pbProducao9.setVisibility(View.INVISIBLE);
                    pbProducao10.setVisibility(View.INVISIBLE);

                    txtErro.setVisibility(View.GONE);
                    break;

                case 5:
                    txtData1.setText(producoes.get(0).getDataMedicao());
                    pbProducao1.setProgress((int) (producoes.get(0).getProducao() * 100));

                    txtData2.setText(producoes.get(1).getDataMedicao());
                    pbProducao2.setProgress((int) (producoes.get(1).getProducao() * 100));

                    txtData3.setText(producoes.get(2).getDataMedicao());
                    pbProducao3.setProgress((int) (producoes.get(2).getProducao() * 100));

                    txtData4.setText(producoes.get(3).getDataMedicao());
                    pbProducao4.setProgress((int) (producoes.get(3).getProducao() * 100));

                    txtData5.setText(producoes.get(4).getDataMedicao());
                    pbProducao5.setProgress((int) (producoes.get(4).getProducao() * 100));

                    txtData6.setVisibility(View.INVISIBLE);
                    txtData7.setVisibility(View.INVISIBLE);
                    txtData8.setVisibility(View.INVISIBLE);
                    txtData9.setVisibility(View.INVISIBLE);
                    txtData10.setVisibility(View.INVISIBLE);

                    pbProducao6.setVisibility(View.INVISIBLE);
                    pbProducao7.setVisibility(View.INVISIBLE);
                    pbProducao8.setVisibility(View.INVISIBLE);
                    pbProducao9.setVisibility(View.INVISIBLE);
                    pbProducao10.setVisibility(View.INVISIBLE);

                    txtErro.setVisibility(View.GONE);
                    break;

                case 6:
                    txtData1.setText(producoes.get(0).getDataMedicao());
                    pbProducao1.setProgress((int) (producoes.get(0).getProducao() * 100));

                    txtData2.setText(producoes.get(1).getDataMedicao());
                    pbProducao2.setProgress((int) (producoes.get(1).getProducao() * 100));

                    txtData3.setText(producoes.get(2).getDataMedicao());
                    pbProducao3.setProgress((int) (producoes.get(2).getProducao() * 100));

                    txtData4.setText(producoes.get(3).getDataMedicao());
                    pbProducao4.setProgress((int) (producoes.get(3).getProducao() * 100));

                    txtData5.setText(producoes.get(4).getDataMedicao());
                    pbProducao5.setProgress((int) (producoes.get(4).getProducao() * 100));

                    txtData6.setText(producoes.get(5).getDataMedicao());
                    pbProducao6.setProgress((int) (producoes.get(5).getProducao() * 100));

                    txtData7.setVisibility(View.INVISIBLE);
                    txtData8.setVisibility(View.INVISIBLE);
                    txtData9.setVisibility(View.INVISIBLE);
                    txtData10.setVisibility(View.INVISIBLE);

                    pbProducao7.setVisibility(View.INVISIBLE);
                    pbProducao8.setVisibility(View.INVISIBLE);
                    pbProducao9.setVisibility(View.INVISIBLE);
                    pbProducao10.setVisibility(View.INVISIBLE);

                    txtErro.setVisibility(View.GONE);
                    break;

                case 7:
                    txtData1.setText(producoes.get(0).getDataMedicao());
                    pbProducao1.setProgress((int) (producoes.get(0).getProducao() * 100));

                    txtData2.setText(producoes.get(1).getDataMedicao());
                    pbProducao2.setProgress((int) (producoes.get(1).getProducao() * 100));

                    txtData3.setText(producoes.get(2).getDataMedicao());
                    pbProducao3.setProgress((int) (producoes.get(2).getProducao() * 100));

                    txtData4.setText(producoes.get(3).getDataMedicao());
                    pbProducao4.setProgress((int) (producoes.get(3).getProducao() * 100));

                    txtData5.setText(producoes.get(4).getDataMedicao());
                    pbProducao5.setProgress((int) (producoes.get(4).getProducao() * 100));

                    txtData6.setText(producoes.get(5).getDataMedicao());
                    pbProducao6.setProgress((int) (producoes.get(5).getProducao() * 100));

                    txtData7.setText(producoes.get(6).getDataMedicao());
                    pbProducao7.setProgress((int) (producoes.get(6).getProducao() * 100));

                    txtData8.setVisibility(View.INVISIBLE);
                    txtData9.setVisibility(View.INVISIBLE);
                    txtData10.setVisibility(View.INVISIBLE);

                    pbProducao8.setVisibility(View.INVISIBLE);
                    pbProducao9.setVisibility(View.INVISIBLE);
                    pbProducao10.setVisibility(View.INVISIBLE);

                    txtErro.setVisibility(View.GONE);
                    break;

                case 8:
                    txtData1.setText(producoes.get(0).getDataMedicao());
                    pbProducao1.setProgress((int) (producoes.get(0).getProducao() * 100));

                    txtData2.setText(producoes.get(1).getDataMedicao());
                    pbProducao2.setProgress((int) (producoes.get(1).getProducao() * 100));

                    txtData3.setText(producoes.get(2).getDataMedicao());
                    pbProducao3.setProgress((int) (producoes.get(2).getProducao() * 100));

                    txtData4.setText(producoes.get(3).getDataMedicao());
                    pbProducao4.setProgress((int) (producoes.get(3).getProducao() * 100));

                    txtData5.setText(producoes.get(4).getDataMedicao());
                    pbProducao5.setProgress((int) (producoes.get(4).getProducao() * 100));

                    txtData6.setText(producoes.get(5).getDataMedicao());
                    pbProducao6.setProgress((int) (producoes.get(5).getProducao() * 100));

                    txtData7.setText(producoes.get(6).getDataMedicao());
                    pbProducao7.setProgress((int) (producoes.get(6).getProducao() * 100));

                    txtData8.setText(producoes.get(7).getDataMedicao());
                    pbProducao8.setProgress((int) (producoes.get(7).getProducao() * 100));

                    txtData9.setVisibility(View.INVISIBLE);
                    txtData10.setVisibility(View.INVISIBLE);

                    pbProducao9.setVisibility(View.INVISIBLE);
                    pbProducao10.setVisibility(View.INVISIBLE);

                    txtErro.setVisibility(View.GONE);
                    break;

                case 9:
                    txtData1.setText(producoes.get(0).getDataMedicao());
                    pbProducao1.setProgress((int) (producoes.get(0).getProducao() * 100));

                    txtData2.setText(producoes.get(1).getDataMedicao());
                    pbProducao2.setProgress((int) (producoes.get(1).getProducao() * 100));

                    txtData3.setText(producoes.get(2).getDataMedicao());
                    pbProducao3.setProgress((int) (producoes.get(2).getProducao() * 100));

                    txtData4.setText(producoes.get(3).getDataMedicao());
                    pbProducao4.setProgress((int) (producoes.get(3).getProducao() * 100));

                    txtData5.setText(producoes.get(4).getDataMedicao());
                    pbProducao5.setProgress((int) (producoes.get(4).getProducao() * 100));

                    txtData6.setText(producoes.get(5).getDataMedicao());
                    pbProducao6.setProgress((int) (producoes.get(5).getProducao() * 100));

                    txtData7.setText(producoes.get(6).getDataMedicao());
                    pbProducao7.setProgress((int) (producoes.get(6).getProducao() * 100));

                    txtData8.setText(producoes.get(7).getDataMedicao());
                    pbProducao8.setProgress((int) (producoes.get(7).getProducao() * 100));

                    txtData9.setText(producoes.get(8).getDataMedicao());
                    pbProducao9.setProgress((int) (producoes.get(8).getProducao() * 100));

                    txtData10.setVisibility(View.INVISIBLE);

                    pbProducao10.setVisibility(View.INVISIBLE);

                    txtErro.setVisibility(View.GONE);
                    break;

                default:
                    txtData1.setText(producoes.get(0).getDataMedicao());
                    pbProducao1.setProgress((int) (producoes.get(0).getProducao() * 100));

                    txtData2.setText(producoes.get(1).getDataMedicao());
                    pbProducao2.setProgress((int) (producoes.get(1).getProducao() * 100));

                    txtData3.setText(producoes.get(2).getDataMedicao());
                    pbProducao3.setProgress((int) (producoes.get(2).getProducao() * 100));

                    txtData4.setText(producoes.get(3).getDataMedicao());
                    pbProducao4.setProgress((int) (producoes.get(3).getProducao() * 100));

                    txtData5.setText(producoes.get(4).getDataMedicao());
                    pbProducao5.setProgress((int) (producoes.get(4).getProducao() * 100));

                    txtData6.setText(producoes.get(5).getDataMedicao());
                    pbProducao6.setProgress((int) (producoes.get(5).getProducao() * 100));

                    txtData7.setText(producoes.get(6).getDataMedicao());
                    pbProducao7.setProgress((int) (producoes.get(6).getProducao() * 100));

                    txtData8.setText(producoes.get(7).getDataMedicao());
                    pbProducao8.setProgress((int) (producoes.get(7).getProducao() * 100));

                    txtData9.setText(producoes.get(8).getDataMedicao());
                    pbProducao9.setProgress((int) (producoes.get(8).getProducao() * 100));


                    txtData10.setText(producoes.get(9).getDataMedicao());
                    pbProducao10.setProgress((int) (producoes.get(9).getProducao() * 100));

                    txtErro.setVisibility(View.GONE);
                    break;
            }
        }else{
            txtData1.setVisibility(View.INVISIBLE);
            txtData2.setVisibility(View.INVISIBLE);
            txtData3.setVisibility(View.INVISIBLE);
            txtData4.setVisibility(View.INVISIBLE);
            txtData5.setVisibility(View.INVISIBLE);
            txtData6.setVisibility(View.INVISIBLE);
            txtData7.setVisibility(View.INVISIBLE);
            txtData8.setVisibility(View.INVISIBLE);
            txtData9.setVisibility(View.INVISIBLE);
            txtData10.setVisibility(View.INVISIBLE);

            pbProducao1.setVisibility(View.INVISIBLE);
            pbProducao2.setVisibility(View.INVISIBLE);
            pbProducao3.setVisibility(View.INVISIBLE);
            pbProducao4.setVisibility(View.INVISIBLE);
            pbProducao5.setVisibility(View.INVISIBLE);
            pbProducao6.setVisibility(View.INVISIBLE);
            pbProducao7.setVisibility(View.INVISIBLE);
            pbProducao8.setVisibility(View.INVISIBLE);
            pbProducao9.setVisibility(View.INVISIBLE);
            pbProducao10.setVisibility(View.INVISIBLE);
        }

    }
}
