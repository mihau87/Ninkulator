package pl.mihau.ninqiuz;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.CheckBox;

public class QuizMenu extends AppCompatActivity {

    Button quizButton;
    RadioButton easyLevelRadio;
    RadioButton mediumLevelRadio;
    RadioButton hardLevelRadio;
    EditText playerNameEditText;
    CheckBox plusEquationCheckbox;
    CheckBox minusEquationCheckbox;
    int radioButtonFlag = 2;
    int equationFlag = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);

        quizButton = (Button) findViewById(R.id.quizButton);
        easyLevelRadio = (RadioButton) findViewById(R.id.easyLevelRadio);

        mediumLevelRadio = (RadioButton) findViewById(R.id.mediumLevelRadio);
        mediumLevelRadio.setChecked(true);

        hardLevelRadio = (RadioButton) findViewById(R.id.hardLevelRadio);
        playerNameEditText = (EditText) findViewById(R.id.playerNameEditText);
        playerNameEditText.setFocusable(false);

        plusEquationCheckbox = (CheckBox) findViewById(R.id.plusEquationCheckbox);
        plusEquationCheckbox.setChecked(true);
        minusEquationCheckbox = (CheckBox) findViewById(R.id.minusEquationCheckbox);
        minusEquationCheckbox.setChecked(true);


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

                if (plusEquationCheckbox.isChecked()) {

                    equationFlag = equationFlag + 1;
                }
                else
                {
                    equationFlag = equationFlag - 1;
                }

            }});

        minusEquationCheckbox.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View view){

                if (plusEquationCheckbox.isChecked()) {

                    equationFlag = equationFlag + 2;
                }
                else
                {
                    equationFlag = equationFlag - 2;
                }

            }});

        quizButton.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                if (TextUtils.isEmpty(playerNameEditText.getText().toString())) {

                    playerNameEditText.setFocusable(true);
                    playerNameEditText.setFocusableInTouchMode(true);
                    playerNameEditText.requestFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

                    //Informacja o nieuzupełnionym polu
                    TextInputLayout til = (TextInputLayout) findViewById(R.id.text_input_layout);
                    til.setErrorEnabled(true);
                    til.setError("Wpisz swoje imię");
                }
                else {
                    Intent intent = new Intent(QuizMenu.this, Quiz.class);
                    Bundle extras = new Bundle();
                    extras.putString("playerName", playerNameEditText.getText().toString());
                    extras.putInt("difficultyLevel", radioButtonFlag);
                    extras.putInt("equationType", equationFlag);
                    intent.putExtras(extras);
                    startActivity(intent);
                }
            }});
           }
}