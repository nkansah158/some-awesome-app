package com.example.n.myapplication.uis;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.n.myapplication.R;
import com.example.n.myapplication.adpaters.RecyclerViewAdapter;
import com.example.n.myapplication.models.DemoModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.ContentValues.TAG;

public class ProfileFragment extends Fragment {
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    BottomNavigationView bottomNavigationView;
    TextView textView;
    RecyclerView recyclerView;
    private Context mContext;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.profile_fragment, container, false);
    initRecyclerView(view);

        return view;
    }






    private void initRecyclerView(View view) {
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        recyclerView = (RecyclerView)  view.findViewById(R.id.recyclerv_view);
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(),initDemoList());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
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


}
