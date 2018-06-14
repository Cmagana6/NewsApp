package com.m00061016.gamenews.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.m00061016.gamenews.Objects.Image_class;
import com.m00061016.gamenews.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapterImages extends RecyclerView.Adapter<RecyclerViewAdapterImages.MyViewHolder> {

    Context context;
    List<Image_class> imageList;

   public RecyclerViewAdapterImages(Context context, List<Image_class> imageList){
       this.context = context;
       this.imageList = imageList;

    }

    @NonNull
    @Override
    public RecyclerViewAdapterImages.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.image_item,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.with(context).load(imageList.get(position).GetUrl()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            image= (ImageView) itemView.findViewById(R.id.item_fragment_image);
        }
    }


}
