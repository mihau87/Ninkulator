package pl.mihau.ninqiuz;

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


        // wykonanie po naciśnięciu
        button1.setOnClickListener((View.OnClickListener) this);
        button2.setOnClickListener((View.OnClickListener) this);
        button3.setOnClickListener((View.OnClickListener) this);
        button4.setOnClickListener((View.OnClickListener) this);
        button5.setOnClickListener((View.OnClickListener) this);
        button6.setOnClickListener((View.OnClickListener) this);
        button7.setOnClickListener((View.OnClickListener) this);
        button8.setOnClickListener((View.OnClickListener) this);
        button9.setOnClickListener((View.OnClickListener) this);
        minusButton.setOnClickListener((View.OnClickListener) this);
        plusButton.setOnClickListener((View.OnClickListener) this);
        countButton.setOnClickListener((View.OnClickListener) this);

    }

    public void countByClinck(View view)
    {
        int firstNum;
        int secondNum;
        int result;



        if (TextUtils.isEmpty(resultTextView.getText().toString()))
        {

            return;
    }
}}
