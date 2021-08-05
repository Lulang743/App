package com.example.mpesaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class deposit extends AppCompatActivity {
EditText amount;
TextView currentAmount;
Button deposit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        amount=(EditText)findViewById(R.id.amount);
        currentAmount=(TextView) findViewById(R.id.currentAmount);
        Button send=(Button)findViewById(R.id.send);
        deposit=(Button)findViewById(R.id.deposit);

        deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number1=Integer.parseInt(amount.getText().toString());
                int balance=100;
                int result=balance+number1;

                if(result<0)
                {
                    amount.setError("your  cannot deposit amount less than 0!..");
                }
                else
                {
                    currentAmount.setText(String.valueOf(result));
                    Toast.makeText(deposit.this, "Successfully deposited!...M"+number1+".00", Toast.LENGTH_LONG).show();
                }
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(deposit.this,profile.class);
                startActivity(i);
            }
        });
    }
}