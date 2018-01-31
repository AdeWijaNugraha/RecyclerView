package com.awn.app.myrecycleview;

import android.view.View;

/**
 * Created by adewijanugraha on 31/01/18.
 */

public class CustomOnItemClickListener implements View.OnClickListener{
    private int position;
    private OnItemCLickCallback onItemCLickCallback;

    public CustomOnItemClickListener(int position, OnItemCLickCallback onItemCLickCallback){
        this.position = position;
        this.onItemCLickCallback = onItemCLickCallback;
    }

    @Override
    public void onClick(View v) {
        onItemCLickCallback.onItemClicked(v, position);
    }

    public interface OnItemCLickCallback{
        void onItemClicked(View view, int position);
    }
}
