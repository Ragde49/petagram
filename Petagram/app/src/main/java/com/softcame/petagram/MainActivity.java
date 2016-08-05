package com.softcame.petagram;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView ListaAnimales;
    ArrayList<Animales> animales;
    FloatingActionButton fabCamara;
    ImageButton imbFav;
    Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaAnimales = (RecyclerView) findViewById(R.id.rvAnimales);
        fabCamara = (FloatingActionButton) findViewById(R.id.fabCamara);
        imbFav = (ImageButton) findViewById(R.id.ibtFavs);

        imbFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ascotas_favoritas.class);
                startActivity(intent);


            }
        });


        fabCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Sonrie....Click",Snackbar.LENGTH_SHORT).show();
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        ListaAnimales.setLayoutManager(llm);
        inicializaListaAnimales();
        inicializaAdaptador();

    }

    public AnimalesAdaptador adaptador;
    public void inicializaAdaptador(){
        adaptador = new AnimalesAdaptador(animales);
        ListaAnimales.setAdapter(adaptador);
    }

    public void inicializaListaAnimales(){
        animales = new ArrayList<Animales>();

        animales.add(new Animales(R.drawable.conejo,"Conejo","3"));
        animales.add(new Animales(R.drawable.perro2,"Perro 1","4"));
        animales.add(new Animales(R.drawable.perro,"Perro 2","5"));
        animales.add(new Animales(R.drawable.ferret,"Ferret","6"));
        animales.add(new Animales(R.drawable.ferrets,"Ferrets","7"));
        animales.add(new Animales(R.drawable.gato,"Gato","8"));
        animales.add(new Animales(R.drawable.india,"India","3"));
    }
}
