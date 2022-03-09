package com.javeriana.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Paises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);
        ArrayList<Pais> lista_paises= new ArrayList<Pais>();
        ListView paises = findViewById(R.id.paises);
        try {
            JSONObject lectura = new JSONObject(loadJSONFromAsset());
            JSONArray listap = lectura.getJSONArray("paises");
            for(int i=0;i<listap.length();i++)
            {
                JSONObject objeto = listap.getJSONObject(i);
                lista_paises.add(new Pais(objeto.getString("capital"),objeto.getString("nombre_pais"),objeto.getString("nombre_pais_int"),objeto.getString("sigla")));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        ArrayAdapter<Pais> adapter = new ArrayAdapter<Pais>(this, android.R.layout.simple_list_item_1,lista_paises);
        paises.setAdapter(adapter);

        paises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(),Vista_Pais.class);
                Bundle bundle = new Bundle();
                bundle.putString("capital",lista_paises.get(i).getCapital());
                bundle.putString("nombre_pais",lista_paises.get(i).getNombre_pais());
                bundle.putString("nombre_pais_int",lista_paises.get(i).getNombre_pais_int());
                bundle.putString("sigla",lista_paises.get(i).getSigla());
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        });
    }

    public String loadJSONFromAsset(){
        String json = null;
        try {
            InputStream is = this.getAssets().open("paises.json");
            int size = is.available();

            byte[] buffer = new  byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");
        }catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}