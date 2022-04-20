package uz.shox.intentjava;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import uz.shox.intentjava.model.Members;
import uz.shox.intentjava.model.MyData;
import uz.shox.intentjava.model.MyDatas;
import uz.shox.intentjava.model.User;
import uz.shox.intentjava.model.Users;

public class ParActivity extends AppCompatActivity {

    private TextView resultPar;
    private TextView returnObject;
    private Button objectParBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_par);
        initView();
        Users users = new Users(2,"Shahzod");

        MyDatas myDatas = (MyDatas) getIntent().getExtras().getParcelable("myDatas");
        resultPar.setText(myDatas.toString());


        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            Members members =(Members) data.getParcelableExtra("users");
                            returnObject.setText(members.toString());
                        }
                    }
                });

        objectParBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParActivity.this,ResultParActivity.class);
                intent.putExtra("user",users);
                launcher.launch(intent);
            }
        });
    }

    public void initView(){
        resultPar=findViewById(R.id.resultPar);
        returnObject=findViewById(R.id.returnObject);

        objectParBtn=findViewById(R.id.objectParBtn);
    }
}