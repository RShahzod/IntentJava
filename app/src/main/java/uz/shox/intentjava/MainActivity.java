package uz.shox.intentjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import uz.shox.intentjava.model.MyData;
import uz.shox.intentjava.model.MyDatas;
import uz.shox.intentjava.model.User;

public class MainActivity extends AppCompatActivity {

    private Button firstTaskBtn, secondTaskBtn, threeTaskBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        MyData myData = new MyData(24,"Shahzod");
        MyDatas myDatas = new MyDatas(23,"Shahzod");



        firstTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("name","Shahzod");
                intent.putExtra("age",23);
                startActivity(intent);
            }
        });
        secondTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SerActivity.class);
                intent.putExtra("myData",myData);
                startActivity(intent);
            }
        });
        threeTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ParActivity.class);
                intent.putExtra("myDatas",myDatas);
                startActivity(intent);
            }
        });

    }
    public void initView(){
        firstTaskBtn=findViewById(R.id.firstTaskBtn);
        secondTaskBtn=findViewById(R.id.secondTaskBtn);
        threeTaskBtn=findViewById(R.id.threeTaskBtn);

    }
}