package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button longitud=null,peso=null,volumen=null,temperatura=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        longitud=(Button)findViewById(R.id.m_longitud);
        peso=(Button)findViewById(R.id.m_peso);
        volumen=(Button)findViewById(R.id.m_volumen);
        temperatura=(Button) findViewById(R.id.m_temperatura);
    }

    public void cambiar(View view){
        longitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lon=new Intent(getApplicationContext(),Longitud.class);
                startActivity(lon);
                finish();
            }
        });

        peso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent peso=new Intent(getApplicationContext(),Peso.class);
                startActivity(peso);
                finish();
            }
        });

        volumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volu=new Intent(getApplicationContext(),Volumen.class);
                startActivity(volu);
                finish();
            }
        });

        temperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent temp=new Intent(getApplicationContext(),Temperatura.class);
                startActivity(temp);
                finish();
            }
        });
    }

}