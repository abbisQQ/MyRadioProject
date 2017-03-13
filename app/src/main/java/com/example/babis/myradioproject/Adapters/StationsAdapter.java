package com.example.babis.myradioproject.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.babis.myradioproject.Activities.MainActivity;
import com.example.babis.myradioproject.Holders.StationViewHolder;
import com.example.babis.myradioproject.Model.Station;
import com.example.babis.myradioproject.R;

import java.util.ArrayList;

/**
 * Created by Babis on 3/11/2017.
 */

public class StationsAdapter extends RecyclerView.Adapter<StationViewHolder>{


    private ArrayList<Station> stations;


    public StationsAdapter(ArrayList<Station> stations) {
        this.stations = stations;
    }

    @Override
    public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View stationCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.station_card,parent,false);

        return new StationViewHolder(stationCard);
    }

    @Override
    public void onBindViewHolder(StationViewHolder holder,final int position) {
        final Station station = stations.get(position);
        holder.updateUi(station);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getMainActivity().loadDetailScreen(station);
            }
        });

    }

    @Override
    public int getItemCount() {
        return stations.size();
    }
}
