package org.behive.com.workstream_platform.screens.registration.login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import org.behive.com.workstream_platform.BR;
import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.databinding.CheckUsernameFragmentBinding;
import org.behive.com.workstream_platform.model.BaseResponse;
import org.behive.com.workstream_platform.model.CheckUserResponse;
import org.behive.com.workstream_platform.screens.ActivityView;
import org.behive.com.workstream_platform.screens.BaseFragment;
import org.behive.com.workstream_platform.screens.BaseVM;
import org.behive.com.workstream_platform.screens.MainActivity;
import org.behive.com.workstream_platform.utils.AppLog;

import androidx.navigation.NavController;

public class CheckUserNameFragment extends BaseFragment<CheckUsernameFragmentBinding> {
    private static final String TAG = CheckUserNameFragment.class.getSimpleName();
    private LoginViewModel viewModel;
    private NavController navController;
    private ActivityView activityView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activityView = ((MainActivity) getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        navController = activityView.getNavController();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected BaseVM onCreateViewModel() {
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        viewModel.getUserNameResponse().observe(this, new Observer<BaseResponse<CheckUserResponse>>() {
            @Override
            public void onChanged(@Nullable BaseResponse<CheckUserResponse> baseResponse) {
                if (baseResponse != null && baseResponse.getSuccess()) {
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
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
