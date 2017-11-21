package com.kif.vkvideo.ui.main;

import com.google.gson.Gson;

import com.kif.vkvideo.model.videofeed.VideoFeedResponse;
import com.kif.vkvideo.model.getvideo.VideoPreview;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;

import javax.inject.Inject;

public class MainPresenter implements MainMvp.Presenter {

    private MainMvp.View view;

    @Inject
    Gson gson;

    @Inject
    MainPresenter(MainMvp.View view) {
        this.view = view;
    }

    @Override
    public void getVideos(int startFrom) {
        VKRequest request = new VKRequest("newsfeed.get",
                VKParameters.from(VKApiConst.FILTERS, "video", "start_from", startFrom, "count", 10));
        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                super.onComplete(response);
                view.handleNewsFeedResponse(gson.fromJson(String.valueOf(response.json),
                        VideoFeedResponse.class));
            }
        });
    }

    @Override
    public void vkVideoGet(int idOwner, int idVideo) {
        VKRequest request = new VKRequest("video.get",
                VKParameters.from("videos", idOwner+"_"+idVideo));
        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                super.onComplete(response);
                VideoPreview videoPreview = gson.fromJson(String.valueOf(response.json), VideoPreview.class);
                view.handleVideoResponse(videoPreview.getResponse().getItems().get(0).getPlayer());
            }
        });
    }
}
