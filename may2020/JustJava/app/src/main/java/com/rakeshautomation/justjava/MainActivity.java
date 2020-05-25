/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.rakeshautomation.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int currentQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentQuantity = getCurrentQuantity();
    }

    /*
     * Get starting quantity
     */
    public int getCurrentQuantity(){
        TextView currentQuantityView = (TextView) findViewById(R.id.quantity_text_view);
        return Integer.valueOf(currentQuantityView.getText().toString());
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox toppingCheckboxView = (CheckBox) findViewById(R.id.topping_checkbox_view);
        boolean isWhippedCreamChecked = toppingCheckboxView.isChecked();
        Log.v("OrderPrep", "isWhippedCreamChecked: " + isWhippedCreamChecked);

        CheckBox chocolateCheckboxView = (CheckBox) findViewById(R.id.chocolate_checkbox_view);
        boolean isChocolateChecked = chocolateCheckboxView.isChecked();
        Log.v("OrderPrep", "isChocolateChecked: " + isChocolateChecked);

        EditText nameView = (EditText) findViewById(R.id.name_edit_view);
        String name = String.valueOf(nameView.getText());
        Log.v("OrderPrep", "Name: " + name);

        int price = calculatePrice(isWhippedCreamChecked, isChocolateChecked);
        Log.v("OrderPrep", "Total price is . $" + price);

        String message = createOrderSummary(price, name, isWhippedCreamChecked, isChocolateChecked);
        //displayMessage(message);
        composeEmail(new String[]{getString(R.string.email_address)}, getString(R.string.email_subject), message);

    }

    /*
     * To calculate the price of the coffee
     */
    private int calculatePrice(boolean isWhippedCreamChecked, boolean isChocolateChecked){
        int pricePerCup = 5 + (isWhippedCreamChecked == true ? 1:0) + (isChocolateChecked == true ? 2:0);
        Log.v("OrderPrep", "Price per cup is: " + pricePerCup);
        return currentQuantity * pricePerCup;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /*
     * To increment the quantity
     */
    public void increment(View view){
        if(currentQuantity == 100){
            Toast.makeText(this, getString(R.string.toast_more_than_100), Toast.LENGTH_SHORT).show();
            return;
        }
        currentQuantity++;
        displayQuantity(currentQuantity);
    }

    /*
     * To decrement the quantity
     */
    public void decrement(View view){
        if(currentQuantity == 1){
            Toast.makeText(this, getString(R.string.toast_less_than_1), Toast.LENGTH_SHORT).show();
            return;
        }
        currentQuantity--;
        displayQuantity(currentQuantity);
    }

    /*
     * To create order summary
     */
    private String createOrderSummary(int price, String name, boolean isWhippedCreamChecked, boolean isChocolateChecked){



        String message = getString(R.string.email_name, name) +
                "\n" + getString(R.string.email_add_whipped_cream) + isWhippedCreamChecked +
                "\n" + getString(R.string.email_add_chocolate) + isChocolateChecked +
                "\n" + getString(R.string.email_quantity) + currentQuantity +
                "\n" + getString(R.string.email_total) + price +
                "\n" + getString(R.string.email_thank_you);
        return message;
    }

    /*
     * Compose an email
     */
    public void composeEmail(String[] addresses, String subject, String body){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); //only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }


}