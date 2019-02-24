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

                    if (!responseBody.isSuccess()) {
                        List<LinkedTreeMap<String, String>> linkedTreeMaps = (List<LinkedTreeMap<String, String>>) data;
                        LinkedTreeMap<String, String> errData = linkedTreeMaps.get(0);
                        String key = errData.get("key");
                        String message = errData.get("message");
                        signInResponse.setKey(key);
                        signInResponse.setMessage(message);
                    } else {
                        LinkedTreeMap<String, String> successData = (LinkedTreeMap<String, String>) data;
                        signInResponse.setAccessToken(successData.get("accessToken"));
                        signInResponse.setRefreshToken(successData.get("refreshToken"));
                        signInResponse.setTokenType(successData.get("tokenType"));
                    }

                    responseBaseResponse = new BaseResponse<>();
                    responseBaseResponse.setStatus(responseBody.getStatus());
                    responseBaseResponse.setSuccess(responseBody.isSuccess());
                    responseBaseResponse.setData(signInResponse);
                } else {
                    responseBaseResponse = new BaseResponse<>();
                    responseBaseResponse.setErrorMessage("responseBody == null");
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

    @Override
    public LiveData<BaseResponse<User>> getCurrentUserInfo() {
        MutableLiveData<BaseResponse<User>> userLiveData = new MutableLiveData<>();
        restApi.getCurrentUserInfo().enqueue(new Callback<BaseResponse<Object>>() {
            @Override
            public void onResponse(Call<BaseResponse<Object>> call, Response<BaseResponse<Object>> response) {
                BaseResponse<Object> responseBody = response.body();
                BaseResponse<User> userBaseResponse = new BaseResponse<>();
                if (responseBody != null ){
                    Object data = responseBody.getData();
                    if (responseBody.isSuccess()){
                        userBaseResponse.setSuccess(responseBody.isSuccess());
                        userBaseResponse.setStatus(responseBody.getStatus());
                        User user = new User((LinkedTreeMap<String, Object>) data);
                        userBaseResponse.setData(user);
                    } else {
                        List<LinkedTreeMap<String, String>> linkedTreeMaps = (List<LinkedTreeMap<String, String>>) data;
                        LinkedTreeMap<String, String> errData = linkedTreeMaps.get(0);
                        userBaseResponse.setErrorMessage(errData.get("message"));
                    }
                } else {
                    userBaseResponse.setErrorMessage("responseBody == null");
                }
                userLiveData.setValue(userBaseResponse);

            }

            @Override
            public void onFailure(Call<BaseResponse<Object>> call, Throwable t) {
                BaseResponse<User> baseResponse = new BaseResponse<>();
                baseResponse.setErrorMessage(t.getMessage());
                userLiveData.setValue(baseResponse);
            }
        });
        return userLiveData;
    }
}
