package uz.shox.intentjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import uz.shox.intentjava.model.Member;
import uz.shox.intentjava.model.User;

public class ResultSerActivity extends AppCompatActivity {
    private Button exitSer;
    private TextView serResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_ser);
        initView();

        User user = (User) getIntent().getSerializableExtra("user");
        serResult.setText(user.toString());

        exitSer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToFinish();
            }
        });

    }
    void backToFinish(){
        Member member = new Member("Shahzod","Ro'zimboyev");
        Intent intent = new Intent();
        intent.putExtra("users",member);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }


    public void initView(){
        exitSer=findViewById(R.id.exitSer);
        serResult=findViewById(R.id.serResult);
    }
}