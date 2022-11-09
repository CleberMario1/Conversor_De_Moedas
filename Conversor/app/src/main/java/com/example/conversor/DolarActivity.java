package com.example.conversor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class DolarActivity extends AppCompatActivity {

    private Button bvoltar, converter;
    private EditText cotacao, valorreal;
    DecimalFormat df = new java.text.DecimalFormat("##.##");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dolar);
        Button voltar = findViewById(R.id.bvoltar);
        Button converter = findViewById(R.id.converter);
        EditText cotacao = findViewById(R.id.cotacao);
        EditText valorreal = findViewById(R.id.valorreal);

        converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog alert = new AlertDialog.Builder(DolarActivity.this).create();
                Double c = Double.parseDouble(cotacao.getText().toString());
                Double r = Double.parseDouble(valorreal.getText().toString());
                Double resultado = r / c;
                String dec = df.format(resultado);

                        alert.setTitle("Resultado");
                alert.setMessage("O valor do Dolar é: " + dec);
                alert.setButton(Dialog.BUTTON_NEGATIVE,"Fechar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alert.show();
            }
        });


        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}