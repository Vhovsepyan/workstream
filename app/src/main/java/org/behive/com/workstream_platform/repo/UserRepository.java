package org.behive.com.workstream_platform.repo;

import android.arch.lifecycle.LiveData;

import org.behive.com.workstream_platform.model.BaseResponse;
import org.behive.com.workstream_platform.model.CheckUserResponse;
import org.behive.com.workstream_platform.model.SignInResponse;
import org.behive.com.workstream_platform.model.User;

public interface UserRepository {
    LiveData<BaseResponse<CheckUserResponse>> checkUserName(String userName);

    LiveData<BaseResponse<SignInResponse>> doLogin(User user);

    LiveData<BaseResponse<User>> getCurrentUserInfo();

    void insert(User ...users);

    void update(User ...users);

    void delete(User ...users);

    LiveData<User> getUserById(String userId);
}
