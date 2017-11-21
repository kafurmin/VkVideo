package com.kif.vkvideo.model.videofeed;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public List<Item> getItems() {
        return items;
    }


    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "VideoListResponse{" +
                "items=" + items +
                '}';
    }
}
