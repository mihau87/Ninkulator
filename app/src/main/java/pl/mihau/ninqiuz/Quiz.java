package pl.mihau.ninqiuz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Quiz extends AppCompatActivity {

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button checkButton;
    Button clearButton;
    TextView answerTextView;
    TextView questionTextView;
    TextView lifeTextView;
    TextView pointsTextView;
    int life = 3;
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        checkButton = (Button) findViewById(R.id.checkButton);
        clearButton = (Button) findViewById(R.id.clearButton);
        questionTextView = (TextView) findViewById(R.id.questionTextView);
        answerTextView = (TextView) findViewById(R.id.answerTextView);
        lifeTextView = (TextView) findViewById(R.id.lifeTextView);
        pointsTextView = (TextView) findViewById(R.id.pointsTextView);

        checkButton.setText("Rozpocznij \nNinquiz");
        button0.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        button4.setVisibility(View.INVISIBLE);
        button5.setVisibility(View.INVISIBLE);
        button6.setVisibility(View.INVISIBLE);
        button7.setVisibility(View.INVISIBLE);
        button8.setVisibility(View.INVISIBLE);
        button9.setVisibility(View.INVISIBLE);
        clearButton.setVisibility(View.INVISIBLE);
        lifeTextView.setVisibility(View.INVISIBLE);
        pointsTextView.setVisibility(View.INVISIBLE);
        answerTextView.setVisibility(View.INVISIBLE);
}
}
