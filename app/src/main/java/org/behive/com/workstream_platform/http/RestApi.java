package org.behive.com.workstream_platform.http;

import org.behive.com.workstream_platform.model.BaseResponse;
import org.behive.com.workstream_platform.model.CheckUserResponse;
import org.behive.com.workstream_platform.model.User;
import org.behive.com.workstream_platform.model.task.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApi {
    @GET("/account/check")
    Call<BaseResponse<CheckUserResponse>> checkUserName(@Query("username") String userName);

    @POST("/account/signin")
    Call<BaseResponse<Object>> doLogin(@Body User user);

    @GET("/tasks/list")
    Call<BaseResponse<List<Task>>> getTaskList(@Query("branchId") String branchId);
}
