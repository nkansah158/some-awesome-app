package com.example.n.myapplication.uis;

import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.n.myapplication.R;

import java.util.ArrayList;

import static android.graphics.Color.parseColor;

public class SearchActivity extends Activity {
    androidx.appcompat.app.ActionBar toolbar;
    Context mContext;
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    String res;

    TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        textView=(TextView) findViewById(R.id.image_name);

        ColorDrawable colorDrawable= new ColorDrawable(parseColor("#FFFFFF"));
        toolbar.setBackgroundDrawable(colorDrawable);
        handleIntent(getIntent());



    }

   @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        handleIntent(getIntent());


    }
    private void handleIntent(Intent intent){
        if (Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query=intent.getStringExtra(SearchManager.QUERY);
//            RecyclerViewAdapter adapter=new RecyclerViewAdapter(this,mNames,mImageUrls);
            if(query.contains((CharSequence) mNames)){
                textView.setText((CharSequence) mNames);
            }else{
                textView.setText("Not found");
            }
        }
    }
}
