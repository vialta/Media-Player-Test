package com.virgiltanase.mediaplayertest.galleryplaylist.recyclerview.playlistRecycler;

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

public class PlaylistViewHolder extends RecyclerView.ViewHolder{

    public FrameLayout mediaContainer;
    public ImageView mediaCoverImage;
    public RequestManager requestManager;
    private TextView title;
    private View parent;

    public PlaylistViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView;
        mediaContainer = itemView.findViewById(R.id.mediaContainer);
        mediaCoverImage = itemView.findViewById(R.id.ivMediaCoverImage);
        title = itemView.findViewById(R.id.tvTitle);
    }

    void onBind(GalleryMediaObject galleryMediaObject, RequestManager requestManager) {
        this.requestManager = requestManager;
        parent.setTag(this);
        title.setText(galleryMediaObject.getTitle());
        this.requestManager
                .load(galleryMediaObject.getCoverUrl())
                .into(mediaCoverImage);
    }
}
