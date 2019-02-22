package org.behive.com.workstream_platform.screens.registration.welcome;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

import org.behive.com.workstream_platform.BuildConfig;
import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.screens.BaseVM;
import org.behive.com.workstream_platform.screens.NavigationClickListener;

public class WelcomeViewModel extends BaseVM {

    public ObservableField<String> versioName = new ObservableField<>();
    public ObservableField<SpannableString> signUpText = new ObservableField<>();
    private NavigationClickListener navigationClickListener;

    public WelcomeViewModel(@NonNull Application application) {
        super(application);
        setupVersionNameText();
        setupSignUpText();
    }

    private void setupVersionNameText(){
        String versionNameText = getString(R.string.version_name_text, getVersionName());
        versioName.set(versionNameText);
    }

    private String getVersionName(){
        return BuildConfig.VERSION_NAME;
    }

    private void setupSignUpText(){
        String singUpText = getString(R.string.sign_up_text);
        String fullSignUpText = getString(R.string.dont_have_account_text);

        int spannedTextLength = singUpText.length();
        int fullTextLength = fullSignUpText.length();


        //adding click span
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                navigationClickListener.navigateTo(R.id.checkUserNameFragment);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(ContextCompat.getColor(getApplication(), R.color.charcoal_grey));
            }
        };

        SpannableString spannableString = new SpannableString(fullSignUpText);
        spannableString.setSpan(clickableSpan, fullTextLength - spannedTextLength, fullTextLength, 0 );
        signUpText.set(spannableString);
    }


    public void navigateToSignIn(){
        navigationClickListener.navigateTo(R.id.action_welcomeFragment_to_checkUsernameFragment);
    }

    public void setNavigationClickListener(NavigationClickListener navigationClickListener) {
        this.navigationClickListener = navigationClickListener;
    }
}
