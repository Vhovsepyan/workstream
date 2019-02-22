package org.behive.com.workstream_platform.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> {

    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("status")
    @Expose
    private Integer status;

    @SerializedName("data")
    @Expose
    private T data;

    private String errorMessage;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "success=" + success +
                ", status=" + status +
                ", data=" + data +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
