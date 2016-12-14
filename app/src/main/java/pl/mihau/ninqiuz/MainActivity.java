package pl.mihau.ninqiuz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {


    Button ninkulatorLaunchButton;
    Button quizLaunchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ninkulatorLaunchButton = (Button) findViewById(R.id.ninkulatorLaunchButton);
        quizLaunchButton = (Button) findViewById(R.id.quizLaunchButton);

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

        new AlertDialog.Builder(this)
                .setTitle("Witaj w NinQuiz!")
                .setMessage("Buziaki")
                .show();
    }
}