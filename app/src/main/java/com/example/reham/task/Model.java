package com.example.reham.task;

import com.example.reham.task.Retrofit.ApiClient;
import com.example.reham.task.Retrofit.Feed;
import com.example.reham.task.Retrofit.Retrofit;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by reham on 1/17/2019.
 */

public class Model implements Contract.Model {
    @Override
    public void getList(final OnFinishedListener onFinishedListener, int id) {

        Retrofit.ApiInterface apiService = ApiClient.getClient().create(Retrofit.ApiInterface.class);
        Call<List<Feed>> call = null;
        if (id == 0) {
            call = apiService.getElements();
        } else {
            call = apiService.getSubElements();
        }
        call.enqueue(new Callback<List<Feed>>() {
            @Override
            public void onResponse(Call<List<Feed>> call, Response<List<Feed>> response) {
                List<Feed> items = response.body();
                //   RC.setAdapter(new RecyclerViewAdapter(context,items,itemClickListener));
                onFinishedListener.onFinished(items);
            }

            @Override
            public void onFailure(Call<List<Feed>> call, Throwable t) {
                // Log error here since request failed
                onFinishedListener.onFailure(t);
            }
        });
    }

}