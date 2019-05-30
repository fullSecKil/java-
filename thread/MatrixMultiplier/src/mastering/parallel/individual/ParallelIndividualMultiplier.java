package mastering.parallel.individual;

import java.util.ArrayList;
import java.util.List;

/**
 * 并行个人乘数
 * <p>
 * ParallelIndividualMultiplier类将创建所有
 * 必要的执行县城计算结果矩阵
 */
public class ParallelIndividualMultiplier {

    /**
     * 接受两个将要相乘的矩阵，和用于存放结果的矩阵
     * 将处理结果矩阵所有元素，并创建一个单独的individualMultiplierTask类计算每一个元素
     * 按照10个一组的方式启动线程
     * 启动10个线程后，可使用waitForThreads辅助方法等待这10个线程最终完成
     *
     * @param matrix1
     * @param matrix2
     * @param result
     */
    public static void multipy(double[][] matrix1, double[][] matrix2, double[][] result) {

        List<Thread> threadList = new ArrayList<>();

        int rows1 = matrix1.length;

        int rows2 = matrix2.length;

        int columns2 = matrix2[0].length;

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                IndividualMultiplierTask task = new IndividualMultiplierTask(matrix1, matrix2, result, i, j);
                Thread thread = new Thread(task);
                thread.start();
                threadList.add(thread);

                if (threadList.size() % 10 == 0) {
                    waitForThreads(threadList);
                }
            }
        }
    }

    // 主线程阻塞等待，10个线程矩阵数值
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