package com.example.mohamed.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        final String a = "a";
        final String b = "b";
        EditText taille;
        EditText poids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        taille = (EditText)findViewById(R.id.taille);
        poids = (EditText)findViewById(R.id.poids);
        super.onKeyDown(keyCode, event);
        if (taille.getText().toString().equalsIgnoreCase("")){

            return false;
        }
        else {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN){
            taille.setText( String.valueOf(Integer.parseInt(taille.getText().toString())-1));
            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP){
            taille.setText( String.valueOf(Integer.parseInt(taille.getText().toString())+1));
            return true;
        }}
        return false;
    }

    public void calculer(View view){
        taille = (EditText)findViewById(R.id.taille);
        poids = (EditText)findViewById(R.id.poids);
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
