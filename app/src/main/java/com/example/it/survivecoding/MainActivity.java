package com.example.it.survivecoding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

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
}
