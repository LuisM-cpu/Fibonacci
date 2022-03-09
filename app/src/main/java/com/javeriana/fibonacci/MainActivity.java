package com.javeriana.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView contador = findViewById(R.id.contador);
        Spinner spinner = findViewById(R.id.spinner);
        Button factorial = findViewById(R.id.factorial);
        TextView hora = findViewById(R.id.hora);
        Button paises = findViewById(R.id.paises);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.numeros, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        TextView posiciones = findViewById(R.id.posiciones);

        Button fibonacci = findViewById(R.id.fibonacci);
        fibonacci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Fibonacci.class);
                if(posiciones.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Ingrese la cantidad de posiciones a calcular.", Toast.LENGTH_SHORT).show();
                }else{
                    intent.putExtra("posiciones",posiciones.getText().toString());
                    int vcont= Integer.parseInt(contador.getText().toString());
                    vcont++;
                    contador.setText(Integer.toString(vcont));
                    String fechayhora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
                    hora.setText(fechayhora);
                    startActivity(intent);
                }

            }
        });

        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int vcont= Integer.parseInt(contador.getText().toString());
                vcont++;
                contador.setText(Integer.toString(vcont));
                Intent intent = new Intent(view.getContext(),Factorial.class);
                intent.putExtra("numero",spinner.getSelectedItem().toString());
                String fechayhora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
                hora.setText(fechayhora);
                startActivity(intent);
            }
        });

        paises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Paises.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}