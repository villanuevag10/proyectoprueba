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

public class Esfera extends AppCompatActivity {
    TextView radio;
    Button calcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esfera);
        radio = (TextView)findViewById(R.id.txtRadioE);
        calcular = (Button) findViewById(R.id.btnCalcularE);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!radio.getText().toString().isEmpty()) {
                    calcularV();
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
        radio.setText("");
    }

    public void calcularV(){
        double vRadio = Float.valueOf(radio.getText().toString());

        double resultado = (4/3) *3.1416 * (vRadio * vRadio * vRadio);
        String descripcion = "Volumen de la Esfera";
        Operacion operacion = new Operacion();
        operacion.setDescripcion(descripcion);
        operacion.setDatos("Radio: " + vRadio);
        operacion.setResultado(resultado);
        Datos.guardar(operacion);
        Intent i = new Intent(this, Mostrar.class);
        i.putExtra("tittle",getResources().getString(R.string.esfera));
        i.putExtra("resultado",descripcion + " " + resultado );
        startActivity(i);
    }
}
