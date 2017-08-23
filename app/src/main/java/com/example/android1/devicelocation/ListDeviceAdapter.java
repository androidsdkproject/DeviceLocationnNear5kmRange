package com.example.android1.devicelocation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Android1 on 7/26/2017.
 */


public class ListDeviceAdapter extends ArrayAdapter<ListDeviceModel> {

    private final Context context;
    private final ArrayList<ListDeviceModel> itemsArrayList;

    public ListDeviceAdapter(Context context, ArrayList<ListDeviceModel> itemsArrayList) {
        super(context, R.layout.device_list_item, itemsArrayList);
        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.device_list_item, parent, false);

        TextView placename = (TextView) rowView.findViewById(R.id.devicename);
        placename.setText(itemsArrayList.get(position).getDevice_name());


        TextView location = (TextView) rowView.findViewById(R.id.location);
        location.setText(itemsArrayList.get(position).getLocation());

        TextView dist = (TextView) rowView.findViewById(R.id.distance);
        dist.setText("Distance " + String.format("%.2f", itemsArrayList.get(position).getDevicedistance()) + " km");

        return rowView;
    }


}
