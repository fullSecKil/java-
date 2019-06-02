package mastering.main;

import mastering.matrixmultiplier.MatrixGenerator;
import mastering.parallel.individual.ParallelGroupMutiplier;

import java.util.Date;

public class ParallelGroupMain {
    public static void main(String[] args) {
        double[][] matrix1 = MatrixGenerator.generate(2000, 2000);
        double[][] matrix2 = MatrixGenerator.generate(2000, 2000);
        double[][] result = new double[matrix1.length][matrix2[0].length];

        Date start = new Date();
        ParallelGroupMutiplier.multiply(matrix1, matrix2, result);
        Date end = new Date();
        System.out.println("并行核心线程数"+(end.getTime()-start.getTime()));
    }
}
