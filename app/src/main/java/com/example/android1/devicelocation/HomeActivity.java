package com.example.android1.devicelocation;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    final public static int PERMISSION_ALL = 1;
    static ArrayList<ListDeviceModel> arrayList = new ArrayList<>();
    String TAG = "Home";
    TabLayout tabLayout;
    ViewPager viewPager;
    String[] PERMISSIONS = {
            android.Manifest.permission.INTERNET,
            android.Manifest.permission.ACCESS_NETWORK_STATE,
            android.Manifest.permission.ACCESS_WIFI_STATE,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.WRITE_GSERVICES

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        if (!hasPermissions(HomeActivity.this, PERMISSIONS)) {
            Log.d("Home", "permission");
            ActivityCompat.requestPermissions(HomeActivity.this, PERMISSIONS, PERMISSION_ALL);
        }

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_action_name);

        double Currentlat = 26.901111;
        double CurrentLong = 75.800336;
        arrayList.add(new ListDeviceModel("1184", "Device A", 26.906699, 75.807460, distance(26.901111, 75.800336, 26.906699, 75.807460), bitmap, getAddress(26.906699, 75.807460)));
        arrayList.add(new ListDeviceModel("1185", "Device B", 26.903991, 75.813352, distance(26.901111, 75.800336, 26.903991, 75.813352), bitmap, getAddress(26.903991, 75.813352)));
        arrayList.add(new ListDeviceModel("1186", "Device C", 26.895793, 75.806334, distance(26.901111, 75.800336, 26.895793, 75.806334), bitmap, getAddress(26.895793, 75.806334)));
        arrayList.add(new ListDeviceModel("1187", "Device D", 26.898529, 75.800961, distance(26.901111, 75.800336, 26.898529, 75.800961), bitmap, getAddress(26.898529, 75.800961)));
        arrayList.add(new ListDeviceModel("1188", "Device E", 26.902062, 75.798825, distance(26.901111, 75.800336, 26.902062, 75.798825), bitmap, getAddress(26.902062, 75.798825)));


        Collections.sort(arrayList, new ListDeviceModelComparator());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());


        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.pager);

        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0);
        tabLayout.getTabAt(1);


        tabLayout.setOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    public boolean hasPermissions(Context context, String... permissions) {


        if (android.os.Build.VERSION.SDK_INT >= 21 && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }


        return true;
    }

    private double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1))
                * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    public String getAddress(double lat, double lng) {
        String strAdd = "";
        Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
            Address obj = addresses.get(0);


            Address returnedAddress = addresses.get(0);
            StringBuilder strReturnedAddress = new StringBuilder("");

            for (int i = 0; i < returnedAddress.getMaxAddressLineIndex(); i++) {
                strReturnedAddress.append(returnedAddress.getAddressLine(i)).append(" ");
            }
            strAdd = strReturnedAddress.toString();
            Log.d(TAG, "str add " + strAdd);
            return strAdd;


        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Intent in = new Intent(HomeActivity.this, PrefsActivity.class);
                startActivity(in);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public class ListDeviceModelComparator implements Comparator<ListDeviceModel> {
        public int compare(ListDeviceModel left, ListDeviceModel right) {
            if (left.getDevicedistance() > right.getDevicedistance()) {
                return 1;
            } else if (left.getDevicedistance() < right.getDevicedistance()) {
                return -1;

            } else
                return 0;
        }
    }

}
