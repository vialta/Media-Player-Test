package com.virgiltanase.mediaplayertest.galleryplaylist.view;

import android.content.Context;

import com.virgiltanase.mediaplayertest.galleryplaylist.model.GalleryMediaObject;

import java.util.ArrayList;

public interface GalleryPlaylistView {
    Context getParentContext();
    void setRecyclerView(ArrayList<GalleryMediaObject> list);
}
