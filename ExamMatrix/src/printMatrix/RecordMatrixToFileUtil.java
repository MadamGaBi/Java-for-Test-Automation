package printMatrix;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by GaBi on 24.01.2016.
 */

public class RecordMatrixToFileUtil {
    public static void fileInform(String s) {
        /*
        Prints string text
         */
        System.out.println(s);
    }

    public static File fileCreate() throws IOException {
        /*
        Creates file .txt
         */
        File fileWithMatrix = new File("matrix.txt");
        if (!fileWithMatrix.exists()) {
            fileWithMatrix.createNewFile();
        }
        return fileWithMatrix;
    }

    public static void writeMatrixInFile(int[][] matrix, File fileWithMatrix) throws IOException {
        /*
        Writes table matrix in file
         */
        FileWriter fileWriter = new FileWriter(fileWithMatrix, true);
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                fileWriter.append(anAMatrix + "\t");
            }
            fileWriter.append("\n");
        }
        fileWriter.close();
    }

    public static void writeStringInFile(String stringMatrix, File fileWithMatrix) throws IOException {
        /*
        Writes string matrix in file
         */
        FileWriter fileWriter = new FileWriter(fileWithMatrix, true);
        fileWriter.append(stringMatrix).append("\n");
        fileWriter.close();
    }
}
