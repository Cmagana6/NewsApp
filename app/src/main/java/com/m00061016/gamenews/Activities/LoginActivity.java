package com.m00061016.gamenews.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.m00061016.gamenews.Helpers.RetrofitService;
import com.m00061016.gamenews.Interfaces.UserInterface;
import com.m00061016.gamenews.Objects.LoginAuth;
import com.m00061016.gamenews.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button signin;
    private UserInterface service;
    public static String Tokenglobal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_index);

        this.username=(EditText) findViewById(R.id.id_username);
        this.password=(EditText) findViewById(R.id.id_password);
        this.signin=(Button) findViewById(R.id.signig_button);

        this.service = RetrofitService.getRetrofitInstance().create(UserInterface.class);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<LoginAuth> authenticate = service.signIn(username.getText().toString(),password.getText().toString());
                authenticate.enqueue(new Callback<LoginAuth>() {
                    @Override
                    public void onResponse(Call<LoginAuth> call, Response<LoginAuth> response) {
                        if(response.body().getToken() !=null){
                            Tokenglobal = response.body().getToken().toString();
                            Intent intent;
                            intent=new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginAuth> call, Throwable t) {

                    }
                });
            }
        });
    }
}
