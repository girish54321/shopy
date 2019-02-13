package com.example.girish.shopy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.girish.shopy.api.RetrofitClient;
import com.example.girish.shopy.models.LoginRespons;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEmailText;
    private EditText loginPassText;
    private Button loginBtn;
    private Button loginRegBtn;
    private ProgressBar loginProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmailText = findViewById(R.id.reg_email);
        loginPassText = findViewById(R.id.reg_confirm_pass);
        loginBtn = findViewById(R.id.login_btn);
        loginRegBtn = findViewById(R.id.login_reg_btn);
        loginProgress = findViewById(R.id.login_progress);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
                loginProgress.setVisibility(View.VISIBLE);
            }
        });

        loginRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void loginUser(){
        String email = loginEmailText.getText().toString().trim();
        String password = loginPassText.getText().toString().trim();

        Call<LoginRespons> call = RetrofitClient.getInstance().getApi()
                .userlogin(email,password);

        call.enqueue(new Callback<LoginRespons>() {
            @Override
            public void onResponse(Call<LoginRespons> call, Response<LoginRespons> response) {
                LoginRespons loginRespons = response.body();

                if (!loginRespons.isError()){
                    SharedPrefManger.getInstance(LoginActivity.this)
                            .saveUser(loginRespons.getUser());
                    loginProgress.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<LoginRespons> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error = "+t, Toast.LENGTH_LONG).show();
                loginProgress.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (SharedPrefManger.getInstance(this).isLoggedIn()) {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}
