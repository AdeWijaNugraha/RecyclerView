package com.awn.app.myrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by adewijanugraha on 31/01/18.
 */

public class StaggeredGridPresidentAdapter extends RecyclerView.Adapter<StaggeredGridPresidentAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<President> listPresident;

    ArrayList<President> getListPresident() {
        return listPresident;
    }

    void setListPresident(ArrayList<President> listPresident) {
        this.listPresident = listPresident;
    }

    StaggeredGridPresidentAdapter(Context context) {
        this.context = context;
    }

    @Override
    public StaggeredGridPresidentAdapter.CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_staggered_grid_president, parent, false);
        return new StaggeredGridPresidentAdapter.CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(StaggeredGridPresidentAdapter.CategoryViewHolder holder, int position) {
        holder.tvName.setText(getListPresident().get(position).getName());
        Glide.with(context)
                .load(getListPresident().get(position).getPhoto())
                .override(250, 550)
                .crossFade()
                .into(holder.imgPhoto);
    }

    public int getItemCount() {
        return getListPresident().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView imgPhoto;

        CategoryViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_item_name);
            imgPhoto = (ImageView) itemView.findViewById(R.id.img_item_photo);
        }
    }
}
