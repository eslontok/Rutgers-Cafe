package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Activity_coffee class serves as the controller for the Order Coffee screen
 * @author Earl Lontok, Aristeidis Stoupas
 */
public class Activity_coffee extends AppCompatActivity {

    private DecimalFormat decForm = new DecimalFormat("#,###.00");

    private Spinner sizeSpinner;
    private Spinner quantitySpinner;
    private ArrayAdapter<String> sizeAdapter;
    private ArrayAdapter<String> quantityAdapter;
    private String[] sizes = {"SHORT", "TALL", "GRANDE", "VENTI"};
    private String[] quantities = {"1", "2", "3", "4", "5"};

    private CheckBox sweetCream;
    private CheckBox irishCream;
    private CheckBox frenchVanilla;
    private CheckBox caramel;
    private CheckBox mocha;

    private TextView subtotal;

    private String size;
    private int quantity;
    double amount = 0;

    /**
     * Sets the layout to activity_coffee.xml (displays the Order Coffee screen)
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);
        sizeSpinner = findViewById(R.id.sizeSpinner);
        sizeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sizes);
        sizeSpinner.setAdapter(sizeAdapter);
        quantitySpinner = findViewById(R.id.quantitySpinner);
        quantityAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, quantities);
        quantitySpinner.setAdapter(quantityAdapter);
        sweetCream = findViewById(R.id.sweetCream);
        irishCream = findViewById(R.id.irishCream);
        frenchVanilla = findViewById(R.id.frenchVanilla);
        caramel = findViewById(R.id.caramel);
        mocha = findViewById(R.id.mocha);
        subtotal = findViewById(R.id.subtotal);

        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                size = sizeSpinner.getSelectedItem().toString();
                calculateSubtotal();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // your code here
            }
        });
        quantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                quantity = Integer.parseInt(quantitySpinner.getSelectedItem().toString());
                calculateSubtotal();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // your code here
            }
        });
    }

    /**
     * A helper method that calculates the price of the coffee based on size, quantity, and number of add-ins
     */
    private void calculateSubtotal(){

        amount = 0;
        if(size.equals("SHORT")){
            amount += Constant.SHORT_PRICE;
        }else if(size.equals("TALL")){
            amount += Constant.TALL_PRICE;
        }else if(size.equals("GRANDE")){
            amount += Constant.GRANDE_PRICE;
        }else{
            amount += Constant.VENTI_PRICE;
        }
        if(sweetCream.isChecked()){
            amount += Constant.ADD_INS;
        }
        if(irishCream.isChecked()){
            amount += Constant.ADD_INS;
        }
        if(frenchVanilla.isChecked()){
            amount += Constant.ADD_INS;
        }
        if(caramel.isChecked()){
            amount += Constant.ADD_INS;
        }
        if(mocha.isChecked()){
            amount += Constant.ADD_INS;
        }
        if(amount == 0){
            subtotal.setText("$0.00");
        }else{
            subtotal.setText("$" + decForm.format(amount * quantity));
        }

    }

    /**
     * Updates the subtotal when an add-in is selected/unselected
     * @param view the view of interest
     */
    public void checkBoxAddIns(View view){

        calculateSubtotal();

    }

    /**
     * Adds the coffee order to the current order
     * @param view the view of interest
     */
    public void addToOrderButtonClick(View view){

        String size = sizeSpinner.getSelectedItem().toString();
        int quantity = Integer.parseInt(quantitySpinner.getSelectedItem().toString());
        ArrayList<String> listAddins = new ArrayList<String>();
        if(sweetCream.isChecked()){
            listAddins.add("SWEET CREAM");
        }
        if(irishCream.isChecked()){
            listAddins.add("IRISH CREAM");
        }
        if(frenchVanilla.isChecked()){
            listAddins.add("FRENCH VANILLA");
        }
        if(caramel.isChecked()){
            listAddins.add("CARAMEL");
        }
        if(mocha.isChecked()){
            listAddins.add("MOCHA");
        }
        Coffee coffee = new Coffee(size, listAddins, quantity);
        MainActivity.getCurrOrder().add(coffee);
        Toast.makeText(this, "Added " + coffee + " to your order", Toast.LENGTH_SHORT).show();


    }


}