package org.behive.com.workstream_platform.screens.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.screens.ActivityView;
import org.behive.com.workstream_platform.screens.MainActivity;
import org.behive.com.workstream_platform.utils.SharedPrefs;

import androidx.navigation.NavController;

public class HomeFragment extends Fragment {
    private NavController navController;
    private ActivityView activityView;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        return inflater.inflate(R.layout.fragment_home, container, false);
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