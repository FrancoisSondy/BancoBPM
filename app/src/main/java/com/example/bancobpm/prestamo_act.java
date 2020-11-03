package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class prestamo_act extends AppCompatActivity {
    private Spinner spin1, spin2;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamo_act);

        spin1 =(Spinner)findViewById(R.id.sp1);
        spin2 =(Spinner)findViewById(R.id.sp2);
        text =(TextView)findViewById(R.id.tv1);

        ArrayList<String> listaclientes = (ArrayList<String>)getIntent().getSerializableExtra("listaclientes");
        ArrayList<String> listaCredito = (ArrayList<String>)getIntent().getSerializableExtra("listaCredito");

        ArrayAdapter<String> adap = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaclientes);
        ArrayAdapter<String> adap1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaCredito);

        spin1.setAdapter(adap);
        spin2.setAdapter(adap1);
    }

    public void CalcularPrestamo(View v) {

        String cliente = spin1.getSelectedItem().toString();
        String credito = spin2.getSelectedItem().toString();


        ClienteSaldo  saldo = new ClienteSaldo();
        if (cliente.equals("AXEL") && credito.equals("CREDITO HPOTECARIO"))
        {
           int total = saldo.getAxel() + 1000000;
            text.setText("El Monto es:"
                    + total);
        }

        if (cliente.equals("AXEL") && credito.equals("CREDITO AUTOMOTRIZ"))
        {
            int total = saldo.getAxel() + 500000;
            text.setText("El Monto es :"
                    +total);

        }
        if (cliente.equals("ROXANA") && credito.equals("CREDITO HPOTECARIO"))
        {
            int total = saldo.getRoxana() + 1000000;
            text.setText("El Monto  es:"
                    +total);
        }

        if (cliente.equals("ROXANA") && credito.equals("CREDITO AUTOMOTRIZ"))
        {
            int total = saldo.getRoxana() + 500000;
            text.setText("El Monto es :"
                    +total);
        }
    }

    public void CalcularDeuda(View v) {

        String cliente = spin1.getSelectedItem().toString();
        String credito = spin2.getSelectedItem().toString();


        ClienteSaldo  saldo = new ClienteSaldo();
        if (cliente.equals("AXEL") && credito.equals("CREDITO HPOTECARIO"))
        {
            int total = (saldo.getAxel() + 1000000) /12;
            text.setText("La Deuda Es De:"
                    + total);
        }

        if (cliente.equals("AXEL") && credito.equals("CREDITO AUTOMOTRIZ"))
        {
            int total = (saldo.getAxel() + 500000)/8;
            text.setText("La Deuda Es De :"
                    +total);

        }
        if (cliente.equals("ROXANA") && credito.equals("CREDITO HPOTECARIO"))
        {
            int total = (saldo.getRoxana() + 1000000)/12;
            text.setText("La Deuda Es De :"
                    +total);
        }

        if (cliente.equals("ROXANA") && credito.equals("CREDITO AUTOMOTRIZ"))
        {
            int total = (saldo.getRoxana() + 500000)/8;
            text.setText("La Deuda Es De :"
                    +total);

        }
    }

}