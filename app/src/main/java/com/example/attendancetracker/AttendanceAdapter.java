package com.example.attendancetracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class AttendanceAdapter extends ArrayAdapter<AttendanceData> {
    Context context;
    ArrayList<AttendanceData> attendanceData;
    public AttendanceAdapter(Context context,ArrayList<AttendanceData> attendanceData) {
        super(context,R.layout.custom_attendance_listview,attendanceData);
        this.context = context;
        this.attendanceData = attendanceData;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.custom_attendance_listview, parent,false);
        }
        TextView s_nameTxt = convertView.findViewById(R.id.s_nameTxt);
        TextView s_rollNoTxt = convertView.findViewById(R.id.s_rollNoTxt);
        TextView s_attStatusTxt = convertView.findViewById(R.id.s_attStatus);

        s_nameTxt.setText(attendanceData.get(position).getStudent_name());
        s_rollNoTxt.setText(attendanceData.get(position).getRoll_no());
        s_attStatusTxt.setText(attendanceData.get(position).getStatus());

        return convertView;
    }
}
