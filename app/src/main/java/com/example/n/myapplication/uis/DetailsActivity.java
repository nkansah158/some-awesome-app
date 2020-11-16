package com.example.n.myapplication.uis;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.n.myapplication.R;
import com.example.n.myapplication.models.DemoModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import static android.graphics.Color.parseColor;


/**
 * Created by User on 1/2/2018.
 */

public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";
    ActionBar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Log.d(TAG, "onCreate: started.");
        toolbar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(parseColor("#FFFFFF"));
        toolbar.setBackgroundDrawable(colorDrawable);

        DemoModel demoModel = getIntent().getParcelableExtra("demoData");
        Glide.with(this).load(demoModel.getImgUrl()).into((ImageView) findViewById(R.id.image));
         TextView description = (TextView) findViewById(R.id.image_description);
         description.setText(demoModel.getCityName());
        toolbar.setTitle(demoModel.getCityName());
    }


}


















