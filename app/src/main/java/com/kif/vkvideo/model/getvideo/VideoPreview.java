package com.kif.vkvideo.model.getvideo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class VideoPreview {

    @SerializedName("response")
    @Expose
    private VideoListResponse response;

    public VideoListResponse getResponse() {
        return response;
    }

    public void setResponse(VideoListResponse response) {
        this.response = response;
    }
}