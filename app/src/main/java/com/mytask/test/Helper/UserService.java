package com.mytask.test.Helper;

import com.mytask.test.Model.Resul;
import com.mytask.test.Model.Result;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {



    @Headers({"Accept: application/json"})
    @GET("movie?sort_by=popularity.desc&api_key=fd75d8c708d418f9ee6280f179e7f399")
    Call<Resul> getlist();

}