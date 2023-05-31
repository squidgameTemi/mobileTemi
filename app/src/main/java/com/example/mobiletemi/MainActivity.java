package com.example.mobiletemi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();

    private RadioButton rb_easy, rb_normal, rb_hard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rb_easy = (RadioButton)findViewById(R.id.easy);
        rb_normal = (RadioButton)findViewById(R.id.normal);
        rb_hard = (RadioButton)findViewById(R.id.hard);

        databaseReference.child("game").setValue(-1);

    }

    public void game_start(View view){
        if(rb_easy.isChecked()){
            databaseReference.child("game").setValue(1);
        }
        else if(rb_normal.isChecked()){
            databaseReference.child("game").setValue(2);
        }
        else if(rb_hard.isChecked()){
            databaseReference.child("game").setValue(3);
        }
    }

    public void game_end(View view){
        databaseReference.child("game").setValue(0);
    }
}
