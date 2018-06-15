package com.m00061016.gamenews.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
    int position;
    Dialog myD;
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
       final MyViewHolder vHolder = new MyViewHolder(v);

        myD = new Dialog(context);
        myD.setContentView(R.layout.vista_noticia);
        myD.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        vHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView title = (TextView) myD.findViewById(R.id.vistanoticia_titulo);
                TextView game = (TextView) myD.findViewById(R.id.vistanoticia_juego);
                TextView body = (TextView) myD.findViewById(R.id.vistanoticia_body);
                TextView date = (TextView) myD.findViewById(R.id.vistanoticia_fecha);
                ImageView img = (ImageView) myD.findViewById(R.id.vistanoticia_imagen);
                TextView desc = (TextView) myD.findViewById(R.id.vistanoticia_desc);

                title.setText(NewsListData.get(vHolder.getAdapterPosition()).getTitle());
                desc.setText(NewsListData.get(vHolder.getAdapterPosition()).getDescription());
                game.setText(NewsListData.get(vHolder.getAdapterPosition()).getGame());
                body.setText(NewsListData.get(vHolder.getAdapterPosition()).getBody());
                date.setText(NewsListData.get(vHolder.getAdapterPosition()).getCreated_date());
                Picasso.with(context).load(NewsListData.get(vHolder.getAdapterPosition()).getCoverImage()).into(img);

                myD.show();
            }
        });

        myD.findViewById(R.id.vistanoticia_btnclose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myD.dismiss();
            }
        });

       return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterNew.MyViewHolder holder, int position) {
        holder.news_title.setText(NewsListData.get(position).getTitle());
        holder.news_game.setText(NewsListData.get(position).getGame());
        Picasso.with(context).load(NewsListData.get(position).getCoverImage()).into(holder.new_image);

    }

    @Override
    public int getItemCount() {
        return NewsListData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView news_title, news_game;
        private ImageView new_image;
        public MyViewHolder(View itemView) {
            super(itemView);
            new_image = (ImageView) itemView.findViewById(R.id.item_new_image);
             news_title = (TextView) itemView.findViewById(R.id.item_new_title);
            news_game = (TextView) itemView.findViewById(R.id.item_new_game);

        }

    }

}
