package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class home_act extends AppCompatActivity {

    private ViewFlipper fliper;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);
        fliper = (ViewFlipper)findViewById(R.id.slider);

        for(int i = 0; i < images.length; i++)
        {
            flip_image(images[i]);
        }
    }


    // función que me permitirá configurar el slider
    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        fliper.addView(view);           // añadimos al viewflipper el contenido del slider
        fliper.setFlipInterval(2800);   // duración intervalo de imagenes
        fliper.setAutoStart(true);     // inicia de forma automatica.

        // Sentido al slider
        fliper.setInAnimation(this, android.R.anim.slide_in_left);
        fliper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
    public void GestionarCliente (View v)
    {
        Intent i = new Intent(this, clientes.class);
        startActivity(i);
    }
    public void Informacion (View v)
    {
        Intent i = new Intent(this,info_act.class);
    startActivity(i);
    }

    public void Prestamos (View v)
    {
        ArrayList<String> listaclientes = new ArrayList<String>();
        listaclientes.add("BETZABE");
        listaclientes.add("MATIAS");

        ArrayList<String> listaCredito = new ArrayList<String>();
        listaCredito.add("CREDITO HPOTECARIO");
        listaCredito.add("CREDITO AUTOMOTRIZ");

        Intent i = new Intent(this, prestamo_act.class);
        i.putExtra("listaclientes",listaclientes);
        i.putExtra("listaCredito",listaCredito);
        startActivity(i);
    }
    public void Seguridad (View v)
    {
        Intent i = new Intent(this,seguridad_act.class);
        startActivity(i);
    }

}