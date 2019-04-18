package com.example.flight.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.flight.R;

public class Main2Activity extends AppCompatActivity {
    TextView text1,text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text1=findViewById(R.id.textView);
        text2=findViewById(R.id.text);

        Intent intent= getIntent();
        text1.setText(intent.getStringExtra("departure")+"->"+intent.getStringExtra("arrived"));

        Double price=intent.getDoubleExtra("price",0);
       text2.setText(intent.getStringExtra("airway")+" "+intent.getStringExtra("cabin")+" Class "+price.toString()+" TL");

    }
}
