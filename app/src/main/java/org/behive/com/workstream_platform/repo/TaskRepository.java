package org.behive.com.workstream_platform.repo;

import android.arch.lifecycle.LiveData;

import org.behive.com.workstream_platform.model.task.Task;

import java.util.List;

public interface TaskRepository {

    LiveData<List<Task>> getTaskList(String branchId);
}
