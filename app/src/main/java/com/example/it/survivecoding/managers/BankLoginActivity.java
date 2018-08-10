package com.example.it.survivecoding.managers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.it.survivecoding.R;
import com.example.it.survivecoding.models.Account;

public class BankLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mIdEditText;
    private EditText mPwdEditText;
    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.bank_login);

        mIdEditText = findViewById(R.id.bank_login_id_EditText);
        mPwdEditText = findViewById(R.id.bank_login_pwd_EditText);
        mResultTextView = findViewById(R.id.bank_login_accountInfo);
        findViewById(R.id.bank_loginBtn).setOnClickListener(this);
        findViewById(R.id.bank_login_closeBtn).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bank_loginBtn:
                Bank bank = Bank.newInstance();
                String id = mIdEditText.getText().toString();
                String pwd = mPwdEditText.getText().toString();
                Account account = bank.login(id, pwd);
                if (account != null) {
                    mResultTextView.setText(account.toString());
                }
                break;
            case R.id.bank_login_closeBtn:
                finish();
                break;
        }
    }
}
