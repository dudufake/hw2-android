package com.example.android.myapplication;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupReferences();
        btn.setEnabled(false);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start.setEnabled(false);
                btn.setEnabled(true);
                count = 0;
                new CountDownTimer(maxTime*1000, 1000) {
                    @Override
                    public void onTick(long l) {
                        timerTV.setText(l/1000 + "");
                    }

                    @Override
                    public void onFinish() {
                        btn.setEnabled(false);
                        start.setEnabled(true);
                    }
                }.start();
            }
        });
    }

    public void clicked(View view) {
        counterTV.setText(++count + "");
    }


    Button btn, start;
    TextView counterTV;
    TextView timerTV;
    int count = 0, maxTime = 30;

    private void setupReferences() {
        btn = findViewById(R.id.btn);
        start = findViewById(R.id.start);
        counterTV = findViewById(R.id.counter);
        timerTV = findViewById(R.id.timer);
    }
}
