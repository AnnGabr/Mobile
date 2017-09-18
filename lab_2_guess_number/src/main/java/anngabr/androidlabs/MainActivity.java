package anngabr.androidlabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    TextView tvSeekBarProgress;
    Button bControl;
    EditText etInput;
    SeekBar sBar;

    int number;
    boolean right;
    int max_val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControls();
        setListeners();
        setValues();
    }

    public void setControls(){
        tvInfo = (TextView)findViewById(R.id.textView);
        etInput = (EditText)findViewById(R.id.editText);
        bControl = (Button)findViewById(R.id.button);
        sBar = (SeekBar)findViewById(R.id.seekBar);
        tvSeekBarProgress = (TextView)(findViewById(R.id.seekBarProgress));
    }

    public void setListeners(){
        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if(right == true) {
                    tvSeekBarProgress.setText(String.valueOf(progress));
                    max_val = progress;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    public void setValues(){
        max_val = sBar.getProgress();
        tvSeekBarProgress.setText(Integer.toString(max_val));
        ((TextView)(findViewById(R.id.tvStartVal))).setText(R.string.start_val);
        ((TextView)(findViewById(R.id.tvEndValue))).setText(R.string.end_val);
        number = (int)(Math.random()*max_val);
        right = true;
    }

    public void onClick(View v){
        try {
            if(!right){
                int assumption = Integer.parseInt(etInput.getText().toString());
                if(assumption > number)
                    tvInfo.setText(R.string.ahead);
                if(assumption < number)
                    tvInfo.setText(R.string.behind);
                if(assumption == number){
                    bControl.setText(R.string.play_more);
                    tvInfo.setText(R.string.hit);
                    right = true;
                }
            }
            else{
                number = (int)(Math.random()*max_val);
                bControl.setText(R.string.input_value);
                tvInfo.setText(R.string.try_to_guess);
                right = false;
            }
        }
        catch (Exception ex){
            tvInfo.setText(R.string.error);
        }
        etInput.setText(R.string.empty_string);
    }
}
