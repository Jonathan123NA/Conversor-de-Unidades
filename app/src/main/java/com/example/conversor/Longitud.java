package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Longitud extends AppCompatActivity {

    private Button convertir=null,borrar=null;
    private EditText cantidad=null;
    private TextView resultado=null;
    private Spinner spincl=null;
    private Toast msg;
    private Button longitud=null,peso=null,volumen=null,temperatura=null,inicio=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_longitud);

        convertir=(Button)findViewById(R.id.btn_longitud);
        borrar=(Button)findViewById(R.id.btn_borrar);
        cantidad=(EditText) findViewById(R.id.edt_ingresar);
        resultado=(TextView) findViewById(R.id.tv_resultado);
        spincl=(Spinner) findViewById(R.id.spinLong);

        longitud=(Button)findViewById(R.id.longitud);
        peso=(Button)findViewById(R.id.peso);
        volumen=(Button)findViewById(R.id.volumen);
        temperatura=(Button) findViewById(R.id.temperatura);
        inicio=(Button)findViewById(R.id.btn_inicio);

        String[]op={"Selecciona una opción","mm a cm","mm a m","mm a km",
                "cm a mm","cm a m","cm a km",
                "m a mm","m a cm","m a km",
                "km a mm","km a cm","km a m"
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
                            //resultado de mm a cm
                            res = c/10;
                            break;

                        case 2:
                            //resultado de mm a m
                            res = c/1000;
                            break;

                        case 3:
                            //resultado de mm a km
                            res = c/1000000;
                            break;

                        case 4:
                            //resultado de cm a mm
                            res=c*10;
                            break;

                        case 5:
                            //resultado de cm a m
                            res=c/100;
                            break;

                        case 6:
                            //resultado de cm a km
                            res=c/100000;
                            break;

                        case 7:
                            //resultado de m a mm
                            res=c*1000;
                            break;

                        case 8:
                            //resultado de m a cm
                            res=c*100;
                            break;

                        case 9:
                            //resultado de m a km
                            res=c/1000;
                            break;

                        case 10:
                            //resultado de km a mm
                            res=c*1000000;
                            break;

                        case 11:
                            //resultado de km a cm
                            res=c*100000;
                            break;

                        case 12:
                            //resultado de km a m
                            res=c*1000;
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