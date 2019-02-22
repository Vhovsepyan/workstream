package org.behive.com.workstream_platform.repo.impl;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import org.behive.com.workstream_platform.executors.ExecutorService;
import org.behive.com.workstream_platform.executors.ExecutorType;
import org.behive.com.workstream_platform.http.RestApi;
import org.behive.com.workstream_platform.http.RestApiFactory;
import org.behive.com.workstream_platform.model.BaseResponse;
import org.behive.com.workstream_platform.model.CheckUserResponse;
import org.behive.com.workstream_platform.model.SignInResponse;
import org.behive.com.workstream_platform.model.User;
import org.behive.com.workstream_platform.repo.UserRepository;

import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepositoryImpl implements UserRepository {
    private RestApi restApi;

    public UserRepositoryImpl() {
    }

    @Override
    public LiveData<BaseResponse<CheckUserResponse>> checkUserName(String userName) {
        MutableLiveData<BaseResponse<CheckUserResponse>> baseResponseMutableLiveData = new MutableLiveData<>();
        getRestApi().checkUserName(userName).enqueue(new Callback<BaseResponse<CheckUserResponse>>() {
            @Override
            public void onResponse(Call<BaseResponse<CheckUserResponse>> call, Response<BaseResponse<CheckUserResponse>> response) {
                baseResponseMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<BaseResponse<CheckUserResponse>> call, Throwable t) {
                BaseResponse baseResponse = new BaseResponse();
                baseResponse.setErrorMessage(t.getMessage());
                baseResponseMutableLiveData.setValue(baseResponse);
            }
        });
        return baseResponseMutableLiveData;
    }

    @Override
    public LiveData<BaseResponse<SignInResponse>> doLogin(User user) {
        MutableLiveData<BaseResponse<SignInResponse>> baseResponseMutableLiveData = new MutableLiveData<>();
        getRestApi().doLogin(user).enqueue(new Callback<BaseResponse<SignInResponse>>() {
            @Override
            public void onResponse(Call<BaseResponse<SignInResponse>> call, Response<BaseResponse<SignInResponse>> response) {
                baseResponseMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<BaseResponse<SignInResponse>> call, Throwable t) {
                BaseResponse baseResponse = new BaseResponse();
                baseResponse.setErrorMessage(t.getMessage());
                baseResponseMutableLiveData.setValue(baseResponse);
            }
        });
        return baseResponseMutableLiveData;
    }

    private RestApi getRestApi() {
        if (restApi == null) {
            restApi = RestApiFactory.create();
        }
        return restApi;
    }
}
