package com.example.radiobuttonex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        tv1 = findViewById(R.id.tv1);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner s = (Spinner)view;
                tv1.setText(s.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        tv = findViewById(R.id.tv);

        ToggleButton toggle = findViewById(R.id.tgbtn);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "켰네", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "껐네", Toast.LENGTH_LONG).show();
                }
            }
        });
        Switch swich = findViewById(R.id.switch1);
        swich.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "스위치 켰네", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "스위치 껐네", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void radio_check(View v){
        RadioButton b = (RadioButton)v;
        switch (v.getId()){

            case R.id.b1:
                tv.setText(b.getText());
                break;

            case R.id.b2:
                tv.setText(b.getText());
                break;

            case R.id.b3:
                tv.setText(b.getText());
                break;

            case R.id.b4:
                tv.setText(b.getText());
                break;



        }
    }


}
