package uz.shox.intentjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import uz.shox.intentjava.model.Member;
import uz.shox.intentjava.model.Members;
import uz.shox.intentjava.model.User;
import uz.shox.intentjava.model.Users;

public class ResultParActivity extends AppCompatActivity {
    private Button exitPar;
    private TextView parResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_par);
        initView();


        Users users = (Users) getIntent().getParcelableExtra("user");
        parResult.setText(users.toString());

        exitPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToFinish();
            }
        });

    }
    void backToFinish(){
        Members members = new Members("Shox","Shah");
        Intent intent = new Intent();
        intent.putExtra("users",members);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }

    public void initView(){
        exitPar=findViewById(R.id.exitPar);
        parResult=findViewById(R.id.parResult);
    }
}