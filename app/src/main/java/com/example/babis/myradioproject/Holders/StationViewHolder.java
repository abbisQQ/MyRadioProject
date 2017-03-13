package com.example.babis.myradioproject.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.babis.myradioproject.Model.Station;
import com.example.babis.myradioproject.R;

/**
 * Created by Babis on 3/11/2017.
 */

public class StationViewHolder extends RecyclerView.ViewHolder{

    private ImageView mainImage;
    private TextView titleTextView;

    public StationViewHolder(View itemView) {
        super(itemView);

        this.mainImage = (ImageView)itemView.findViewById(R.id.main_image);
        this.titleTextView = (TextView)itemView.findViewById(R.id.main_text);

    }

    public void updateUi(Station station){
        String uri = station.getImgUri();

        int resources = mainImage.getResources().getIdentifier(uri,null,mainImage.getContext().getPackageName());

        mainImage.setImageResource(resources);

        titleTextView.setText(station.getStationTitle());
    }




}
