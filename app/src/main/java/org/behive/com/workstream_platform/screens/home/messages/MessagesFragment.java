package org.behive.com.workstream_platform.screens.home.messages;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.ViewDataBinding;

import org.behive.com.workstream_platform.BR;
import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.screens.BaseFragment;
import org.behive.com.workstream_platform.screens.BaseVM;

public class MessagesFragment extends BaseFragment {
    private MessagesViewModel viewModel ;

    @Override
    protected BaseVM onCreateViewModel() {
        viewModel = ViewModelProviders.of(this).get(MessagesViewModel.class);
        return viewModel;
    }

    @Override
    protected void onBindViewModel(ViewDataBinding binding) {

    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_messages;
    }
}
