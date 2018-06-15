package com.m00061016.gamenews.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m00061016.gamenews.Adapters.RecyclerViewAdapterNew;
import com.m00061016.gamenews.Helpers.RetrofitService;
import com.m00061016.gamenews.Interfaces.UserInterface;
import com.m00061016.gamenews.Objects.Image_class;
import com.m00061016.gamenews.Objects.New_class;
import com.m00061016.gamenews.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.m00061016.gamenews.Activities.LoginActivity.Tokenglobal;

public class News_Fragments extends Fragment {

    private RecyclerView newsRecyclerView;
    public static List<New_class> listnews;
    private UserInterface helper;
    private String baseUrl;
    private Retrofit retrofit;
    private Call<List<New_class>> call;
    private List<New_class> auxiliar = null;
    public static List<New_class> listToSend;
    private String title, body, game, coverImage, desc, created_date;
    View view;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_fragment, container, false);
        loadNews(view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public void loadNews(final View v) {

        baseUrl = "http://gamenews.uca.herokuapp.com/";

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        helper = RetrofitService.getRetrofitInstance().create(UserInterface.class);

        call = helper.getNews("Bearer "+Tokenglobal);

        call.enqueue(new Callback<List<New_class>>() {
            @Override
            public void onResponse(Call<List<New_class>> call, Response<List<New_class>> response) {
                auxiliar = response.body();
                listToSend = new ArrayList<>();
            if(listToSend.size()==0) {
                for (int i = 0; i < auxiliar.size(); i++) {
                    if (auxiliar.get(i).getTitle() == null) title = "noticia sin titulo";
                    else {
                        title = auxiliar.get(i).getTitle();
                    }
                    if (auxiliar.get(i).getBody() == null) body = "noticia sin cuerpo";
                    else {
                        body = auxiliar.get(i).getBody();
                    }
                    if (auxiliar.get(i).getGame() == null) game = "noticia sin juego";
                    else {
                        game = auxiliar.get(i).getGame();
                    }
                    if (auxiliar.get(i).getCoverImage() == null) coverImage = "noticia sin imagen";
                    else {
                        coverImage = auxiliar.get(i).getCoverImage();
                    }
                    if (auxiliar.get(i).getDescription() == null) desc = "noticia sin descripcion";
                    else {
                        desc = auxiliar.get(i).getDescription();
                    }
                    if (auxiliar.get(i).getCreated_date() == null)
                        created_date = "noticia sin fecha de creacion";
                    else {
                        created_date = auxiliar.get(i).getCreated_date();
                    }

                    listToSend.add(new New_class(auxiliar.get(i).get_id(), title, body, game, coverImage, desc, created_date, auxiliar.get(i).get__v()));

                }
            }
                listnews = listToSend;

                newsRecyclerView = (RecyclerView) view.findViewById(R.id.rc_news);
                RecyclerViewAdapterNew recyclerViewAdapterNew = new RecyclerViewAdapterNew(getContext(), listToSend);

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

                newsRecyclerView.setLayoutManager(gridLayoutManager);
                newsRecyclerView.setAdapter(recyclerViewAdapterNew);

            }

            @Override
            public void onFailure(Call<List<New_class>> call, Throwable t) {

            }
        });
    }
}
