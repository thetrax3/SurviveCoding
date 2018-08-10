package com.example.it.survivecoding.managers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.it.survivecoding.R;
import com.example.it.survivecoding.models.Account;

public class BankRegisterActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bank_register);

        findViewById(R.id.addBtn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Bank bank = Bank.newInstance();
        String id = ((EditText) findViewById(R.id.id_register_editText)).getText().toString();
        String pwd = ((EditText) findViewById(R.id.pwd_register_edit)).getText().toString();
        int balance = Integer.parseInt(((EditText) findViewById(R.id.balance_register_edit)).getText().toString());

        Account account = new Account(id, pwd, balance);
        bank.open(account);
        finish();
    }
}
