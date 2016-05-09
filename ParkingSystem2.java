import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ParkingSystem2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] matrixSize = scan.nextLine().split(" ");
        int r = Integer.parseInt(matrixSize[0]);
        LinkedHashMap<Integer, ArrayList<Integer>> lista = new LinkedHashMap<Integer, ArrayList<Integer>>();
        String input = scan.nextLine();

        while (input != "stop") {
            String[] text = input.split(" ");

            for (int i = 0; i < r; i++) {
                lista.put(i, new ArrayList<Integer>());
                for (int j = 0; j < r; j++) {//pulni listata s nuli
                    lista.get(i).add(0);
                }
            }


            input = scan.nextLine();

        }



    }


}
