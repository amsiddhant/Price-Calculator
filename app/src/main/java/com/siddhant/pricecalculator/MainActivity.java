package com.siddhant.pricecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView pweight,nweight;
    EditText netWeight, mrp, productWeight, netPrice;
    ToggleButton toggleButton;
    Button reset;

    float price, weight;
    int kg = 1000;
    float a;
    float b;
    float c;
    float weightChange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        netWeight = (EditText) findViewById(R.id.netWeight);
        mrp = (EditText) findViewById(R.id.mrp);
        productWeight = (EditText) findViewById(R.id.productWeight);
        netPrice = (EditText) findViewById(R.id.netPrice);
        toggleButton = (ToggleButton)findViewById(R.id.toggle);
        reset = (Button)findViewById(R.id.reset);
        pweight=(TextView)findViewById(R.id.pweight);
        nweight=(TextView)findViewById(R.id.nweight);

       toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButton.isChecked()){
                    pweight.setText("gm");
                    nweight.setText("gm");
                    if (netWeight.getText().toString() !="" && netWeight.getText().length()>0) {
                        float nw = Float.parseFloat(netWeight.getText().toString()) * 1000;
                        netWeight.setText(Float.toString(nw));
                    }
                    else {
                        netWeight.setText("");
                    }
                    if(productWeight.getText().toString() !="" && productWeight.getText().length()>0) {
                        Float pw = Float.parseFloat(productWeight.getText().toString()) * 1000;
                        productWeight.setText(Float.toString(pw));
                    }
                    else{
                        productWeight.setText("");
                    }

                }
                else {
                    pweight.setText("kg");
                    nweight.setText("kg");
                    if (netWeight.getText().toString() !="" && netWeight.getText().length()>0) {
                        float nw = Float.parseFloat(netWeight.getText().toString()) / 1000;
                        netWeight.setText(Float.toString(nw));
                    }
                    else {
                        netWeight.setText("");

                    }
                    if(productWeight.getText().toString() !="" && productWeight.getText().length()>0) {
                        Float pw = Float.parseFloat(productWeight.getText().toString()) / 1000;
                        productWeight.setText(Float.toString(pw));
                    }
                    else{
                        productWeight.setText("");

                    }

                }
            }
        });


        netWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                netPrice.setText(add());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mrp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                netPrice.setText(add());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        productWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                netPrice.setText(add());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        netPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               // productWeight.setText(WeightChange());


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               netWeight.setText("");
               mrp.setText("");
               productWeight.setText("");
               netPrice.setText("");
               toggleButton.setChecked(false);
               nweight.setText("kg");
               pweight.setText("kg");
            }
        });
    }

    private String add()
    {


        if (netWeight.getText().toString() !="" && netWeight.getText().length()>0) {
            if (toggleButton.isChecked()){
                a = Float.parseFloat("0"+netWeight.getText().toString());
            }
            else {
                a = Float.parseFloat("0"+netWeight.getText().toString())*1000;
            }
        }
        else
        {
            a=1;
        }
        if(mrp.getText().toString() !="" && mrp.getText().length()>0){
            b = Float.parseFloat("0"+mrp.getText().toString());
        }
        else{
            b=1;
        }
        if(productWeight.getText().toString() !="" && productWeight.getText().length()>0){
            if (toggleButton.isChecked()){
                c = Float.parseFloat("0"+productWeight.getText().toString());
            }
            else {
                c = Float.parseFloat("0"+productWeight.getText().toString())*1000;
            }

        }
        else{
            c=0;
        }
        float d = (b/a)*c;
        return Float.toString(d);
    }
  /*  private String WeightChange(){

        float n;

        if(netPrice.getText().toString() !="" && netPrice.getText().length()>0) {
            n = Float.parseFloat("0" + netPrice.getText().toString());
        }
        else {
            n=1;
        }

        weightChange = (a/b)*n;
        return Float.toString(weightChange);
    }

   */
}
