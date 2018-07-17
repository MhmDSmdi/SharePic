package com.bluecode.mhmd.share_pic.ui.add_image.bottomSheet;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluecode.mhmd.share_pic.R;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    private BottomSheetListener mListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_add_image, container, false);
        TextView fromGallery = v.findViewById(R.id.item_bottomSheet_gallery);
        TextView fromCamera = v.findViewById(R.id.item_bottomSheet_camera);

        fromCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.takeImageFromCamera();
                dismiss();
            }
        });

        fromGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.takeImageFromGallery();
                dismiss();
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (BottomSheetListener) context;
        } catch (Exception e) {

        }

    }

    public interface BottomSheetListener {
        void takeImageFromCamera();

        void takeImageFromGallery();
    }
}
