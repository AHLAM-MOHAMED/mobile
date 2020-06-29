package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Screen;
    private Button c,div,mult,add,sub,one,two,three,four,five,six,seven,eight,nine,zero,equal;
    private String input,Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen=findViewById(R.id.screen);

        c=findViewById(R.id.c);
        div=findViewById(R.id.div);
        mult=findViewById(R.id.mult);
        add=findViewById(R.id.add);
        sub=findViewById(R.id.sub);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);
        equal=findViewById(R.id.equal);
    }
    public void ButtonClick(View View){
        Button button=(Button) View;
        String data=button.getText().toString();
        switch (data){
            case "c":
                input="";
                break;
            case "*":
                Solve();
                input+="*";
                break;
            case "=":
                Solve();
                Answer=input;
                break;
            default:
                if (input==null){
                    input="";
                }
                 if (data.equals("+") || data.equals("-") || data.equals("/")){
                     Solve();
                 }
                input+=data;
        }
        Screen.setText(input);
    }
    private void Solve() {
        if (input.split("\\*").length == 2) {
            String number[] = input.split("\\*");
            try {

                double mult = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mult + "";
            } catch (Exception e) {

            }
        } else if (input.split("/").length == 2) {
            String number[] = input.split("/");
            try {

                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div + "";
            } catch (Exception e) {

            }
        } else if (input.split("\\+").length == 2) {
            String number[] = input.split("\\+");
            try {

                double add = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = add + "";
            } catch (Exception e) {

            }
        } else if (input.split("-").length > 1) {
            String number[] = input.split("-");
            //to Subtract from negative number
            if (number[0] == "" && number.length == 2) {
                number[0] = 0 + "";
            }
            try {
                double sub = 0;
                if (number.length == 2) {
                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                } else if (number.length == 3) {
                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                input = sub + "";

            } catch (Exception e) {
            }
        }
        Screen.setText(input);
    }
}