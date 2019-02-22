package org.behive.com.workstream_platform.screens.home.contacts;

import android.arch.lifecycle.ViewModelProviders;

import org.behive.com.workstream_platform.BR;
import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.databinding.FragmentContactsBinding;
import org.behive.com.workstream_platform.screens.BaseFragment;
import org.behive.com.workstream_platform.screens.BaseVM;

public class ContactsFragment extends BaseFragment<FragmentContactsBinding> {
    private ContactsViewModel viewModel;

    @Override
    protected BaseVM onCreateViewModel() {
        viewModel = ViewModelProviders.of(this).get(ContactsViewModel.class);
        return viewModel;
    }

    @Override
    protected void onBindViewModel(FragmentContactsBinding binding) {

    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_contacts;
    }
}
