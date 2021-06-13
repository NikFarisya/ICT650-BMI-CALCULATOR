package net.sarah.bmicalculatorapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button bcalculatebmi;

    TextView mcurrentheight;
    TextView mcurrentage, mcurrentweight;
    ImageView mincrementage,mincrementweight, mdecrementage, mdecrementweight;
    SeekBar mseekbarheight;
    RelativeLayout mmale, mfemale;

    int intweight=60;
    int intage=15;
    int currentprogress;
    String mintprogress="100";
    String typeofuser="0";
    String weight2="60";
    String age2="15";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bcalculatebmi=findViewById(R.id.calculatebmi);

        mcurrentage=findViewById(R.id.currentage);
        mcurrentweight=findViewById(R.id.currentweight);
        mcurrentheight=findViewById(R.id.currentheight);
        mincrementage=findViewById(R.id.incrementage);
        mdecrementage=findViewById(R.id.decrementage);
        mincrementweight=findViewById(R.id.incrementweight);
        mdecrementweight=findViewById(R.id.decrementweight);
        mseekbarheight=findViewById(R.id.seekbarheight);
        mmale=findViewById(R.id.male);
        mfemale=findViewById(R.id.female);



        //Will set the gender to male

        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemaletype));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemaletype2));
                typeofuser="Male";
            }
        });

        //Will set the gender to female

        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemaletype));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemaletype2));
                typeofuser="Female";
            }
        });


        mseekbarheight.setMax(300);
        mseekbarheight.setProgress(100);
        mseekbarheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress=progress;
                mintprogress=String.valueOf(currentprogress);
                mcurrentheight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Increment age button
        mincrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage+1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });

        //Increment weight button

        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight+1;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });

        //Decrement age button

        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage-1;
                age2=String.valueOf(intage);
                mcurrentage.setText(age2);
            }
        });

        //Decrement weight button

        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight-1;
                weight2=String.valueOf(intweight);
                mcurrentweight.setText(weight2);
            }
        });








        bcalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //check if user select male or female or age or height or not, if not, the message will comes out
                if (typeofuser.equals("0"))
                {
                    Toast.makeText(getApplicationContext(), "Please select your gender", Toast.LENGTH_SHORT).show();
                }
                else if(mintprogress.equals("0"))
                {
                    Toast.makeText(getApplicationContext(), "Please select your height", Toast.LENGTH_SHORT).show();
                }
                else if(intage==0 | intage < 0)
                {
                    Toast.makeText(getApplicationContext(), "Please enter your correct age", Toast.LENGTH_SHORT).show();
                }
                else if(intweight==0 | intweight < 0)
                {
                    Toast.makeText(getApplicationContext(), "Weight is incorrect", Toast.LENGTH_SHORT).show();
                }
                else //the process if everything false
                {
                    Intent intent=new Intent(MainActivity.this,bmiactivity.class);
                    intent.putExtra("gender", typeofuser);
                    intent.putExtra("height", mintprogress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("age", age2);
                    startActivity(intent);
                }




            }
        });



    }
}