package org.behive.com.workstream_platform.repo.impl;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.google.gson.internal.LinkedTreeMap;

import org.behive.com.workstream_platform.http.RestApi;
import org.behive.com.workstream_platform.model.BaseResponse;
import org.behive.com.workstream_platform.model.CheckUserResponse;
import org.behive.com.workstream_platform.model.SignInResponse;
import org.behive.com.workstream_platform.model.User;
import org.behive.com.workstream_platform.repo.UserRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepositoryImpl implements UserRepository {
    private RestApi restApi;

    public UserRepositoryImpl(@NonNull RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public LiveData<BaseResponse<CheckUserResponse>> checkUserName(String userName) {
        MutableLiveData<BaseResponse<CheckUserResponse>> baseResponseMutableLiveData = new MutableLiveData<>();
        restApi.checkUserName(userName).enqueue(new Callback<BaseResponse<CheckUserResponse>>() {
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
        restApi.doLogin(user).enqueue(new Callback<BaseResponse<Object>>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse<Object>> call, @NonNull Response<BaseResponse<Object>> response) {
                SignInResponse signInResponse = new SignInResponse();
                BaseResponse<SignInResponse> responseBaseResponse;
                BaseResponse<Object> responseBody = response.body();
                if (responseBody != null) {
                    Object data = responseBody.getData();

                    if (data instanceof List) {
                        List<LinkedTreeMap<String, String>> linkedTreeMaps = (List<LinkedTreeMap<String, String>>) data;
                        LinkedTreeMap<String, String> err_data = linkedTreeMaps.get(0);
                        String value_key = err_data.get("key");
                        String value_message = err_data.get("message");
                        signInResponse.setKey(value_key);
                        signInResponse.setMessage(value_message);
                    } else {
                        LinkedTreeMap<String, String> success_data = (LinkedTreeMap<String, String>) data;
                        signInResponse.setAccessToken(success_data.get("accessToken"));
                        signInResponse.setRefreshToken(success_data.get("refreshToken"));
                        signInResponse.setTokenType(success_data.get("tokenType"));
                    }

                    responseBaseResponse = new BaseResponse<>();
                    responseBaseResponse.setStatus(responseBody.getStatus());
                    responseBaseResponse.setErrorMessage(responseBody.getErrorMessage());
                    responseBaseResponse.setSuccess(responseBody.getSuccess());
                    responseBaseResponse.setData(signInResponse);
                } else {
                    responseBaseResponse = null;
                }
                baseResponseMutableLiveData.setValue(responseBaseResponse);
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse<Object>> call, @NonNull Throwable t) {
                BaseResponse baseResponse = new BaseResponse();
                baseResponse.setErrorMessage(t.getMessage());
                baseResponseMutableLiveData.setValue(baseResponse);
            }
        });
        return baseResponseMutableLiveData;
    }
}
