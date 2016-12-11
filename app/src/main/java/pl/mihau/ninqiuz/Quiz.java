package pl.mihau.ninqiuz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

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
    int life;
    int points;
    boolean newGameFlag = true;
    int goodAnswer;
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

        newGame(true);
        checkButton.setText("Rozpocznij \nNinquiz");



        checkButton.setOnClickListener (new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View view) {

                                                if (newGame(newGameFlag)) {
                                                    goodAnswer = randomEquation();
                                                    checkButton.setText("Sprawdź");
                                                    button0.setVisibility(View.VISIBLE);
                                                    button1.setVisibility(View.VISIBLE);
                                                    button2.setVisibility(View.VISIBLE);
                                                    button3.setVisibility(View.VISIBLE);
                                                    button4.setVisibility(View.VISIBLE);
                                                    button5.setVisibility(View.VISIBLE);
                                                    button6.setVisibility(View.VISIBLE);
                                                    button7.setVisibility(View.VISIBLE);
                                                    button8.setVisibility(View.VISIBLE);
                                                    button9.setVisibility(View.VISIBLE);
                                                    questionTextView.setVisibility(View.VISIBLE);
                                                    clearButton.setVisibility(View.VISIBLE);
                                                    lifeTextView.setVisibility(View.VISIBLE);
                                                    pointsTextView.setVisibility(View.VISIBLE);
                                                    pointsTextView.setText("Punkty: 0");
                                                    answerTextView.setVisibility(View.VISIBLE);
                                                    lifeTextView.setText("Życie: 3");
                                                    newGameFlag = false;
                                                }
                                                else {
                                                    if (TextUtils.isEmpty(answerTextView.getText().toString())) {
                                                        return;
                                                    } else {
                                                        checkAnswer(Integer.parseInt(answerTextView.getText().toString()), goodAnswer);

                                                    }                                                        if (checkWin(points) || checkLoose(life))
                                                    {
                                                        newGame(true);
                                                    }
                                                    else
                                                    {
                                                        goodAnswer = randomEquation();
                                                    }
                                                }

                                            }});

        clearButton.setOnClickListener (new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View view)
                                            {
                                                answerTextView.setText("");
                                                clearButton.setEnabled(true);
                                            }
                                        }
        );

        button0.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){

                                            answerTextView.append((button0.getText().toString()));
                                            clearButton.setEnabled(true);

                                        }
                                    }
        );

        button1.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){

                                            answerTextView.append((button1.getText().toString()));
                                            clearButton.setEnabled(true);

                                        }
                                    }
        );

        button2.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            answerTextView.append((button2.getText().toString()));
                                            clearButton.setEnabled(true);

                                        }
                                    }
        );

        button3.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            answerTextView.append((button3.getText().toString()));
                                            clearButton.setEnabled(true);

                                        }
                                    }
        );
        button4.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            answerTextView.append((button4.getText().toString()));
                                            clearButton.setEnabled(true);

                                        }
                                    }
        );
        button5.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            answerTextView.append((button5.getText().toString()));
                                            clearButton.setEnabled(true);

                                        }
                                    }
        );
        button6.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            answerTextView.append((button6.getText().toString()));
                                            clearButton.setEnabled(true);
                                        }
                                    }
        );
        button7.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            answerTextView.append((button7.getText().toString()));
                                            clearButton.setEnabled(true);
                                        }
                                    }
        );
        button8.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            answerTextView.append((button8.getText().toString()));
                                            clearButton.setEnabled(true);

                                        }
                                    }
        );
        button9.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            answerTextView.append((button9.getText().toString()));
                                            clearButton.setEnabled(true);
                                        }
                                    }
        );
    }
    public int randomEquation()
    {
        int goodAnswer = 22;
        answerTextView.setText("");
        while(goodAnswer > 20){
            Random r = new Random();
            int firstNum = r.nextInt(20 + 1);
            int secondNum = r.nextInt(20 + 1);
//        int firstNum = points +11;
//        int secondNum = 2;
            goodAnswer = firstNum + secondNum;
            questionTextView.setText(firstNum + " + " + secondNum + " = ?");
        }
        return goodAnswer;
    }

    public  void checkAnswer(int answer, int goodAnswer)
    {
        if (goodAnswer == answer) {
            points = points + 1;
            if (checkWin(points))
            {
                return;
            }
            else {
                pointsTextView.setText("Punkty: " + points);
            }
        }
            else
            {
                life = life - 1;
                if (checkLoose(life))
                {
                    return;
                }
                else {
                    lifeTextView.setText("Życie: " + life);
                }
            }
        }

    public boolean checkWin(int points)
    {
        if (points == 3)
        {
//            newGame(true);
            questionTextView.setVisibility(View.VISIBLE);
            questionTextView.setText("WYGRAŁAŚ!!!!!!!");
            return  true;
        }
        else
        {
            return false;
        }
    }

    public boolean checkLoose(int life)
    {
        if (life == 0) {
//            newGame(true);
            questionTextView.setVisibility(View.VISIBLE);
            questionTextView.setText("PRZEGRAŁAŚ :(");
            return true;
        }
            else
        {
            return false;
        }
    }

    public boolean newGame(boolean flag)
    {
        if (flag) {
            points = 0;
            life = 3;
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
            answerTextView.setText("");
            checkButton.setText("Rozpocznij nową grę");
            newGameFlag = true;
            return true;
        }
        else
        {
            return false;
        }
    }



    }

