package com.example.rathana.onesignaldemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay=findViewById(R.id.display);

        if(getIntent()!=null){
            Intent intent=getIntent();
            String title =intent.getStringExtra("title");
            String content=intent.getStringExtra("content");

            tvDisplay.setText("Title = " + title + " content "+ content);
        }
    }
}
