package com.example.conversor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class RealActivity extends AppCompatActivity {
    private Button bvoltar, converter;
    private EditText cotacaodolar, valordolar;
    DecimalFormat df = new java.text.DecimalFormat("##.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real);
        bvoltar = findViewById(R.id.bvoltar2);
        converter = findViewById(R.id.converter2);
        cotacaodolar = findViewById(R.id.cotacaodolar);
        valordolar = findViewById(R.id.valordolar);

        converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog alert = new AlertDialog.Builder(RealActivity.this).create();
                Double c = Double.parseDouble(cotacaodolar.getText().toString());
                Double r = Double.parseDouble(valordolar.getText().toString());
                Double resultado = r * c;
                String dec = df.format(resultado);

                alert.setTitle("Resultado");
                alert.setMessage("O valor do Real é: " + dec);
                alert.setButton(Dialog.BUTTON_NEGATIVE,"Fechar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                alert.show();
            }
        });










        bvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}