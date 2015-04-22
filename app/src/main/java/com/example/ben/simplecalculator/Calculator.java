package com.example.ben.simplecalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Calculator extends ActionBarActivity {

    CharSequence currValue = null;
    int currValInt = 0;
    int prevValue = 0;
    // Tells us which operation to do
    // 0 Add, 1 Sub, 2 Mult, 3 Div, 4 x^2
    int operation = 0;

    // Tells us if there's more than one operand
    boolean multOperand = false;

    EditText calc_disp;

    /** Called when user clicks the Calculator button */
    public void calculate(View v) {
        switch(v.getId()) {
            // Numbers
            case R.id.button_7:
                generateDispText("7");
                calc_disp.setText(currValue);
                break;
            case R.id.button_8:
                generateDispText("8");
                calc_disp.setText(currValue);
                break;
            case R.id.button_9:
                generateDispText("9");
                calc_disp.setText(currValue);
                break;
            case R.id.button_4:
                generateDispText("4");
                calc_disp.setText(currValue);
                break;
            case R.id.button_5:
                generateDispText("5");
                calc_disp.setText(currValue);
                break;
            case R.id.button_6:
                generateDispText("6");
                calc_disp.setText(currValue);
                break;
            case R.id.button_1:
                generateDispText("1");
                calc_disp.setText(currValue);
                break;
            case R.id.button_2:
                generateDispText("2");
                calc_disp.setText(currValue);
                break;
            case R.id.button_3:
                generateDispText("3");
                calc_disp.setText(currValue);
                break;
            case R.id.button_0:
                generateDispText("0");
                calc_disp.setText(currValue);
                break;

            // Functions
            case R.id.button_C:
                generateDispText("C");
                multOperand = false;
                prevValue = 0;
                currValInt = 0;
                operation = 0;
                calc_disp.setText(currValue);
                break;
            case R.id.button_equal:
                currValInt = Integer.parseInt(currValue.toString());

                if (operation == 0)
                    currValInt += prevValue;
                else if (operation == 1)
                    currValInt = prevValue - currValInt;
                else if (operation == 2)
                    currValInt *= prevValue;
                else if (operation == 3)
                    currValInt = prevValue / currValInt;
                else if (operation == 4) {
                    currValInt = exponent(prevValue, currValInt);
                }

                currValue = String.valueOf(currValInt);
                prevValue = 0;

                calc_disp.setText(currValue);
                break;

            case R.id.button_plus:
                multOperand = true;
                prevValue = Integer.parseInt(currValue.toString());
                currValue = null;
                operation = 0;
                break;
            case R.id.button_minus:
                multOperand = true;
                prevValue = Integer.parseInt(currValue.toString());
                currValue = null;
                operation = 1;
                break;
            case R.id.button_multiply:
                multOperand = true;
                prevValue = Integer.parseInt(currValue.toString());
                currValue = null;
                operation = 2;
                break;
            case R.id.button_divide:
                multOperand = true;
                prevValue = Integer.parseInt(currValue.toString());
                currValue = null;
                operation = 3;
                break;
            case R.id.button_pow:
                multOperand = true;
                prevValue = Integer.parseInt(currValue.toString());
                currValue = null;
                operation = 4;
                break;

            default:
                throw new RuntimeException("Unknown button ID");

        }
    }

    /** Handles the calculation of exponents, x^y */
    int exponent(int x, int y) {
        int ans = x;
        for (int i = 1; i < y; i++)
            ans *= x;
        return ans;
    }

    /** Alters the currValue CharSequence appropriately */
    public void generateDispText(CharSequence c) {
        if ((currValue == null || currValue == "0") && c != "C") {
            currValue = (CharSequence)c;
        } else if (c == "C") {
            currValue = "0";
        } else {
            currValue = currValue.toString() + c;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        calc_disp = (EditText)findViewById(R.id.calc_disp);
        calc_disp.setText("0");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
