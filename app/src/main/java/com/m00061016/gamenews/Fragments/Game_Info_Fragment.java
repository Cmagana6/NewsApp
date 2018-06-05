package com.m00061016.gamenews.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m00061016.gamenews.Adapters.ViewPagerAdapterGames;
import com.m00061016.gamenews.R;

public class Game_Info_Fragment extends Fragment {

    private TabLayout tab;
    private ViewPager vp;
    private ViewPagerAdapterGames vpg;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.gameinfo_fragment,container,false);

        tab = (TabLayout) view.findViewById(R.id.gameinfo_menu);
        vp = (ViewPager) view.findViewById(R.id.viewpager_game);
        vpg = new ViewPagerAdapterGames(getChildFragmentManager());

        vpg.AddFragment(new general_fragment(), "GENERALS");
        vpg.AddFragment(new top_players_fragment(), "TOP PLAYERS");
        vpg.AddFragment(new images_Fragment(), "IMAGES");

        tab.setTabTextColors(Color.parseColor("#727272"),Color.parseColor("#ffffff"));

        vp.setAdapter(vpg);
        tab.setupWithViewPager(vp);

        return view;
    }



}
