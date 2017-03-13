package com.example.babis.myradioproject.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.babis.myradioproject.Fragments.DetailsFragment;
import com.example.babis.myradioproject.Fragments.MainFragment;
import com.example.babis.myradioproject.Model.Station;
import com.example.babis.myradioproject.R;

public class MainActivity extends AppCompatActivity {

    private static MainActivity  mainActivity;

    public static Station station;
    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    private static void setMainActivity(MainActivity mainActivity) {
        MainActivity.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMainActivity(this);

        FragmentManager fm = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment)fm.findFragmentById(R.id.container_main);

        if(mainFragment==null){

            mainFragment = MainFragment.newInstance("nothing","nothing  ");

            fm.beginTransaction()
                    .add(R.id.container_main,mainFragment)
                    .commit();

        }

    }


    public void loadDetailScreen(Station selectStation){
        station = selectStation;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_main,new DetailsFragment())
                .addToBackStack(null)
                .commit();

    }
}
