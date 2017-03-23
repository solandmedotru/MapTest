package ru.solandme.maptest;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class MyListAdapter extends ArrayAdapter<GeoPlace> {

    GeoPlace[] geoPlaces;

    public MyListAdapter(@NonNull Context context, GeoPlace[] geoPlaces) {
        super(context, 0, geoPlaces);
        this.geoPlaces = geoPlaces;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.nameField);
        name.setText(geoPlaces[position].getName());
        return convertView;
    }

}