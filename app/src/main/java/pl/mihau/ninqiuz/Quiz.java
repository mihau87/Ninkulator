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
    int life = 3;
    int points = 0;
    int startFlag = 0;

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


        checkButton.setOnClickListener (new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View view)
                                            {

        if (startFlag == 0){

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
            clearButton.setVisibility(View.VISIBLE);
            clearButton.setEnabled(false);
            lifeTextView.setVisibility(View.VISIBLE);
            pointsTextView.setVisibility(View.VISIBLE);
            answerTextView.setVisibility(View.VISIBLE);

           // randomEquation();
            int goodAnswer = 21;
            do{
                Random r = new Random();
                int firstNum = r.nextInt(20 + 1);
                int secndNum = r.nextInt(20 + 1);

                goodAnswer = firstNum + secndNum;

                questionTextView.setText(firstNum + " + " + secndNum + " = ?");

        }while(goodAnswer > 20 || goodAnswer < 0);
        }
        else {
            return;
        }                                   }
                                        }
        );

        clearButton.setOnClickListener (new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View view)
                                            {

                                                answerTextView.setText("");
                                            }
                                        }
        );

        button0.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){

                                            answerTextView.append((button0.getText().toString()));

                                        }
                                    }
        );

        button1.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){

                                            answerTextView.append((button1.getText().toString()));

                                        }
                                    }
        );

        button2.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            answerTextView.append((button2.getText().toString()));

                                        }
                                    }
        );

        button3.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            answerTextView.append((button3.getText().toString()));

                                        }
                                    }
        );
        button4.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            answerTextView.append((button4.getText().toString()));

                                        }
                                    }
        );
        button5.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            answerTextView.append((button5.getText().toString()));

                                        }
                                    }
        );
        button6.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            answerTextView.append((button6.getText().toString()));
                                        }
                                    }
        );
        button7.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            answerTextView.append((button7.getText().toString()));
                                        }
                                    }
        );
        button8.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            answerTextView.append((button8.getText().toString()));

                                        }
                                    }
        );
        button9.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            answerTextView.append((button9.getText().toString()));
                                        }
                                    }
        );



//        public boolean checkWin(int currentPoint)
//        {
//            if (currentPoint == 10)
//            {
//               return true;
//            }
//            else
//            {
//               return false;
//            }
//        };
//
//    public boolean checkLoose(int currentLife)
//    {
//        if (currentLife == 0)
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//    };

//        public int randomEquation()
//        {
//            int goodQuestion = 0;
//            while(goodQuestion > 20 || goodQuestion < 0) {
//                Random r = new Random();
//                int firstNum = r.nextInt(20 + 1);
//                int secndNum = r.nextInt(20 + 1);
//
//                goodQuestion = firstNum + secndNum;
//            }
//            return goodQuestion;
//        };

    }


    }

