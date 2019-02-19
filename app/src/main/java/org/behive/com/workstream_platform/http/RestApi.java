package org.behive.com.workstream_platform.http;

import org.behive.com.workstream_platform.model.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {
    @GET("/account/check")
    Call<BaseResponse> checkUserName(@Query("username") String userName);
}
