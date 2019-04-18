package com.example.flight.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.flight.R;
import com.example.flight.listeners.CabinRadioButtonClickListener;
import com.example.flight.models.Cabin;
import com.example.flight.models.Flight;

import java.util.ArrayList;
import java.util.List;


public class FligthAdapter extends RecyclerView.Adapter<FligthAdapter.FligthHolder>  {

    private List<Flight> flights;
    private Context context;

    public FligthAdapter(List<Flight> flights, Context context) {
        this.flights = flights;
        this.context = context;
    }

    @NonNull
    @Override
    public FligthHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.simple_fligth, viewGroup,false);
        return new FligthHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FligthHolder holder, int i) {
        Flight flight = flights.get(i);
        holder.tvDepArr.setText(flight.getDepartureCity() + " -> " + flight.getArrivedCity());
        holder.tvAirway.setText(flight.getAirway());
        holder.tvTime.setText(flight.getTime());

        holder.rvCabins.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        holder.rvCabins.setAdapter(new CabinAdapter(flight.getCabinList(), context,flight,this));
    }

    @Override
    public int getItemCount() {
        return flights.size();
    }


    static class FligthHolder extends  RecyclerView.ViewHolder {

        TextView tvDepArr, tvAirway, tvTime;
        RecyclerView rvCabins;

        FligthHolder(@NonNull View itemView){
            super(itemView);
            tvDepArr = itemView.findViewById(R.id.tvDepArr);
            tvAirway = itemView.findViewById(R.id.tvAirway);
            tvTime = itemView.findViewById(R.id.tvTime);
            rvCabins = itemView.findViewById(R.id.rvCabin);

        }
    }
}
