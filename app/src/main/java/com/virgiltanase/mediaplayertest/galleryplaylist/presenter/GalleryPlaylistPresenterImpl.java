package com.virgiltanase.mediaplayertest.galleryplaylist.presenter;

import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;

import com.virgiltanase.mediaplayertest.galleryplaylist.model.GalleryMediaObject;
import com.virgiltanase.mediaplayertest.galleryplaylist.view.GalleryPlaylistView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GalleryPlaylistPresenterImpl implements GalleryPlaylistPresenter{

    private GalleryPlaylistView galleryPlaylistView;

    public GalleryPlaylistPresenterImpl(GalleryPlaylistView view){
        this.galleryPlaylistView = view;
    }

    @Override
    public void prepareVideoListDebug(){
        Log.e("TAG","prepreVideo");
        GalleryMediaObject galleryMediaObject = new GalleryMediaObject();
        galleryMediaObject.setId(1);
        galleryMediaObject.setUserHandle("User 1");
        galleryMediaObject.setTitle(
                "Item 1");
        galleryMediaObject.setCoverUrl(
                "https://www.learntotrade.com.ph/assets-lttph/uploads/2016/04/video-preview-pic.jpg");
        galleryMediaObject.setUrl("https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4");

        GalleryMediaObject galleryMediaObject2 = new GalleryMediaObject();
        galleryMediaObject2.setId(2);
        galleryMediaObject2.setUserHandle("user 2");
        galleryMediaObject2.setTitle(
                "Item 2");
        galleryMediaObject2.setCoverUrl(
                "https://www.learntotrade.com.ph/assets-lttph/uploads/2016/04/video-preview-pic.jpg");
        galleryMediaObject2.setUrl("https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4");

        GalleryMediaObject galleryMediaObject3 = new GalleryMediaObject();
        galleryMediaObject3.setId(3);
        galleryMediaObject3.setUserHandle("User 3");
        galleryMediaObject3.setTitle("Item 3");
        galleryMediaObject3.setCoverUrl(
                "https://www.learntotrade.com.ph/assets-lttph/uploads/2016/04/video-preview-pic.jpg");
        galleryMediaObject3.setUrl("https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4");

        GalleryMediaObject galleryMediaObject4 = new GalleryMediaObject();
        galleryMediaObject4.setId(4);
        galleryMediaObject4.setUserHandle("User 4");
        galleryMediaObject4.setTitle("Item 4");
        galleryMediaObject4.setCoverUrl(
                "https://www.learntotrade.com.ph/assets-lttph/uploads/2016/04/video-preview-pic.jpg");
        galleryMediaObject4.setUrl("https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4");

        GalleryMediaObject galleryMediaObject5 = new GalleryMediaObject();
        galleryMediaObject5.setId(5);
        galleryMediaObject5.setUserHandle("User 5");
        galleryMediaObject5.setTitle("Item 5");
        galleryMediaObject5.setCoverUrl(
                "https://www.learntotrade.com.ph/assets-lttph/uploads/2016/04/video-preview-pic.jpg");
        galleryMediaObject5.setUrl("https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4");
        ArrayList<GalleryMediaObject> galleryMediaObjectList = new ArrayList<>();
        galleryMediaObjectList.add(galleryMediaObject);
        galleryMediaObjectList.add(galleryMediaObject2);
        galleryMediaObjectList.add(galleryMediaObject3);
        galleryMediaObjectList.add(galleryMediaObject4);
        galleryMediaObjectList.add(galleryMediaObject5);

        galleryPlaylistView.setRecyclerView(galleryMediaObjectList);
    }

    //TODO expand for all multimedia types and grab data from the gallery
    @Override
    public void prepareVideoList() {
        List<String> videoStrings = getAllMedia();


    }


    public ArrayList<String> getAllMedia() {
        HashSet<String> videoItemHashSet = new HashSet<>();
        String[] projection = { MediaStore.Video.VideoColumns.DATA ,MediaStore.Video.Media.DISPLAY_NAME};
        Cursor cursor = galleryPlaylistView.getParentContext().getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, projection, null, null, null);
        try {
            cursor.moveToFirst();
            do{
                videoItemHashSet.add((cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA))));
            }while(cursor.moveToNext());

            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> downloadedList = new ArrayList<>(videoItemHashSet);
        return downloadedList;
    }

}
