package com.example.reham.task;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.reham.task.Retrofit.Feed;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class BlankFragment extends android.app.Fragment implements RecyclerViewAdapter.ItemClickListener, Contract.View {
    RecyclerViewAdapter.ItemClickListener itemClickListener = this;
    private OnFragmentInteractionListener mListener;
    List<Feed> items;
    RecyclerViewAdapter adapter;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        ButterKnife.bind(getActivity());
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        Bundle bundle = getArguments();
        int id = bundle.getInt("key");
        Presenter presenter = new Presenter(this);
        presenter.requestDataFromServer(id);
        final RecyclerView RC = rootView.findViewById(R.id.recycler_view);
        RC.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        RC.setHasFixedSize(true);
        items = new ArrayList<>();
        adapter = new RecyclerViewAdapter(getActivity(), items, itemClickListener);
        RC.setAdapter(adapter);
        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(int position, String titleEn) {
        mListener.onFragmentInteraction(position, titleEn);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setDataToRecyclerView(List<Feed> ArrayList) {
        items.addAll(ArrayList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(getActivity(), "some thing went wrong", Toast.LENGTH_LONG).show();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(int position, String titleEn);
    }
}
