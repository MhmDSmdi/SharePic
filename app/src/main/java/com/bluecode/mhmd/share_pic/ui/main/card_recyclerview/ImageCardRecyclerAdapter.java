package com.bluecode.mhmd.share_pic.ui.main.card_recyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bluecode.mhmd.share_pic.R;
import com.bluecode.mhmd.share_pic.data.db.Model.ImageCardHolder;
import com.bluecode.mhmd.share_pic.ui.base.BaseViewHolder;
import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

public class ImageCardRecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<ImageCardHolder> imageCardHolderList;

    public ImageCardRecyclerAdapter(List<ImageCardHolder> imageCardHolderList) {
        this.imageCardHolderList = imageCardHolderList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_imageview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return imageCardHolderList.size();
    }

    public void addItem(ImageCardHolder imageCardHolder) {
        imageCardHolderList.add(imageCardHolder);
        notifyDataSetChanged();
    }

    public void addItem(List<ImageCardHolder> imageCardList) {
        imageCardHolderList.addAll(imageCardList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends BaseViewHolder {

        ImageView imageView;
        TextView txtTitle, txtCaption;

        public ViewHolder(View itemView) {
            super(itemView);
            txtCaption = itemView.findViewById(R.id.txt_caption);
            txtTitle = itemView.findViewById(R.id.txt_title);
            imageView = itemView.findViewById(R.id.img_holder);
        }

        @Override
        protected void onClear() {
            txtTitle.setText("");
            txtCaption.setText("");
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            final ImageCardHolder imageCardHolder = imageCardHolderList.get(position);
            txtCaption.setText(imageCardHolder.getCaption());
            txtTitle.setText(imageCardHolder.getTile());

            //SetImageFromPath
            File imgFile = new  File(imageCardHolder.getPhotoPath());
            if(imgFile.exists()){
                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                imageView.setImageBitmap(myBitmap);
            } else {

            }
        }
    }
}
