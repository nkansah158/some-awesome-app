package com.example.n.myapplication.uis;


import android.app.SearchManager;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.n.myapplication.R;
import com.example.n.myapplication.adpaters.RecyclerViewAdapter;
import com.example.n.myapplication.models.DemoModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.graphics.Color.parseColor;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private List<DemoModel> demoModelList = new ArrayList<>();
    private Context mContext;
    //private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private RecyclerViewAdapter adapter;
    BottomNavigationView bottomNavigationView;
    TextView textView;
    RecyclerView recyclerView;
    Fragment fragment;
    androidx.appcompat.app.ActionBar toolbar;
    Button button;
    SearchView searchView;

    AppCompatEditText appCompatEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        textView = (TextView) findViewById(R.id.textView);
        loadFragment(new HomeFragment());
        toolbar = getSupportActionBar();
        toolbar.setTitle("Home");
        ColorDrawable colorDrawable = new ColorDrawable(parseColor("#FFFFFF"));
        toolbar.setBackgroundDrawable(colorDrawable);


//
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerv_view);
//        //adapter = new RecyclerViewAdapter(this,mNames,mImageUrls);
//        // recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
//        recyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch ((item.getItemId())) {
            case R.id.action_search:
                onSearchRequested();
                return true;
            default:
                return false;
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.home:
                    fragment = new HomeFragment();
                    toolbar.setTitle("Home");
                    loadFragment(fragment);
                    return true;
                case R.id.camera:
                    fragment = new CameraFragment();
                    toolbar.setTitle("Camera");
                    loadFragment(fragment);
                    return true;
                case R.id.profile:
                    fragment = new ProfileFragment();
                    toolbar.setTitle("Profile");
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }

        ;

    };


    public void loadFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();

    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerv_view);
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,initDemoList());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<DemoModel> initDemoList() {
        List<DemoModel> demoList = new ArrayList<>();

        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");


        demoList.add(
                new DemoModel("Havasu Falls", "https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg")
        );
        demoList.add(
                new DemoModel("Trondheim", "https://i.redd.it/tpsnoz5bzo501.jpg")
        );
        demoList.add(
                new DemoModel("Portugal", "https://i.redd.it/qn7f9oqu7o501.jpg")
        );
        demoList.add(
                new DemoModel("Rocky Mountain National Park", "https://i.redd.it/j6myfqglup501.jpg")
        );
        demoList.add(
                new DemoModel("Mahahual", "https://i.redd.it/0h2gm1ix6p501.jpg")
        );
        demoList.add(
                new DemoModel("Frozen Lake", "https://i.redd.it/k98uzl68eh501.jpg")
        );
        demoList.add(
                new DemoModel("White Sands Desert", "https://i.redd.it/glin0nwndo501.jpg")
        );
        demoList.add(
                new DemoModel("Austrailia", "https://i.redd.it/obx4zydshg601.jpg")
        );
        demoList.add(
                new DemoModel("Washington", "https://i.imgur.com/ZcLLrkY.jpg")
        );

        return demoList;
    }

    // private  void fillExampleList(){
    //   mArrayList= new ArrayList<>();
    // mArrayList.add(new ExampleItem(R.drawable.ic_baseline_adb_24,"Hello"));
    //mArrayList.add(new ExampleItem(R.drawable.ic_baseline_adb_24,"Hello"));

}