package org.behive.com.workstream_platform.screens.home;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.behive.com.workstream_platform.BR;
import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.databinding.FragmentHomeBinding;
import org.behive.com.workstream_platform.screens.ActivityView;
import org.behive.com.workstream_platform.screens.BaseFragment;
import org.behive.com.workstream_platform.screens.BaseVM;
import org.behive.com.workstream_platform.screens.MainActivity;
import org.behive.com.workstream_platform.utils.SharedPrefs;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> {

    private HomeViewModel viewModel;
    private NavController navController;
    private ActivityView activityView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activityView = ((MainActivity) getActivity());
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        navController = activityView.getNavController();
        if (TextUtils.isEmpty(SharedPrefs.getInstance().getString(SharedPrefs.Constants.IS_USER_LOGGED_IN_KEY, ""))) {
            navController.popBackStack();
            navController.navigate(R.id.navigation2);
            return null;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(getActivity(), R.id.bottomNavFragment);
        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottom_navigation);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

    }

    @Override
    protected BaseVM onCreateViewModel() {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        return viewModel;
    }

    @Override
    protected void onBindViewModel(FragmentHomeBinding binding) {

    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }
}
