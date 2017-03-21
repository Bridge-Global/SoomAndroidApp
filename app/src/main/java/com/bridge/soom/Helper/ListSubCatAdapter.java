package com.bridge.soom.Helper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bridge.soom.Activity.GetCatActivity;
import com.bridge.soom.Activity.GetSubCatActivity;
import com.bridge.soom.R;

import java.util.List;

/**
 * Created by Thaher-Majeed on 21-03-2017.
 */

public class ListSubCatAdapter extends RecyclerView.Adapter<ListSubCatAdapter.MyViewHolder>{

    private List<String> list;
    private Context context;
    private GetSubCatActivity mactivty;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public RelativeLayout listItem;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            listItem = (RelativeLayout) view.findViewById(R.id.list_item);

        }
    }


    public ListSubCatAdapter(List<String> moviesList, GetSubCatActivity mactivty, Context context) {
        this.list = moviesList;
        this.context =context;
        this.mactivty = mactivty;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);



        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        String movie = list.get(position);
        holder.title.setText(movie);
        holder.listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mactivty.startNextRest(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}