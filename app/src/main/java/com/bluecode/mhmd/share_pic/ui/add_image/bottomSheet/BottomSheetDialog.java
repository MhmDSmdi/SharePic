package com.bluecode.mhmd.share_pic.ui.add_image.bottomSheet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluecode.mhmd.share_pic.R;

public class BottomSheet extends BottomSheetDialogFragment implements BottomSheetMvpView {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_add_image, container, false);


        return v;
    }

    @Override
    public void onClickFromGallery() {

    }

    @Override
    public void onClickFromCamera() {

    }
}
