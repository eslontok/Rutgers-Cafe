package com.example.project5;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * OrderDonutsActivity class serves as the controller for the Order Donuts screen
 * @author Earl Lontok, Aristeidis Stoupas
 */
public class OrderDonutsActivity extends AppCompatActivity {

    RecyclerView donuts;
    private ArrayList<MenuItem> menu = new ArrayList<>();

    /**
     * Sets the layout to order_donuts.xml (displays the Order Donuts screen)
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_donuts);
        donuts = findViewById(R.id.RecyclerViewDonuts);
        setDonutMenu();
        Log.i(menu.get(0).toString(), "Function has generated zero.");
        MyAdapter adapter = new MyAdapter(getApplicationContext(), menu);
        donuts.setAdapter(adapter);
        donuts.setLayoutManager(new LinearLayoutManager(this));

    }

    /**
     * A helper method that sets the contents for the RecyclerView donuts
     */
    private void setDonutMenu(){
        menu.add(new YeastDonut("Glazed", 1));
        menu.add(new YeastDonut("Chocolate", 1));
        menu.add(new YeastDonut("Vanilla", 1));
        menu.add(new YeastDonut("Boston Cream", 1));
        menu.add(new YeastDonut("Custard", 1));
        menu.add(new YeastDonut("Strawberry Jelly", 1));

        menu.add(new CakeDonut("Old-Fashioned", 1));
        menu.add(new CakeDonut("Mocha", 1));
        menu.add(new CakeDonut("Granulated Sugar", 1));

        menu.add(new DonutHoleDonut("Cinnamon" , 1));
        menu.add(new DonutHoleDonut("Powdered Sugar" , 1));
        menu.add(new DonutHoleDonut("Blueberry" , 1));
    }

}
