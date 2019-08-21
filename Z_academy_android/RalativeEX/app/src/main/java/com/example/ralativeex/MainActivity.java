package com.example.ralativeex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.btn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"버튼이상한거클릭함",Toast.LENGTH_LONG).show();
            }
        });

    }
    public void clickLisener(View v){
        Toast.makeText(getApplicationContext(),"버튼누름",Toast.LENGTH_LONG).show();
    }
}
