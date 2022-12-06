package com.example.simran_c0870768_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String itemsval = getIntent().getStringExtra("Item");
        TextView text1 = findViewById(R.id.text1);

        int quantityval = getIntent().getIntExtra("quantity", 0);
        TextView text2 = findViewById(R.id.text2);


        double totalpayment = getIntent().getIntExtra("price", 0);
        TextView text3 = findViewById(R.id.text3);

        if(itemsval != null){
            text1.setText(itemsval);
        }
        text2.setText(String.valueOf(quantityval));
        text3.setText(String.valueOf(totalpayment));

    }



}