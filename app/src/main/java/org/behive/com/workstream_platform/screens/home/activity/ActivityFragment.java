package org.behive.com.workstream_platform.screens.home.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.behive.com.workstream_platform.BR;
import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.databinding.FragmentActivityBinding;
import org.behive.com.workstream_platform.screens.BaseFragment;
import org.behive.com.workstream_platform.screens.BaseVM;

public class ActivityFragment extends BaseFragment<FragmentActivityBinding> {
    private AcitivtyFragmentViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected BaseVM onCreateViewModel() {
        viewModel = ViewModelProviders.of(this).get(AcitivtyFragmentViewModel.class);
        return viewModel;
    }

    @Override
    protected void onBindViewModel(FragmentActivityBinding binding) {

    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
