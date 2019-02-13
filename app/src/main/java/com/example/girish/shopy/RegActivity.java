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
import com.example.girish.shopy.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegActivity extends AppCompatActivity {

    private EditText reg_email_field;
    private EditText reg_pass_field;
    private EditText reg_confirm_pass_field;
    private EditText reg_name;
    private Button reg_btn;
    private Button reg_login_btn;
    private ProgressBar reg_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        reg_email_field = findViewById(R.id.reg_email);
        reg_pass_field = findViewById(R.id.reg_pass);
        reg_confirm_pass_field = findViewById(R.id.reg_confirm_pass);
        reg_btn = findViewById(R.id.reg_btn);
        reg_login_btn = findViewById(R.id.reg_login_btn);
        reg_progress = findViewById(R.id.reg_progress);
        reg_name = findViewById(R.id.reg_name);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regUses();
                reg_progress.setVisibility(View.VISIBLE);
            }
        });
    }

    private void regUses(){
        String email = reg_email_field.getText().toString().trim();
        String name = reg_name.getText().toString().trim().toUpperCase();
        String password = reg_pass_field.getText().toString().trim();

        Call<DefaultResponse> call = RetrofitClient
                .getInstance().getApi().createUser(email,password,name);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.code() == 201) {
                    DefaultResponse defaultResponse = response.body();
                    Toast.makeText(RegActivity.this, defaultResponse.getMessage(), Toast.LENGTH_LONG).show();
                    sendToLogin();

                } else if (response.code() == 422) {
                    Toast.makeText(RegActivity.this, "User Can't Login", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });

    }

    private void sendToLogin(){
        Intent intent = new Intent(RegActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
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
