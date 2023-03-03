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

public class Volumen extends AppCompatActivity {

    private Button convertir=null,borrar=null;
    private EditText cantidad=null;
    private TextView resultado=null;
    private Spinner spincl=null;
    private Toast msg;
    private Button longitud=null,peso=null,volumen=null,temperatura=null,inicio=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen);

        convertir=(Button)findViewById(R.id.btn_volumen);
        borrar=(Button)findViewById(R.id.btn_borrar);
        cantidad=(EditText) findViewById(R.id.edt_ingresar);
        resultado=(TextView) findViewById(R.id.tv_resultado);
        spincl=(Spinner) findViewById(R.id.spinVolu);

        longitud=(Button)findViewById(R.id.longitud);
        peso=(Button)findViewById(R.id.peso);
        volumen=(Button)findViewById(R.id.volumen);
        temperatura=(Button) findViewById(R.id.temperatura);
        inicio=(Button)findViewById(R.id.btn_inicio4);

        String[]op={"Selecciona una opción","L a mm³","L a cm³","L a m³",
                "mm³ a L","mm³ a cm³","mm³ a m³",
                "cm³ a L","cm³ a mm³","cm³ a m³",
                "m³ a L","m³ a mm³","m³ a cm³",
                "ml a L","ml a mm³","ml a cm³","ml a m³",
                "L a ml","mm³ a ml","cm³ a ml","m³ a ml"
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
                            //resultado de L a mm³
                            res = c*1000000;
                            break;

                        case 2:
                            //resultado de L a cm³
                            res = c*1000;
                            break;

                        case 3:
                            //resultado de L a m³
                            res = c/1000;
                            break;

                        case 4:
                            //resultado de mm³ a L
                            res=c/1000000;
                            break;

                        case 5:
                            //resultado de mm³ a cm³
                            res=c/1000;
                            break;

                        case 6:
                            //resultado de mm³ a m³
                            res=c/1000000000;
                            break;

                        case 7:
                            //resultado de cm³ a L
                            res=c/1000;
                            break;

                        case 8:
                            //resultado de cm³ a mm³
                            res=c*1000;
                            break;

                        case 9:
                            //resultado de cm³ a m³
                            res=c/1000000;
                            break;

                        case 10:
                            //resultado de m³ a L
                            res=c*1000;
                            break;

                        case 11:
                            //resultado de m³ a mm³
                            res=c*1000000000;
                            break;

                        case 12:
                            //resultado de m³ a cm³
                            res=c*1000000;
                            break;

                        case 13:
                            //resultado de ml a L
                            res=c/1000;
                            break;

                        case 14:
                            //resultado de ml a mm³
                            res=c*1000;
                            break;

                        case 15:
                            //resultado de ml a cm³
                            res=c*1;
                            break;

                        case 16:
                            //resultado de ml a m³
                            res=c/1000000;
                            break;

                        case 17:
                            //resultado de L a ml
                            res=c*1000;
                            break;

                        case 18:
                            //resultado de mm³ a ml
                            res=c/1000;
                            break;

                        case 19:
                            //resultado de cm³ a ml
                            res=c*1;
                            break;

                        case 20:
                            //resultado de m³ a ml
                            res=c*1000000;
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