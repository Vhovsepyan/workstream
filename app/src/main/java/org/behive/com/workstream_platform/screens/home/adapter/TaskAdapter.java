package org.behive.com.workstream_platform.screens.home.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.behive.com.workstream_platform.screens.home.tasks.OnTaskItemClickListener;
import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.model.task.Task;
import org.behive.com.workstream_platform.screens.home.viewholder.BaseRecyclerViewHolder;
import org.behive.com.workstream_platform.screens.home.viewholder.TaskViewHolder;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<BaseRecyclerViewHolder<Task>> {

    private List<Task> taskList;
    private OnTaskItemClickListener onItemClickListner;

    public TaskAdapter(OnTaskItemClickListener onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    @NonNull
    @Override
    public BaseRecyclerViewHolder<Task> onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.task_item_layout, viewGroup, false);
        return new TaskViewHolder(view, onItemClickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerViewHolder<Task> taskBaseRecyclerViewHolder, int i) {
        taskBaseRecyclerViewHolder.bind(taskList.get(i));
    }

    @Override
    public int getItemCount() {
        return taskList == null ? 0 : taskList.size();
    }

    public void setTaskList(List<Task> taskList){
        this.taskList = taskList;
        notifyDataSetChanged();
    }
}
