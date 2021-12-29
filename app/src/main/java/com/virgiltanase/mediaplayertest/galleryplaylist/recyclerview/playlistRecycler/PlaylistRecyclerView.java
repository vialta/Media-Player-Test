package com.virgiltanase.mediaplayertest.galleryplaylist.recyclerview.playlistRecycler;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class PlaylistRecyclerView extends RecyclerView {

    private static final String TAG = "PlaylistRecyclerView";
    private Context context;

    public PlaylistRecyclerView(@NonNull Context context) {
        super(context);
    }

    public PlaylistRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private void init(Context context) {
        this.context = context.getApplicationContext();
    }

}
