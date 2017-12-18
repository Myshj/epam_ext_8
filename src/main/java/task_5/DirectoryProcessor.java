package task_5;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class DirectoryProcessor implements Runnable {
    ExecutorService pool;
    File resultFile;
    @Override
    public void run() {
        resultFile.canExecute();
    }
}
