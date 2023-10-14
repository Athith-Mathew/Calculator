package com.example.scientificcalculator;

import static com.example.scientificcalculator.calculate.calculateM;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    TextView input, signBox;
    String sign, value2;
    StringBuilder value1=new StringBuilder();
    ImageButton history;
    boolean hasDot;
    ListView list;

    @SuppressLint({"MissingInflatedId", "SourceLockedOrientationActivity"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        input = findViewById(R.id.input);
        signBox = findViewById(R.id.sign);
        list = findViewById(R.id.list);

        history= findViewById(R.id.history);

        history.setOnClickListener(view -> {
            //Codes for history Actions.
        });

        hasDot = false;
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_0(View view) {
        input.setText(input.getText() + "0");
        if (value1 == null) {
            value1 = new StringBuilder();
        }

        value1.append(0);

        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_1(View view) {
        input.setText(input.getText() + "1");
        if (value1 == null) {
            value1 = new StringBuilder();
        }

        value1.append(1);

        cal();
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_2(View view) {
        input.setText(input.getText() + "2");
        if (value1 == null) {
            value1 = new StringBuilder();
        }

        value1.append(2);

        cal();
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_3(View view) {
        input.setText(input.getText() + "3");
        if (value1 == null) {
            value1 = new StringBuilder();
        }

        value1.append(3);

        cal();
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_4(View view) {
        input.setText(input.getText() + "4");
        if (value1 == null) {
            value1 = new StringBuilder();
        }

        value1.append(4);

        cal();
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_5(View view) {
        input.setText(input.getText() + "5");
        if (value1 == null) {
            value1 = new StringBuilder();
        }

        value1.append(5);

        cal();
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_6(View view) {
        input.setText(input.getText() + "6");
        if (value1 == null) {
            value1 = new StringBuilder();
        }

        value1.append(6);

        cal();
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_7(View view) {
        input.setText(input.getText() + "7");
        if (value1 == null) {
            value1 = new StringBuilder();
        }

        value1.append(7);

        cal();
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_8(View view) {
        input.setText(input.getText() + "8");
        if (value1 == null) {
            value1 = new StringBuilder();
        }

        value1.append(8);

        cal();
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_9(View view) {
        input.setText(input.getText() + "9");
        if (value1 == null) {
            value1 = new StringBuilder();
        }

        value1.append(9);

        cal();
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_dot(View view) {
        if (!hasDot) {
            if (input.getText().equals("")) {

                input.setText("0.");
                value1.append(0.);
            } else {

                input.setText(input.getText() + ".");
                value1.append('.');
            }

            hasDot = true;
        }
        cal();
        System.out.println(value1);

    }

    public void btnClick_add(View view) {
        sign = "+";
        value1.append('+');
        input.setText(value1);

        hasDot = false;
        System.out.println(value1);
    }

    public void btnClick_subtract(View view) {
        sign = "-";
        value1.append('-');
        input.setText(value1);
        hasDot = false;
        System.out.println(value1);

    }

    public void btnClick_multiply(View view) {
        sign = "*";
        value1.append('*');
        input.setText(value1);
        hasDot = false;
        System.out.println(value1);
    }

    public void btnClick_divide(View view) {
        sign = "/";
        value1.append('/');
        input.setText(value1);
        hasDot = false;
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_equal(View view) {
        cal();
        input.setText("");
        value1.delete(0,value1.length());

    }


    public void btnClick_delete(View view) {
        if (input.getText().equals("")) {
            input.setText(null);
        } else {
            int len = input.getText().length();
            String s = input.getText().toString();
            value1.deleteCharAt(value1.length()-1);
            System.out.println("hggh"+value1);
            if (s.charAt(len - 1) == '.') {
                hasDot = false;
                input.setText(input.getText().subSequence(0, input.getText().length() - 1));

            } else {
                input.setText(input.getText().subSequence(0, input.getText().length() - 1));
            }
        }
    }

    public void btnClick_clear(View view) {
        if (value1.length()!=0) {
            System.out.println("fjfj");
            value1.delete(0, value1.length());
        }
        input.setText(null);
        signBox.setText(null);

        value2 = null;
        sign = null;
        hasDot = false;
    }

    public void  cal(){
        String result = calculateM(String.valueOf(value1));
        if (result.equals("Invalid expression")){
            signBox.setText("Invalid expression");
        }else{
            signBox.setText(result);
        }

    }


    public void openLens(View view) {
        Intent lensIntent = new Intent("com.google.vr.apps.ornament.action.OVERVIEW");

        // Check if there's an app that can handle this Intent
        if (lensIntent.resolveActivity(getPackageManager()) != null) {
            // If the Google Lens app is installed, launch it
            startActivity(lensIntent);
        } else {
            // If the Google Lens app is not installed, you can provide an alternative action or inform the user
            Toast.makeText(this, "Google Lens app is not installed", Toast.LENGTH_SHORT).show();
        }
    }
}