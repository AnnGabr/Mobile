package anngabr.androidlabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    Button bControl;
    EditText etInput;

    int number;
    boolean right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.textView);
        etInput = (EditText)findViewById(R.id.editText);
        bControl = (Button)findViewById(R.id.button);

        number = (int)(Math.random()*100);
        right = false;
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
                number = (int)(Math.random()*100);
                bControl.setText(R.string.input_value);
                tvInfo.setText(R.string.try_to_guess);
                right = false;
            }
        }
        catch (Exception ex){
            tvInfo.setText(R.string.error);
        }
    }
}
