package mastering.matrixmultiplier;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * 随机生成将进行乘法操作的举证
 */
public class MatrixGenerator {

    public static double[][] generate(int rows, int columns) {
        double[][] result = new double[rows][columns];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = random.nextDouble() * 10;
            }
        }
        return result;
    }
}
