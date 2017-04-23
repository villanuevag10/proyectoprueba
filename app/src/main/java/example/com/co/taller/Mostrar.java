package example.com.co.taller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Mostrar extends AppCompatActivity {
    TextView tittle;
    TextView resultado;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        tittle = (TextView)findViewById(R.id.tittle);
        resultado = (TextView)findViewById(R.id.txtresultado);
        ok = (Button)findViewById(R.id.btnok);
        String tittleText = getIntent().getStringExtra("tittle");
        String resultadoText = getIntent().getStringExtra("resultado");
        tittle.setText(tittleText);
        resultado.setText(resultadoText);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mostrar.this, Principal.class);
                startActivity(i);
            }
        });
    }
}
