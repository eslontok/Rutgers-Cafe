package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

/**
 * MainActivity class serves as the controller for the main (home) screen
 * @author Earl Lontok, Aristeidis Stoupas
 */
public class MainActivity extends AppCompatActivity {

    static Order currOrder = new Order(0);
    static ArrayList<Order> orderList = new ArrayList<>();

    public static int orderNum= 0;

    /**
     * Generates an order number for a new Order
     */
    public static int generateNum(){
        orderNum++;
        return orderNum;
    }

    /**
     * Sets the current Order to a new Order
     */
    public static void resetOrder(){
        currOrder = new Order(generateNum());
    }

    /**
     * A getter method that returns the current Order in the Shopping Basket
     * @return the current Order in the Shopping Basket
     */
    public static Order getCurrOrder(){
        return currOrder;
    }

    /**
     * A getter method that returns the list of all orders placed
     * @return the list of all orders placed
     */
    public static ArrayList<Order> getOrderList(){
        return orderList;
    }

    /**
     * Sets the layout to activity_main.xml (displays the home screen)
     * There are 4 actions: Order Donuts, Order Coffee, view the Shopping Basket, and view the Orders
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Launches OrderDonutsActivity when the Order Donuts image is clicked
     * @param view the view of interest
     */
    public void showActivityDonuts(View view){
        Intent intent = new Intent(this, OrderDonutsActivity.class);
        startActivity(intent);
    }

    /**
     * Launches Activity_coffee when the Order Coffee image is clicked
     * @param view the view of interest
     */
    public void showActivityCoffee(View view){
        Intent intent = new Intent(this, Activity_coffee.class);
        startActivity(intent);
    }

    /**
     * Launches Activity_basket when the Shopping Basket image is clicked
     * @param view the view of interest
     */
    public void showActivityBasket(View view){
        Intent intent = new Intent(this, Activity_basket.class);
        startActivity(intent);
    }

    /**
     * Launches Activity_orders when the Orders image is clicked
     * @param view the view of interest
     */
    public void showActivityOrders(View view){
        Intent intent = new Intent(this, Activity_orders.class);
        startActivity(intent);
    }

}