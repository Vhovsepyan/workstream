package org.behive.com.workstream_platform.screens.home.workspaces;

import android.arch.lifecycle.ViewModelProviders;

import org.behive.com.workstream_platform.BR;
import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.databinding.FragmentWorkSpacesBinding;
import org.behive.com.workstream_platform.screens.BaseFragment;
import org.behive.com.workstream_platform.screens.BaseVM;

public class WorkSpacesFragment extends BaseFragment<FragmentWorkSpacesBinding> {
    private WorkspaseViewModel viewModel;

    @Override
    protected BaseVM onCreateViewModel() {
        viewModel = ViewModelProviders.of(this).get(WorkspaseViewModel.class);
        return viewModel;
    }

    @Override
    protected void onBindViewModel(FragmentWorkSpacesBinding binding) {

    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_work_spaces;
    }
}
