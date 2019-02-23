package org.behive.com.workstream_platform.screens.home.viewholder;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;

import org.behive.com.workstream_platform.BR;
import org.behive.com.workstream_platform.screens.home.tasks.OnTaskItemClickListener;
import org.behive.com.workstream_platform.model.task.Task;

public class TaskViewHolder extends BaseRecyclerViewHolder {
    private ViewDataBinding binding;
    private OnTaskItemClickListener onItemClickListner;

    public TaskViewHolder(View itemView, OnTaskItemClickListener onItemClickListner) {
        super(itemView);
        this.onItemClickListner = onItemClickListner;
        binding = DataBindingUtil.bind(itemView);
    }

    @Override
    public void bind(Object object) {
        Task task = (Task) object;
        itemView.setOnClickListener((view) -> {
            if (onItemClickListner != null) {
                onItemClickListner.onItemClicked(task);
            }
        });
        getBinding().setVariable(BR.item, task);
        getBinding().executePendingBindings();
    }

    @Override
    public ViewDataBinding getBinding() {
        return binding;
    }
}
