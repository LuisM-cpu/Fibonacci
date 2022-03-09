package com.javeriana.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class Fibonacci extends AppCompatActivity {

    String[] arreglo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);
        String posiciones = getIntent().getStringExtra("posiciones");
        ScrollView scroll = findViewById(R.id.scroll);
        ListView secuencia = findViewById(R.id.secuencia);
        int pos=Integer.parseInt(posiciones)+1;
        calcularSecuencia(pos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arreglo);
        secuencia.setAdapter(adapter);
        ImageView foto = findViewById(R.id.foto);
        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView myWebView = findViewById(R.id.webview);
                myWebView.loadUrl("https://es.wikipedia.org/wiki/Leonardo_de_Pisa");
            }
        });
    }

    private void calcularSecuencia(int pos) {
        arreglo = new String[pos];
        if(pos>2)
        {
            arreglo[0]="0";
            arreglo[1]="1";
            int v1,v2;
            for (int i = 2; i < pos; i++){
                v1=Integer.parseInt(arreglo[i-1]);
                v2=Integer.parseInt(arreglo[i-2]);
                arreglo[i]=Integer.toString(v1+v2);
            }
        }else if(pos==2)
        {
            arreglo[0]="0";
            arreglo[1]="1";
        }else{
            arreglo[0]="0";
        }
    }
}