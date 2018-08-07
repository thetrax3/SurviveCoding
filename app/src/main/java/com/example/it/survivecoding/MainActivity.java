package com.example.it.survivecoding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private final int price= 4500;
    private int mQuantity = 0;
    private TextView quantityTextView;
    private TextView mPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView quantityTextView =
                findViewById(R.id.quantity_text_view);
        mPriceTextView = findViewById(R.id.price_text_view);
        findViewById(R.id.increaseBtn).setOnClickListener(this);
        findViewById(R.id.decreaseBtn).setOnClickListener(this);
    }

    public void subitOrder(View view){
        Log.d(TAG, "Btn");
        display(mQuantity);
        //displayPrice(mQuantity * price);
        String sPrice = NumberFormat.getCurrencyInstance().format(mQuantity * price);
        String priceMsg = "Total:" + sPrice + "\nThank you!";
        displayMsg(priceMsg);
    }
    private void display(int number){
        quantityTextView.setText(""+number);
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
        display(mQuantity);
        displayPrice(mQuantity * price);
    }

    private void Decrease() {
        if (mQuantity > 0) mQuantity--;
        else mQuantity = 0;
    }

    private void Increase() {
        mQuantity++;
    }
}
