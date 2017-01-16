    package com.mihau.game.ninqiuz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.CheckBox;

public class QuizMenu extends AppCompatActivity {

    Button startQuizButton;
    RadioButton easyLevelRadio;
    RadioButton mediumLevelRadio;
    RadioButton hardLevelRadio;
    EditText playerNameEditText;
    CheckBox plusEquationCheckbox;
    CheckBox minusEquationCheckbox;
    int radioButtonFlag = 2;
    int equationFlag = 1;
    boolean errorFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);

        startQuizButton = (Button) findViewById(R.id.quizButton);
        easyLevelRadio = (RadioButton) findViewById(R.id.easyLevelRadio);

        mediumLevelRadio = (RadioButton) findViewById(R.id.mediumLevelRadio);
        mediumLevelRadio.setChecked(true);

        hardLevelRadio = (RadioButton) findViewById(R.id.hardLevelRadio);
        playerNameEditText = (EditText) findViewById(R.id.playerNameEditText);
        playerNameEditText.setFocusable(false);

        plusEquationCheckbox = (CheckBox) findViewById(R.id.plusEquationCheckbox);
        plusEquationCheckbox.setChecked(true);
        minusEquationCheckbox = (CheckBox) findViewById(R.id.minusEquationCheckbox);
        minusEquationCheckbox.setChecked(false);

        playerNameEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });

        easyLevelRadio.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View view){

                    radioButtonFlag = 1;


            }});
        mediumLevelRadio.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View view){

                radioButtonFlag = 2;


            }});
        hardLevelRadio.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View view){

                radioButtonFlag = 3;


            }});

        plusEquationCheckbox.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View view){

                if (plusEquationCheckbox.isChecked() && minusEquationCheckbox.isChecked()) {

                    equationFlag = 3;
                }
                else
                {
                    if (plusEquationCheckbox.isChecked() && !minusEquationCheckbox.isChecked())
                    {
                        equationFlag = 1;
                    }
                    if (!plusEquationCheckbox.isChecked() && !minusEquationCheckbox.isChecked())
                    {
                        equationFlag = 0;
                    }
                }

            }});

        minusEquationCheckbox.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View view){

                if (plusEquationCheckbox.isChecked() && minusEquationCheckbox.isChecked()) {

                    equationFlag = 3;
                }
                else
                {
                    if (!plusEquationCheckbox.isChecked() && minusEquationCheckbox.isChecked())
                    {
                        equationFlag = 1;
                    }
                    if (!plusEquationCheckbox.isChecked() && !minusEquationCheckbox.isChecked())
                    {
                        equationFlag = 0;
                    }
                }

            }});


        startQuizButton.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View view){

                if (TextUtils.isEmpty(playerNameEditText.getText().toString())) {

                    playerNameEditText.setFocusable(true);
                    playerNameEditText.setFocusableInTouchMode(true);
                    playerNameEditText.requestFocus();
//                    playerNameEditText.getText().toString().replace(" ");
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

                    //Informacja o nieuzupełnionym polu
                    TextInputLayout til = (TextInputLayout) findViewById(R.id.text_input_layout);
                    til.setErrorEnabled(true);
                    til.setError("Wpisz swoje imię");
                    errorFlag = true;
                }
                if (!plusEquationCheckbox.isChecked() && !minusEquationCheckbox.isChecked())
                {
                    generatePopup(1);
                    errorFlag = true;
                }
                if (equationFlag > 3 || equationFlag <0)
                {
                    generatePopup(0);
                    errorFlag = true;
                }
                else {
                    if (errorFlag == false){
                        errorFlag = true;
                        Intent intent = new Intent(QuizMenu.this, Quiz.class);
                        Bundle extras = new Bundle();
                        extras.putString("playerName", playerNameEditText.getText().toString());
                        extras.putInt("difficultyLevel", radioButtonFlag);
                        extras.putInt("equationType", equationFlag);
                        intent.putExtras(extras);
                        startActivity(intent);

                    }
                    else{
                        errorFlag = false;
                    return;
                    }
                }
                errorFlag = false;
            }});
           }

    AlertDialog dialog;
    String title;
    String message;
    public void generatePopup(int x) {


        switch (x){
        case 1:
        {
            title = "Bład";
            message = "Nie wybrałeś działania";
            break;
        }
        case 0:
        {
            title = "Uwaga";
            message = "Wystąpił błąd. Spróbuj ponownie";
            equationFlag = 3;
            plusEquationCheckbox.setChecked(true);
            minusEquationCheckbox.setChecked(true);

            break;
        }}

        AlertDialog.Builder popupMessage = new AlertDialog.Builder(this);
        popupMessage.setTitle(title);
        popupMessage.setMessage(message);
        popupMessage.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {

            }
        });
        popupMessage.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                closeContextMenu();
            }
        });
//        popupMessage.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
////                finish();
//            }
//        });
        dialog = popupMessage.create();
        dialog.show();

//        dialog.setCanceledOnTouchOutside(false);
    }
}