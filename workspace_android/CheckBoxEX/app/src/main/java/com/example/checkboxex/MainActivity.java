package com.example.checkboxex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chrck_click(View v){
        CheckBox ch = (CheckBox)v;
        switch (v.getId()){
            case R.id.meatspin:
                if (ch.isChecked())
                    Toast.makeText(getApplicationContext(),"고기를 돌려라!!",Toast.LENGTH_LONG).show();
                break;
            case R.id.cheese:
                if (ch.isChecked())
                    Toast.makeText(getApplicationContext(),"치즈가 좋냐!!",Toast.LENGTH_LONG).show();
                break;
        }
    }

}
