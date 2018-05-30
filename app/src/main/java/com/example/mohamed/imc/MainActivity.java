package com.example.mohamed.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        Intent intent = new Intent(MainActivity.this,Resultat.class);
        intent.putExtra(a,taille.getText().toString());
        intent.putExtra(b,poids.getText().toString());
        startActivity(intent);
    }
}
