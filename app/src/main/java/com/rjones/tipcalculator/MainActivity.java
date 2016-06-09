package com.rjones.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends AppCompatActivity implements OnEditorActionListener{

    //define instance variables
    private EditText billAmountText;
    private TextView percentText;
    private TextView tipText;
    private TextView totalText;

    private String billAmountString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get reference to the widgets
        billAmountText = (EditText) findViewById(R.id.billAmountText);
        percentText = (EditText) findViewById(R.id.percentText);
        tipText = (EditText) findViewById(R.id.tipText);
        totalText = (EditText) findViewById(R.id.totalText);

        // set the listener
        billAmountText.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE  ||
                actionId ==  EditorInfo.IME_ACTION_UNSPECIFIED){
            calculateAndDisplay();
        }
        return false;
    }

    private void calculateAndDisplay() {
        billAmountString = billAmountText.getText().toString();
        float billAmount;
        if(billAmountString.equals("")){
            billAmount = 0;
        }else{
            billAmount =Float.parseFloat(billAmountString);
        }

        // get discount percent
        float taxPercent = 0;
        if(billAmount >= 200){
            taxPercent = .2f;
        } else if(billAmount >= 100){
            taxPercent = .1f;
        }else{
            taxPercent = 0;
        }

        //

    }
}
