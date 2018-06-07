package com.m00061016.gamenews.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m00061016.gamenews.Adapters.RecyclerViewAdapterTopPlayer;
import com.m00061016.gamenews.Objects.Player;
import com.m00061016.gamenews.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class top_players_fragment extends Fragment {

    private RecyclerView rctopplayer;
    private List<Player> playerList;
    View view;

    public top_players_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_top_players_fragment,container,false);
        rctopplayer = (RecyclerView) view.findViewById(R.id.rc_game_topplayer);
        RecyclerViewAdapterTopPlayer recyclerViewAdapterTopPlayer = new RecyclerViewAdapterTopPlayer(getContext(),playerList);
        rctopplayer.setLayoutManager(new LinearLayoutManager(getActivity()));
        rctopplayer.setAdapter(recyclerViewAdapterTopPlayer);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playerList = new ArrayList<>();
        playerList.add(new Player(1,"ninja","Culero que juega fortnite","aiosdnd","Fortnite"));
        playerList.add(new Player(2,"Lolito","Pendejo que juega fortnite","aiosdnd","Fortnite"));
        playerList.add(new Player(3,"WillyRex","Cerote que juega fortnite","aiosdnd","Fortnite"));
    }
}
