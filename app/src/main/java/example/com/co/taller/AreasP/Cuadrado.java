package example.com.co.taller.AreasP;

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

public class Cuadrado extends AppCompatActivity {

    TextView lado;
    Button calcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);
        lado = (TextView)findViewById(R.id.txtLado);
        calcular = (Button) findViewById(R.id.btnCalcular);
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
        double resultado = vLado * vLado;
        String descripcion = "Area del Cuadrado";
        Operacion operacion = new Operacion();
        operacion.setDescripcion(descripcion);
        operacion.setDatos("Lado: " + vLado);
        operacion.setResultado(resultado);
        Datos.guardar(operacion);
        Intent i = new Intent(this, Mostrar.class);
        i.putExtra("tittle",getResources().getString(R.string.Cuadrado));
        i.putExtra("resultado",descripcion + " " + resultado );
        startActivity(i);
    }
}
