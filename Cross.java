import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cross {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] matrixdimensions = sc.nextLine().split(" ");
        int rows = Integer.parseInt(matrixdimensions[0]);
        int cols = Integer.parseInt(matrixdimensions[1]);
        long[][] matrix = new long[rows][cols];
        long n = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = n++;
            }
        }
        String input = sc.nextLine();
        String[][] newMatrix = new String[rows][cols];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                newMatrix[i][j] = String.valueOf(matrix[i][j]);

            }
        }
        while (!input.equals("Nuke it from orbit")) {
            String[] data = input.split(" ");
            long row = Integer.parseInt(data[0]);
            long col = Integer.parseInt(data[1]);
            long radius = Integer.parseInt(data[2]);
            deleteNums(row, col, radius, newMatrix);
            for (int i = 0; i < newMatrix.length; i++) {
                for (int j = 0; j < newMatrix[0].length; j++) {
                    if (newMatrix[i][j].equals("0")) {
                        if (j < newMatrix[0].length - 1) {
                            newMatrix[i][j] = newMatrix[i][j + 1];
                            newMatrix[i][j + 1] = "0";
                        }
                    }
                }
            }
            input = sc.nextLine();
        }
        for (int i = 0; i < newMatrix.length; i++) {
            int nonemptylines = 0;
            for (int j = 0; j < newMatrix[0].length; j++) {
                if (!newMatrix[i][j].equals("0")) {
                    System.out.print(newMatrix[i][j] + " ");
                    nonemptylines++;
                }
            }
            if (nonemptylines > 0) {
                System.out.println();
            }
        }
    }

    private static void deleteNums(long row, long col, long radius, String matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == row) {
                    if (j >= col - radius && j <= radius + col) {
                        matrix[i][j] = "0";
                    }
                }
                if (j == col) {
                    if (i >= row - radius && i <= radius + row) {
                        matrix[i][j] = "0";
                    }
                }
            }
        }
    }
}