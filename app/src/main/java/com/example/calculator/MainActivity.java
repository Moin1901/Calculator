package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    ImageView btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_0;
    ImageView btn_dot,btn_ac,btn_divide,percc,btn_multiplication,btn_minus,btn_plus,btn_equal,pic;

    TextView outPuttxt,inputTxt;


    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outPuttxt=findViewById(R.id.outputtxt);
        inputTxt=findViewById(R.id.inputTxt);

        btn_0=findViewById(R.id.btn_0);
        btn_1=findViewById(R.id.btn_1);
        btn_2=findViewById(R.id.btn_2);
        btn_3=findViewById(R.id.btn_3);
        btn_4=findViewById(R.id.btn_4);
        btn_5=findViewById(R.id.btn_5);
        btn_6=findViewById(R.id.btn_6);
        btn_7=findViewById(R.id.btn_7);
        btn_8=findViewById(R.id.btn_8);
        btn_9=findViewById(R.id.btn_9);

        btn_dot=findViewById(R.id.btn_dot);
        btn_ac=findViewById(R.id.btn_ac);
        btn_divide=findViewById(R.id.btn_divide);
        percc=findViewById(R.id.perc);
        btn_multiplication=findViewById(R.id.btn_multiplication);
        btn_minus=findViewById(R.id.btn_minus);
        btn_plus=findViewById(R.id.btn_plus);
        btn_equal=findViewById(R.id.btn_equal);
        pic=findViewById(R.id.pic);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"0");
            }
        });


        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"2");
            }
        });


        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"9");
            }
        });



        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+".");
            }
        });

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTxt.setText("");
                outPuttxt.setText("");
            }
        });


        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"/");
            }
        });

        percc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"%");
            }
        });


        btn_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data +"×");
            }
        });


        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data +"-");
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data +"+");
            }
        });

        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data=inputTxt.getText().toString();
                if (data.length()>0)
                {
                    data=data.substring(0,data.length()-1);
                    inputTxt.setText(data);
                }

            }
        });


       btn_equal.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               data=inputTxt.getText().toString();

               data=data.replace("×","*");
               data=data.replace("%","/100");

               Context rhino=Context.enter();

               rhino.setOptimizationLevel(-1);

               String finalResult="";

               try{
                   Scriptable scriptable=rhino.initStandardObjects();
                   finalResult=rhino.evaluateString(scriptable,data,"javascript",1,null).toString();
               }catch (Exception e)
               {
                   finalResult="Chala ja bsdk";
               }
               outPuttxt.setText(finalResult);



           }
       });

    }
}