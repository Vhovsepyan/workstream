package org.behive.com.workstream_platform.screens.home;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.behive.com.workstream_platform.BR;
import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.screens.ActivityView;
import org.behive.com.workstream_platform.screens.BaseFragment;
import org.behive.com.workstream_platform.screens.BaseVM;
import org.behive.com.workstream_platform.screens.MainActivity;
import org.behive.com.workstream_platform.utils.SharedPrefs;

import androidx.navigation.NavController;

public class HomeFragment extends BaseFragment {
    private NavController navController;
    private ActivityView activityView;
    private HomeViewModel viewModel;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        navController = activityView.getNavController();
        if (TextUtils.isEmpty(SharedPrefs.getInstance().getString(SharedPrefs.Constants.IS_USER_LOGGED_IN_KEY, ""))) {
            navController.popBackStack();
            navController.navigate(R.id.navigation2);
            return null;
        }
        activityView.setNavigationVisible(true);
        // Inflate the layout for this fragment
        return super.onCreateView(inflater,container, savedInstanceState);
    }

    @Override
    protected BaseVM onCreateViewModel() {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
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
        return R.layout.fragment_home;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activityView = ((MainActivity)getActivity());
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
