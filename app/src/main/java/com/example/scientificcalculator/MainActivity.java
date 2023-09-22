package com.example.scientificcalculator;

import static com.example.scientificcalculator.calculate.calculateM;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView input, signBox;
    String sign, value2;
    StringBuilder value1=new StringBuilder();
    ImageButton history;
    boolean hasDot;
    ListView list;

    DataBaseHandler dataBaseHandler=new DataBaseHandler(this);
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
        if(value1==null){
            value1.append(0);
        }else {
            value1.append(0);
        }
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_1(View view) {
        input.setText(input.getText() + "1");
        if(value1==null) value1.append(1);
        else value1.append(1);
        cal();
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_2(View view) {
        input.setText(input.getText() + "2");
        if(value1==null){
            value1.append(2);
        }else {
            value1.append(2);

        }
        cal();
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_3(View view) {
        input.setText(input.getText() + "3");
        if(value1==null){
            value1.append(3);
        }else {
            value1.append(3);

        }
        cal();
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_4(View view) {
        input.setText(input.getText() + "4");
        if(value1==null){
            value1.append(4);
        }else {
            value1.append(4);

        }
        cal();
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_5(View view) {
        input.setText(input.getText() + "5");
        if(value1==null){
            value1.append(5);
        }else {
            value1.append(5);

        }
        cal();
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_6(View view) {
        input.setText(input.getText() + "6");
        if(value1==null){
            value1.append(6);
        }else {
            value1.append(6);

        }
        cal();
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_7(View view) {
        input.setText(input.getText() + "7");
        if(value1==null){
            value1.append(7);
        }else {
            value1.append(7);

        }
        cal();
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_8(View view) {
        input.setText(input.getText() + "8");
        if(value1==null){
            value1.append(8);
        }else {
            value1.append(8);

        }
        cal();
        System.out.println(value1);
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_9(View view) {
        input.setText(input.getText() + "9");
        if(value1==null){
            value1.append(9);
        }else {
            value1.append(9);

        }
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

    /*private void Set_Listview(){
        Collections.reverse(historyList);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, historyList);
        list.setAdapter(arr);
    }*/
    /*public  void Refresh_Feed(){
        Cursor c1 = dataBaseHandler.getData();
        if (c1.moveToFirst()) {
            do{
                @SuppressLint("Range") String num1 = c1.getString(c1.getColumnIndex("num1"));
                @SuppressLint("Range") String num2 = c1.getString(c1.getColumnIndex("num2"));
                @SuppressLint("Range") String op = c1.getString(c1.getColumnIndex("op"));
                @SuppressLint("Range") String result = c1.getString(c1.getColumnIndex("result"));
                String output= num1+" "+op+" "+num2+" ="+result;
                historyList.add(output);
                System.out.println(output);
            }while(c1.moveToNext());
        }
    }*/
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






//package com.example.scientificcalculator;
//import android.annotation.SuppressLint;
//import android.content.pm.ActivityInfo;
//import android.database.Cursor;
//import android.os.Bundle;
//import android.text.method.ScrollingMovementMethod;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.ImageButton;
//import android.widget.ListView;
//import android.widget.TextView;
//import androidx.appcompat.app.AppCompatActivity;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//
//    TextView input, signBox;
//    private static final int CAMERA_REQUEST = 1888;
//    String sign, value1, value2,op;
//    Double num1, num2, result;
//    ImageButton history;
//    boolean hasDot;
//ListView list;
//    List<String> historyList = new ArrayList<String>();
//    List<String> Rev_historyList = new ArrayList<String>();
//
//    DataBaseHandler dataBaseHandler=new DataBaseHandler(this);
////arun
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//
//        input = (TextView) findViewById(R.id.input);
//        signBox = (TextView) findViewById(R.id.sign);
//        list =(ListView) findViewById(R.id.list);
//        //loadDoc();
//
//        history=(ImageButton) findViewById(R.id.history);
//
//        history.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Refresh_Feed();
//                //Set_history();
//                Set_Listview();
//            }
//        });
//
//        hasDot = false;
//    }
//
//    @SuppressLint("SetTextI18n")
//    public void btnClick_0(View view) {
//        input.setText(input.getText() + "0");
//        if(value1==null){
//            value1.append(0);
//        }else {
//            value1.append(0);
//
//        }
//        System.out.println(value1);
//    }
//
//    @SuppressLint("SetTextI18n")
//    public void btnClick_1(View view) {
//        input.setText(input.getText() + "1");
//        if(value1==null){
//            value1.append(1);
//        }else {
//            value1.append(1);
//
//        }
//        cal();
//        System.out.println(value1);
//    }
//
//    @SuppressLint("SetTextI18n")
//    public void btnClick_2(View view) {
//        input.setText(input.getText() + "2");
//        if(value1==null){
//            value1.append(2);
//        }else {
//            value1.append(2);
//
//        }
//        cal();
//        System.out.println(value1);
//    }
//
//    @SuppressLint("SetTextI18n")
//    public void btnClick_3(View view) {
//        input.setText(input.getText() + "3");
//        if(value1==null){
//            value1.append(3);
//        }else {
//            value1.append(3);
//
//        }
//        cal();
//        System.out.println(value1);
//    }
//
//    @SuppressLint("SetTextI18n")
//    public void btnClick_4(View view) {
//        input.setText(input.getText() + "4");
//        if(value1==null){
//            value1.append(4);
//        }else {
//            value1.append(4);
//
//        }
//        cal();
//        System.out.println(value1);
//    }
//
//    @SuppressLint("SetTextI18n")
//    public void btnClick_5(View view) {
//        input.setText(input.getText() + "5");
//        if(value1==null){
//            value1.append(5);
//        }else {
//            value1.append(5);
//
//        }
//        cal();
//        System.out.println(value1);
//    }
//
//    @SuppressLint("SetTextI18n")
//    public void btnClick_6(View view) {
//        input.setText(input.getText() + "6");
//        if(value1==null){
//            value1.append(6);
//        }else {
//            value1.append(6);
//
//        }
//        cal();
//        System.out.println(value1);
//    }
//
//    @SuppressLint("SetTextI18n")
//    public void btnClick_7(View view) {
//        input.setText(input.getText() + "7");
//        if(value1==null){
//            value1.append(7);
//        }else {
//            value1.append(7);
//
//        }
//        cal();
//        System.out.println(value1);
//    }
//
//    @SuppressLint("SetTextI18n")
//    public void btnClick_8(View view) {
//        input.setText(input.getText() + "8");
//        if(value1==null){
//            value1.append(8);
//        }else {
//            value1.append(8);
//
//        }
//        cal();
//        System.out.println(value1);
//    }
//
//    @SuppressLint("SetTextI18n")
//    public void btnClick_9(View view) {
//        input.setText(input.getText() + "9");
//        if(value1==null){
//            value1.append(9);
//        }else {
//            value1.append(9);
//
//        }
//        cal();
//        System.out.println(value1);
//    }
//
//    @SuppressLint("SetTextI18n")
//    public void btnClick_dot(View view) {
//        if (!hasDot) {
//            if (input.getText().equals("")) {
//
//                input.setText("0.");
//            } else {
//
//                input.setText(input.getText() + ".");
//            }
//
//            hasDot = true;
//        }
//
//    }
//
//    public void btnClick_add(View view) {
//        sign = "+";
//        value1 = input.getText().toString();
//        input.setText(null);
//        signBox.setText("+");
//        hasDot = false;
//    }
//
//    public void btnClick_subtract(View view) {
//        sign = "-";
//        value1 = input.getText().toString();
//        input.setText(null);
//        signBox.setText("-");
//        hasDot = false;
//    }
//
//    public void btnClick_multiply(View view) {
//        sign = "*";
//        value1 = input.getText().toString();
//        input.setText(null);
//        signBox.setText("×");
//        hasDot = false;
//    }
//
//    public void btnClick_divide(View view) {
//        sign = "/";
//        value1 = input.getText().toString();
//        input.setText(null);
//        signBox.setText("÷");
//        hasDot = false;
//    }
//
//    @SuppressLint("SetTextI18n")
//    public void btnClick_equal(View view) {
//        String val = input.getText().toString();
//        if (sign == null) {
//            signBox.setText(val);
//        } else if (input.getText().equals("")) {
//            signBox.setText("0");
//        } else if ((sign.equals("+") || sign.equals("-") || sign.equals("*") || sign.equals("/")) && value1.equals("")) {
//            signBox.setText("Error!");
//        } else {
//            switch (sign) {
//                default:
//                    break;
//                case "+":
//                    op="+";
//                    value2 = input.getText().toString();
//                    num1 = Double.parseDouble(value1);
//                    num2 = Double.parseDouble(value2);
//                    result = num1 + num2;
//                    input.setText(result + "");
//                    sign = null;
//                    signBox.setText(null);
//                    break;
//                case "-":
//                    op="-";
//                    value2 = input.getText().toString();
//                    num1 = Double.parseDouble(value1);
//                    num2 = Double.parseDouble(value2);
//                    result = num1 - num2;
//                    input.setText(result + "");
//                    sign = null;
//                    signBox.setText(null);
//                    break;
//                case "*":
//                    op="*";
//                    value2 = input.getText().toString();
//                    num1 = Double.parseDouble(value1);
//                    num2 = Double.parseDouble(value2);
//                    result = num1 * num2;
//                    input.setText(result + "");
//                    sign = null;
//                    signBox.setText(null);
//                    break;
//                case "/":
//                    op="/";
//                    value2 = input.getText().toString();
//                    num1 = Double.parseDouble(value1);
//                    num2 = Double.parseDouble(value2);
//                    result = num1 / num2;
//                    input.setText(result + "");
//                    sign = null;
//                    signBox.setText(null);
//                    break;
//            }
//            dataBaseHandler.insertData(num1,op,num2,result);
//            Refresh_Feed();
//            Set_Listview();
//
//        }
//    }
//
//
//    public void btnClick_delete(View view) {
//        if (input.getText().equals("")) {
//            input.setText(null);
//        } else {
//            int len = input.getText().length();
//            String s = input.getText().toString();
//            if (s.charAt(len - 1) == '.') {
//                hasDot = false;
//                input.setText(input.getText().subSequence(0, input.getText().length() - 1));
//
//            } else {
//                input.setText(input.getText().subSequence(0, input.getText().length() - 1));
//            }
//        }
//    }
//
//    public void btnClick_clear(View view) {
//
//        input.setText(null);
//        signBox.setText(null);
//        value1 = null;
//        value2 = null;
//        sign = null;
//        hasDot = false;
//    }
//
//    private void Set_Listview(){
//        Collections.reverse(historyList);
//        ArrayAdapter<String> arr;
//        arr = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, historyList);
//        list.setAdapter(arr);
//    }
//    /*
//    private void Set_history() {
//        for (Object i:historyList){
//            signBox.setText((CharSequence) i);
//        }
//    }
//     */
//
//    public  void Refresh_Feed(){
//        Cursor c1 = dataBaseHandler.getData();
//        if (c1.moveToFirst()) {
//            do{
//                @SuppressLint("Range") String num1 = c1.getString(c1.getColumnIndex("num1"));
//                @SuppressLint("Range") String num2 = c1.getString(c1.getColumnIndex("num2"));
//                @SuppressLint("Range") String op = c1.getString(c1.getColumnIndex("op"));
//                @SuppressLint("Range") String result = c1.getString(c1.getColumnIndex("result"));
//                String output= num1+" "+op+" "+num2+" ="+result;
//                historyList.add(output);
//                System.out.println(output);
//            }while(c1.moveToNext());
//        }
//    }
//
//}
