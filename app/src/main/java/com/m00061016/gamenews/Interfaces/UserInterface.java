package com.m00061016.gamenews.Interfaces;

import com.m00061016.gamenews.Objects.LoginAuth;
import com.m00061016.gamenews.Objects.New_class;
import com.m00061016.gamenews.Objects.Player;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserInterface {
    @FormUrlEncoded
    @POST("login")
    Call<LoginAuth> signIn (@Field("user") String username, @Field("password") String password);

    @GET("news")
    Call<List<New_class>> getNews(@Header("Authorization") String token);

    @GET("players")
    Call<List<Player>> getPlayers(@Header("Authorization") String token);
}
