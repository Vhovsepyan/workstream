package org.behive.com.workstream_platform.executors;

import java.util.concurrent.Executor;

interface ExecutorProvider {
    Executor getExecutor(@ExecutorType int type);
}
