package com.example.n.myapplication.adpaters;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.n.myapplication.uis.DetailsActivity;
import com.example.n.myapplication.R;
import com.example.n.myapplication.models.DemoModel;

import java.util.ArrayList;
import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements Filterable {


    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;
    private ArrayList<String> filteredData = new ArrayList<>();
    private List<DemoModel> demoModelLists = new ArrayList<>();
    private List<DemoModel> unfilteredDemoList = new ArrayList<>();


    public RecyclerViewAdapter(Context mContext, List<DemoModel> demoModelLists) {
        this.mContext = mContext;
        this.demoModelLists = demoModelLists;
        this.unfilteredDemoList = demoModelLists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        DemoModel demoModel = demoModelLists.get(position);
        holder.imageName.setText(demoModel.getCityName());


        if (!demoModel.getImgUrl().isEmpty()){
            Glide.with(mContext)
                    .asBitmap()
                    .load(demoModelLists.get(position).getImgUrl())
                    .into(holder.image);
        }


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtra("demoData", demoModelLists.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return demoModelLists.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                List<DemoModel> semiFilter = new ArrayList<>();
                if (charSequence == null || charSequence.length() == 0) {
                    filterResults.values = unfilteredDemoList;
                    filterResults.count = unfilteredDemoList.size();
                } else {
                    ArrayList<String> data = new ArrayList<String>();
                    String searchValue = charSequence.toString().toLowerCase();


                    for (DemoModel demoModel : demoModelLists) {
                        if (demoModel.getCityName().toLowerCase().contains(charSequence.toString())){
                          semiFilter.add(demoModel);
                        }
                    }

                    filterResults.values = semiFilter;
                    filterResults.count = semiFilter.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                demoModelLists = ((ArrayList<DemoModel>) filterResults.values);
                notifyDataSetChanged();

            }
        };
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView imageName;
        CardView parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}








