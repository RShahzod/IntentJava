package uz.shox.intentjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    private TextView resultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();


        String name = getIntent().getStringExtra("name");
        int age = getIntent().getIntExtra("age", 0);
        resultTxt.setText(name + " : " + age);

    }

    public void initView() {

        resultTxt = findViewById(R.id.resultTxt);

    }
}