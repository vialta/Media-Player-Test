package com.virgiltanase.mediaplayertest.galleryplaylist.recyclerview.galleryRecycler;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.virgiltanase.mediaplayertest.R;
import com.virgiltanase.mediaplayertest.galleryplaylist.model.GalleryMediaObject;

public class GalleryViewHolder extends RecyclerView.ViewHolder {

    public FrameLayout mediaContainer;
    public ImageView mediaCoverImage, volumeControl;
    public ProgressBar progressBar;
    public RequestManager requestManager;
    private TextView title, userHandle;
    private View parent;

    public GalleryViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView;
        mediaContainer = itemView.findViewById(R.id.mediaContainer);
        mediaCoverImage = itemView.findViewById(R.id.ivMediaCoverImage);
        title = itemView.findViewById(R.id.tvTitle);
        userHandle = itemView.findViewById(R.id.tvUserHandle);
        progressBar = itemView.findViewById(R.id.progressBar);
        volumeControl = itemView.findViewById(R.id.ivVolumeControl);
    }

    void onBind(GalleryMediaObject galleryMediaObject, RequestManager requestManager) {
        this.requestManager = requestManager;
        parent.setTag(this);
        title.setText(galleryMediaObject.getTitle());
        userHandle.setText(galleryMediaObject.getUserHandle());
        this.requestManager
                .load(galleryMediaObject.getCoverUrl())
                .into(mediaCoverImage);
    }
}
