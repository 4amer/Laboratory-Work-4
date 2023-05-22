package com.example.lb4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ThreadLocalRandom;
import java.lang.StringBuilder;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int RandomNumText;
    TextView num;


    TextView reverceStr;
    EditText editReverce;

    boolean isRecording = false;
    Button recordBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = findViewById(R.id.numText);

        reverceStr = findViewById(R.id.reverceResult);
        editReverce = findViewById(R.id.inputReverceSting);

        recordBtn = findViewById(R.id.recordBtn);
    }

    public void RandomNum(View v){
        RandomNumText = ThreadLocalRandom.current().nextInt(0, 101);
        num.setText(String.valueOf(RandomNumText));
    }

    public void reverceString(View v){
        reverceStr.setText(new StringBuilder(editReverce.getText()).reverse().toString());
    }

    public void recording(View v){
        isRecording = !isRecording;
        if(isRecording == true){
            recordBtn.setText("Стоп");
            Toast.makeText(this, "Запись пошла…", Toast.LENGTH_LONG).show();
        }
        else{
            recordBtn.setText("Старт");
            Toast.makeText(this, "Запись остановлена…", Toast.LENGTH_LONG).show();
        }
    }

    public void goNext(View v){
        Intent intent = new Intent(this, checkBoxes.class);
        startActivity(intent);
    }
}