package com.example.attendancetracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class AttendanceActivity extends AppCompatActivity {

    TextView dayTxt;
    ListView attendance_list;
    Button attAdd;

    ArrayList<AttendanceData> attendanceData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_attendance);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dayTxt = findViewById(R.id.dayTxt);
        attendance_list = findViewById(R.id.attendance_list);
        attAdd = findViewById(R.id.attAdd);
        Bundle bundle = getIntent().getExtras();

        dayTxt.setText(bundle.getString("Day"));


        AttendanceData d1 = new AttendanceData("Arnab Mitra","5","present");
        AttendanceData d2 = new AttendanceData("Belal Sardar","6","absent");
        AttendanceData d3 = new AttendanceData("Soumik Ghosh","33","present");
        AttendanceData d4 = new AttendanceData("Monalisa Gayen","25","present");
        AttendanceData d5 = new AttendanceData("Tirthamay Biswas","22","absent");

        attendanceData.add(d1);
        attendanceData.add(d2);
        attendanceData.add(d3);
        attendanceData.add(d4);
        attendanceData.add(d5);

        AttendanceAdapter attAdapter = new AttendanceAdapter(AttendanceActivity.this,attendanceData);
        attendance_list.setAdapter(attAdapter);

        attAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void showAddAttendanceDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(AttendanceActivity.this);
        View dialogView = getLayoutInflater().inflate(R.layout.add_attendance_dialog,null);
        builder.setView(dialogView);

        TextView dateTxt = dialogView.findViewById(R.id.dateTxt);
        EditText s_nameTxt = dialogView.findViewById(R.id.att_nameTxt);
        EditText s_rollNoTxt = dialogView.findViewById(R.id.att_rollNoTxt);
        Spinner attStatus = dialogView.findViewById(R.id.statusOpt);

    }
}