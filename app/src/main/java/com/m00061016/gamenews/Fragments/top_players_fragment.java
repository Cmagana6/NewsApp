package com.m00061016.gamenews.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m00061016.gamenews.Adapters.RecyclerViewAdapterImages;
import com.m00061016.gamenews.Adapters.RecyclerViewAdapterTopPlayer;
import com.m00061016.gamenews.Helpers.RetrofitService;
import com.m00061016.gamenews.Interfaces.UserInterface;
import com.m00061016.gamenews.Objects.Player;
import com.m00061016.gamenews.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.m00061016.gamenews.Activities.LoginActivity.Tokenglobal;
import static com.m00061016.gamenews.Activities.MainActivity.flagcsgo;
import static com.m00061016.gamenews.Activities.MainActivity.flaglol;
import static com.m00061016.gamenews.Activities.MainActivity.flagoverwatch;


/**
 * A simple {@link Fragment} subclass.
 */
public class top_players_fragment extends Fragment {
    String baseUrl;
    String juego;
    List<Player> auxiliar =null;
    Call<List<Player>> callplayer;
    Retrofit retrofit;
    private RecyclerView rctopplayer;
    private List<Player> playerList;
    String avatar;
    String name;
    String biografia;
    String game;
    String __v;
    View view;

    public top_players_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_top_players_fragment,container,false);
        LoadPlayer(view);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playerList = new ArrayList<>();
       }

       public void LoadPlayer(final View v){
        baseUrl ="http://gamenewsuca.herokuapp.com/";

        if(retrofit == null){
            retrofit= new Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

           UserInterface userInterface = retrofit.create(UserInterface.class);

        callplayer = userInterface.getPlayers("Bearer "+Tokenglobal);

        callplayer.enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
                auxiliar = response.body();
                playerList = new ArrayList<>();
                if(flagcsgo){
                    juego="csgo";
                }else if(flaglol){
                    juego="lol";
                }else if(flagoverwatch){
                    juego="overwatch";
                }
               for(int i=0;i<auxiliar.size();i++) {
                   if (auxiliar.get(i).getGame().equals(juego)) {

                       if (auxiliar.get(i).getAvatar() == null) {
                           avatar = "Sin avatar";
                       } else {
                           avatar = auxiliar.get(i).getAvatar();
                       }
                       if (auxiliar.get(i).getName() == null) {
                           name = "Sin nombre";
                       } else {
                           name = auxiliar.get(i).getName();
                       }
                       if (auxiliar.get(i).getBiografia() == null) {
                           biografia = "Sin biografia";
                       } else {
                           biografia = auxiliar.get(i).getBiografia();
                       }
                       if (auxiliar.get(i).getGame() == null) {
                           game = "Sin juego";
                       } else {
                           game = auxiliar.get(i).getGame();
                       }

                       playerList.add(new Player(auxiliar.get(i).get_id(), name, biografia, avatar, game, auxiliar.get(i).get__v()));
                   }
               }

               rctopplayer = (RecyclerView) v.findViewById(R.id.rc_game_topplayer);
               RecyclerViewAdapterTopPlayer recyclerViewAdapterTopPlayer = new RecyclerViewAdapterTopPlayer(getContext(),playerList);
               rctopplayer.setLayoutManager(new LinearLayoutManager(getActivity()));
               rctopplayer.setAdapter(recyclerViewAdapterTopPlayer);

            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {

            }
        });

       }
}
