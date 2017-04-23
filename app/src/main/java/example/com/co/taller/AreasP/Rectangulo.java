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

public class Rectangulo extends AppCompatActivity {
    TextView base;
    TextView altura;
    Button calcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);
        base = (TextView)findViewById(R.id.txtBaseR);
        altura = (TextView)findViewById(R.id.txtAlturaR);
        calcular = (Button) findViewById(R.id.btnCalcularR);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!base.getText().toString().isEmpty()) {
                    if(!altura.getText().toString().isEmpty()) {
                        calcularV();
                    }else{
                        altura.setError(getResources().getString(R.string.error));
                    }
                }else{
                    base.setError(getResources().getString(R.string.error));
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
        base.setText("");
    }
    public void calcularV(){
        double b = Float.valueOf(base.getText().toString());
        double a = Float.valueOf(altura.getText().toString());
        double resultado = (a * b);
        String descripcion = "Area del Rectangulo";
        Operacion operacion = new Operacion();
        operacion.setDescripcion(descripcion);
        operacion.setDatos("Base: " + b + " Altura:" + a);
        operacion.setResultado(resultado);
        Datos.guardar(operacion);
        Intent i = new Intent(this, Mostrar.class);
        i.putExtra("tittle",getResources().getString(R.string.rectangulo));
        i.putExtra("resultado",descripcion + " " + resultado );
        startActivity(i);
    }
}
