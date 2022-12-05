package com.example.pruebarecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter{

    private List mDataset;
    private Context context;

    public MyAdapter(Context c) {
        this.context = c;
        mDataset = new ArrayList();
    }

    public void add(Item i) {
        mDataset.add(i);
        notifyItemInserted(mDataset.indexOf(i));
    }
    public void remove(Item item) {
        int position = mDataset.indexOf(item);

        if(position != -1) {
            mDataset.remove(position);
            notifyItemRemoved(position);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Item item = (Item) mDataset.get(position);
        ViewHolder hold = (ViewHolder) holder;
        hold.imageView.setImageDrawable(item.getImageSrc());
        hold.mTextView.setText(item.getName());


        hold.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            imageView = (ImageView) v.findViewById(R.id.ivItem);
            mTextView = (TextView) v.findViewById(R.id.tvItem);
        }
    }

}
