package org.behive.com.workstream_platform.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.internal.LinkedTreeMap;

import org.behive.com.workstream_platform.R;

import java.util.List;

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


    @BindingAdapter("taskPriorityBackground")
    public static void setTaskPriorityBackground(View view, int priority){
        Resources resources= view.getContext().getResources();
        switch (priority){
            case 1:{
                view.setBackgroundColor(resources.getColor(R.color.colorPeriwinkleBlue));
                break;
            }
            case 2:{
                view.setBackgroundColor(resources.getColor(R.color.orangeot_mi_ban));
                break;
            }
            case 3:{
                view.setBackgroundColor(Color.RED);
                break;
            }
            default:{
                break;
            }
        }
    }

    @BindingAdapter("taskItemBackground")
    public static void setTaskItemBackground(LinearLayout view, int priority){
        Resources resources= view.getContext().getResources();
        switch (priority){
            case 1:{
                view.setBackgroundColor(resources.getColor(R.color.colorLowBg));
                break;
            }
            case 2:{
                view.setBackgroundColor(resources.getColor(R.color.colorMediumBg));
                break;
            }
            case 3:{
                view.setBackgroundColor(Color.WHITE);
                break;
            }
            default:{
                break;
            }
        }
    }

    @BindingAdapter("taskPriorityText")
    public static void setTaskPriorityText(TextView textView, int priority){
        switch (priority){
            case 1:{
                textView.setText(R.string.low_priority_text);
                break;
            }
            case 2:{
                textView.setText(R.string.medium_priority_text);
                break;
            }
            case 3:{
                textView.setText(R.string.high_priority_text);
                break;
            }
            default:{
                break;
            }
        }
    }

    @BindingAdapter("taskPriorityTextColor")
    public static void setTaskPriorityBackground(TextView textView, int priority){
        Resources resources= textView.getContext().getResources();
        switch (priority){
            case 1:{
                textView.setTextColor(resources.getColor(R.color.colorPeriwinkleBlue));
                break;
            }
            case 2:{
                textView.setTextColor(resources.getColor(R.color.orangeot_mi_ban));
                break;
            }
            case 3:{
                textView.setTextColor(Color.RED);
                break;
            }
            default:{
                break;
            }
        }
    }

    @BindingAdapter("initAssigneesLayout")
    public static void initAssigneesLayout(LinearLayout linearLayout, List<Object> assignees){
        Context context = linearLayout.getContext();
        linearLayout.removeAllViews();
        for (int i = 0; i < assignees.size(); i++) {
            Object o = assignees.get(i);
            LinkedTreeMap map = (LinkedTreeMap) o;
            String firstName = (String) map.get("username");
            TextView textView = new TextView(context);
            firstName = firstName.substring(0,1).toUpperCase();
            textView.setLayoutParams(new LinearLayout.LayoutParams(80, 80));
            textView.setGravity(Gravity.CENTER);

            if (i <= 2){
                textView.setBackgroundResource(R.drawable.rounded_corners);
                textView.setText(firstName);
                GradientDrawable drawable = (GradientDrawable) textView.getBackground();
                drawable.setColor(getColorByPosition(i));
                linearLayout.addView(textView);
            } else {
                textView.setText("+" + (assignees.size()-3));
                linearLayout.addView(textView);
                break;
            }

        }
    }

    private static int getColorByPosition(int i){
        switch (i){
            case 0:
                return Color.RED;
            case 1:
                return Color.GREEN;
            case 2:
                return Color.YELLOW;
                default:
                    return Color.GRAY;
        }

    }
}
