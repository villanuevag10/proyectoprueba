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

public class Areas extends AppCompatActivity {

    ListView areas;
    ArrayAdapter<String> adapter;
    Resources res;
    String[] listaArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);
        res = getResources();

        areas = (ListView) findViewById(R.id.listArea);
        listaArea = res.getStringArray(R.array.opcAreas);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaArea);
        areas.setAdapter(adapter);

        areas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent cuadrado = new Intent(Areas.this, Cuadrado.class);
                        startActivity(cuadrado);
                        break;
                    case 1:
                        Intent triangulo = new Intent(Areas.this, Triangulo.class);
                        startActivity(triangulo);
                        break;
                    case 2:
                        Intent rectangulo = new Intent(Areas.this, Rectangulo.class);
                        startActivity(rectangulo);
                        break;
                    case 3:
                        Intent circulo = new Intent(Areas.this, Circulo.class);
                        startActivity(circulo);
                        break;
                }
            }
        });

    }
}
