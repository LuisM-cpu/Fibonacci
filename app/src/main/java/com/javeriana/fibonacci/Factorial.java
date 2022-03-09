package com.javeriana.fibonacci;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Factorial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);
        TextView resultado = findViewById(R.id.resultado);
        String factor = "Operación: ";
        int total=1;
        int numero = Integer.parseInt(getIntent().getStringExtra("numero"));
        for(int i=1;i<=numero;i++)
        {
            total*=i;
            factor= factor + Integer.toString(i);
            if(i!=numero)
            {
                factor = factor + "*";
            }
        }
        factor = factor + "\nResultado: "+Integer.toString(total);
        resultado.setText(factor);
    }
}