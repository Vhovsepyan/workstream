package org.behive.com.workstream_platform.screens.register;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.screens.ActivityView;
import org.behive.com.workstream_platform.screens.MainActivity;

import androidx.navigation.NavController;


public class RegistrationFragment extends Fragment {

    private NavController navController;
    private EditText nameEditText;
    private EditText passEditText;
    private ActivityView activityView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activityView = ((MainActivity)getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activityView.setNavigationVisible(false);
        navController = activityView.getNavController();
        return inflater.inflate(R.layout.registration_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.registr_button).setOnClickListener(v -> successLogin());
        nameEditText = view.findViewById(R.id.name_edit_text);
        passEditText = view.findViewById(R.id.password_edittext);
    }

    public void doLoginOrRegistr() {
        String name = nameEditText.getText().toString();
        if (TextUtils.isEmpty(name)) {
            return;
        }
        String pass = passEditText.getText().toString();
    }

    public void successLogin() {
        navController.popBackStack();
        navController.navigate(R.id.homeFragment);
    }
}
