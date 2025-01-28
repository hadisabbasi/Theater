package com.github.hadisabbasi.theater;

public class Account {
    private final int userId;
    private String userName;
    private int pass;
    private boolean isDeleted;
    private static int ID = 100;

    public Account() {
        this("null", 0);
    }

    public Account(String userName, int pass) {
        this.userName = userName;
        this.pass = pass;
        this.userId = ID;
        this.isDeleted = false;
        ID++;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}


