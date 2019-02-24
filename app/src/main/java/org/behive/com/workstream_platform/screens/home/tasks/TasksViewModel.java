package org.behive.com.workstream_platform.screens.home.tasks;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import org.behive.com.workstream_platform.MyApplication;
import org.behive.com.workstream_platform.model.task.Task;
import org.behive.com.workstream_platform.repo.TaskRepository;
import org.behive.com.workstream_platform.screens.BaseVM;
import org.behive.com.workstream_platform.utils.UrlConstants;

import java.util.List;

public class TasksViewModel extends BaseVM {
    private TaskRepository taskRepository;
    private LiveData<List<Task>> taskListLiveData;

    public TasksViewModel(@NonNull Application application) {
        super(application);
        taskRepository = ((MyApplication) application).getTaskRepository();
        taskListLiveData = taskRepository.getTaskList(UrlConstants.BRANCH_ID);
    }

    public LiveData<List<Task>> getTaskListLiveData() {
        return taskListLiveData;
    }
}
