package example.com.co.taller;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    ListView opciones;
    ArrayAdapter<String> adapter;
    Resources res;
    String[] listaOpc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        res = getResources();

        opciones = (ListView) findViewById(R.id.listOpc);
        listaOpc = res.getStringArray(R.array.opcArray);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaOpc);
        opciones.setAdapter(adapter);

        opciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent ia = new Intent(Principal.this,Areas.class);
                        startActivity(ia);
                        break;
                    case 1:
                        Intent ib = new Intent(Principal.this,Volumenes.class);
                        startActivity(ib);
                        break;
                    case 2:
                        Intent ic = new Intent(Principal.this,Reporte.class);
                        startActivity(ic);
                        break;

                }
            }
        });
    }



}
