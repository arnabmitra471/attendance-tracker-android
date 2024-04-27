package com.example.attendancetracker;

public class AttendanceData {
    String student_name,roll_no,status;

    public AttendanceData(String student_name, String roll_no, String status) {
        this.student_name = student_name;
        this.roll_no = roll_no;
        this.status = status;
    }

    public AttendanceData() {
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
