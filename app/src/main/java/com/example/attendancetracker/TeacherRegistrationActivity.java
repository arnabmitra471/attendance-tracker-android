package com.example.attendancetracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TeacherRegistrationActivity extends AppCompatActivity {

    EditText tnameTxt,temailTxt,tPassTxt,tConfPassTxt;
    Button registerBtn,regLoginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teacher_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tnameTxt = findViewById(R.id.tnameTxt);
        temailTxt = findViewById(R.id.temailTxt);
        tPassTxt = findViewById(R.id.tPassTxt);
        tConfPassTxt = findViewById(R.id.tConfPassTxt);
        registerBtn = findViewById(R.id.registerBtn);
        regLoginBtn = findViewById(R.id.reg_loginBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tName = tnameTxt.getText().toString();
                String tEmail = temailTxt.getText().toString();
                String tPassword = tPassTxt.getText().toString();
                String tConfPass = tConfPassTxt.getText().toString();

                if(tName.isEmpty() || tEmail.isEmpty() || tPassword.isEmpty() || tConfPass.isEmpty())
                {
                    Toast.makeText(TeacherRegistrationActivity.this,"All fields must be filled out",Toast.LENGTH_SHORT).show();
                }
                else if(!tPassword.equals(tConfPass))
                {
                    Toast.makeText(TeacherRegistrationActivity.this,"Passwords don't match",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    TeacherDbHelper dbHelper = new TeacherDbHelper(TeacherRegistrationActivity.this);

                    TeacherRegData regData = new TeacherRegData(tName,tEmail,tPassword,tConfPass);
                    long insertedId = dbHelper.addTeacher(regData);

                    if(insertedId > 0)
                    {
                        Toast.makeText(TeacherRegistrationActivity.this,"You have registered successfully",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(TeacherRegistrationActivity.this,"Unable to register",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        regLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teacherLoginIntent = new Intent(TeacherRegistrationActivity.this,MainActivity.class);
                startActivity(teacherLoginIntent);
            }
        });
    }
}