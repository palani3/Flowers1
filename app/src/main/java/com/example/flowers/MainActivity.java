package com.example.flowers;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button daily,viewsummary;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        floatingActionButton=findViewById(R.id.floatadd);
        //register=(Button)findViewById(R.id.Registation);
        daily=(Button)findViewById(R.id.Daily);
        viewsummary=(Button)findViewById(R.id.summary);

        daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dailyactivity();

            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                another();
            }
        });





    }



    public void another()
    {
        Intent intent=new Intent(this,Register.class);
        startActivity(intent);

    }


    public void Dailyactivity()
    {
        Intent intent=new Intent(this,SearchActivity.class);
        startActivity(intent);
    }
    /*
    public void onClick(View view)
    {
        Intent intent= new Intent(this,Register.class);
        startActivity(intent);
    }*/

}

