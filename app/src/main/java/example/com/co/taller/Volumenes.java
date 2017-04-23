package example.com.co.taller;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import example.com.co.taller.AreasP.Circulo;
import example.com.co.taller.AreasP.Cuadrado;
import example.com.co.taller.AreasP.Rectangulo;
import example.com.co.taller.AreasP.Triangulo;
import example.com.co.taller.VolumenesP.Cilindro;
import example.com.co.taller.VolumenesP.Cono;
import example.com.co.taller.VolumenesP.Cubo;
import example.com.co.taller.VolumenesP.Esfera;

public class Volumenes extends AppCompatActivity {
    ListView volumenes;
    ArrayAdapter<String> adapter;
    Resources res;
    String[] listaVolu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumenes);
        res = getResources();

        volumenes = (ListView) findViewById(R.id.listVolu);
        listaVolu = res.getStringArray(R.array.opcVolu);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaVolu);
        volumenes.setAdapter(adapter);
        volumenes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent cuadrado = new Intent(Volumenes.this, Esfera.class);
                        startActivity(cuadrado);
                        break;
                    case 1:
                        Intent triangulo = new Intent(Volumenes.this, Cilindro.class);
                        startActivity(triangulo);
                        break;
                    case 2:
                        Intent rectangulo = new Intent(Volumenes.this, Cono.class);
                        startActivity(rectangulo);
                        break;
                    case 3:
                        Intent circulo = new Intent(Volumenes.this, Cubo.class);
                        startActivity(circulo);
                        break;
                }
            }
        });
    }
}
