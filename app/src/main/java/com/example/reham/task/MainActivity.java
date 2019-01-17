package com.example.reham.task;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {
    @BindView(R.id.toolbar)
    android.support.v7.widget.Toolbar mToolbar;
    @BindView(R.id.imageButton)
    ImageButton imageButton;
    @BindView(R.id.imageView1)
    ImageView imageView;
    @BindView(R.id.text_view)
    TextView textView;
    boolean detailAct;
    String title;
    String FRAGMENT_TAG = "savedFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (savedInstanceState != null && savedInstanceState.getBoolean("key") == true && !(savedInstanceState.getString("title")).equals("")) {
            detailAct = true;
            title = savedInstanceState.getString("title");
            imageButton.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
            textView.setText(title);
            BlankFragment blankFragment = (BlankFragment)
                    this.getFragmentManager().findFragmentByTag(FRAGMENT_TAG);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    detailAct = false;
                    imageButton.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.GONE);
                    BlankFragment blankFragment = new BlankFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("key", 0);
                    blankFragment.setArguments(bundle);
                    final FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, blankFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
        } else {
            detailAct = false;
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            imageButton.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
            Bundle bundle = new Bundle();
            BlankFragment blankFragment = new BlankFragment();
            bundle.putInt("key", 0);
            blankFragment.setArguments(bundle);
            android.app.FragmentManager manager = getFragmentManager();
            manager.beginTransaction().add(R.id.fragment_container, blankFragment).commit();
        }

    }

    @Override
    public void onFragmentInteraction(int position, String titleEn) {
        detailAct = true;
        title = titleEn;
        imageButton.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.GONE);
        textView.setVisibility(View.VISIBLE);
        textView.setText(titleEn);
        BlankFragment newFragment = new BlankFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putInt("key", 1);
        newFragment.setArguments(bundle);
        transaction.replace(R.id.fragment_container, newFragment, FRAGMENT_TAG);
        transaction.addToBackStack(null);
        transaction.commit();
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailAct = false;
                imageButton.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
                textView.setVisibility(View.GONE);
                BlankFragment blankFragment = new BlankFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("key", 0);
                blankFragment.setArguments(bundle);
                final FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, blankFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("key", detailAct);
        outState.putString("title", title);
    }
}
