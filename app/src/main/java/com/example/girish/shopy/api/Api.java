package com.example.girish.shopy.api;

import com.example.girish.shopy.Data.Electronics;
import com.example.girish.shopy.models.DefaultResponse;
import com.example.girish.shopy.models.LoginRespons;
import com.example.girish.shopy.models.UsersResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {

    @FormUrlEncoded
    @POST("createuser")
    Call<DefaultResponse> createUser(
            @Field("email") String email,
            @Field("password") String password,
            @Field("name") String name

    );

    @FormUrlEncoded
    @POST("userlogin")
    Call<LoginRespons> userlogin(
            @Field("email") String email,
            @Field("password") String password

    );

    @GET("allcomputer")
    Call<Electronics>  getAllElectronics();

    @GET("allclothing")
    Call<Electronics>  getAllClothing();

    @FormUrlEncoded
    @PUT("updateuser/{id}")
    Call<LoginRespons> updateUser(
            @Path("id") int id,
            @Field("email") String email,
            @Field("name") String name,
            @Field("school") String school
    );

    @FormUrlEncoded
    @PUT("updatepassword")
    Call<DefaultResponse> updatePassword(
            @Field("currentpassword") String currtentpassword,
            @Field("newpassword") String newpassword,
            @Field("email") String email
    );

    @DELETE("deleteuser/{id}")
    Call<DefaultResponse> deletUser(

            @Path("id") int id
    );
}

