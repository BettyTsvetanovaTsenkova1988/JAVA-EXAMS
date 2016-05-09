import java.util.*;

public class PossibleTriangles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        ArrayList<Double> lista = new ArrayList<Double>();
        int counter = 0;
        while (!text.equals("End")) {
            String[] arr = text.split(" ");
            double one = Double.parseDouble(arr[0]);
            double two = Double.parseDouble(arr[1]);
            double thhee = Double.parseDouble(arr[2]);
            lista.add(one);
            lista.add(two);
            lista.add(thhee);
            Collections.sort(lista);
            if (lista.get(0) + lista.get(1) > lista.get(2)) {
                System.out.printf("%.2f+%.2f>%.2f", lista.get(0), lista.get(1), lista.get(2));
                System.out.println();
                counter++;
            }
            lista.clear();

            text = scan.nextLine();
        }
        if (counter == 0) {
            System.out.println("No");
        }
    }
}
