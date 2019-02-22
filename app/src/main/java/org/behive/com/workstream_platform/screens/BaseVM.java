package org.behive.com.workstream_platform.screens;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import org.behive.com.workstream_platform.executors.ExecutorService;
import org.behive.com.workstream_platform.executors.ExecutorType;
import org.behive.com.workstream_platform.utils.SharedPrefs;

import java.util.concurrent.Executor;

public abstract class BaseVM extends AndroidViewModel {


    public BaseVM(@NonNull Application application) {
        super(application);
    }

    protected Executor getExecutor(@ExecutorType int type) {
        return ExecutorService.getExecutor(type);
    }

    protected SharedPrefs getPreferences() {
        return SharedPrefs.getInstance();
    }

    protected String getString(int resId) {
        return getApplication().getString(resId);
    }

    protected String getString(int resId, String text) {
        return getApplication().getString(resId, text);
    }
}
