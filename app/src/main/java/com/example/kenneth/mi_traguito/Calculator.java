package com.example.kenneth.mi_traguito;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.AbstractList;

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

        double P = Double.parseDouble(porciento_ingresado.getText().toString());//Porciento de alcohol en la bebida
        double onzas = Double.parseDouble(onzas_ingresadas.getText().toString());//onzas de la bebida
        double W = Double.parseDouble(peso_ingresado.getText().toString());//Peso
        double H = Double.parseDouble(horas_transcurridas.getText().toString());//Tiempo
        double cantidad = Double.parseDouble(cantidad_ingresada.getText().toString());//cantidad tomada

        P=P/100;//Se convierte el prociento ingresado a decimal
        double  A = cantidad*onzas*P;//Onzas liquidas de alcohol
        double total = ((A*5.14)/(W*r))-(0.015*H);//Formula para el Blood Alcohol Content
        total = Math.floor(total*1000)/1000;//Se convierte el total a 4 numeros despues del punto
        myAlert(total);
    }

    public void myAlert(double A){
        AlertDialog.Builder myAlert = new AlertDialog.Builder  (this);
        String mensaje = null;

        if(A <= 0.03)
        mensaje = "Ligera euforia y pérdida de timidez. ";

        else if (A > 0.03 && A <= 0.06)
            mensaje = "Sensación de bienestar, relajación, inhibiciones\n" +
                    "inferiores, sensación de calor.";

        else if (A > 0.06 && A <= 0.08)
            mensaje = "Disminución leve del equilibrio, el habla, la visión,el tiempo de reacción \n" +
                    "y la audición.";

        else if (A > 0.081 && A <= 0.125)
            mensaje = "Deteriorio significativo de la coordinacion motora\n"+
                    "y perdida del buen juicio. En este porciento o mas es ilegal";

        else if (A > 0.125 && A <= 0.15)
            mensaje = "Insuficiencia motora y falta de control físico. Visión borrosa y\n"+
                    " pérdida importante de equilibrio.";

        else if (A > 0.15 && A <= 0.19)
            mensaje = "Predomina la disforia, pueden aparecer náuseas.";

        else if (A > 0.19 && A <= 0.24)
            mensaje = "Abatido, aturdido, confundido o de otra manera\n" +
                    "desorientado.";

        else if (A > 0.24 && A <= 0.29)
            mensaje = " Todas las funciones mentales, físicas y sensoriales están\n" +
                    "gravemente afectadas.";

        else if (A > 0.29 && A <= 0.34)
            mensaje = "Tienes poca comprensión de dónde estás. Usted puede\n" +
                    "desmayarse repentinamente y ser difícil de despertar.";

        else if (A > 0.34 && A <= 0.40)
            mensaje = "Coma es posible.";

        else if (A > 0.40 )
            mensaje = "VISTE A DIOS, Comienzo del coma y posible muerte por\n" +
                    "paro respiratorio.";


        myAlert.setMessage("Usted tiene: "+A+"%\n"+mensaje).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Calculator.this, NavDrawMainActivity.class);
                        Calculator.this.startActivity(intent);
                        finish();
                    }
                })
                .setTitle("B.A.C. Levels");
        myAlert.show();

    }
}
