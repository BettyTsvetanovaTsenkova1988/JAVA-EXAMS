import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Parking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] matrixSize = scan.nextLine().split(" ");
        int r = Integer.parseInt(matrixSize[0]);
        int c = Integer.parseInt(matrixSize[0]);
        int[][] matrix = new int[r][c];
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                matrix[row][col] = 0; //pulni mi matricata s nuli
            }
        }

        String input = scan.nextLine();

        while (!input.equals("stop")) {
            int counter = 0;
            String[] text = input.split(" ");// string skomandata
            int entry = Integer.parseInt(text[0]);
            int wantedRow = Integer.parseInt(text[1]);
            int wantedCol = Integer.parseInt(text[2]);
            int currRow = entry;//ot tozi red vliza
            int currCol = 0;//ot tazi colona vliza

            if (wantedCol > c) { //ako izleze ot granicite v dqsno
                wantedCol = c;
            } else if (wantedCol < 0) {
                wantedCol = 0;
            }

            if (matrix[wantedRow][wantedCol] == 0) {//ako e svobodno mqstoto stava na 1-ca
                matrix[wantedRow][wantedCol] = 1;
                counter = Math.abs(entry - wantedRow) + (currCol + wantedCol + 1);//broi na stupkite
                System.out.println(counter);
            } else {//ako e zaETO
                if (matrix[wantedRow][wantedCol - 1] == 0 && wantedCol - 1 != 0) {//gleda v lqvo ako e svobodno
                    matrix[wantedRow][wantedCol - 1] = 1;
                    counter = Math.abs((entry - wantedRow) + (currCol + wantedCol));//broi na stupkite
                    System.out.println(counter);
                } //else if (matrix[wantedRow][wantedCol - 1] == 1 || wantedCol == 0) {//ako na lqvo e pulno ili e stignalo vhodnata kolona 0 da hodi na dqsno
               else if (matrix[wantedRow][wantedCol + 1] == 0) {//ako na dqsno e svododno go zaema
                    matrix[wantedRow][wantedCol + 1] = 1;
                    counter = Math.abs((entry - wantedRow) + (currCol + wantedCol + 2));//broi na stupkite
                    System.out.println(counter);
                } else if (matrix[wantedRow][wantedCol + 1] == 1) {//ako na dqsno e pulno
                    if (wantedCol + 1 == c) {//??? kude da go vmukna??????????????????????????????
                        wantedCol++;
                        if (matrix[wantedRow][wantedCol + 1] == 0) {
                            matrix[wantedRow][wantedCol + 1] = 1;
                            counter = Math.abs((entry - wantedRow) + (currCol + wantedCol + 2));//broi na stupkite
                            System.out.println(counter);
                        } else {
                            System.out.printf("Row %d full", wantedRow);
                            System.out.println();
                        }

//                    } else {
//                        System.out.printf("Row %d full", wantedRow);
//                        System.out.println();
//                    }

                    } else {
                        System.out.printf("Row %d full", wantedRow);
                        System.out.println();


                    }

                }


            }


            input = scan.nextLine();
        }
    }
}









