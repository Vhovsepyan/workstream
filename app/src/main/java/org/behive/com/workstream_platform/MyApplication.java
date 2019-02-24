package org.behive.com.workstream_platform;

import android.app.Application;

import org.behive.com.workstream_platform.dao.AppDatabase;
import org.behive.com.workstream_platform.http.RestApiFactory;
import org.behive.com.workstream_platform.repo.TaskRepository;
import org.behive.com.workstream_platform.repo.UserRepository;
import org.behive.com.workstream_platform.repo.impl.TaskRepositoryImpl;
import org.behive.com.workstream_platform.repo.impl.UserRepositoryImpl;
import org.behive.com.workstream_platform.utils.SharedPrefs;

public class MyApplication extends Application {
    private AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPrefs.initialize(this);
        appDatabase = AppDatabase.getInstance(this);
    }

    public TaskRepository getTaskRepository() {
        return new TaskRepositoryImpl(RestApiFactory.getRestApi());
    }

    public UserRepository getUserRepository() {
        return new UserRepositoryImpl(RestApiFactory.getRestApi(), appDatabase.getUserDao());
    }
}
