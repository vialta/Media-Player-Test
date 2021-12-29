package com.virgiltanase.mediaplayertest.galleryplaylist.recyclerview.playlistRecycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.virgiltanase.mediaplayertest.R;
import com.virgiltanase.mediaplayertest.galleryplaylist.model.GalleryMediaObject;

import java.util.ArrayList;

public class PlaylistRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<GalleryMediaObject> playlistMediaObjects;
    private RequestManager requestManager;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlaylistViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_playlist, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((PlaylistViewHolder) holder).onBind(playlistMediaObjects.get(position), requestManager);
    }

    @Override
    public int getItemCount() {
        return playlistMediaObjects.size();
    }
}
