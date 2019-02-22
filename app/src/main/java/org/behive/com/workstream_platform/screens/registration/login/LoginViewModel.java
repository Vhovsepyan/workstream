package org.behive.com.workstream_platform.screens.registration.login;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.model.BaseResponse;
import org.behive.com.workstream_platform.model.CheckUserResponse;
import org.behive.com.workstream_platform.repo.UserRepository;
import org.behive.com.workstream_platform.repo.impl.UserRepositoryImpl;
import org.behive.com.workstream_platform.screens.BaseVM;

public class LoginViewModel extends BaseVM {
    public ObservableField<String> userName = new ObservableField<>("");
    public ObservableField<String> errorMessage = new ObservableField<>("");
    private LiveData<BaseResponse<CheckUserResponse>> userNameResponse;

    private MutableLiveData<String> userNameLiveData = new MutableLiveData<>();
    private UserRepository userRepository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        userRepository = UserRepositoryImpl.getsInstance();
        userNameResponse = Transformations.switchMap(userNameLiveData, data -> {
                    return userRepository.checkUserName(data);
                }
        );
    }

    public void checkUser() {
        String text = userName.get();
        if (TextUtils.isEmpty(text)) {
            errorMessage.set(getString(R.string.incorrect_username_text));
            return;
        }
        userNameLiveData.setValue(text);
    }

    public LiveData<BaseResponse<CheckUserResponse>> getUserNameResponse() {
        return userNameResponse;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage.set(errorMessage);
    }
}
