package com.example.it.survivecoding.managers;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.it.survivecoding.R;

public class BankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bank_activity);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_account:
                startActivity(new Intent(this, BankRegisterActivity.class));
                break;
            case R.id.open_account:
                startActivity(new Intent(this, BankLoginActivity.class));
                break;
            case R.id.admin_mode:
                showAdminDialog();
                break;
            case R.id.exitBtn:
                finish();
                break;
        }
    }

    private void showAdminDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_login, null, false);
        final EditText idEditText = view.findViewById(R.id.id_edit);
        final EditText pwdEditText = view.findViewById(R.id.pwd_edit);
        builder.setView(view);
        builder.setPositiveButton("로그인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String id = idEditText.getText().toString();
                String pwd = pwdEditText.getText().toString();

                Bank bank = Bank.newInstance();
                if (bank.isAdmin(id, pwd)) {
                    //관리자라면
                    startActivity(new Intent(BankActivity.this, AdminModeActivity.class));
                }
            }
        });
        builder.setNegativeButton("닫기", null);
        builder.show();
    }


}
