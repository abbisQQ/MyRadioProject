package com.example.babis.myradioproject.Fragments;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.babis.myradioproject.Adapters.StationsAdapter;
import com.example.babis.myradioproject.R;
import com.example.babis.myradioproject.Services.DataService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StationFragment extends Fragment {

    private static final String ARG_Station_type = "station type";


    // TODO: Rename and change types of parameters
    private int stationType;
    RecyclerView recyclerView;
    StationsAdapter adapter;


    public static final int STATION_TYPE_FEATURED =0;
    public static final int STATION_TYPE_RECENT =1;
    public static final int STATION_TYPE_PARTY =2;


    public StationFragment() {
        // Required empty public constructor

    }



    // TODO: Rename and change types and number of parameters
    public static StationFragment newInstance(int stationType) {
        StationFragment fragment = new StationFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_Station_type,stationType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stationType = getArguments().getInt(ARG_Station_type);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_station, container, false);

         recyclerView = (RecyclerView)view.findViewById(R.id.recycler_stations);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        if(stationType == STATION_TYPE_FEATURED){
            adapter = new StationsAdapter(DataService.getInstance().getFeaturedStations());
        }else if(stationType==STATION_TYPE_RECENT){
            adapter = new StationsAdapter(DataService.getInstance().getRecentStations());
        }else {
            adapter = new StationsAdapter(DataService.getInstance().getPartyStations());
        }


        recyclerView.addItemDecoration(new HorrizontalItemDecorator(30));

        recyclerView.setAdapter(adapter);


        return view;
    }

}
    //how to get space between recycler View items!!!

    class HorrizontalItemDecorator extends RecyclerView.ItemDecoration{

        private  final int SPACER;


        public HorrizontalItemDecorator(int SPACER) {
            this.SPACER = SPACER;
        }


        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.right = SPACER;
        }
    }
