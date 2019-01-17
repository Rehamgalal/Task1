package com.example.reham.task.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by reham on 1/15/2019.
 */

public interface Retrofit {
    interface ApiInterface {

        @GET("app.asmx/GetCategories?categoryId=0&countryId=1")
        Call<List<Feed>> getElements();

        @GET("app.asmx/GetCategories?categoryId=1&countryId=1")
        Call<List<Feed>> getSubElements();
    }
}
