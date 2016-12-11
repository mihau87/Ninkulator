package pl.mihau.ninqiuz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class Menu extends AppCompatActivity {


    Button ninkulatorButton;
    Button quizButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ninkulatorButton = (Button) findViewById(R.id.ninkulatorButton);
        quizButton = (Button) findViewById(R.id.quizButton);

        ninkulatorButton.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view){

                Intent intent = new Intent(MainActivity.this, Ninkulator.class);
                startActivity(intent);
            }});

        quizButton.setOnClickListener (new OnClickListener()
        {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Quiz.class);
                startActivity(intent);
            }});
    }
}