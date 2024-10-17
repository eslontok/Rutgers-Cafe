package com.example.project5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * Activity_basket class serves as the controller for the Shopping Basket screen
 * @author Earl Lontok, Aristeidis Stoupas
 */
public class Activity_basket extends AppCompatActivity {

    DecimalFormat decForm = new DecimalFormat("#,###.00");
    private ListView basketListView;

    private TextView subtotalBasket;
    private TextView salesTaxBasket;
    private TextView totalBasket;

    /**
     * Sets the layout to activity_basket.xml (displays the Shopping Basket screen).
     * If an item from the order is selected, an alert appears, asking the user if the user wants to remove the item
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        subtotalBasket = findViewById(R.id.subtotalBasket);
        salesTaxBasket = findViewById(R.id.salesTaxBasket);
        totalBasket = findViewById(R.id.totalBasket);

        basketListView = findViewById(R.id.basketListView);
        Order order = MainActivity.getCurrOrder();
        ArrayAdapter<MenuItem> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, order.getList());
        basketListView.setAdapter(adapter);
        setPrices();
        basketListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MenuItem item = (MenuItem)parent.getItemAtPosition(position);
                AlertDialog.Builder alert = new AlertDialog.Builder(parent.getContext());
                alert.setTitle("Remove Item");
                alert.setMessage("Do you want to remove " + item.toString());
                //anonymous inner class to handle the onClick event of YES or NO.
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), item.toString() + " removed", Toast.LENGTH_SHORT).show();
                        order.remove(item);
                        adapter.remove(item);
                        basketListView.setAdapter(adapter);
                        setPrices();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //do nothing
                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();
            }
        });
    }

    /**
     * A helper method that displays the subtotal, sales tax, and total cost of the current order
     */
    private void setPrices(){

        double amount = 0;
        Order order = MainActivity.getCurrOrder();
        if(order.getList().size() == 0){
            subtotalBasket.setText("$0.00");
            salesTaxBasket.setText("$0.00");
            totalBasket.setText("$0.00");
        }else{
            for(int i = 0; i < order.getList().size(); i++){
                amount += order.getList().get(i).itemPrice();
            }
            subtotalBasket.setText("$" + decForm.format(amount));
            double tax = amount * Constant.SALES_TAX;
            salesTaxBasket.setText("$" + decForm.format(tax));
            totalBasket.setText("$" + decForm.format(amount + tax));
        }

    }

    /**
     * Adds the current order to the list of orders - afterwards, the current order is reset to an empty order
     * @param view the view of interest
     */
    public void placeOrderButtonClick(View view){

        Order order = MainActivity.getCurrOrder();
        if(order.getList().size() == 0){
            Toast.makeText(this, "Order is empty", Toast.LENGTH_SHORT).show();
        }else{
            MainActivity.getOrderList().add(order);
            MainActivity.resetOrder();
            order = MainActivity.getCurrOrder();
            ArrayAdapter<MenuItem> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, order.getList());
            basketListView.setAdapter(adapter);
            subtotalBasket.setText("$0.00");
            salesTaxBasket.setText("$0.00");
            totalBasket.setText("$0.00");
            Toast.makeText(this, "Order placed", Toast.LENGTH_SHORT).show();
        }

    }

}