package org.behive.com.workstream_platform.model.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attachment {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("contentType")
    @Expose
    private String contentType;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}