package com.sisnet.univali.br.projetocalculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText widthField, heightField, radiusField;

    TextView resultTextView, radiusLabel;
    Spinner spinner;
    ImageView areaImage;

    double widthy = 0;
    double heighty = 0;
    double radiusy = 0;

    double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        widthField = ((EditText) findViewById(R.id.widthField));
        heightField = ((EditText) findViewById(R.id.heightField));
        radiusField = ((EditText) findViewById(R.id.radiusField));

        radiusLabel = (TextView) findViewById(R.id.radius);
        resultTextView = (TextView) findViewById(R.id.result);

        areaImage = (ImageView) findViewById(R.id.imageArea);
        spinner = (Spinner) findViewById(R.id.spinner);

        radiusField.setVisibility(View.INVISIBLE);
        radiusLabel.setVisibility(View.INVISIBLE);

        List<String> shapes = new ArrayList<String>();
        shapes.add("Select a shape!");
        shapes.add("Rectangle");
        shapes.add("Triangle");
        shapes.add("Circle");


        /*** Criando Adapter Spinner **/
        ArrayAdapter<String> dataAdapater = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, shapes);

        /*** Dropdown Style **/
        dataAdapater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        /*** Anexando DataAdapter no Spinner **/
        spinner.setAdapter(dataAdapater);

        /*** Manipulando Click Events no spinner item Selected **/
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String selectedItem = adapterView.getItemAtPosition(i).toString();

                /*** Atribuindo Valores**/

                if(widthField != null && !widthField.getText().toString().equals("")) {

                    widthy = Double.parseDouble(widthField.getText().toString());
                }
                if (heightField !=null && !heightField.getText().toString().equals("")) {

                    heighty = Double.valueOf(heightField.getText().toString());
                }
                if (radiusField != null && !radiusField.getText().toString().equals("")) {

                    radiusy = Double.parseDouble(radiusField.getText().toString());
                }


                /** Adicionando Click Events para cada tem no spinner **/

                if (selectedItem.equals("Selecione uma Forma!")) {

                    // Faça alguma coisa
                    Toast.makeText(MainActivity.this, "Select any shape", Toast.LENGTH_SHORT).show();
                }

               if (selectedItem.equals("Rectangle")){

                    Toast.makeText(MainActivity.this, "You selected : " + selectedItem, Toast.LENGTH_SHORT).show();

                    radiusField.setVisibility(View.INVISIBLE);
                    radiusLabel.setVisibility(View.INVISIBLE);

                    result = widthy*heighty;
                    resultTextView.setText(result + "cm²");
                    areaImage.setImageResource(R.drawable.rectangle);

                }
               if (selectedItem.equals("Triangle")){

                    Toast.makeText(MainActivity.this, "You selected : " + selectedItem, Toast.LENGTH_SHORT).show();

                    radiusField.setVisibility(View.INVISIBLE);
                    radiusLabel.setVisibility(View.INVISIBLE);

                    result = (widthy*heighty) / 2;
                    resultTextView.setText( result + "cm²");
                    areaImage.setImageResource(R.drawable.triangle);

                }
                if (selectedItem.equals("Circle")) {

                    Toast.makeText(MainActivity.this, "You selected : " + selectedItem, Toast.LENGTH_SHORT).show();

                    radiusField.setVisibility(View.VISIBLE);
                    radiusLabel.setVisibility(View.VISIBLE);

                    result = 3.14 * (widthy*heighty);
                    resultTextView.setText(result + "cm²");
                    areaImage.setImageResource(R.drawable.radius);

                }

            }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
    }
}
