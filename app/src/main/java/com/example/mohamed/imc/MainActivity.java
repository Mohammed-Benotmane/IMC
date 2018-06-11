package com.example.mohamed.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        final String a = "a";
        final String b = "b";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void calculer(View view){
        EditText taille = (EditText)findViewById(R.id.taille);
        EditText poids = (EditText)findViewById(R.id.poids);
        if (taille.getText().toString().equals("")){
            Toast.makeText(MainActivity.this,"Veuillez introduire votre taille",Toast.LENGTH_SHORT).show();
            return;
        }
        if (poids.getText().toString().equals("")){
            Toast.makeText(MainActivity.this,"Veuillez introduire votre poids",Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(MainActivity.this,Resultat.class);
        intent.putExtra(a,taille.getText().toString());
        intent.putExtra(b,poids.getText().toString());
        startActivity(intent);
    }
}
