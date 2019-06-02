package mastering.parallel.individual;

import java.util.ArrayList;
import java.util.List;

public class ParallelRowMultiplier {

    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        List<Thread> threadList = new ArrayList<>();
        int rows1 = matrix1.length;

        for (int i = 0; i < rows1; i++) {
            RowMultiplierTask task = new RowMultiplierTask(matrix1, matrix2, result, i);
            Thread thread = new Thread(task);
            thread.start();
            threadList.add(thread);
            if (threadList.size() % 10 == 0) {
                waitForThreads(threadList);
            }
        }
    }

    private static void waitForThreads(List<Thread> threadList) {
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threadList.clear();
    }
}
