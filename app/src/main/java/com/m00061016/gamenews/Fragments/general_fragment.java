
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

import com.m00061016.gamenews.Adapters.RecyclerViewAdapterNew;
import com.m00061016.gamenews.Interfaces.UserInterface;
import com.m00061016.gamenews.Objects.Image_class;
import com.m00061016.gamenews.Objects.New_class;
import com.m00061016.gamenews.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import static com.m00061016.gamenews.Activities.MainActivity.flagcsgo;
import static com.m00061016.gamenews.Activities.MainActivity.flaglol;
import static com.m00061016.gamenews.Activities.MainActivity.flagoverwatch;
import static com.m00061016.gamenews.Fragments.News_Fragments.listnews;


/**
 * A simple {@link Fragment} subclass.
 */
public class general_fragment extends Fragment {

    private RecyclerView rcgeneral;
    public static List<New_class> generallist;
    public static List<Image_class> imglist;
    private UserInterface helper;
    private String baseUrl;
    private Retrofit retrofit;
    private Call<List<New_class>> call;
    private List<New_class> auxiliar;
    private List<New_class> listToSend,listGame;
    private String title, body, game, coverImage, desc, created_date;
    public static String juego;
    View view;

    public general_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_general_fragment, container, false);
        loadNewsGeneral(view);
        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public void loadNewsGeneral( View v) {
        auxiliar = listnews;
        generallist = new ArrayList<>();
        if(flagcsgo){
            juego="csgo";
        }else if(flaglol){
            juego="lol";
        }else if(flagoverwatch){
            juego="overwatch";
        }

        for(int i=0;i<auxiliar.size();i++){
            if(auxiliar.get(i).getGame().equals(juego)){
                game = auxiliar.get(i).getGame();
                coverImage= auxiliar.get(i).getCoverImage();
            body= auxiliar.get(i).getBody();
            desc=auxiliar.get(i).getDescription();
            title=auxiliar.get(i).getTitle();
            created_date= auxiliar.get(i).getCreated_date();
            generallist.add(new New_class(auxiliar.get(i).get_id(),title,body,game,coverImage,desc,created_date,auxiliar.get(i).get__v()));
            }

        }

        rcgeneral = (RecyclerView) view.findViewById(R.id.rc_game_general);
        RecyclerViewAdapterNew recyclerViewAdapterNew = new RecyclerViewAdapterNew(getContext(), generallist);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(position%3==0 ){
                    return 2;
                }
                else{
                    return 1;
                }
            }
        });

        rcgeneral.setLayoutManager(gridLayoutManager);
        rcgeneral.setAdapter(recyclerViewAdapterNew);

    }
}
