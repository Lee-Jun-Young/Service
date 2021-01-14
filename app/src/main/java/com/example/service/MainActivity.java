package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_startService;
        Button btn_stopService;

        btn_startService = findViewById(R.id.btn_startService);
        btn_stopService = findViewById(R.id.btn_stopService);

        // 서비스 시작하기
        btn_startService.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("test", "startService");
                Intent intent = new Intent(
                        getApplicationContext(),
                        MyService.class);
                startService(intent);
            }
        });

        // 서비스 정지하기
        btn_stopService.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("test", "stopService");
                Intent intent = new Intent(
                        getApplicationContext(),
                        MyService.class);
                stopService(intent);
            }
        });

    }
}