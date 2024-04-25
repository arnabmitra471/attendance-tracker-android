package com.example.attendancetracker;

public class TeacherRegData {
    private String tName,tEmail,tPass,tConfPass;


    public TeacherRegData() {
    }

    public TeacherRegData(String tName, String tEmail, String tPass, String tConfPass) {
        this.tName = tName;
        this.tEmail = tEmail;
        this.tPass = tPass;
        this.tConfPass = tConfPass;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettEmail() {
        return tEmail;
    }

    public void settEmail(String tEmail) {
        this.tEmail = tEmail;
    }

    public String gettPass() {
        return tPass;
    }

    public void settPass(String tPass) {
        this.tPass = tPass;
    }

    public String gettConfPass() {
        return tConfPass;
    }

    public void settConfPass(String tConfPass) {
        this.tConfPass = tConfPass;
    }
}
