package com.techoutsource.mparking.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.techoutsource.mparking.R;
import com.techoutsource.mparking.model.DashboardModel;

import java.util.ArrayList;

public class DashboardAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<DashboardModel> dashboardModelArrayList;
    private TextView dashboardTextView;
    private ImageView dashboardImageView;

    public DashboardAdapter(Context coxt, ArrayList<DashboardModel> dashboardModels) {
        this.context = coxt;
        this.dashboardModelArrayList = dashboardModels;
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return dashboardModelArrayList.size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return dashboardModelArrayList.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View imageView = layoutInflater.inflate(R.layout.dashboard_template, parent, false);
        dashboardImageView = (ImageView) imageView.findViewById(R.id.dashboard_imageView);
        dashboardTextView = (TextView) imageView.findViewById(R.id.dashboard_textView);
        dashboardImageView.setImageResource(dashboardModelArrayList.get(position).getImage_drawable());
        dashboardTextView.setText(dashboardModelArrayList.get(position).getName());
        return imageView;
    }
    public Integer[] imageThumbIds = {
            R.drawable.pay_parking_fee, R.drawable.pay_traffic_offence,
            R.drawable.manage_my_car, R.drawable.breakdown,R.drawable.traffic_car_jam,
            R.drawable.road_accident, R.drawable.mistreated,
    };
}
