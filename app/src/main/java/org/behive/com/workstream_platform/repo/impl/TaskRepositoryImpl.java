package org.behive.com.workstream_platform.repo.impl;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import org.behive.com.workstream_platform.http.RestApi;
import org.behive.com.workstream_platform.model.BaseResponse;
import org.behive.com.workstream_platform.model.task.Task;
import org.behive.com.workstream_platform.repo.TaskRepository;
import org.behive.com.workstream_platform.utils.AppLog;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskRepositoryImpl implements TaskRepository {
    private static final String TAG = TaskRepositoryImpl.class.getSimpleName();
    private final RestApi restApi;

    public TaskRepositoryImpl(@NonNull RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public LiveData<List<Task>> getTaskList(String branchId) {
        MutableLiveData<List<Task>> mutableLiveData = new MutableLiveData<>();
        restApi.getTaskList(branchId).enqueue(new Callback<BaseResponse<List<Task>>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<List<Task>>> call, @NonNull Response<BaseResponse<List<Task>>> response) {
                if (response.body() != null) {
                    List<Task> taskList = response.body().getData();
                    mutableLiveData.postValue(taskList);
                }

            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse<List<Task>>> call, @NonNull Throwable t) {
                AppLog.e(TAG + " " + t.getMessage());

            }
        });

        return mutableLiveData;
    }

}
