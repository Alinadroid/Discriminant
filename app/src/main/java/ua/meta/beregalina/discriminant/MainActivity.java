package ua.meta.beregalina.discriminant;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

    private EditText A;
    private EditText B;
    private EditText C;
    private Button Clean;
    private Button Solve;
    private static final double ACCURACY = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        A = (EditText)findViewById(R.id.a);
        B = (EditText)findViewById(R.id.b);
        C = (EditText)findViewById(R.id.c);
        Clean = (Button)findViewById(R.id.cl);
        Solve = (Button)findViewById(R.id.sl);
        Clean.setOnClickListener(this);
        Solve.setOnClickListener(this);
        }
    @Override
    public void onClick(View v){
        if (v==Clean){
            A.setText("");
            B.setText("");
            C.setText("");
        }
        if (v==Solve){
            double a =0;
            double b =0;
            double c =0;
            double r1 =0;
            double r2 =0;
            try{
                a= Double.parseDouble(A.getText().toString());
                b= Double.parseDouble(B.getText().toString());
                c= Double.parseDouble(C.getText().toString());
            }
            catch (Exception e){
                Toast.makeText(this,R.string.note6, Toast.LENGTH_SHORT).show();
                return;
            }
            double D;
            D = b*b - 4 * a* c;
            if (D<0){
                Toast.makeText(this,R.string.note5, Toast.LENGTH_SHORT).show();
            }
            if (D==0){
                r1=Math.round(-b/2*a)*ACCURACY/ACCURACY;
                Toast.makeText(this,getString(R.string.note3)+r1, Toast.LENGTH_SHORT).show();
            }
            if (D>0);
            r1 = Math.round(-b+Math.sqrt(D)/2*a);
            r2 = Math.round(-b-Math.sqrt(D)/2*a);
            Toast.makeText(this, getString(R.string.note3)+"("+r1+"; "+r2+")",Toast.LENGTH_SHORT).show();

        }
    }

}
