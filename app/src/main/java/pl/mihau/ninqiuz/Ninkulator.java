package com.mihau.game.ninqiuz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Ninkulator extends AppCompatActivity {
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
    Button plusButton;
    Button minusButton;
    Button countButton;
    Button clearButton;
    TextView resultTextView;
    String sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninkulator);

        // określenie elementów w widoku
        resultTextView = (TextView) findViewById(R.id.resultTextView);
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
        plusButton = (Button) findViewById(R.id.plusButton);
        minusButton = (Button) findViewById(R.id.minusButton);
        countButton = (Button) findViewById(R.id.countButton);
        clearButton = (Button) findViewById(R.id.clearButton);

        countButton.setEnabled(false);

        // wykonanie po naciśnięciu
        button0.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){

                                            resultTextView.append((button0.getText().toString()));

                                        }
                                    }
        );

        button1.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View view){

                resultTextView.append((button1.getText().toString()));

            }
        }
        );

        button2.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            resultTextView.append((button2.getText().toString()));

                                        }
                                    }
        );

        button3.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            resultTextView.append((button3.getText().toString()));

                                        }
                                    }
        );
        button4.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            resultTextView.append((button4.getText().toString()));

                                        }
                                    }
        );
        button5.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            resultTextView.append((button5.getText().toString()));

                                        }
                                    }
        );
        button6.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            resultTextView.append((button6.getText().toString()));
                                        }
                                    }
        );
        button7.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            resultTextView.append((button7.getText().toString()));
                                        }
                                    }
        );
        button8.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            resultTextView.append((button8.getText().toString()));

                                        }
                                    }
        );
        button9.setOnClickListener (new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View view){
                                            resultTextView.append((button9.getText().toString()));
                                        }
                                    }
        );

        minusButton.setOnClickListener (new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View view){
                                              if (TextUtils.isEmpty(resultTextView.getText().toString())) {
                                                  resultTextView.setText("0-");
                                              }
                                              else
                                                {
                                                    resultTextView.append("-");
                                                }
                                                minusButton.setEnabled(false);
                                                countButton.setEnabled(true);
                                                plusButton.setEnabled(false);
                                                sign = "\\-";
                                            }
                                        }
        );

        plusButton.setOnClickListener (new View.OnClickListener()
                                       {
                                           @Override
                                           public void onClick(View view){
                                               if (TextUtils.isEmpty(resultTextView.getText().toString())) {
                                                   resultTextView.setText("0+");
                                                   }
                                               else
                                               {
                                                   resultTextView.append("+");
                                               }
                                               minusButton.setEnabled(false);
                                               plusButton.setEnabled(false);
                                               countButton.setEnabled(true);
                                               sign = "\\+";
                                           }
                                       }
        );

          countButton.setOnClickListener (new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View view)
                                        {

              String [] numbers = resultTextView.getText().toString().split(sign);
              int firstNum = Integer.parseInt(numbers[0]);
              int secondNum = Integer.parseInt(numbers[1]);
              if (TextUtils.isEmpty((resultTextView).getText().toString()))
                  return;
              else
              {
              if (sign.equals("+")) {
                  int result = firstNum + secondNum;
                  resultTextView.setText(String.valueOf(result));
              }
              else
                        {
                            int result = firstNum - secondNum;
                            resultTextView.setText(String.valueOf(result));
                        }
                  countButton.setEnabled(false);
                  button0.setEnabled(false);
                  button1.setEnabled(false);
                  button2.setEnabled(false);
                  button3.setEnabled(false);
                  button4.setEnabled(false);
                  button5.setEnabled(false);
                  button6.setEnabled(false);
                  button7.setEnabled(false);
                  button8.setEnabled(false);
                  button9.setEnabled(false);
              }
                                        }
                                        }
                                            );
        clearButton.setOnClickListener (new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View view)
                                            {

        resultTextView.setText("");
                                                countButton.setEnabled(false);
                                                plusButton.setEnabled(true);
                                                minusButton.setEnabled(true);
                                                button0.setEnabled(true);
                                                button1.setEnabled(true);
                                                button2.setEnabled(true);
                                                button3.setEnabled(true);
                                                button4.setEnabled(true);
                                                button5.setEnabled(true);
                                                button6.setEnabled(true);
                                                button7.setEnabled(true);
                                                button8.setEnabled(true);
                                                button9.setEnabled(true);
          }
                                        }
        );

}}
