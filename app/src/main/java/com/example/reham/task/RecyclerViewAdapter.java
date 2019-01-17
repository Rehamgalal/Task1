package com.example.reham.task;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reham.task.Retrofit.Feed;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by reham on 1/15/2019.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context mContext;
    ItemClickListener mClickListener;
    List<Feed> items;

    public RecyclerViewAdapter(@NonNull Context context, List<Feed> items, ItemClickListener itemClickListener) {
        // this.mClickListener = itemClickListener;
        this.mContext = context;
        this.items = items;
        this.mClickListener = itemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater;
        mInflater = LayoutInflater.from(mContext);
        View view = mInflater.inflate(R.layout.recycler_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String imagePath = items.get(position).getPhoto();
        Picasso.with(mContext).load(imagePath).into(holder.imageView);
        String titleEn = items.get(position).getTitleEn();
        holder.textView.setText(titleEn);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface ItemClickListener {
        void onItemClick(int position, String titleEn);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.imageview)
        ImageView imageView;
        @BindView(R.id.text)
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            Typeface custom_font = Typeface.createFromAsset(mContext.getAssets(), "GE Dinar One Medium.ttf");
            textView.setTypeface(custom_font);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null)
                mClickListener.onItemClick(getAdapterPosition(), items.get(getAdapterPosition()).getTitleEn());

        }
    }
}
