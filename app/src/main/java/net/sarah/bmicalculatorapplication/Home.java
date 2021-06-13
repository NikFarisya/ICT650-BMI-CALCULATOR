package net.sarah.bmicalculatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    android.widget.Button babout, bbmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        babout=findViewById(R.id.about);
        bbmi=findViewById(R.id.bmi);

        babout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentA=new Intent(getApplicationContext(),About.class);
                startActivity(intentA);
                finish();
            }
        });

        bbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentB=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intentB);
                finish();
            }
        });


    }
}