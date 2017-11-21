package com.kif.vkvideo.ui.main;

import com.kif.vkvideo.model.videofeed.VideoFeedResponse;
import com.kif.vkvideo.ui.base.MvpView;

public interface MainMvp {
    interface View extends MvpView {
        void handleNewsFeedResponse(VideoFeedResponse videoInfo);
        void handleVideoResponse(String url);
    }

    interface Presenter {
        void getVideos(int startFrom);
        void vkVideoGet(int idOwner, int idVideo);
    }
}
