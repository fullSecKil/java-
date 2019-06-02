package mastering.main;

import mastering.matrixmultiplier.MatrixGenerator;
import mastering.parallel.individual.ParallelIndividualMultiplier;

import java.util.Date;

/**
 *  每一个元素一个线程
 */
public class ParallelIndividualMain {
    public static void main(String[] args) {
        double matrix1[][] = MatrixGenerator.generate(2000, 2000);
        double matrix2[][] = MatrixGenerator.generate(2000, 2000);
        double resultSerial[][] = new double[matrix1.length][matrix2[0].length];

        Date start = new Date();
        ParallelIndividualMultiplier.multipy(matrix1, matrix2, resultSerial);
        Date end = new Date();
        System.out.println(end.getTime()-start.getTime());
    }
}
