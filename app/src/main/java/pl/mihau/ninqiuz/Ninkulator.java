package pl.mihau.ninqiuz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Ninkulator extends AppCompatActivity {
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
    TextView resultTextView;
    String sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninkulator);

        // określenie elementów w widoku
        resultTextView = (TextView) findViewById(R.id.resultTextView);
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

        countButton.setEnabled(false);

        // wykonanie po naciśnięciu
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
                                                sign = "-";
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
                                               sign = "+";
                                           }
                                       }
        );

          countButton.setOnClickListener (new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View view)
                                        {

              String [] numbers = resultTextView.getText().toString().split(sign);


              int firstNum = Integer.parseInt(numbers[1]);
              int secondNum = Integer.parseInt(numbers[2]);
              if (sign.equals("+"))
              {
                            int result = firstNum + secondNum;
                  resultTextView.setText(String.valueOf(result));
              }
              else
                        {
                            int result = firstNum + secondNum;
                            resultTextView.setText(String.valueOf(result));
                        }


                                        }
                                        }
                                            );

}}
