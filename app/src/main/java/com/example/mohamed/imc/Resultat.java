package com.example.mohamed.imc;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mohamed on 30/03/18.
 */

public class Resultat extends AppCompatActivity {
    final String a = "a";
    final String b = "b";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultat);
        Intent moha = getIntent();
        TextView imc = (TextView)findViewById(R.id.imc);
        TextView kilo = (TextView)findViewById(R.id.kilo);
        TextView regime = (TextView)findViewById(R.id.regime);
        TextView textView = (TextView)findViewById(R.id.textView5);
        double taille = Double.parseDouble(moha.getStringExtra(a))/100;
        double poids = Double.parseDouble(moha.getStringExtra(b));
        double res = (int)((poids / (taille * taille))*100);
        res = res/100;
        imc.setText(Double.toString(res));
        if(res<18.5){
            kilo.setText("Poids Insuffisant");
        }
        else{
            if(res<25){
                kilo.setText("Poids Normal");
            }
            else{
                if (res<30){
                    kilo.setText("Surpoids");
                }
                else{
                    if (res<35){
                        kilo.setText("Obesité Classe 1");
                    }
                    else{
                        if (res<40){
                            kilo.setText("obesité Classe 2");
                        }
                        else{
                            kilo.setText("Obesité Classe 3");
                        }
                    }
                }
            }
        }
        int p;
        boolean var=false;
        if (res<18.5){
            var = true;
            p= (int)((18.5 * taille * taille)-poids)+1;
            regime.setText("Vous devez prendre au minimum");
            textView.setText(String.valueOf(p));
        }
        else{
            if (res>24.9){
                var = true;
            p = (int)(poids -(24.9 * taille * taille));
            regime.setText("Vous devez perdre au minimum");
            textView.setText(String.valueOf(p));
        }}
        Button conseille = (Button)findViewById(R.id.button);

        if (res<18.5){
            conseille.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Intent intent = new Intent(Resultat.this,Maigre.class);
                    startActivity(intent);
                }
            });
        }
    }
}
