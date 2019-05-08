package index1.developer.acadview.com.taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IncomeActivity extends AppCompatActivity {

    EditText et;
    TextView tx;
    TextView tx1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        et=(EditText)findViewById(R.id.edit1);
        tx=(TextView)findViewById(R.id.text1);
        tx1=(TextView)findViewById(R.id.text2);
        b1=(Button)findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 calculate();
            }
        });
    }


    public void calculate()
    {
        long Net = 0;
        long Tax=0;
        long input;
        if(et.getText().toString().isEmpty()){
            tx1.setText("Income field cannot be empty");
        }
        else if(et.getText().toString().length()>18){
            tx1.setText("Please input the income < 999999999999999999");
        }
        else {
            int in = Integer.parseInt(et.getText().toString());
            if (in >= 1000000) {
                input = in - 1000000;
                Tax = (input / 100 ) * 30 + (500000 * 20) / 100 + (250000 * 5) / 100;
                Net = in - Tax;
            } else if (in >= 500000 && in < 1000000) {
                input = in - 500000;
                Tax = (input * 20) / 100 + (250000 * 5) / 100;
                Net = in - Tax;
            } else if (in >= 250000 && in < 500000) {
                input = in - 250000;
                Tax = (input * 5) / 100;
                Net = in - Tax;
            } else {
                Net = in;
            }
            tx1.setText("Tax on your income " + et.getText() + "= \t" + Tax + "\n \n" +
                    "Net Income (Exclusive of Tax) " + "= \t" + Net);
        }
    }
}
