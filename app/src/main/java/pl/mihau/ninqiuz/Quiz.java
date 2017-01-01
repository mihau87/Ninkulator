package pl.mihau.ninqiuz;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import static pl.mihau.ninqiuz.R.layout.activity_quiz;

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
    TextView firstNumTextView;
    TextView secondNumTextView;
    TextView answerTextView;
    TextView equationSignTextView;
    TextView lifeTextView;
    TextView pointsTextView;
//    TextView blankTextView;
    int life;
    int points;
    int limit;
    boolean newGameFlag = true;
    int goodAnswer;
    int pointsToWin;
    String playerName;
//    Integer difficultyLevel;
    Integer equationType;
    String message;
    String title;
    Integer state;
    long startTime;
    long difference;
    double time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_quiz);

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
        secondNumTextView = (TextView) findViewById(R.id.secondNumTextView);
        firstNumTextView = (TextView) findViewById(R.id.firstNumTextView);
        checkButton = (Button) findViewById(R.id.checkButton);
        clearButton = (Button) findViewById(R.id.clearButton);
//        questionTextView = (TextView) findViewById(R.id.questionTextView);
        answerTextView = (TextView) findViewById(R.id.answerTextView);
        lifeTextView = (TextView) findViewById(R.id.lifeTextView);
        pointsTextView = (TextView) findViewById(R.id.pointsTextView);
        equationSignTextView = (TextView) findViewById(R.id.equationSignTextView);
        message = new String();
        title = new String();
        state = 1;

        getPreviousIntentData();

        generatePopup(state);

        checkButton.setOnClickListener (new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View view) {

        checkButton.setText("Sprawdź");

                                                if (newGame(newGameFlag)) {
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
                                                    checkButton.setVisibility(View.VISIBLE);
//                                                    questionTextView.setVisibility(View.VISIBLE);
                                                    clearButton.setVisibility(View.VISIBLE);
                                                    lifeTextView.setVisibility(View.VISIBLE);
                                                    pointsTextView.setVisibility(View.VISIBLE);
                                                    pointsTextView.setText("Punkty: 0");
                                                    answerTextView.setVisibility(View.VISIBLE);
                                                    firstNumTextView.setVisibility(View.VISIBLE);
                                                    secondNumTextView.setVisibility(View.VISIBLE);
                                                    lifeTextView.setText("Życie: " + life);
                                                    goodAnswer = randomEquation();
                                                    newGameFlag = false;

                                                    //uruchamianie licznika czasu
                                                    startTime = System.currentTimeMillis();
                                                }
                                                else {
                                                    if (answerTextView.getText().toString().length() >5)
                                                    {
                                                                new AlertDialog.Builder(Quiz.this)
                                                                        .setTitle("Ja Cię smolę!")
                                                                        .setMessage("Popraw odpowiedź, bo jest za długa")
                                                                        .show();
                                                    }
                                                    else
                                                    {

                                                    if (TextUtils.isEmpty(answerTextView.getText().toString())) {
                                                        return;
                                                    } else {
                                                        checkAnswer(Integer.parseInt(answerTextView.getText().toString()), goodAnswer);
//                                                          checkAnswer(answer, goodAnswer);
                                                    }

                                                    if (checkWin(points) || checkLoose(life))
                                                    {
                                                     //   newGame(true);
                                                    }
                                                    else
                                                    {
                                                        goodAnswer = randomEquation();
                                                    }

                                                    }
                                                }

                                            }});

        clearButton.setOnClickListener (new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View view)
                                            {
                                                String answer = answerTextView.getText().toString();
                                                if (answer.length() == 0) {
                                                    answerTextView.setText(answer);
                                                }
                                                else {
                                                    answerTextView.setText(answer.substring(0, answer.length() - 1));

                                                }
                                                    clearButton.setEnabled(true);
                                            }
                                        }
        );

        button0.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){

                                            String answer = answerTextView.getText().toString();
                                            if (TextUtils.isEmpty(answer))
                                            {
                                                answerTextView.append((button0.getText().toString()));
                                            }
                                            else {
                                                if (Integer.parseInt(answer) == 0) {
                                                    answerTextView.setText("0");
                                                } else {
                                                    answerTextView.append((button0.getText().toString()));
                                                }
                                                clearButton.setEnabled(true);
                                            }

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
        answerTextView.setText("");

        switch (state)
        {
            case 1:
                limit = 20;
                goodAnswer = limit +3;
                break;
            case 2:
                limit = 40;
                goodAnswer = limit +3;
                break;
            case 3:
                limit = 70;
                goodAnswer = limit +3;
                break;

        }


        int firstNum = 5;
        int secondNum = 5;


        if (equationType == 1)
        {
            equationSignTextView.setText("+");
                    while (goodAnswer > limit || (firstNum < 4 || secondNum < 4))
                    {
                    Random r = new Random();
                    firstNum = r.nextInt(limit + 1);
                    secondNum = r.nextInt(limit + 1);
                    goodAnswer = firstNum + secondNum;
                    firstNumTextView.setText(Integer.toString(firstNum));
                    secondNumTextView.setText(Integer.toString(secondNum));
//                    questionTextView.setText(firstNum + " + " + secondNum + " = ?");
                    }
            return goodAnswer;
        }

        if (equationType == 2)
        {
            equationSignTextView.setText("-");
                    while (goodAnswer > limit || goodAnswer<0) {
                        Random r = new Random();
                        firstNum = r.nextInt(limit + 1);
                        secondNum = r.nextInt(limit + 1);
                        goodAnswer = firstNum - secondNum;
                        firstNumTextView.setText(Integer.toString(firstNum));
                        secondNumTextView.setText(Integer.toString(secondNum));
                    }
                        return goodAnswer;
        }
        else
        {
            Random r = new Random();
            int random = r.nextInt(1+1);
            if (random == 1)
            {
                while (goodAnswer > limit || (firstNum < 4 || secondNum < 4))
                {
                    equationSignTextView.setText("+");
                    r = new Random();
                    firstNum = r.nextInt(limit + 1);
                    secondNum = r.nextInt(limit + 1);
                    goodAnswer = firstNum + secondNum;
                    firstNumTextView.setText(Integer.toString(firstNum));
                    secondNumTextView.setText(Integer.toString(secondNum));
//                    questionTextView.setText(firstNum + " + " + secondNum + " = ?");
                }
            }
            else
            {
                equationSignTextView.setText("-");
                while (goodAnswer > limit || goodAnswer<0) {
                    r = new Random();
                    firstNum = r.nextInt(limit + limit + 1);
                    secondNum = r.nextInt(limit + limit + 1);
                    goodAnswer = firstNum - secondNum;
                    firstNumTextView.setText(Integer.toString(firstNum));
                    secondNumTextView.setText(Integer.toString(secondNum));
//                    questionTextView.setText(firstNum + " - " + secondNum + " = ?");
                }
            }



            return goodAnswer;
        }


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
        switch (state) {
            case 1:
                pointsToWin = 10;
                break;
            case 2:
                pointsToWin = 20;
                break;
            case 3:
                pointsToWin = 20;
                break;
        }

        if (points == pointsToWin)
        {
            //zatrzymanie czasu
            difference = System.currentTimeMillis() - startTime;
            time = difference/1000;
            generatePopup(4);
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
            //zatrzymanie czasu
            difference = System.currentTimeMillis() - startTime;
            time = difference/1000;
            generatePopup(5);
            return true;
        }
            else
        {
            return false;
        }
    }

    public void getPreviousIntentData(){
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        playerName = extras.getString("playerName");
        state = extras.getInt("difficultyLevel");
        equationType = extras.getInt("equationType");
    }

    AlertDialog dialog;
    boolean noFinish = false;
    public void generatePopup(int state) {
        clearScreen();

        switch (state) {
            // Nowa gra łatwy poziom
            case 1:
                message = "Wybrałeś poziom łatwy\nMusisz zdobyć 10 punktów";
                title = ", witaj w NinQuiz";
                break;
            // Nowa gra średni poziom
            case 2:
                message = "Wybrałeś poziom średni\nMusisz zdobyć 20 punktów";
                title = ", witaj w NinQuiz";
                break;
            // Nowa gra trudny poziom
            case 3:
                message = "Wybrałeś poziom trudny\nMusisz zdobyć 30 punktów";
                title = ", witaj w NinQuiz";
                break;
            // wygrana
            case 4:
                message = "Gratuluję wygrałeś!\nZajęło Ci to: " + time + "s\nGrasz ponownie?";
                title = "! :)";
                break;
            // przegrana
            case 5:
                message = "Niestety przegrałeś\nZajęło Ci to: " + time + "s\nGrasz ponownie?";
                title = " :(";
                break;
        }
        noFinish = false;
        AlertDialog.Builder popupMessage = new AlertDialog.Builder(this);
        popupMessage.setTitle(playerName + title);
        popupMessage.setMessage(message.replace(".0", ""));
        popupMessage.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (!noFinish)
                finish();
            }
        });
        popupMessage.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                checkButton.callOnClick();
                noFinish = true;
            }
        });
        popupMessage.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
//                finish();
            }
        });
//        popupMessage.setCancelable(false);
        dialog = popupMessage.create();
        dialog.show();

        dialog.setCanceledOnTouchOutside(false);

        newGame(true);
    }


    public void clearScreen(){
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
//        questionTextView.setVisibility(View.INVISIBLE);
        checkButton.setVisibility(View.INVISIBLE);
    }

    public boolean newGame(boolean flag)
    {
        if (flag) {
            points = 0;
            switch (state) {
                case 1:
                    life = 3;
                    break;
                case 2:
                    life = 2;
                    break;
                case 3:
                    life = 1;
                    break;
            }
            newGameFlag = true;
            return true;
        }
        else
        {
            return false;
        }
    }



    }

