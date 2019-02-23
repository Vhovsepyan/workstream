package org.behive.com.workstream_platform.screens.registration.login;

import android.arch.lifecycle.ViewModelProviders;
import android.widget.EditText;

import org.behive.com.workstream_platform.BR;
import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.databinding.CheckPasswordFragmentBinding;
import org.behive.com.workstream_platform.model.SignInResponse;
import org.behive.com.workstream_platform.screens.BaseFragment;
import org.behive.com.workstream_platform.screens.BaseVM;
import org.behive.com.workstream_platform.utils.AppLog;
import org.behive.com.workstream_platform.utils.SharedPrefs;
import org.behive.com.workstream_platform.utils.Utils;

public class CheckPasswordFragment extends BaseFragment<CheckPasswordFragmentBinding> {
    private static final String TAG = CheckPasswordFragment.class.getSimpleName();
    private CheckPasswordViewModel viewModel;
    private EditText editText;

    @Override
    protected BaseVM onCreateViewModel() {
        viewModel = ViewModelProviders.of(this).get(CheckPasswordViewModel.class);
        viewModel.getSignInResponse().observe(this, baseResponse -> {
            if (baseResponse != null && baseResponse.getSuccess()) {
                SignInResponse data = baseResponse.getData();
                if (data != null) {
                    viewModel.setErrorMessage("");
                    AppLog.i(TAG + " baseResponse = " + baseResponse);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(data.getTokenType())
                            .append(" ")
                            .append(data.getAccessToken());
                    boolean isSuccess = SharedPrefs.getInstance().putString(
                            SharedPrefs.Constants.IS_USER_LOGGED_IN_KEY,
                            stringBuilder.toString());
                    if (isSuccess) {
                        Utils.hideKeyboardFrom(editText, getActivity());
                        getNavController().navigate(R.id.action_checkPasswordFragment_to_homeFragment);
                    }
                } else {
                    viewModel.setErrorMessage(getString(R.string.incorrect_username_password_text));
                    AppLog.e(TAG + " baseResponse = " + baseResponse);
                }
            } else {
                viewModel.setErrorMessage(getString(R.string.something_went_wrong_text));
                AppLog.e(TAG + " baseResponse = " + baseResponse);
            }
        });
        return viewModel;
    }

    @Override
    protected void onBindViewModel(CheckPasswordFragmentBinding binding) {
        editText = binding.passwordEditText;
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.check_password_fragment;
    }
}
