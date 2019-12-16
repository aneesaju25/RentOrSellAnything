package com.example.rentorsellanything;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MyProfile extends Fragment {

    String[] mimeTypes = {"image/jpeg","image/png"};

    public void MyProfile() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final int REQ_GALLERY = 0;

        final View rootView = inflater.inflate(R.layout.my_profile, container, false);

        final Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        ImageButton imageButton = (ImageButton) rootView.findViewById(R.id.uploadUserImgBtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                galleryIntent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
                startActivityForResult(galleryIntent,REQ_GALLERY);
            }
        });


        final TextView textView = (TextView)rootView.findViewById(R.id.tvEditProfile);
        final TextView textView1 = (TextView)rootView.findViewById(R.id.tvMyPosts);
        final TextView textView2 = (TextView)rootView.findViewById(R.id.tvWishlist);
        final LinearLayout linearLayout =(LinearLayout)rootView.findViewById(R.id.editProfile);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.VISIBLE);
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBlock = new Intent(v.getContext(), MyActivity.class);
                startActivity(intentBlock);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBlock = new Intent(v.getContext(), MyActivity.class);
                startActivity(intentBlock);
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }
}
