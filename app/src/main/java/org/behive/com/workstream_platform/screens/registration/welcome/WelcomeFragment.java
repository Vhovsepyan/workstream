package org.behive.com.workstream_platform.screens.registration.welcome;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.behive.com.workstream_platform.BR;
import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.databinding.WelcomeFragmentBinding;
import org.behive.com.workstream_platform.screens.BaseFragment;
import org.behive.com.workstream_platform.screens.BaseVM;
import org.behive.com.workstream_platform.screens.MainActivity;
import org.behive.com.workstream_platform.screens.NavigationClickListener;


public class WelcomeFragment extends BaseFragment<WelcomeFragmentBinding> {

    private MainActivity activity;
    private WelcomeViewModel viewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = ((MainActivity) getActivity());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity.setNavigationVisible(false);
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setTitle("");
        }
    }

    @Override
    protected BaseVM onCreateViewModel() {
        viewModel = ViewModelProviders.of(this).get(WelcomeViewModel.class);
        viewModel.setNavigationClickListener(navigationClickListener);
        return viewModel;
    }

    @Override
    protected void onBindViewModel(WelcomeFragmentBinding binding) {
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.welcome_fragment;
    }

    private NavigationClickListener navigationClickListener = destinationId -> getNavController().navigate(destinationId);

}
