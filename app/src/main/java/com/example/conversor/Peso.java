package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Peso extends AppCompatActivity {
    private Button convertir=null,borrar=null;
    private EditText cantidad=null;
    private TextView resultado=null;
    private Spinner spincl=null;
    private Toast msg;
    private Button longitud=null,peso=null,volumen=null,temperatura=null,inicio=null;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso);

        convertir=(Button)findViewById(R.id.btn_peso);
        borrar=(Button)findViewById(R.id.btn_borrar);
        cantidad=(EditText) findViewById(R.id.edt_ingresar);
        resultado=(TextView) findViewById(R.id.tv_resultado);
        spincl=(Spinner) findViewById(R.id.spinPeso);

        longitud=(Button)findViewById(R.id.longitud);
        peso=(Button)findViewById(R.id.peso);
        volumen=(Button)findViewById(R.id.volumen);
        temperatura=(Button) findViewById(R.id.temperatura);
        inicio=(Button)findViewById(R.id.btn_inicio2);

        String[]op={"Selecciona una opción","g a Kg","g a lb","g a oz",
                "kg a g","kg a lb","kg a oz",
                "lb a g","lb a kg","lb a oz",
                "oz a g","oz a kg","oz a lb"
        };

        ArrayAdapter<String> adapter=new
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,op);

        spincl.setAdapter(adapter);

        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //cantidad que el usuario ingresa
                    Double c = Double.parseDouble(cantidad.getText().toString());
                    //resultado que se arrojara
                    Double res = null;
                    //opcion selecionada en el spinner
                    int select = spincl.getSelectedItemPosition();

                    //identificar opcion seleccionada
                    switch (select) {
                        case 0:
                            Toast.makeText(getApplicationContext(), "Selecciona una opción", Toast.LENGTH_SHORT).show();
                            break;

                        case 1:
                            //resultado de g a km
                            res = c/1000;
                            break;

                        case 2:
                            //resultado de g a lb
                            res = c/453.59237;
                            break;

                        case 3:
                            //resultado de g a oz
                            res = c/28.3495231;
                            break;

                        case 4:
                            //resultado de kg a g
                            res=c*1000;
                            break;

                        case 5:
                            //resultado de kg a lb
                            res=c*2.20462262;
                            break;

                        case 6:
                            //resultado de kg a oz
                            res=c*35.273962;
                            break;

                        case 7:
                            //resultado de lb a g
                            res=c*453.59237;
                            break;

                        case 8:
                            //resultado de lb a kg
                            res=c/2.20462262;
                            break;

                        case 9:
                            //resultado de lb a oz
                            res=c*16;
                            break;

                        case 10:
                            //resultado de oz a g
                            res=c*28.3495231;
                            break;

                        case 11:
                            //resultado de oz a kg
                            res=c/35.273962;
                            break;

                        case 12:
                            //resultado de oz a lb
                            res=c/16;
                            break;

                    }

                    //mandar el resultado correspondiente
                    resultado.setText(res.toString());

                }catch(Exception e){
                    cantidad.setText("");
                    Toast.makeText(getApplicationContext(), "Escribe una cantidad", Toast.LENGTH_SHORT).show();
                }
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantidad.setText("");
                resultado.setText("");
                spincl.setSelection(0);
            }
        });
    }

    public void cambiar(View view){
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ini=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(ini);
                finish();
            }
        });
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