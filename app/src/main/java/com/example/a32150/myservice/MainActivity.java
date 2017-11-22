package com.example.a32150.myservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onStartService(View v)  {
        System.out.println("開始服務");
        Intent it = new Intent(this, MyService.class);
        MyService.isStop = false;
        startService(it);
    }

    public void onEndService(View v)  {
        System.out.println("結束服務");
        Intent it = new Intent(this, MyService.class);
        MyService.isStop = true;
        stopService(it);

    }
}
