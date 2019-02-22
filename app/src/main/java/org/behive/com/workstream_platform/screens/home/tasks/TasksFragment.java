package org.behive.com.workstream_platform.screens.home.tasks;

import android.databinding.ViewDataBinding;

import org.behive.com.workstream_platform.BR;
import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.databinding.FragmentTasksBinding;
import org.behive.com.workstream_platform.screens.BaseFragment;
import org.behive.com.workstream_platform.screens.BaseVM;

public class TasksFragment extends BaseFragment<FragmentTasksBinding> {
    @Override
    protected BaseVM onCreateViewModel() {
        return null;
    }

    @Override
    protected void onBindViewModel(FragmentTasksBinding binding) {

    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_tasks;
    }
}
