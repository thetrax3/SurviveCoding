package com.example.it.survivecoding.managers;

import com.example.it.survivecoding.models.Account;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private static Bank sInstance = new Bank();

    //관리자
    private final static String ADMIN_ID = "admin";
    private final static String ADMIN_PWD = "admin";

    //사용자
    private List<Account> mAccountLIst;

    //싱글턴 패턴
    public static Bank newInstance() {
        return sInstance;
    }

    private Bank() {
        this.mAccountLIst = new ArrayList<>();
    }

    /**
     * @param account 개설할 계좌 정보
     */
    public void open(Account account) {

    }


    /**
     * 로그인
     *
     * @param id  아이디
     * @param pwd 패스워드
     * @return 없으면 null, 있으면 해당 계좌
     */
    public Account login(String id, String pwd) {
        return null;
    }

    /**
     * 관리자 계정 확인
     *
     * @param id
     * @param pwd
     * @return
     */
    public boolean isAdmin(String id, String pwd) {
        return false;
    }

    /**
     * 전체 계좌 정보를 얻기
     *
     * @return 전체 계좌 정보
     */
    public List<Account> getAccountList() {
        return mAccountLIst;
    }
}
