

package com.m00061016.gamenews.Fragments;


import android.os.Bundle;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class general_fragment extends Fragment {

    private RecyclerView rcgeneral;
    private List<New_class> generallist;
    View view;

    public general_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.news_fragment, container, false);
        rcgeneral = (RecyclerView) view.findViewById(R.id.rc_news);
        RecyclerViewAdapterNew recyclerViewAdapterNew = new RecyclerViewAdapterNew(getContext(), generallist);
        rcgeneral.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rcgeneral.setAdapter(recyclerViewAdapterNew);
        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        generallist = new ArrayList<>();
        generallist.add(new New_class("1", "noticia 1", "body noticia 1", "Juego N1", "Image_class", "Desc N1", "08-05-2018", 1));
        generallist.add(new New_class("2", "noticia 2", "body noticia 2", "Juego N2", "Image_class", "Desc N2", "08-05-2018", 2));
        generallist.add(new New_class("3", "noticia 3", "body noticia 3", "Juego N3", "Image_class", "Desc N3", "08-05-2018", 3));
        generallist.add(new New_class("1", "noticia 1", "body noticia 1", "Juego N1", "Image_class", "Desc N1", "08-05-2018", 1));
        generallist.add(new New_class("2", "noticia 2", "body noticia 2", "Juego N2", "Image_class", "Desc N2", "08-05-2018", 2));
        generallist.add(new New_class("3", "noticia 3", "body noticia 3", "Juego N3", "Image_class", "Desc N3", "08-05-2018", 3));
        generallist.add(new New_class("1", "noticia 1", "body noticia 1", "Juego N1", "Image_class", "Desc N1", "08-05-2018", 1));
        generallist.add(new New_class("2", "noticia 2", "body noticia 2", "Juego N2", "Image_class", "Desc N2", "08-05-2018", 2));
        generallist.add(new New_class("3", "noticia 3", "body noticia 3", "Juego N3", "Image_class", "Desc N3", "08-05-2018", 3));

    }

}
