package net.sarah.bmicalculatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class About extends AppCompatActivity {
    android.widget.Button bhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        TextView textLink = (TextView) findViewById(R.id.ghlink);
        textLink.setMovementMethod(LinkMovementMethod.getInstance());

        bhome=findViewById(R.id.home);

        bhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(About.this,Home.class);
                startActivity(intent);
                finish();
            }
        });

    }
}