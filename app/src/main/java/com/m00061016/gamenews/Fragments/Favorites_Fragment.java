package com.m00061016.gamenews.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m00061016.gamenews.Adapters.RecyclerViewAdapterNew;
import com.m00061016.gamenews.Objects.New_class;
import com.m00061016.gamenews.R;

import java.util.ArrayList;
import java.util.List;


public class Favorites_Fragment extends Fragment {

    private RecyclerView fvrecyclerview;
    private List<New_class> favlist;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fav_fragment, container, false);
        fvrecyclerview = (RecyclerView) view.findViewById(R.id.rc_fav_fragment);
        RecyclerViewAdapterNew recyclerViewAdapterNew = new RecyclerViewAdapterNew(getContext(), favlist);
        fvrecyclerview.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        fvrecyclerview.setAdapter(recyclerViewAdapterNew);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        favlist = new ArrayList<>();
        favlist.add(new New_class("1", "noticia 1 fav", "body noticia 1", "Juego N1", "Image_class", "Desc N1", "08-05-2018", 1));
        favlist.add(new New_class("2", "noticia 2", "body noticia 2", "Juego N2", "Image_class", "Desc N2", "08-05-2018", 2));
        favlist.add(new New_class("3", "noticia 3", "body noticia 3", "Juego N3", "Image_class", "Desc N3", "08-05-2018", 3));
        favlist.add(new New_class("1", "noticia 1", "body noticia 1", "Juego N1", "Image_class", "Desc N1", "08-05-2018", 1));

    }

}
