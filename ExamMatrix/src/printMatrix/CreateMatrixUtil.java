package printMatrix;

/**
 * Created by GaBi on 22.01.2016.
 */

import java.util.Scanner;

public class CreateMatrixUtil {
    public static int enterDimensionOfMatrix() {
        /*
        Enter dimension Of Matrix from 1 to 10
         */
        boolean finished = false;
        int dimensionOfMatrix = 0;
        while (!finished) {
            System.out.print("Enter dimension of matrix, an integer number from 1 to 10:");
            Scanner sc = new Scanner(System.in);
            String scannerDimensionOfMatrix = sc.nextLine().trim();
            try {
                dimensionOfMatrix = Integer.valueOf(scannerDimensionOfMatrix);
                finished = (dimensionOfMatrix >= 1) & (dimensionOfMatrix <= 10);
            }catch (NumberFormatException e){
                finished = false;
            }
        }
        return dimensionOfMatrix;
    }


    public static int[][] buildMatrix(int n) {
        /*
        Creates n x n matrix, n from 1 to 10
         */
        int[ ][ ] randomMatrix = new int[n][n];
        for(int i=0; i<randomMatrix.length; i++) {
            for(int j=0; j<randomMatrix[i].length; j++) {
                randomMatrix[i][j] = (int)(Math.random()*201 - 100);
            }
        }
        return randomMatrix;
    }

    public static String spiralMatrix(int n[][]) {
        /*
        Spirals n x n matrix
         */
        int startRow = 0, endRow = n.length-1, startCol=0, endCol=n[startRow].length-1;
        StringBuilder spiral = new StringBuilder();
        while (true){
            {
                for(int j = startCol; j <= endCol; ++j) spiral.append(n[startRow][j]).append(" ");
                startRow++;
                if(startRow > endRow || startCol > endCol) break;
                for(int i = startRow; i <= endRow; ++i) spiral.append(n[i][endCol]).append(" ");
                endCol--;
                if(startRow > endRow || startCol > endCol) break;
                for(int j = endCol; j >= startCol; --j) spiral.append(n[endRow][j]).append(" ");
                endRow--;
                if(startRow > endRow || startCol > endCol) break;
                for(int i = endRow; i >= startRow; --i) spiral.append(n[i][startCol]).append(" ");
                startCol++;
                if(startRow > endRow || startCol > endCol) break;
            }
        }
        return spiral.toString();
    }

    public static String serpentineMatrix(int n[][]) {
        /*
        Makes serpentine of n x n matrix
         */
        int startRow = 0, endRow = n.length-1, startCol=0, endCol=n[startRow].length-1;
        StringBuilder serpentine = new StringBuilder();
        while (true){
            for(int j = endCol; j >= startCol; --j) serpentine.append(n[endRow][j]).append(" ");
            endRow--;
            if(endRow < startRow) break;
            for(int j = startCol; j <= endCol; ++j) serpentine.append(n[endRow][j]).append(" ");
            endRow--;
            if(endRow < startRow) break;
        }
        return serpentine.toString();
    }
}


