package com.example.calculoimc;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        Float imc = peso_valor/altura_valor;
        String tabela;
        if (imc < 17){
            tabela = "Muito abaixo do peso";
        }else if (imc >= 17 && imc <= 18.49){
            tabela = "Abaixo do peso";
        }else if (imc >= 18.5  && imc <= 24.99){
            tabela = "Peso normal";
        }else if (imc >= 25 && imc <= 29.99){
            tabela = "Acima do peso";
        }else if (imc >= 30 && imc <= 34.99){
            tabela = "Obesidade I";
        }else if (imc >= 35  && imc <= 39.99){
            tabela = "Obesidade II (severa)";
        }else{
            tabela = "Obesidade III (mórbida)";
        }

        String Msg = getResources().getString(R.string.value) + ": " + imc + " " + tabela;

        txt.setContentDescription(Msg);

        txt.setText(Msg);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =item.getItemId();

        if (id==android.R.id.home) {
            finish();
        }
        return true;
    }
}
