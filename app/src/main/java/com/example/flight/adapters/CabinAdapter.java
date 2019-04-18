package com.example.flight.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.flight.R;
import com.example.flight.activities.MainActivity;
import com.example.flight.listeners.CabinRadioButtonClickListener;
import com.example.flight.models.Cabin;
import com.example.flight.models.Flight;

import java.util.List;


public class CabinAdapter extends RecyclerView.Adapter<CabinAdapter.CabinHolder> implements CabinRadioButtonClickListener {

    private List<Cabin> cabins;
    private Context context;
    private final CabinRadioButtonClickListener listener;
   // private int selectedIndex = -1;
    private Flight flight;
    private FligthAdapter fligthAdapter;

    public CabinAdapter(List<Cabin> cabins, Context context,Flight flight, FligthAdapter fligthAdapter) {
        this.cabins = cabins;
        this.context = context;
        this.listener = this;
        this.flight = flight;
        this.fligthAdapter = fligthAdapter;
    }

    @NonNull
    @Override
    public CabinHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.simple_cabin, viewGroup, false);
        return new CabinHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CabinHolder holder, int i) {

       holder.bind(cabins.get(i), listener);
    }

    @Override
    public int getItemCount() {
        return cabins.size();
    }

    @Override
    public void onRadioButtonClicked(int index) {
       /* if(selectedIndex > -1) {
            cabins.get(selectedIndex).setIcChecked(false);
        }
        selectedIndex = index;
        cabins.get(index).setIcChecked(true);
        this.notifyDataSetChanged();
        */
        for (Cabin c: MainActivity.allcabins){
            c.setIcChecked(false);
        }
        cabins.get(index).setIcChecked(true);

        for (Flight f: MainActivity.flights){
            f.setSelected(false);
        }
        flight.setSelected(true);
        fligthAdapter.notifyDataSetChanged();
    }


    class CabinHolder extends RecyclerView.ViewHolder {

        RadioButton radioButton;

        CabinHolder(@NonNull View itemView) {
            super(itemView);
            radioButton = itemView.findViewById(R.id.rbCheck);

        }

        void bind(Cabin cabin, CabinRadioButtonClickListener listener) {
            radioButton.setText(cabin.getCabinName() + " -> " + cabin.getPrice());
            radioButton.setChecked(cabin.isIcChecked());

            radioButton.setOnClickListener(v -> listener.onRadioButtonClicked(cabin.getIndex()));

        }
    }
}
