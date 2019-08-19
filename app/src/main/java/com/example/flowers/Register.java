package com.example.flowers;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;

public class Register extends AppCompatActivity {
    private EditText editblock,editname,editphone,editprice;
    DatePickerDialog picker;
    private Button btnregister;
    private EditText Calender;
    private ImageView imageView;

    FirebaseFirestore db=FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Calender=(EditText)findViewById(R.id.calender);

        Calender.setInputType(InputType.TYPE_NULL);
        Calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog

                picker= new DatePickerDialog(Register.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthofYear, int dayofmonth) {
                        Calender.setText(dayofmonth+"/"+(monthofYear+1)+"/"+year);

                    }
                },year,month,day);
                picker.show();
            }
        });

        /*editdate=(EditText)findViewById(R.id.calender);

        editdate.setInputType(InputType.TYPE_NULL);
        editdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                picker=new DatePickerDialog(Register.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthofyear, int dayofmonth) {


                    }
                },year,month,day);
            }
        });
    */


        //imageView=findViewById(R.id.imageview);
        editblock=findViewById(R.id.Block);
        editname=findViewById(R.id.Name);
        editphone=findViewById(R.id.Phone);
        editprice=findViewById(R.id.Price);

        Calender=(EditText)findViewById(R.id.calender);
        btnregister=findViewById(R.id.Register);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User users=new User(editblock.getText().toString(),editname.getText().toString(),editphone.getText().toString(),editprice.getText().toString(),Calender.getText().toString());
                db.collection("Users").add(users);
                /*if (users!=null) {
                    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                    try {
                        BitMatrix bitMatrix = multiFormatWriter.encode(String.valueOf(users.toString().trim()), BarcodeFormat.QR_CODE, 500, 500);
                        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                        imageView.setImageBitmap(bitmap);
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }
                }*/

                Toast.makeText(Register.this,"Successful Registered",Toast.LENGTH_LONG).show();
                // barcodegenerate();


            }
        });








    }
    public void barcodegenerate()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }




}
