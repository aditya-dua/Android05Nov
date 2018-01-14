package com.adityadua.materialdesign5ndemo;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AdityaDua on 06/01/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private  ItemData[] itemsData;

    public MyAdapter(ItemData[] itemsData) {
        this.itemsData = itemsData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.row,null);

        ViewHolder vh = new ViewHolder(view);

        return  vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.textViewTitle.setText(itemsData[position].getName());
        holder.textViewFeatures.setText(itemsData[position].getFeatures());
        holder.imageViewIcon.setImageResource(itemsData[position].getUrl());

        holder.textViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v,"Clicked On ::"+itemsData[position].getName(),
                        Snackbar.LENGTH_LONG).setAction("Action Here",null).show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return itemsData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewTitle;
        public ImageView imageViewIcon;
        public TextView textViewFeatures;


        public ViewHolder(View itemView) {
            super(itemView);

            textViewTitle = (TextView) itemView.findViewById(R.id.textView2);
            textViewFeatures = (TextView) itemView.findViewById(R.id.textView3);
            imageViewIcon = (ImageView)itemView.findViewById(R.id.imageView);

        }
    }

}
