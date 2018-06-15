package com.m00061016.gamenews.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.m00061016.gamenews.Objects.Player;
import com.m00061016.gamenews.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapterTopPlayer extends RecyclerView.Adapter<RecyclerViewAdapterTopPlayer.MyViewHolder> {
    Dialog playerdialog;
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
        final MyViewHolder viewHolder = new MyViewHolder(v);

        playerdialog = new Dialog(context);
        playerdialog.setContentView(R.layout.vista_topplayer);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView juego = (TextView) playerdialog.findViewById(R.id.vistaplayer_game);
                TextView biografia = (TextView) playerdialog.findViewById(R.id.vistaplayer_biografia);
                TextView name = (TextView) playerdialog.findViewById(R.id.vistaPlayer_name);
                ImageView imgplayer = (ImageView) playerdialog.findViewById(R.id.vistaplayer_avatar);

                juego.setText(playerList.get(viewHolder.getAdapterPosition()).getGame());
                biografia.setText(playerList.get(viewHolder.getAdapterPosition()).getBiografia());
                name.setText(playerList.get(viewHolder.getAdapterPosition()).getName());
                Picasso.with(context).load(playerList.get(viewHolder.getAdapterPosition()).getAvatar()).into(imgplayer);

                playerdialog.show();
            }
        });

        playerdialog.findViewById(R.id.vistaplayer_btnclose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerdialog.dismiss();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.playername.setText(playerList.get(position).getName());

        if(playerList.get(position).getAvatar().equals("Sin avatar")){
                holder.playerimage.setImageResource(R.drawable.ic_account_circle_black_24dp);
        }else {
            Picasso.with(context).load(playerList.get(position).getAvatar()).into(holder.playerimage);
        }
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView playername;
        private ImageView playerimage;

        public MyViewHolder(View itemView) {
            super(itemView);
            playername = (TextView) itemView.findViewById(R.id.item_game_topplayer_name);
            playerimage = (ImageView) itemView.findViewById(R.id.top_player_image);
        }
    }
}
