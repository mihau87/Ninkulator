package pl.mihau.ninqiuz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class QuizMenu extends AppCompatActivity {

    Button quizButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);

        quizButton = (Button) findViewById(R.id.quizButton);


        quizButton.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(QuizMenu.this, Quiz.class);
                startActivity(intent);
            }});
           }
}

