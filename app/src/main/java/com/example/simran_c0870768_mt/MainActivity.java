package com.example.simran_c0870768_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner cars;
    String itemsValue;
    int itemPrice;
    TextView pricevalue;
    RadioGroup group;
    TextView totalPrice;
    SeekBar quantityValue;
    TextView quantityTitle;
    CheckBox check1;
    CheckBox check2;
    CheckBox check3;
    int quantity;
    Button details;
    int Totalpayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cars = findViewById(R.id.itemdropdown);
        pricevalue = findViewById(R.id.pricevalue);
        group = findViewById(R.id.group);
        totalPrice = findViewById(R.id.totalamount);
        quantityValue = findViewById(R.id.quantityvalue);
        quantityTitle = findViewById(R.id.quantitytitle);
        details = findViewById(R.id.totalpayment);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
       


        quantityValue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                quantityTitle.setText("How many days you want to rent: " + String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        cars.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                calculateRent();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        details.setOnClickListener(v -> {
            calculateTotalPrice();
            Toast.makeText(this, "Total payment"+totalPrice, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("Item", itemsValue);
            intent.putExtra("quantity", String.valueOf(quantity));
            intent.putExtra("Payment", String.valueOf(totalPrice));
            startActivity(intent);
        });
    }

    void calculateRent() {
        itemsValue = cars.getSelectedItem().toString();

        switch (itemsValue) {
            case "BMW":
                itemPrice = 1;
                pricevalue.setText("10$");
                break;
            case "Mercedes":
                itemPrice = 2;
                pricevalue.setText("20$");
                break;
            case "KIA":
                itemPrice = 3;
                pricevalue.setText("30$");
                break;
            case "FORD":
                itemPrice = 4;
                pricevalue.setText("40$");
                break;
            case "Toyota":
                itemPrice = 5;
                pricevalue.setText("50$");
                break;
            case "Nissan":
                itemPrice = 6;
                pricevalue.setText("60$");
                break;
            case "Hyundai":
                itemPrice = 6;
                pricevalue.setText("70$");
                break;
            default:
                itemPrice = 0;
                pricevalue.setText("0$");
                break;
        }
    }

        void calculateTotalPrice () {

            itemsValue = cars.getSelectedItem().toString();

            switch (itemsValue) {
                case "BMW":
                    itemPrice = 1;
                    pricevalue.setText("10$");
                    break;
                case "Mercedes":
                    itemPrice = 2;
                    pricevalue.setText("20$");
                    break;
                case "KIA":
                    itemPrice = 3;
                    pricevalue.setText("30$");
                    break;
                case "FORD":
                    itemPrice = 4;
                    pricevalue.setText("40$");
                    break;
                case "Toyota":
                    itemPrice = 5;
                    pricevalue.setText("50$");
                    break;
                case "Nissan":
                    itemPrice = 6;
                    pricevalue.setText("60$");
                    break;
                case "Hyundai":
                    itemPrice = 6;
                    pricevalue.setText("70$");
                    break;
                default:
                    itemPrice = 0;
                    pricevalue.setText("0$");
                    break;
            }
            quantity = quantityValue.getProgress();

            int dealId = group.getCheckedRadioButtonId();
            String deal;
            switch (dealId) {
                case R.id.first:
                    deal = "5";
                    break;
                case R.id.second:
                    deal = "0";
                    break;
                case R.id.third:
                    deal = "10";
                    break;
                default:
                    deal = "0";
            }

            double driverage = Double.parseDouble(deal);
            double regularPrice = quantity * itemPrice;
            double check = 0.13 * regularPrice;
            double radio = driverage * regularPrice;
            Totalpayment = (int) (regularPrice + check + radio);

            totalPrice.setText("" + Totalpayment + "$");


        }
    }

