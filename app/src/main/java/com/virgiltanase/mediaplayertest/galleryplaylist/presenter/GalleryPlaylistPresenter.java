package com.virgiltanase.mediaplayertest.galleryplaylist.presenter;

import java.util.ArrayList;

public interface GalleryPlaylistPresenter {

    ArrayList<String> getAllMedia();

    void prepareVideoListDebug();

    void prepareVideoList();
}
