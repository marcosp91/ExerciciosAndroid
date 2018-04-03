package com.sisnet.univali.br.projetocalculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    EditText widthField, heightField, radiusField;
    Button buttonCalcular;

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

        buttonCalcular = (Button) findViewById(R.id.button);
        buttonCalcular.setOnClickListener(this);

        radiusField.setVisibility(View.INVISIBLE);
        radiusLabel.setVisibility(View.INVISIBLE);

        List<String> shapes = new ArrayList<String>();
        shapes.add("Selecione uma forma!");
        shapes.add("Retângulo");
        shapes.add("Triângulo");
        shapes.add("Circulo");


        /*** Criando Adapter Spinner **/
        ArrayAdapter<String> dataAdapater = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, shapes);

        /*** Dropdown Style **/
        dataAdapater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        /*** Anexando DataAdapter no Spinner **/
        spinner.setAdapter(dataAdapater);

        /*** Manipulando Click Events no spinner item Selected **/


    }

    @Override
    public void onClick(View v) {

        String spinnerValue = spinner.getSelectedItem().toString();

        if (widthField != null && !widthField.getText().toString().equals("")) {

            widthy = Double.parseDouble(widthField.getText().toString());
        }
        if (heightField != null && !heightField.getText().toString().equals("")) {

            heighty = Double.valueOf(heightField.getText().toString());
        }
        if (radiusField != null && !radiusField.getText().toString().equals("")) {

            radiusy = Double.parseDouble(radiusField.getText().toString());
        }

        switch (spinnerValue) {
            case "Retângulo":
                Toast.makeText(MainActivity.this, "Selecionado: " + spinnerValue, Toast.LENGTH_SHORT).show();

                radiusField.setVisibility(View.INVISIBLE);
                radiusLabel.setVisibility(View.INVISIBLE);

                result = widthy * heighty;
                resultTextView.setText(result + "cm²");
                areaImage.setImageResource(R.drawable.rectangle);

                break;

            case "Triângulo":
                Toast.makeText(MainActivity.this, "Selecionado : " + spinnerValue, Toast.LENGTH_SHORT).show();

                radiusField.setVisibility(View.INVISIBLE);
                radiusLabel.setVisibility(View.INVISIBLE);

                result = (widthy * heighty) / 2;
                resultTextView.setText(result + "cm²");
                areaImage.setImageResource(R.drawable.triangle);
                break;

            case "Circulo":
                Toast.makeText(MainActivity.this, "Selecionado: " + spinnerValue, Toast.LENGTH_SHORT).show();

                radiusField.setVisibility(View.VISIBLE);
                radiusLabel.setVisibility(View.VISIBLE);

                if (radiusField == null || radiusField.getText().toString().equals("")) {

                    Toast.makeText(MainActivity.this, "Insira um número válido", Toast.LENGTH_SHORT).show();
                    result = 0.0;
                    radiusField.requestFocus();

                } else {
                    result = 3.14 * (widthy * heighty);
                    resultTextView.setText(result + "cm²");
                    areaImage.setImageResource(R.drawable.radius);
                }

                break;

            default:
                Toast.makeText(MainActivity.this, "Selecione alguma forma.", Toast.LENGTH_SHORT).show();

        }


    }

}
