package com.example.project5;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

/**
 * AddDonutActivity class serves as the controller for the Add Donuts screen
 * @author Earl Lontok, Aristeidis Stoupas
 */
public class AddDonutActivity extends AppCompatActivity {
    private DecimalFormat decForm = new DecimalFormat("#,###.00");
    Button addDonutButton;
    TextView subtotal;
    Spinner spinner;
    Bundle extras;
    String quantity;

    /**
     * Sets the layout to add_donuts.xml (displays the Add Donuts screen)
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_donuts);

        extras = getIntent().getExtras();
        String price = extras.getString("price").substring(1);
        subtotal = findViewById(R.id.donutSubtotal);
        subtotal.setText(price);

        addDonutButton = findViewById(R.id.addDonutButton);

        spinner = findViewById(R.id.donutNum);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {    //changes the subtotal anytime a different quantity is picked
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                quantity = spinner.getSelectedItem().toString();
                double cost = Double.parseDouble(price) * Double.parseDouble(quantity);
                subtotal.setText("$" + decForm.format(cost));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // your code here
            }
        });


        ArrayAdapter<CharSequence> adap = ArrayAdapter.createFromResource(this, R.array.num, android.R.layout.simple_spinner_item);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adap);
    }

    /**
     * Adds the selected donut flavor and quantity to the current order
     * @param view the view of interest
     */
    public void addDonutToOrder(View view){

        if (extras != null) {
            String type = extras.getString("type");
            String price = extras.getString("price").substring(1);
            if(Double.parseDouble(price) == Constant.CAKE_PRICE){
                CakeDonut temp = new CakeDonut(type, Integer.parseInt(spinner.getSelectedItem().toString()));
                MainActivity.getCurrOrder().add(temp);
                Toast.makeText(this, "Added " + temp.toString() + " to your order!", Toast.LENGTH_SHORT).show();
            }
            else if(Double.parseDouble(price) == Constant.YEAST_PRICE){
                YeastDonut temp = new YeastDonut(type, Integer.parseInt(spinner.getSelectedItem().toString()));
                MainActivity.getCurrOrder().add(temp);
                Toast.makeText(this, "Added " + temp.toString() + " to your order!", Toast.LENGTH_SHORT).show();
            }
            else{
                DonutHoleDonut temp = new DonutHoleDonut(type, Integer.parseInt(spinner.getSelectedItem().toString()));
                MainActivity.getCurrOrder().add(temp);
                Toast.makeText(this, "Added " + temp.toString() + " to your order!", Toast.LENGTH_SHORT).show();
            }

            Log.d("hmm", MainActivity.getCurrOrder().toString());

        }

        finish();

    }

}
