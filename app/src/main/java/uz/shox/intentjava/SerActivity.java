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

import uz.shox.intentjava.model.Member;
import uz.shox.intentjava.model.MyData;
import uz.shox.intentjava.model.User;

public class SerActivity extends AppCompatActivity {

    private TextView resultSer;
    private TextView returnObject;
    private Button objectSerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ser);
        initView();
        User user = new User(1,"Shahzod");

        MyData myData = (MyData) getIntent().getSerializableExtra("myData");
        resultSer.setText(myData.toString());

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            Member users =(Member) data.getSerializableExtra("users");
                            returnObject.setText(users.toString());
                        }
                    }
                });

        objectSerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SerActivity.this,ResultSerActivity.class);
                intent.putExtra("user",user);
                launcher.launch(intent);
            }
        });

    }

    public void initView(){
        resultSer=findViewById(R.id.resultSer);
        returnObject=findViewById(R.id.returnObject);

        objectSerBtn=findViewById(R.id.objectSerBtn);
    }
}