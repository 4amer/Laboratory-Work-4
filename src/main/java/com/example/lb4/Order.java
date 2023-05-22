package com.example.lb4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Order extends AppCompatActivity {

    TextView order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        order = findViewById(R.id.orderText);
        order.setText("Вы заказали: " + getIntent().getExtras().get("bread").toString() + " хлеб и " + getIntent().getExtras().get("beverage").toString());
    }

    public void goBack(View v){
        Intent intent = new Intent(this, checkBoxes.class);
        startActivity(intent);
    }
}