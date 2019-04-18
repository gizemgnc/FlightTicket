package com.example.flight.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.flight.R;
import com.example.flight.adapters.FligthAdapter;
import com.example.flight.models.Cabin;
import com.example.flight.models.Flight;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private FligthAdapter fligthAdapter;
    private RecyclerView rvFligths;
    public static List<Flight> flights = new ArrayList<>();
    public static List<Cabin> allcabins = new ArrayList<>();
    private Button btnFlight;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Flight Ticket");
        toolbar.setLogo(R.drawable.flight);

        btnFlight=findViewById(R.id.btnFlight);
        btnFlight.setOnClickListener(this);

        getFligths();

        rvFligths = findViewById(R.id.rvFligths);
        fligthAdapter = new FligthAdapter(flights, this);
        rvFligths.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvFligths.setAdapter(fligthAdapter);

    }

    private void getFligths() {

        Cabin c1 = new Cabin("P", 50, false,0);
        Cabin c2 = new Cabin("E", 100, false,1);
        Cabin c3 = new Cabin("B", 200, false,2);

        Cabin c4 = new Cabin("P", 50, false,0);
        Cabin c5 = new Cabin("E", 100, false,1);
        Cabin c6 = new Cabin("B", 200, false,2);

        Cabin c7 = new Cabin("P", 50, false,0);
        Cabin c8 = new Cabin("E", 100, false,1);
        Cabin c9 = new Cabin("B", 200, false,2);

        List<Cabin> cabinList1 = new ArrayList<>();
        cabinList1.add(c1);
        cabinList1.add(c2);
        cabinList1.add(c3);
        List<Cabin> cabinList2 = new ArrayList<>();
        cabinList2.add(c4);
        cabinList2.add(c5);
        cabinList2.add(c6);

        List<Cabin> cabinList3 = new ArrayList<>();
        cabinList3.add(c7);
        cabinList3.add(c8);
        cabinList3.add(c9);

        allcabins.addAll(cabinList1);
        allcabins.addAll(cabinList2);
        allcabins.addAll(cabinList3);

        Flight flight = new Flight("Ankara", "istanbul","THY", "15:40" ,cabinList1);
        Flight flight2 = new Flight("Ankara", "istanbul", "Pegasus", "19:20", cabinList2);
        Flight flight3 = new Flight("Ankara", "istanbul", "Atlas", "21:00", cabinList3);
        flights.add(flight);
        flights.add(flight2);
        flights.add(flight3);

    }


    @Override
    public void onClick(View v) {

        for (Flight f: flights){
            if (f.isSelected()){
                for(Cabin c: f.getCabinList()){
                    if (c.isIcChecked()){
                        Toast.makeText(this, f.getAirway() +": "+ c.getCabinName() + ": " + c.getPrice(), Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                        intent.putExtra("departure",f.getDepartureCity());
                        intent.putExtra("arrived",f.getArrivedCity());
                        intent.putExtra("airway",f.getAirway());
                        intent.putExtra("cabin",c.getCabinName());
                        intent.putExtra("price",c.getPrice());

                        startActivity(intent);
                    }

                }
            }
        }
    }
}
