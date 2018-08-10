package com.example.it.survivecoding.coffeeApp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.it.survivecoding.R;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private final int price= 4500;
    private int mQuantity = 0;
    private TextView quantityTextView;
    private TextView mPriceTextView;
    private CheckBox topping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityTextView = findViewById(R.id.quantity_text_view);
        mPriceTextView = findViewById(R.id.price_text_view);
        findViewById(R.id.increaseBtn).setOnClickListener(this);
        findViewById(R.id.decreaseBtn).setOnClickListener(this);
        topping = findViewById(R.id.topping_checkbox);
    }

    public void subitOrder(View view){
        String tName = "Name: PJH";
        String tQuantity = "Quantity:" + mQuantity;
        String tPrice = "Total:" + NumberFormat.
                getCurrencyInstance().format(mQuantity * price);

        String mTopping;
        if (topping.isChecked()) {
            mTopping = "Topping:+$500";
            tPrice = "Total:" + NumberFormat.
                    getCurrencyInstance().format(mQuantity * price + 500);
        } else mTopping = "Topping:+$0";

        String tMsg =
                tName + "\n" +
                        tQuantity + "\n" +
                        mTopping + "\n" +
                        tPrice + "\n" +
                        "Thank you!";

        displayMsg(tMsg);

        /* 전화걸기
        Uri uri =Uri.parse("tel:01034243814");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);*/
        String[] addresses = new String[]{"thetrax5@naver.com"};
        composeEmail(addresses, "title:mail test", null, tMsg);
    }

    public void composeEmail(String[] addresses, String subject, Uri attachment, String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_STREAM, attachment);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    private void display(int number){
        quantityTextView.setText("" + number);//
    }

    private void displayPrice(int number){
        mPriceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
        //$를 해당 국가의 화폐 단위로 변경
    }

    private void displayMsg(String msg) {
        mPriceTextView.setText(msg);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.increaseBtn:
                Increase();
                break;

            case R.id.decreaseBtn:
                Decrease();
                break;
        }
        display(mQuantity);//
        displayPrice(mQuantity * price);
    }

    private void Decrease() {
        if (mQuantity > 0) mQuantity--;
        else mQuantity = 0;
    }

    private void Increase() {
        mQuantity++;
    }

    //메뉴를 붙이는 부분
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                Toast.makeText(this, "설정 미구현", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_menu2:
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
