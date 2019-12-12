package com.example.rentorsellanything;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class PostAnItem extends Fragment {


    String[] mimeTypes = {"image/jpeg","image/png"};
    public void PostAnItem() {
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

        final View rootView = inflater.inflate(R.layout.post_an_item, container, false);

        final Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        ImageButton imageButton = (ImageButton) rootView.findViewById(R.id.uploadItemImgBtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                galleryIntent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
                startActivityForResult(galleryIntent,REQ_GALLERY);
            }
        });


        return rootView;
    }
}
