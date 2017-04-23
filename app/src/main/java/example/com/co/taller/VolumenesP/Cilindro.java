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

public class Cilindro extends AppCompatActivity {
    TextView radio;
    TextView altura;
    Button calcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilindro);
        radio = (TextView)findViewById(R.id.txtRadioCi);
        altura = (TextView)findViewById(R.id.txtAlturaCi);
        calcular = (Button) findViewById(R.id.btnCalcularR);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!radio.getText().toString().isEmpty()) {
                    if(!altura.getText().toString().isEmpty()) {
                        calcularV();
                    }else{
                        altura.setError(getResources().getString(R.string.error));
                    }
                }else{
                    radio.setError(getResources().getString(R.string.error));
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
        altura.setText("");
        radio.setText("");
    }

    public void calcularV(){
        double b = Float.valueOf(radio.getText().toString());
        double a = Float.valueOf(altura.getText().toString());
        double resultado = 3.14116 * (b*b) * a;
        String descripcion = "Volumen del Cilindro";
        Operacion operacion = new Operacion();
        operacion.setDescripcion(descripcion);
        operacion.setDatos("Radio: " + b + " Altura:" + a);
        operacion.setResultado(resultado);
        Datos.guardar(operacion);
        Intent i = new Intent(this, Mostrar.class);
        i.putExtra("tittle",getResources().getString(R.string.cilindro));
        i.putExtra("resultado",descripcion + " " + resultado );
        startActivity(i);
    }
}
