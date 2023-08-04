package com.example.mycalci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnone,btntwo,btnthree,btnfour,btnfive,btnsix,btnseven,btneight,btnnine,btnzero;
    Button btndiv,btnmul,btnadd,btnsub,btndot,btneql,btnclr;
    EditText edt_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnone=(Button) findViewById(R.id.btn_1);
        btnone.setOnClickListener(this);

        btntwo=(Button) findViewById(R.id.btn_2);
        btntwo.setOnClickListener(this);

        btnthree=(Button) findViewById(R.id.btn_3);
        btnthree.setOnClickListener(this);

        btnfour=(Button) findViewById(R.id.btn_4);
        btnfour.setOnClickListener(this);

        btnfive=(Button) findViewById(R.id.btn_5);
        btnfive.setOnClickListener(this);

        btnsix=(Button) findViewById(R.id.btn_6);
        btnsix.setOnClickListener(this);

        btnseven=(Button) findViewById(R.id.btn_7);
        btnseven.setOnClickListener(this);

        btneight=(Button) findViewById(R.id.btn_8);
        btneight.setOnClickListener(this);

        btnnine=(Button) findViewById(R.id.btn_9);
        btnnine.setOnClickListener(this);

        btnzero=(Button) findViewById(R.id.btn_0);
        btnzero.setOnClickListener(this);

        btndiv=(Button) findViewById(R.id.btn_div);
        btndiv.setOnClickListener(this);

        btnmul=(Button) findViewById(R.id.btn_mul);
        btnmul.setOnClickListener(this);

        btnadd=(Button) findViewById(R.id.btn_add);
        btnadd.setOnClickListener(this);

        btnsub=(Button) findViewById(R.id.btn_sub);
        btnsub.setOnClickListener(this);

        btndot=(Button) findViewById(R.id.btn_dot);
        btndot.setOnClickListener(this);

        btneql=(Button) findViewById(R.id.btn_eql);
        btneql.setOnClickListener(this);

        btnclr=(Button) findViewById(R.id.btn_clr);
        btnclr.setOnClickListener(this);

        edt_txt=(EditText) findViewById(R.id.edt_txt);
        edt_txt.setText("");
    }

    @Override
    public void onClick(View v) {
        if(v.equals(btnone))
        {
            edt_txt.append("1");
        }
        if(v.equals(btntwo))
        {
            edt_txt.append("2");
        }
        if(v.equals(btnthree))
        {
            edt_txt.append("3");
        }
        if(v.equals(btnfour))
        {
            edt_txt.append("4");
        }
        if(v.equals(btnfive))
        {
            edt_txt.append("5");
        }
        if(v.equals(btnsix))
        {
            edt_txt.append("6");
        }
        if(v.equals(btnseven))
        {
            edt_txt.append("7");
        }
        if(v.equals(btneight))
        {
            edt_txt.append("8");
        }
        if(v.equals(btnnine))
        {
            edt_txt.append("9");
        }
        if(v.equals(btnzero))
        {
            edt_txt.append("0");
        }
        if(v.equals(btndiv))
        {
            edt_txt.append("/");
        }
        if(v.equals(btnmul))
        {
            edt_txt.append("*");
        }
        if(v.equals(btnadd))
        {
            edt_txt.append("+");
        }
        if(v.equals(btnsub))
        {
            edt_txt.append("-");
        }
        if(v.equals(btndot))
        {
            edt_txt.append(".");
        }
        if(v.equals(btnclr))
        {
            edt_txt.setText("");
        }
        if(v.equals(btneql))
        {
            String data=edt_txt.getText().toString();
            try{
                if(data.contains("+"))
                {
                    add(data);
                }
                if(data.contains("-"))
                {
                    sub(data);
                }
                if(data.contains("*"))
                {
                    mul(data);
                }
                if(data.contains("/"))
                {
                    divide(data);
                }
            }
            catch (Exception e)
            {
                displayerror("Invalid Input");
            }
        }
    }

    private void displayerror(String msg) {
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }

    private void divide(String data) {
        String[] operand=data.split(Pattern.quote("/"));
        if(operand.length==2)
        {
            Double op1=Double.parseDouble(operand[0]);
            Double op2=Double.parseDouble(operand[1]);
            Double result=op1/op2;
            edt_txt.setText(String.valueOf(result));
        }
        else {
            displayerror("Invalid Operator");
        }
    }

    private void mul(String data) {
        String[] operand=data.split(Pattern.quote("*"));
        if(operand.length==2)
        {
            Double op1=Double.parseDouble(operand[0]);
            Double op2=Double.parseDouble(operand[1]);
            Double result=op1*op2;
            edt_txt.setText(String.valueOf(result));
        }
        else {
            displayerror("Invalid Operator");
        }
    }

    private void sub(String data) {
        String[] operand=data.split(Pattern.quote("-"));
        if(operand.length==2)
        {
            Double op1=Double.parseDouble(operand[0]);
            Double op2=Double.parseDouble(operand[1]);
            Double result=op1-op2;
            edt_txt.setText(String.valueOf(result));
        }
        else {
            displayerror("Invalid Operator");
        }
    }

    private void add(String data) {
        String[] operand=data.split(Pattern.quote("+"));
        if(operand.length==2)
        {
            Double op1=Double.parseDouble(operand[0]);
            Double op2=Double.parseDouble(operand[1]);
            Double result=op1+op2;
            edt_txt.setText(String.valueOf(result));
        }
        else {
            displayerror("Invalid Operator");
        }
    }
}