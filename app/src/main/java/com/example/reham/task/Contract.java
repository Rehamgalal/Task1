package com.example.reham.task;

import com.example.reham.task.Retrofit.Feed;

import java.util.List;

/**
 * Created by reham on 1/17/2019.
 */

public interface Contract {

    interface Model {

        interface OnFinishedListener {
            void onFinished(List<Feed> ArrayList);

            void onFailure(Throwable t);
        }

        void getList(OnFinishedListener onFinishedListener, int id);

    }

    interface View {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(List<Feed> ArrayList);

        void onResponseFailure(Throwable throwable);

    }

    interface Presenter {

        void onDestroy();

        void requestDataFromServer(int id);

    }
}
