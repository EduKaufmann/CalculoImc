package com.example.calculoimc;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class CalculateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        TextView txt= findViewById(R.id.mostra);

        Intent it= getIntent();
        String peso = it.getStringExtra("Peso");
        String altura = it.getStringExtra("Altura");
        Float altura_valor = Float.valueOf(altura);
        altura_valor *= altura_valor;
        Float peso_valor = Float.valueOf(peso);

        String Msg = "O valor do seu IMC é: " + peso_valor/altura_valor;

        txt.setContentDescription(Msg);

        txt.setText(Msg);
    }

}
