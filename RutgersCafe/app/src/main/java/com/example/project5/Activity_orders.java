package com.example.project5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Activity_orders class serves as the controller for the Orders screen
 * @author Earl Lontok, Aristeidis Stoupas
 */
public class Activity_orders extends AppCompatActivity {

    private ListView ordersListView;

    /**
     * Sets the layout to activity_orders.xml (displays the Orders screen)
     * If an order from the list is selected, an alert appears, asking the user if the user wants to remove the order
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        ordersListView = findViewById(R.id.ordersListView);
        ArrayList<Order> orders = MainActivity.getOrderList();

        ArrayAdapter<Order> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orders);
        ordersListView.setAdapter(adapter);
        ordersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Order currOrder = (Order)parent.getItemAtPosition(position);

                AlertDialog.Builder alert = new AlertDialog.Builder(parent.getContext());
                alert.setTitle("Remove Order");
                alert.setMessage("Do you want to remove Order#: " + currOrder.getOrderNumber() + "?");
                //anonymous inner class to handle the onClick event of YES or NO.
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Order#: " + currOrder.getOrderNumber() + " removed", Toast.LENGTH_SHORT).show();
                        orders.remove(currOrder);
                        adapter.remove(currOrder);
                        ordersListView.setAdapter(adapter);
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

}