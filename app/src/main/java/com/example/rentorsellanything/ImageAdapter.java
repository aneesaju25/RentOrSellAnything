package com.example.rentorsellanything;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    String[] category = {"Honda","Mobile"};

    public ImageAdapter(Context c) {
        mContext = c;
    }
    public int getCount() {
        return thumbImages.length;
    }
    public Object getItem(int position) {
        return null;
    }
    public long getItemId(int position) {
        return 0;
    }
    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_data, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_item_label);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_item_image);
            textView.setText(category[position]);
            imageView.setImageResource(thumbImages[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
    // Add all our images to arraylist
    public Integer[] thumbImages = {
            R.drawable.honda, R.drawable.splash_image

    };
}