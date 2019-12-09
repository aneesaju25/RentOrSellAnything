package com.example.rentorsellanything;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FindAnItem extends Fragment {


    String[] values = new String[] { "Sofa",
            "Chair",
            "Table",
            "Bed",
            "Kids Furniture",
            "Home Decor"
    };

    String[] vehicles = new String[] { "Cars",
            "Bikes",
            "Commercial",
            "Bycycles"
    };
    String[] fashion = new String[] { "Men",
            "Women",
            "Kids"
    };
    public void FindAnItem() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.find_an_item, container, false);
        //now you must initialize your list view
        final ListView yourListView = (ListView)rootView.findViewById(R.id.listview);
        yourListView.setAdapter(new PasswordAdapter(getActivity(),R.layout.list_item,values));
        yourListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = yourListView.getItemAtPosition(position);
                Intent intentBlock = new Intent(view.getContext(), SearchResultsActivity.class);
                startActivity(intentBlock);
            }
        });

        ImageButton imageButton = (ImageButton)rootView.findViewById(R.id.VehicleButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yourListView.setAdapter(new PasswordAdapter(getActivity(),R.layout.list_item,getResources().getStringArray(R.array.Vehicles)));
            }
        });
        ImageButton imageButton1 = (ImageButton)rootView.findViewById(R.id.FashionButton);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                yourListView.setAdapter(new PasswordAdapter(getActivity(),R.layout.list_item,fashion));
            }
        });
        ImageButton imageButton2 = (ImageButton)rootView.findViewById(R.id.FurnitureButton);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                yourListView.setAdapter(new PasswordAdapter(getActivity(),R.layout.list_item,values));
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }
    class PasswordAdapter extends ArrayAdapter {

        public PasswordAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v=((Activity)getContext()).getLayoutInflater().inflate(R.layout.list_item,null);
            TextView txt1 = (TextView) v.findViewById(R.id.textView);
            txt1.setText(values[position]);

            return v;
        }
    }

}
