package com.example.flowers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class Updatedata extends AppCompatActivity implements View.OnClickListener {
    private EditText updatename;
    private EditText updatephone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedata);

        User user= (User) getIntent().getSerializableExtra("user");


        updatename=findViewById(R.id.updatename);
        updatephone=findViewById(R.id.updatephonenumber);


        updatename.setText(user.getName());
        updatephone.setText(user.getPhone());
        findViewById(R.id.updatebtn).setOnClickListener((View.OnClickListener) this);


    }

    private void UpdateInfodata() {

        String name = updatename.getText().toString().trim();
        String phone = updatephone.getText().toString().trim();

    }


    public void onClick(View v)
    {
        UpdateInfodata();
/*
        Switch (v.getId())
        {
            case R.id.updatebtn:
            UpdateInfodata();
            break;

        }*/
    }

}
