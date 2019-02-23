package org.behive.com.workstream_platform.screens.home.tasks;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.behive.com.workstream_platform.BR;
import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.databinding.FragmentTasksBinding;
import org.behive.com.workstream_platform.model.task.Task;
import org.behive.com.workstream_platform.screens.BaseFragment;
import org.behive.com.workstream_platform.screens.BaseVM;
import org.behive.com.workstream_platform.screens.home.adapter.TaskAdapter;
import org.behive.com.workstream_platform.utils.AppLog;

public class TasksFragment extends BaseFragment<FragmentTasksBinding> {
    private static final String TAG = TasksFragment.class.getSimpleName();
    private TasksViewModel viewModel;
    private TaskAdapter taskAdapter;

    @Override
    protected BaseVM onCreateViewModel() {

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        taskAdapter = new TaskAdapter(onItemClickListner);
        viewModel = ViewModelProviders.of(getActivity()).get(TasksViewModel.class);
        viewModel.getTaskListLiveData().observe(this, tasks -> {
            if (tasks != null) {
                AppLog.i(TAG + " taskList size = " + tasks.size());
                taskAdapter.setTaskList(tasks);
            } else {
                AppLog.w(TAG + " taskList is NULL ");
            }
        });
        return viewModel;
    }

    private OnTaskItemClickListener onItemClickListner = object -> {
        Task task = (Task) object;
        AppLog.i(TAG + " clicked task = " + task);
    };

    @Override
    protected void onBindViewModel(FragmentTasksBinding binding) {
        initRecyclerView(binding.tasksRecyclerView);
    }

    private void initRecyclerView(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getApplication(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(taskAdapter);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_tasks;
    }
}
