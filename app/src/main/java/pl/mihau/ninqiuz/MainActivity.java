package com.mihau.game.ninqiuz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.Space;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button ninkulatorLaunchButton;
    Button quizLaunchButton;
    TextView verTextView;
    String versionName = BuildConfig.VERSION_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ninkulatorLaunchButton = (Button) findViewById(R.id.ninkulatorLaunchButton);
        quizLaunchButton = (Button) findViewById(R.id.quizLaunchButton);
        verTextView = (TextView) findViewById(R.id.verTextView);
        verTextView.setText("Wersja "+versionName);


        ninkulatorLaunchButton.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view){

            Intent intent = new Intent(MainActivity.this, Ninkulator.class);
            startActivity(intent);
        }});

        quizLaunchButton.setOnClickListener (new OnClickListener()
        {
            @Override
            public void onClick(View view){
            Intent intent = new Intent(MainActivity.this, QuizMenu.class);
            startActivity(intent);
        }});

//        new AlertDialog.Builder(this)
//                .setTitle("Witaj w NinQuiz!")
//                .setMessage("Wersja: "+ versionName)
//                .show();
    }
}