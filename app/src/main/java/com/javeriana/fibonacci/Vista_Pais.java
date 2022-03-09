package com.javeriana.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Vista_Pais extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_pais);
        Bundle bundle = getIntent().getBundleExtra("bundle");
        ImageView bandera = findViewById(R.id.bandera);
        TextView capital = findViewById(R.id.capital);
        TextView nombre_pais = findViewById(R.id.nombre_pais);
        TextView nombre_pais_int = findViewById(R.id.nombre_pais_int);
        TextView sigla = findViewById(R.id.sigla);
        String ruta = bundle.getString("sigla").toLowerCase();
        bandera.setImageResource(getResources().getIdentifier(ruta,"drawable",getPackageName()));
        capital.setText("Capital: "+bundle.getString("capital"));
        nombre_pais.setText("Nombre: "+bundle.getString("nombre_pais"));
        nombre_pais_int.setText("Nombre Internacional: "+bundle.getString("nombre_pais_int"));
        sigla.setText("Sigla: "+bundle.getString("sigla"));
    }
}