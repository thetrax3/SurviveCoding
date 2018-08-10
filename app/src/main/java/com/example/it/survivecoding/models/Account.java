package com.example.it.survivecoding.models;

import java.util.Locale;

public class Account {
    private String id;
    private String pwd;
    private int balance;

    public Account(String id, String pwd, int balance) {
        this.id = id;
        this.pwd = pwd;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format(Locale.KOREA, "조회한 ID : %s\n조회한 계좌의 잔액 : %d\n", id, balance);
    }
}
