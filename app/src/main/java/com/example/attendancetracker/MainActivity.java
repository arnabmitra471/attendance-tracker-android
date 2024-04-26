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

public class MainActivity extends AppCompatActivity {

    EditText usernameTxt,passwordTxt;
    Button loginBtn,login_regBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        usernameTxt = findViewById(R.id.usernameTxt);
        passwordTxt = findViewById(R.id.passwordTxt);
        loginBtn = findViewById(R.id.loginBtn);
        login_regBtn = findViewById(R.id.login_regBtn);

        login_regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teacherRegIntent = new Intent(MainActivity.this,TeacherRegistrationActivity.class);
                startActivity(teacherRegIntent);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeacherDbHelper dbHelper = new TeacherDbHelper(MainActivity.this);

                String email = usernameTxt.getText().toString();
                String password = passwordTxt.getText().toString();

                if(email.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Both email and password are required",Toast.LENGTH_SHORT).show();
                    return;
                }
                TeacherRegData teacherData = dbHelper.fetchTeacherData(email);

                if(teacherData != null)
                {
                    if(teacherData.gettPass().equals(password))
                    {
                        Toast.makeText(MainActivity.this,"Logged in Successfully",Toast.LENGTH_SHORT).show();
                        Intent dayListIntent = new Intent(MainActivity.this,AttendanceDayListActivity.class);
                        startActivity(dayListIntent);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"Please check your credentials",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this,R.string.unregistered_teacher,Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}