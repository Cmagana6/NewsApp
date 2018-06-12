package com.m00061016.gamenews.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.m00061016.gamenews.Objects.New_class;
import com.m00061016.gamenews.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapterNew extends RecyclerView.Adapter<RecyclerViewAdapterNew.MyViewHolder>{

    Context context;
    List<New_class> NewsListData;

    public RecyclerViewAdapterNew(Context context, List<New_class> NewsListData){
        this.context = context;
        this.NewsListData = NewsListData;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterNew.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v;
       v = LayoutInflater.from(context).inflate(R.layout.news_item,parent,false);
       MyViewHolder vHolder = new MyViewHolder(v);
       return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterNew.MyViewHolder holder, int position) {
        holder.news_title.setText(NewsListData.get(position).getTitle());
        holder.news_desc.setText(NewsListData.get(position).getBody());

        Picasso.with(context).load(NewsListData.get(position).getCoverImage()).into(holder.new_image);

        final ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if(position == 0 || position%3==0){
            StaggeredGridLayoutManager.LayoutParams sglp = (StaggeredGridLayoutManager.LayoutParams) lp;
            sglp.setFullSpan(true);
            holder.itemView.setLayoutParams(sglp);
        }

    }

    @Override
    public int getItemCount() {
        return NewsListData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView news_title, news_desc;
        private ImageView new_image;
        public MyViewHolder(View itemView) {
            super(itemView);
            new_image = (ImageView) itemView.findViewById(R.id.item_new_image);
             news_title = (TextView) itemView.findViewById(R.id.item_new_title);
            news_desc = (TextView) itemView.findViewById(R.id.item_new_desc);

        }

    }

}
