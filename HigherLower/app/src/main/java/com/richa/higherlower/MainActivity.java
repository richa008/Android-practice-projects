package com.richa.higherlower;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Integer randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomNumber = generateRandomNumber();
    }

    private Integer generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }

    public void guessNumber(View view) {
        EditText enteredNumber = (EditText)findViewById(R.id.number);
        String numStr = enteredNumber.getText().toString();

        if ("".equalsIgnoreCase(numStr)) {
            Toast.makeText(MainActivity.this, "Please enter a number!", Toast.LENGTH_SHORT).show();
            return;
        }

        Integer num = Integer.parseInt(numStr);

        if (num > randomNumber) {
            Toast.makeText(MainActivity.this, "Guess Lower", Toast.LENGTH_SHORT).show();
        } else if (num < randomNumber) {
            Toast.makeText(MainActivity.this, "Guess Higher", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "You are right!!! Generating new number", Toast.LENGTH_SHORT).show();
            randomNumber = generateRandomNumber();
        }
    }

}
