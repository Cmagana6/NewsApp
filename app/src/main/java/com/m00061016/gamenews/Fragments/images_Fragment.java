package com.m00061016.gamenews.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.m00061016.gamenews.Adapters.RecyclerViewAdapterImages;
import com.m00061016.gamenews.Adapters.RecyclerViewAdapterNew;
import com.m00061016.gamenews.Objects.Image_class;
import com.m00061016.gamenews.Objects.New_class;
import com.m00061016.gamenews.R;

import java.util.ArrayList;
import java.util.List;

import static com.m00061016.gamenews.Fragments.general_fragment.generallist;
import static com.m00061016.gamenews.Fragments.general_fragment.imglist;


/**
 * A simple {@link Fragment} subclass.
 */
public class images_Fragment extends Fragment {

    private List<Image_class> imgList;
    private RecyclerView imgrc;
    View view;

    public images_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_fragment, container, false);
        imgrc = (RecyclerView) view.findViewById(R.id.rc_news);
        RecyclerViewAdapterImages recyclerViewAdapterImages = new RecyclerViewAdapterImages(getContext(), imglist);
        imgrc.setLayoutManager(new GridLayoutManager(getContext(),3));
        imgrc.setAdapter(recyclerViewAdapterImages);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imglist = new ArrayList<>();

    }

}
