package net.sarah.bmicalculatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmiactivity extends AppCompatActivity {


    android.widget.Button brecalculatebmi, bhome;

    TextView mbmidisplay,mbmicategory,mgender,mbmirisk;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;


    String height;
    String weight;
    float intheight, intweight;
    RelativeLayout mbackground; //change background according the conditions




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable= new ColorDrawable(Color.parseColor("#ffd17d"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        //get data to pass to java to calculate

        intent=getIntent();

        mbmidisplay=findViewById(R.id.bmidisplay);
        mbmicategory=findViewById(R.id.bmicategory);
        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentlayout);
        mimageview=findViewById(R.id.imageview);
        brecalculatebmi=findViewById(R.id.recalculatebmi);
        mbmirisk=findViewById(R.id.bmirisk);
        bhome=findViewById(R.id.home);



        //take data from user
        height=intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        //convert height to float

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        //convert height to meter
        intheight=intheight/100;

        //store bmi
        intbmi=intweight/(intheight*intheight);


        mbmi=Float.toString(intbmi);

        //show bmi
        if(intbmi <= 18.4)
        {
            mbmicategory.setText("Underweight");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.no);
            mbmirisk.setText("Malnutrition risk");
        }
        else if(intbmi <= 24.9 && intbmi >= 18.5)
        {
            mbmicategory.setText("Normal weight");
            mimageview.setImageResource(R.drawable.ok);
            mbmirisk.setText("Low risk");
        }
        else if(intbmi <= 29.9 && intbmi >= 25)
        {
            mbmicategory.setText("Overweight");
            mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.ok);
            mbmirisk.setText("Enhanced risk");
        }
        else if(intbmi <= 34.9 && intbmi >= 30)
        {
            mbmicategory.setText("Moderately obese");
            mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.no);
            mbmirisk.setText("Medium risk");
        }
        else if(intbmi <= 39.9 && intbmi >= 35)
        {
            mbmicategory.setText("Severely obese");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.no);
            mbmirisk.setText("High risk");
        }
        else if(intbmi >= 40)
        {
            mbmicategory.setText("Obese");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.alert);
            mbmirisk.setText("Very high risk");
        }


        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);



        getSupportActionBar().hide();
        brecalculatebmi=findViewById(R.id.recalculatebmi);

        brecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bmiactivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bmiactivity.this,Home.class);
                startActivity(intent);
                finish();
            }
        });

    }
}