package com.kif.vkvideo.model.videofeed;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoFeedResponse {

    @SerializedName("response")
    @Expose
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "VideoFeedResponse{" +
                "response=" + response +
                '}';
    }
}
