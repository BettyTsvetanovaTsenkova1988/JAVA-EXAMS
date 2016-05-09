import java.util.Scanner;

public class ParkingSystem {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] data = console.nextLine().split(" ");
        int matrixRows = Integer.parseInt(data[0]);
        int matrixCols = Integer.parseInt(data[1]);
        boolean[][] matrix = new boolean[matrixRows][matrixCols];
        String input = console.nextLine();


        while (!input.equals("stop")) {
            int stepCounter = 1;
            data = input.split(" ");
            int startRow = Integer.parseInt(data[0]);
            int parcRow = Integer.parseInt(data[1]);
            if (isRowFull(matrix, parcRow)) {
                System.out.printf("R %d full\n", parcRow);
            } else {
                int parCol = Integer.parseInt(data[2]);

                stepCounter += Math.abs(parcRow - startRow);
                stepCounter += parCol;
                if (!matrix[parcRow][parCol]) {
                    matrix[parcRow][parCol] = true;
                    System.out.println(stepCounter);
                } else {
//                    int distance =
                }
            }


            input = console.nextLine();

        }

    }

    static boolean isRowFull(boolean[][] matrix, int row) {
        for (int i = 1; i < matrix[row].length; i++) {
            if (matrix[row][i] == false) {
                return false;
            }
            // boolean[] booleen = matrix[i];
        }
        return true;
    }
}
