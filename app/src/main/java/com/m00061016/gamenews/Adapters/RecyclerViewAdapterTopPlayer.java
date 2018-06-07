package com.m00061016.gamenews.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.m00061016.gamenews.Objects.Player;
import com.m00061016.gamenews.R;

import java.util.List;

public class RecyclerViewAdapterTopPlayer extends RecyclerView.Adapter<RecyclerViewAdapterTopPlayer.MyViewHolder> {

    Context context;
    List<Player> playerList;

    public RecyclerViewAdapterTopPlayer(Context context,List<Player> playerlist) {
        this.context = context;
        this.playerList = playerlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;

        v= LayoutInflater.from(context).inflate(R.layout.topplayer_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.playerdesc.setText(playerList.get(position).getBiografia());
        holder.playername.setText(playerList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView playername, playerdesc;


        public MyViewHolder(View itemView) {
            super(itemView);
            playername = (TextView) itemView.findViewById(R.id.item_game_topplayer_name);
            playerdesc = (TextView) itemView.findViewById(R.id.item_game_toplayer_desc);

        }
    }
}
