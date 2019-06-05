package com.example.project0604;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    Button b;

    public void method2(View v){
        b.setText("Test Button");
        Toast.makeText(getApplicationContext(),"다시전환",LENGTH_LONG).show();
    }

    public void method1(View v){
        b.setText("ex Button");
        Toast.makeText(getApplicationContext(),"뭐지", LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.btn1);
        Log.i("mytag","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("mytag","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("mytag","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("mytag","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("mytag","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("mytag","onResume");
    }
}
