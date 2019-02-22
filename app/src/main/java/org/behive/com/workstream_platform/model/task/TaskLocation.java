package org.behive.com.workstream_platform.model.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaskLocation {

    @SerializedName("longitude")
    @Expose
    private Integer longitude;
    @SerializedName("latitude")
    @Expose
    private Integer latitude;
    @SerializedName("additionalInfo")
    @Expose
    private String additionalInfo;
    @SerializedName("address")
    @Expose
    private String address;

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}