package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whipperCreamCheckBox = (CheckBox) findViewById(R.id.whipperCream);
        boolean hasWhipperCream = whipperCreamCheckBox.isChecked();
        //Log.v("MainActivity","has Whipper Cream"+haswhipperCream);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        EditText nameFile = (EditText) findViewById(R.id.name_view);
        String name = nameFile.getText().toString();
        int price = calculatePrice(quantity,hasWhipperCream,hasChocolate);

        String orderSummary = createOrderSummary(name,price,hasWhipperCream,hasChocolate);
        //displayMessage(orderSummary);
       // public void composeEmail(String[] addresses, String subject, Uri attachment) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_summary_email_subject));
        intent.putExtra(Intent.EXTRA_TEXT, orderSummary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private String createOrderSummary(String name,int price,boolean addWhipperCream, boolean addChocolate){
        String orderSummary = getString(R.string.order_summary_name,name);
        orderSummary = orderSummary + "\n" + getString(R.string.order_summary_chocolate,addChocolate);
        orderSummary = orderSummary + "\n" + getString(R.string.order_summary_whipped_cream,addWhipperCream);
        orderSummary = orderSummary + "\n" + getString(R.string.order_summary_quantity,quantity);
        orderSummary = orderSummary + "\n" + getString(R.string.order_summary_price,("$"+price));
        orderSummary = orderSummary + "\n"+ getString(R.string.thank_you);
        return orderSummary;
    }

    public int calculatePrice(int num, boolean addWhipperCream, boolean addChocolate){
        int newPrice = 5;
        if(addChocolate || addWhipperCream){
            if(addChocolate){
                newPrice = newPrice + 1;
            }
            if(addWhipperCream){
                newPrice = newPrice + 2;
            }
        }
        return num * newPrice;
    }

    public void increment(View view) {
        if(quantity == 100) {
            Toast.makeText(this, "you can not have more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if(quantity == 1) {
            Toast.makeText(this, "you can not have less than 1 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffee) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffee);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}
