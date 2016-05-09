import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Valentin on 23.4.2016 г..
 */
public class Cross2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] strLine = scan.nextLine().split(" ");
        int rows = Integer.parseInt(strLine[0]);
        int cols = Integer.parseInt(strLine[1]);
        int counter = 1;
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> colsList = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                colsList.add(counter);
                counter++;
            }
            matrix.add(colsList);
        }
        while (true) {
            String commandLine = scan.nextLine();
            if (commandLine.equals("Nuke it from orbit")) {
                break;
            }
            String[] commandArray = commandLine.split(" ");
            int rowPoint = Integer.parseInt(commandArray[0]);
            int colPoint = Integer.parseInt(commandArray[1]);
            int radius = Integer.parseInt(commandArray[2]);

            int startRow = rowPoint - radius;
            int endRow = rowPoint + radius;
            int startCol = colPoint - radius;
            int endCol = colPoint + radius;
            for (int i = Math.max(0, startRow); i <= Math.min(matrix.size() - 1, endRow); i++) {
                for (int j = Math.max(0, startCol); j <= Math.min(matrix.get(i).size() - 1, endCol); j++) {
                    if (i == rowPoint || j == colPoint)
                        matrix.get(i).set(j, 0);
                }
            }
            for (int i = matrix.size() - 1; i >= 0; i--) {
                for (int j = matrix.get(i).size() - 1; j >= 0; j--) {
                    if (matrix.get(i).get(j) == 0) {
                        matrix.get(i).remove(j);
                    }
                    if (matrix.get(i).size() == 0) {
                        matrix.remove(i);
                    }
                }
            }

        }
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.printf("%d ", matrix.get(i).get(j));
            }
            System.out.println();
        }
    }

}