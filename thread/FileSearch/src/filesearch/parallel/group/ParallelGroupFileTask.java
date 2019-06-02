package filesearch.parallel.group;

import filesearch.utils.Result;

import java.io.File;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ParallelGroupFileTask implements Runnable {
    private final String fileName;
    private final ConcurrentLinkedQueue<File> directories;
    private final Result parallelResult;
    private boolean found;

    public ParallelGroupFileTask(String fileName, ConcurrentLinkedQueue<File> directories, Result parallelResult, boolean found) {
        this.fileName = fileName;
        this.directories = directories;
        this.parallelResult = parallelResult;
        this.found = found;
    }

    @Override
    public void run() {
        while(directories.size()>0){
            File file = directories.poll();

        }
    }
}
