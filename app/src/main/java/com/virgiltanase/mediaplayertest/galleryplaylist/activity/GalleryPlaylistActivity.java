package com.virgiltanase.mediaplayertest.galleryplaylist.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.virgiltanase.mediaplayertest.R;
import com.virgiltanase.mediaplayertest.galleryplaylist.presenter.GalleryPlaylistPresenter;
import com.virgiltanase.mediaplayertest.galleryplaylist.presenter.GalleryPlaylistPresenterImpl;
import com.virgiltanase.mediaplayertest.galleryplaylist.recyclerview.galleryRecycler.GalleryRecyclerView;
import com.virgiltanase.mediaplayertest.galleryplaylist.recyclerview.galleryRecycler.GalleryRecyclerAdapter;
import com.virgiltanase.mediaplayertest.galleryplaylist.model.GalleryMediaObject;
import com.virgiltanase.mediaplayertest.galleryplaylist.view.GalleryPlaylistView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GalleryPlaylistActivity extends AppCompatActivity implements GalleryPlaylistView {

    private static final String TAG = "GalleryPlaylistActivity";

    GalleryRecyclerView mGalleryRecyclerView;

    private ArrayList<GalleryMediaObject> galleryMediaObjectsList = new ArrayList<>();
    private GalleryRecyclerAdapter mGalleryAdapter;
    private boolean firstTime = true;

    private GalleryPlaylistPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        presenter = new GalleryPlaylistPresenterImpl(this);
        prepareVideoListDebug();

        Log.e(TAG,"OnCreateFinished");
    }

    private void initView(){
        mGalleryRecyclerView = findViewById(R.id.galleryRecyclerView);
        mGalleryRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private RequestManager initGlide() {
        RequestOptions options = new RequestOptions();

        return Glide.with(this)
                .setDefaultRequestOptions(options);
    }

    @Override
    protected void onDestroy() {
        if (mGalleryRecyclerView != null) {
            mGalleryRecyclerView.releasePlayer();
        }
        super.onDestroy();
    }

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

        setRecyclerView(galleryMediaObjectList);
    }

    @Override
    public Context getParentContext() {
        return this;
    }

    @Override
    public void setRecyclerView(ArrayList<GalleryMediaObject> list) {
        Log.e(TAG,"SetListView");
        Log.e(TAG, String.valueOf(list.size()));
        galleryMediaObjectsList = list;
        mGalleryRecyclerView.setModelObjects(galleryMediaObjectsList);
        mGalleryAdapter = new GalleryRecyclerAdapter(galleryMediaObjectsList, initGlide());
        mGalleryRecyclerView.setAdapter(mGalleryAdapter);
    }
}