package org.behive.com.workstream_platform.utils;

import android.app.Activity;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class BindingHelper {

    @BindingAdapter("setSpannedText")
    public static void setSpannedText(TextView textView, SpannableString spannableString){
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    @BindingAdapter("requestFocus")
    public static void requestFocus(EditText editText, String string){
        Activity activity = (Activity) editText.getContext();
        editText.requestFocus();
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
    }
}
