package org.behive.com.workstream_platform.screens;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.support.v7.widget.Toolbar;

import org.behive.com.workstream_platform.MyApplication;
import org.behive.com.workstream_platform.R;

import androidx.navigation.NavController;

public abstract class BaseFragment<B extends ViewDataBinding> extends Fragment {
    private B binding;
    private BaseVM viewModel;
    private NavController navController;
    private MyApplication appContext;
    private Bundle bundle;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.appContext = (MyApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = onCreateViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        binding.setLifecycleOwner(this);
        bundle = getArguments();
        onBindViewModel(binding);
        navController = ((MainActivity)getActivity()).getNavController();
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setVariable(getVariable(), viewModel);
        binding.executePendingBindings();
    }

    protected LinearLayout getToolbarCustomLayout(Activity activity){
        Toolbar toolbar = activity.findViewById(R.id.toolbar);
        return toolbar.findViewById(R.id.toolbar_custom_view);
    }

    protected Toolbar getToolbarLayout(Activity activity){
        return activity.findViewById(R.id.toolbar);
    }
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    protected MyApplication getApplication() {
        return appContext;
    }

    protected NavController getNavController() {
        return navController;
    }

    protected abstract BaseVM onCreateViewModel();

    protected abstract void onBindViewModel(B binding);

    public abstract int getVariable();

    public abstract int getLayoutId();
}
