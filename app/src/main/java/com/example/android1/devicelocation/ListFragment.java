package com.example.android1.devicelocation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import static com.example.android1.devicelocation.HomeActivity.arrayList;


public class ListFragment extends Fragment {


    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);


        listView = (ListView) view.findViewById(R.id.listView);


        ListDeviceAdapter adapter = new ListDeviceAdapter(getActivity(), arrayList);

        listView.setAdapter(adapter);


        return view;
    }


}