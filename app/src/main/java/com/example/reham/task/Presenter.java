package com.example.reham.task;

import com.example.reham.task.Retrofit.Feed;

import java.util.List;

/**
 * Created by reham on 1/17/2019.
 */

public class Presenter implements Contract.Presenter, Contract.Model.OnFinishedListener {

    private Contract.View View;

    private Contract.Model Model;

    public Presenter(Contract.View View) {
        this.View = View;
        Model = new Model();
    }

    @Override
    public void onDestroy() {
        this.View = null;
    }


    @Override
    public void requestDataFromServer(int id) {

        if (View != null) {
            View.showProgress();
        }
        Model.getList(this, id);
    }

    @Override
    public void onFinished(List<Feed> ArrayList) {
        View.setDataToRecyclerView(ArrayList);
        if (View != null) {
            View.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {

        View.onResponseFailure(t);
        if (View != null) {
            View.hideProgress();
        }
    }
}
