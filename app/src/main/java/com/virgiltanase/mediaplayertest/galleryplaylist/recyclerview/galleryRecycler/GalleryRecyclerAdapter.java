package com.virgiltanase.mediaplayertest.galleryplaylist.recyclerview.galleryRecycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.virgiltanase.mediaplayertest.R;
import com.virgiltanase.mediaplayertest.galleryplaylist.model.GalleryMediaObject;

import java.util.ArrayList;

public class GalleryRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<GalleryMediaObject> galleryMediaObjects;
    private RequestManager requestManager;

    public GalleryRecyclerAdapter(ArrayList<GalleryMediaObject> galleryMediaObjects, RequestManager requestManager){
        this.galleryMediaObjects = galleryMediaObjects;
        this.requestManager = requestManager;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GalleryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_gallery, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((GalleryViewHolder) holder).onBind(galleryMediaObjects.get(position), requestManager);
    }

    @Override
    public int getItemCount() {
        return galleryMediaObjects.size();
    }
}
