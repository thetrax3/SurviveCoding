package com.example.it.survivecoding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    int i=0;
    private final int price= 4500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void subitOrder(View view){
        Log.d(TAG, "Btn");
        display(++i);
        displayPrice(i*price);
    }
    private void display(int number){
        TextView quantityTextView =
                (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }
    private void displayPrice(int number){
        TextView priceTextView
                = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
                                //$를 해당 국가의 화폐 단위로 변경
    }
}
