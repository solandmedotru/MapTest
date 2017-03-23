package ru.solandme.maptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    static final GeoPlace[] geoPlaces = {
            new GeoPlace("Рузское водохранилище", 56.051622, 37.310075 ),
            new GeoPlace("Можайское водохранилище", 52.051622, 32.310075),
            new GeoPlace("Парк1", 12.051622, 22.310075),
            new GeoPlace("Парк2", 22.051622, 22.310075),
            new GeoPlace("Парк3", 22.051622, 12.310075),
            new GeoPlace("Парк4", 52.051622, 62.310075),
            new GeoPlace("Парк5", -32.051622, 22.310075)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.placesList);
        listView.setAdapter(new MyListAdapter(this, geoPlaces));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("Lat", geoPlaces[i].getLat());
                intent.putExtra("Lon", geoPlaces[i].getLon());
                intent.putExtra("Name", geoPlaces[i].getName());
                startActivity(intent);
            }
        });

    }
}
