package com.bluecode.mhmd.share_pic.ui.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bluecode.mhmd.share_pic.R;
import com.bluecode.mhmd.share_pic.ui.base.BaseActivity;
import com.bluecode.mhmd.share_pic.ui.main.card_recyclerview.ImageCardRecyclerAdapter;
import com.bumptech.glide.Glide;

import javax.inject.Inject;

public class DetailsActivity extends BaseActivity implements DetailsMvpView {

    @Inject
    DetailsPresenter<DetailsMvpView> mvpPresenter;

    private ImageView imageView;
    private TextView txtTitle, txtCaption, txtNote;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagedetails);
        getActivityComponent().inject(this);

        imageView = findViewById(R.id.img_imageDetails_holder);
        txtCaption = findViewById(R.id.txt_imageDetails_caption);
        txtNote = findViewById(R.id.txt_imageDetails_note);
        txtTitle = findViewById(R.id.txt_imageDetails_title);
        fab = findViewById(R.id.fab_imageDetails);

        txtTitle.setText(getIntent().getStringExtra(ImageCardRecyclerAdapter.TITLE_EXTRA_INTENT));
        txtCaption.setText(getIntent().getStringExtra(ImageCardRecyclerAdapter.CAPTION_EXTRA_INTENT));
        txtNote.setText(getIntent().getStringExtra(ImageCardRecyclerAdapter.NOTE_EXTRA_INTENT));

        Glide.with(this)
                .load(getIntent().getStringExtra(ImageCardRecyclerAdapter.IMAGE_PATH_EXTRA_INTENT))
                .into(imageView);

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
}
