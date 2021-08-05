package com.example.mpesaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class details extends AppCompatActivity {
TextView phone,name,balance;
Button viewDetails;
DatabaseReference myreff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);
        phone=(TextView)findViewById(R.id.phone);
        name=(TextView)findViewById(R.id.name);
        balance=(TextView)findViewById(R.id.balance);

        viewDetails=(Button)findViewById(R.id.details);

        viewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myreff= FirebaseDatabase.getInstance().getReference().child("customers");
                 myreff.addValueEventListener(new ValueEventListener() {
                     @Override
                     public void onDataChange(DataSnapshot dataSnapshot) {
                         String phonet = dataSnapshot.child("phone").getValue().toString();
                         String namet =dataSnapshot.child("name").getValue().toString();
                         String balancet =dataSnapshot.child("balance").getValue().toString();

                         phone.setText(phonet);
                         name.setText(namet);
                         balance.setText(balancet);


                     }

                     @Override
                     public void onCancelled(DatabaseError error) {

                     }
                 });
            }
        });

    }
}