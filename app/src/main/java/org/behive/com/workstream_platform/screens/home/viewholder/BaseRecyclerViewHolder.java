package org.behive.com.workstream_platform.screens.home.viewholder;

import android.annotation.SuppressLint;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseRecyclerViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseRecyclerViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(T object);

    public abstract ViewDataBinding getBinding();

    // Disable touch detection for parent recyclerView if we use vertical nested recyclerViews
    @SuppressLint("ClickableViewAccessibility")
    protected View.OnTouchListener mTouchListener = (v, event) -> {
        v.getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    };
}
