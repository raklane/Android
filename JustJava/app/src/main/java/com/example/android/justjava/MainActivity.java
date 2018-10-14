/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantity = 2;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {


        EditText nameText = (EditText) findViewById(R.id.name_text_view);
        String name = nameText.getText().toString();

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        Boolean hasWhippedCreamChecked = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        Boolean hasChocolateChecked = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCreamChecked, hasChocolateChecked);

        String summary = createOrderSummary(name, price, hasWhippedCreamChecked, hasChocolateChecked);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "rakesh.xyzz@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject,name));
        intent.putExtra(Intent.EXTRA_TEXT, summary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method calculates the price of coffee
     *
     * @param addWhippedCream is whether the whipped cream is checked or not
     * @param addChocolate    is whether the chocolate is checked or not
     * @return price is the price of the coffee
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 5;
        if (addWhippedCream == true) {
            basePrice = basePrice + 1;
        }
        if (addChocolate == true) {
            basePrice = basePrice + 2;
        }
        int price = quantity * basePrice;
        return price;
    }

    /**
     * This method creates the order summary
     *
     * @param price is the total price of the coffee
     * @return summary is the summary of the purchase to be displayed
     */
    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = getString(R.string.order_summary_name,name);
        priceMessage = priceMessage + "\n" + getString(R.string.order_summary_addWhippedCream,addWhippedCream);
        priceMessage = priceMessage + "\n" + getString(R.string.order_summary_addchocolate,addChocolate);
        priceMessage += "\n" + getString(R.string.order_summary_quantity,quantity);
        priceMessage += "\n" + getString(R.string.order_summary_total,
                NumberFormat.getCurrencyInstance().format(price));
        priceMessage += "\n" + getString(R.string.order_summary_thankYouMessage);
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    public void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }


    /**
     * This method is to increment the quantity of coffee by 1
     */
    public void increment(View view) {
        if (quantity == 100) {
            Toast toast = Toast.makeText(MainActivity.this, getString(R.string.toast_quantity_above100), Toast.LENGTH_SHORT);
            toast.show();
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method decrements the quantity to 1
     */
    public void decrement(View view) {
        if (quantity == 1) {
            Toast toast = Toast.makeText(MainActivity.this, getString(R.string.toast_quantity_belowOne), Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
}