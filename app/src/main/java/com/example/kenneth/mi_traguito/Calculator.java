package com.example.kenneth.mi_traguito;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    public void eventoCalcular(View v){
        double r =0.73;//Constante de Genero
        EditText onzas_ingresadas = (EditText)findViewById(R.id.editText);
        EditText peso_ingresado = (EditText)findViewById(R.id.editText2);
        EditText horas_transcurridas = (EditText)findViewById(R.id.editText3);
        EditText cantidad_ingresada = (EditText)findViewById(R.id.editText4);
        EditText porciento_ingresado = (EditText)findViewById(R.id.editText5);
        TextView t1 = (TextView)findViewById(R.id.textView);

        double P = Double.parseDouble(porciento_ingresado.getText().toString());//Porciento de alcohol en la bebida
        double onzas = Double.parseDouble(onzas_ingresadas.getText().toString());//onzas de la bebida
        double W = Double.parseDouble(peso_ingresado.getText().toString());//Peso
        double H = Double.parseDouble(horas_transcurridas.getText().toString());//Tiempo
        double cantidad = Double.parseDouble(cantidad_ingresada.getText().toString());//cantidad tomada

        P=P/100;//Se convierte el prociento ingresado a decimal
        double  A = cantidad*onzas*P;//Onzas liquidas de alcohol
        double total = ((A*5.14)/(W*r))-(0.015*H);//Formula para el Blood Alcohol Content
        total = Math.floor(total*1000)/1000;//Se convierte el total a 4 numeros despues del punto
        t1.setText(Double.toString(total)+"%");
    }
}
