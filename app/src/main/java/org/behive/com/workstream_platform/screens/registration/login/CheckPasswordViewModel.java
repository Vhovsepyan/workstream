package org.behive.com.workstream_platform.screens.registration.login;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import org.behive.com.workstream_platform.MyApplication;
import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.model.BaseResponse;
import org.behive.com.workstream_platform.model.SignInResponse;
import org.behive.com.workstream_platform.model.User;
import org.behive.com.workstream_platform.repo.UserRepository;
import org.behive.com.workstream_platform.screens.BaseVM;

public class CheckPasswordViewModel extends BaseVM implements ViewModelAction{
    public ObservableField<String> password = new ObservableField<>("");
    public ObservableField<String> errorMessage = new ObservableField<>("");
    private LiveData<BaseResponse<SignInResponse>> signInResponse;
    private MutableLiveData<String> passwordLiveData = new MutableLiveData<>();
    private UserRepository userRepository;

    public CheckPasswordViewModel(@NonNull Application application) {
        super(application);
        userRepository = ((MyApplication) application).getUserRepository();

        signInResponse = Transformations.switchMap(passwordLiveData, data -> {
            User user = new User("planet1", data);
            return userRepository.doLogin(user);
        });
    }

    private void checkPassowrdAndSignIn() {
        String text = password.get();
        if (TextUtils.isEmpty(text)) {
            errorMessage.set(getString(R.string.incorrect_password_text));
            return;
        }
        passwordLiveData.setValue(text);
    }


    LiveData<BaseResponse<SignInResponse>> getSignInResponse() {
        return signInResponse;
    }

    void setErrorMessage(String errorMessage) {
        this.errorMessage.set(errorMessage);
    }

    @Override
    public void actionDone() {
        checkPassowrdAndSignIn();
    }
}
