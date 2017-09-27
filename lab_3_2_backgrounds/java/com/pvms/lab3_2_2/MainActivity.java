package com.pvms.lab3_2_2;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button apply = (Button) findViewById(R.id.buttonApply);

        apply.setOnClickListener(new View.OnClickListener() {
            SeekBar sbRed = (SeekBar)findViewById(R.id.seekBarRed);
            SeekBar sbBlue = (SeekBar)findViewById(R.id.seekBarBlue);
            SeekBar sbGreen = (SeekBar)findViewById(R.id.seekBarGreen);
            @Override
            public void onClick(View v) {
                v.getRootView().setBackgroundColor(Color.rgb(sbRed.getProgress(), sbBlue.getProgress(), sbGreen.getProgress()));
            }
        });
    }
}
