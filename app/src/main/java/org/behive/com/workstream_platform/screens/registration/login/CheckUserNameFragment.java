package org.behive.com.workstream_platform.screens.registration.login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.behive.com.workstream_platform.BR;
import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.databinding.CheckUsernameFragmentBinding;
import org.behive.com.workstream_platform.model.BaseResponse;
import org.behive.com.workstream_platform.model.CheckUserResponse;
import org.behive.com.workstream_platform.screens.BaseFragment;
import org.behive.com.workstream_platform.screens.BaseVM;
import org.behive.com.workstream_platform.utils.AppLog;

public class CheckUserNameFragment extends BaseFragment<CheckUsernameFragmentBinding> {
    private static final String TAG = CheckUserNameFragment.class.getSimpleName();
    private CheckUserNameViewModel viewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected BaseVM onCreateViewModel() {
        viewModel = ViewModelProviders.of(this).get(CheckUserNameViewModel.class);
        viewModel.getUserNameResponse().observe(this, new Observer<BaseResponse<CheckUserResponse>>() {
            @Override
            public void onChanged(@Nullable BaseResponse<CheckUserResponse> baseResponse) {
                if (baseResponse != null && baseResponse.isSuccess()) {
                    if (baseResponse.getData() != null && !baseResponse.getData().getResult()) {
                        viewModel.setErrorMessage("");
                        AppLog.i(TAG + " baseResponse = " + baseResponse);
                        getNavController().navigate(R.id.action_checkUserNameFragment_to_checkPasswordFragment);
                    } else {
                        viewModel.setErrorMessage(getString(R.string.incorrect_username_text));
                        AppLog.e(TAG + " baseResponse = " + baseResponse);
                    }
                } else {
                    viewModel.setErrorMessage(getString(R.string.something_went_wrong_text));
                    AppLog.e(TAG + " baseResponse = " + baseResponse);
                }
            }
        });
        return viewModel;
    }

    @Override
    protected void onBindViewModel(CheckUsernameFragmentBinding binding) {
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.check_username_fragment;
    }
}
