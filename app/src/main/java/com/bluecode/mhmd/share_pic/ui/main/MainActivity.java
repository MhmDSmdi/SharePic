package com.bluecode.mhmd.share_pic.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.bluecode.mhmd.share_pic.R;
import com.bluecode.mhmd.share_pic.ui.add_image.AddImageActivity;
import com.bluecode.mhmd.share_pic.ui.base.BaseActivity;
import com.bluecode.mhmd.share_pic.ui.main.card_recyclerview.ImageCardRecyclerAdapter;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView {

    private static final String TAG = "MainActivity";

    @Inject
    MainPresenter<MainMvpView> mPresenter;

    @Inject
    ImageCardRecyclerAdapter mCardAdapter;

    @Inject
    StaggeredGridLayoutManager gridLayoutManager;

    private RecyclerView recyclerView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        recyclerView = findViewById(R.id.recycler_main);
        fab = findViewById(R.id.fab_main);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickFab();
            }
        });

        setUpRecycler();
    }

    public void setUpRecycler() {
        gridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mCardAdapter);
        prepareRecycler();
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public boolean isPermissionGranted(String permission) {
        return false;
    }

    @Override
    public void onClickFab() {
        Intent intent = new Intent(this, AddImageActivity.class);
        startActivity(intent);
    }

    @Override
    public void prepareRecycler() {
        mCardAdapter.setItemList(mPresenter.getImageCardList());
    }

    @Override
    protected void onResume() {
        super.onResume();
        prepareRecycler();
        showMessage(mPresenter.getImageCardList().size() + "");
    }
}
