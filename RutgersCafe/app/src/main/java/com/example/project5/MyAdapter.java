package com.example.project5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * MyAdapter class serves as the adapter that sets up the RecyclerView on the Order Donuts screen
 * @author Earl Lontok, Aristeidis Stoupas
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.DonutHolder> {

    private Context context; //need the context to inflate the layout
    private ArrayList<MenuItem> donuts; //need the data binding to each row of RecyclerView

    /**
     * Constructor for the MyAdapter class
     * @param context the context of interest
     * @param donuts the list of Donuts to be added to the RecyclerView
     */
    public MyAdapter(Context context, ArrayList<MenuItem> donuts) {
        this.context = context;
        this.donuts = donuts;
    }

    /**
     * Creates a view holder for the donuts
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     * @return the view holder for the donuts
     */
    @NonNull
    @Override
    public DonutHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.donut_view, parent, false);

        return new DonutHolder(view);
    }

    /**
     * Binds the views and the data
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param pos The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull DonutHolder holder, int pos) {
        String flavor = donuts.get(pos).getFlavor();
        int picId = findPicId(flavor);
        double price;

        if(donuts.get(pos) instanceof DonutHoleDonut){
            price = Constant.DONUTHOLE_PRICE;
        }
        else if(donuts.get(pos) instanceof CakeDonut){
           price = Constant.CAKE_PRICE;
        }
        else{
           price = Constant.YEAST_PRICE;
        }

        holder.setData(picId, flavor, price);

    }

    /**
     * Finds the ID of the picture corresponding to the given flavor
     * @param flavor the flavor of interest
     * @return the ID of the flavor of interest
     */
    public int findPicId(String flavor){
        if(flavor.equalsIgnoreCase("cinnamon")){
            return R.drawable.cinnamondonuthole;
        }
        else if(flavor.equalsIgnoreCase("powdered sugar")){
            return R.drawable.sugardonuthole;
        }
        else if(flavor.equalsIgnoreCase("blueberry")){
            return R.drawable.blueberrydonuthole;
        }
        else if(flavor.equalsIgnoreCase("old-fashioned")){
            return R.drawable.oldfashioneddonut;
        }
        else if(flavor.equalsIgnoreCase("mocha")){
            return R.drawable.mochadonut;
        }
        else if(flavor.equalsIgnoreCase("granulated sugar")){
            return R.drawable.sugardonut;
        }
        else if(flavor.equalsIgnoreCase("glazed")){
            return R.drawable.glazeddonut;
        }
        else if(flavor.equalsIgnoreCase("chocolate")){
            return R.drawable.chocolatedonut;
        }
        else if(flavor.equalsIgnoreCase("vanilla")){
            return R.drawable.vanilladonut;
        }
        else if(flavor.equalsIgnoreCase("boston cream")){
            return R.drawable.bostoncreamdonut;
        }
        else if(flavor.equalsIgnoreCase("custard")){
            return R.drawable.custarddonut;
        }
        else return R.drawable.stawberryjellydonut;
    }

    /**
     * Gets the number of items in the donuts ArrayList
     * @return the number of items in the donuts ArrayList
     */
    @Override
    public int getItemCount() {
        return donuts.size();
    }

    /**
     * DonutHolder class (extends RecyclerView.ViewHolder) creates a DonutHolder object
     */
    public class DonutHolder extends RecyclerView.ViewHolder{
        private ImageView donutImageView;
        private TextView typeView;
        private TextView priceView;

        /**
         * Constructor for the DonutHolder class
         * @param itemView the view of interest
         */
        public DonutHolder(@NonNull View itemView) {
            super(itemView);
            donutImageView = itemView.findViewById(R.id.donutImage);
            typeView = itemView.findViewById(R.id.typeView);
            priceView = itemView.findViewById(R.id.priceView);
            itemView.setOnClickListener(new View.OnClickListener(){
                /*
                on a donut item click, this will launch the AddDonutActivity
                 */
                @Override
                public void onClick(View v){
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        Intent i = new Intent(context, AddDonutActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i.putExtra("type",typeView.getText());
                        i.putExtra("price",priceView.getText());
                        context.startActivity(i);
                    }

                }

            });

        }

        /**
         * Sets the text for each donut in the RecyclerView
         * @param picId the picture ID of the donut
         * @param flavor the flavor of the donut
         * @param price the price of the donut
         */
        public void setData(int picId, String flavor, double price) {
            donutImageView.setImageResource(picId);
            typeView.setText(flavor);
            priceView.setText("$" + price);
        }
    }

}
