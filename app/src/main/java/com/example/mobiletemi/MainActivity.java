package com.example.mobiletemi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference.child("game").child("start").setValue(0);
        databaseReference.child("game").child("end").setValue(0);
    }

    public void game_start(View view){
        databaseReference.child("game").child("start").setValue(1);
    }

    public void game_end(View view){
        databaseReference.child("game").child("end").setValue(1);
    }
}
