package com.techoutsource.mparking;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.techoutsource.mparking.adapters.DashboardAdapter;
import com.techoutsource.mparking.model.DashboardModel;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {
    private GridView gvGallery;
    private DashboardAdapter gridBaseAdapter;
    private ArrayList<DashboardModel> imageModelArrayList;

    private int[] myImageList = new int[]{R.drawable.pay_parking_fee, R.drawable.pay_traffic_offence,
            R.drawable.manage_my_car, R.drawable.breakdown, R.drawable.traffic_car_jam, R.drawable.road_accident, R.drawable.mistreated,};
    private String[] myImageNameList = new String[]{"Pay Parking Fees", "Pay Fines",
            "Manage My Car", "B/down Services", "Report Traffic Jam", "Report Accident", "Treated Badly ?",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        gvGallery = findViewById(R.id.dashboard_gridview);

        imageModelArrayList = populateList();

        gridBaseAdapter = new DashboardAdapter(getApplicationContext(), imageModelArrayList);
        gvGallery.setAdapter(gridBaseAdapter);

        gvGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent payparkingfees = new Intent(getApplicationContext(), PayParkingFeesActivity.class);
                        payparkingfees.putExtra("id", position);
                        startActivity(payparkingfees);
                        break;
                    case 1:
                        Intent payfines = new Intent(getApplicationContext(), PayFinesActivity.class);
                        payfines.putExtra("id", position);
                        startActivity(payfines);
                        break;
                    case 2:
                        Intent managemycar = new Intent(getApplicationContext(), ManageMyCarActivity.class);
                        managemycar.putExtra("id", position);
                        startActivity(managemycar);
                        break;
                    case 3:
                        Intent breakdownservices = new Intent(getApplicationContext(), BreakdownServicesActivity.class);
                        breakdownservices.putExtra("id", position);
                        startActivity(breakdownservices);
                        break;
                    case 4:
                        Intent reporttrafficjam = new Intent(getApplicationContext(), ReportTrafficJamActivity.class);
                        reporttrafficjam.putExtra("id", position);
                        startActivity(reporttrafficjam);
                        break;
                    case 5:
                        Intent reportaccident = new Intent(getApplicationContext(), ReportAccidentActivity.class);
                        reportaccident.putExtra("id", position);
                        startActivity(reportaccident);
                        break;
                    case 6:
                        Intent treatedbadly = new Intent(getApplicationContext(), BadlyTreatedActivity.class);
                        treatedbadly.putExtra("id", position);
                        startActivity(treatedbadly);
                        break;
                    default:
                        break;
                }
            }
        });

    }

    private ArrayList<DashboardModel> populateList() {
        ArrayList<DashboardModel> list = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            DashboardModel imageModel = new DashboardModel();
            imageModel.setName(myImageNameList[i]);
            imageModel.setImage_drawable(myImageList[i]);
            list.add(imageModel);
        }

        return list;
    }
}
