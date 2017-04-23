package example.com.co.taller.VolumenesP;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import example.com.co.taller.Datos;
import example.com.co.taller.Mostrar;
import example.com.co.taller.Operacion;
import example.com.co.taller.R;

public class Cubo extends AppCompatActivity {

    TextView lado;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);
        lado = (TextView)findViewById(R.id.txtLadoCu);
        calcular = (Button) findViewById(R.id.btnCalcularCu);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!lado.getText().toString().isEmpty()) {
                    calcularV();
                }else{
                    lado.setError(getResources().getString(R.string.error));
                }
            }
        });
        Button ok = (Button) findViewById(R.id.btnBorrar);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                borrar();

            }
        });
    }

    public void borrar(){
        lado.setText("");
    }

    public void calcularV(){
        double vLado = Float.valueOf(lado.getText().toString());
        double resultado = vLado * vLado * vLado;
        String descripcion = "Volumen del Cubo";
        Operacion operacion = new Operacion();
        operacion.setDescripcion(descripcion);
        operacion.setDatos("Lado: " + vLado);
        operacion.setResultado(resultado);
        Datos.guardar(operacion);
        Intent i = new Intent(this, Mostrar.class);
        i.putExtra("tittle",getResources().getString(R.string.cubo));
        i.putExtra("resultado",descripcion + " " + resultado );
        startActivity(i);
    }
}
