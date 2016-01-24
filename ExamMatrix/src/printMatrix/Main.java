package printMatrix;

import java.io.IOException;

/**
 * Created by GaBi on 22.01.2016.
 */

public class Main {
    public static void main(String[] args) throws IOException {
//        Creates matrix
        int[][] matrix = CreateMatrixUtil.buildMatrix(CreateMatrixUtil.enterDimensionOfMatrix());

//        Creates file and write matrix (table) in file
        RecordMatrixToFileUtil.writeStringInFile("Square matrix with random elements from -100 to 100:", RecordMatrixToFileUtil.fileCreate());
        RecordMatrixToFileUtil.writeMatrixInFile(matrix, RecordMatrixToFileUtil.fileCreate());

//        Write spiral matrix in file
        RecordMatrixToFileUtil.writeStringInFile("Spiral matrix:", RecordMatrixToFileUtil.fileCreate());
        RecordMatrixToFileUtil.writeStringInFile(CreateMatrixUtil.spiralMatrix(matrix), RecordMatrixToFileUtil.fileCreate());

//        Write serpentine matrix in file
        RecordMatrixToFileUtil.writeStringInFile("Serpentine matrix:", RecordMatrixToFileUtil.fileCreate());
        RecordMatrixToFileUtil.writeStringInFile(CreateMatrixUtil.serpentineMatrix(matrix), RecordMatrixToFileUtil.fileCreate());

//        Console message
        RecordMatrixToFileUtil.fileInform("Find result in file " + RecordMatrixToFileUtil.fileCreate().getName() + ".\n" +
                                      "Absolute Path: " + RecordMatrixToFileUtil.fileCreate().getAbsolutePath());
    }
}
