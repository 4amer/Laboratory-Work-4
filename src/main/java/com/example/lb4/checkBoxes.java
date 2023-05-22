package com.example.lb4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class checkBoxes extends AppCompatActivity {

    TextView goToTheStore, haveLunch, finishReadingABook;
    CheckBox goToTheStoreBox, haveLunchBox, finishReadingABookBox;

    String Compleate = "Вы сделали задание: ";

    RadioGroup breadRadio, beveragesRadio;

    String breadText, beveragesText;

    RadioButton radioButton;

    Spinner spinner;

    TextView abs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_boxes);

        goToTheStore = findViewById(R.id.textView3);
        haveLunch = findViewById(R.id.textView6);
        finishReadingABook = findViewById(R.id.textView7);

        goToTheStoreBox = findViewById(R.id.checkBox);
        haveLunchBox = findViewById(R.id.checkBox2);
        finishReadingABookBox = findViewById(R.id.checkBox3);

        breadRadio = findViewById(R.id.breadRadio);
        beveragesRadio = findViewById(R.id.beveragesRadio);

        spinner = findViewById(R.id.spinner);
        abs = findViewById(R.id.textView12);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] choose = getResources().getStringArray(R.array.colors);
                if(choose[i].equals("Красный")){
                    System.out.println(choose[i]);
                    abs.setTextColor(Color.parseColor("#FF0000"));
                }
                if(choose[i].equals("Жёлтый")){
                    System.out.println(choose[i]);
                    abs.setTextColor(Color.parseColor("#FFFF00"));
                }
                if(choose[i].equals("Синий")){
                    System.out.println(choose[i]);
                    abs.setTextColor(Color.parseColor("#0000FF"));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void checkStore(View v){
        CheckBox checkBox = (CheckBox) v;
        if(checkBox.isChecked()){
            goToTheStoreBox.setText(Compleate + '"' + goToTheStore.getText() + '"');
        }
        else{
            goToTheStoreBox.setText("");
        }
    }

    public void checkLunch(View v){
        CheckBox checkBox = (CheckBox) v;
        if(checkBox.isChecked()){
            haveLunchBox.setText(Compleate + '"' + haveLunch.getText() + '"');
        }
        else{
            haveLunchBox.setText("");
        }
    }

    public void checkBook(View v){
        CheckBox checkBox = (CheckBox) v;
        if(checkBox.isChecked()){
            finishReadingABookBox.setText(Compleate + '"' + finishReadingABook.getText() + '"');
        }
        else{
            finishReadingABookBox.setText("");
        }
    }

    public void goBack(View v ){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goOrder(View v){
        Intent intent = new Intent(this, Order.class);
        intent.putExtra("bread", breadText);
        intent.putExtra("beverage", beveragesText);
        startActivity(intent);
    }

    public void radioBread(View v){
        int selectedId = breadRadio.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        breadText = radioButton.getText().toString();
    }

    public void radioBeverages(View v){
        int selectedId = beveragesRadio.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        beveragesText = radioButton.getText().toString();
    }

}