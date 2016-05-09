import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class SchoolSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        TreeMap<String, TreeMap<String, ArrayList<Integer>>> lista = new TreeMap<String, TreeMap<String, ArrayList<Integer>>>();

        for (int i = 0; i < n; i++) {
            String[] text = scan.nextLine().split(" ");
            String name = text[0] + " " + text[1];
            String predmet = text[2];
            Integer ocenka = Integer.parseInt(text[3]);
//            System.out.println(name);
//            System.out.println(predmet);
//            System.out.println(ocenka);
            if (!lista.containsKey(name)) {//ako nqma nishto
                lista.put(name, new TreeMap<String, ArrayList<Integer>>());
                lista.get(name).put(predmet, new ArrayList<Integer>());
                lista.get(name).get(predmet).add(ocenka);
            } else if (!lista.get(name).containsKey(predmet)) {//imeto go ima no nqma predmeta
                lista.get(name).put(predmet, new ArrayList<Integer>());
                lista.get(name).get(predmet).add(ocenka);
            } else {//ima si vsichko
                lista.get(name).get(predmet).add(ocenka);
            }

        }
        for (String name : lista.keySet()) {
            int countPossition = 1;
            System.out.print(name + ": [");
            for (String predmet : lista.get(name).keySet()) {
                System.out.print(predmet + " - ");
                ArrayList<Integer> ocenki = lista.get(name).get(predmet);
                ocenki.size();
                double average = 0.00;
                int granica = lista.get(name).size();
                for (Integer ocenka : ocenki) {
                    average += ocenka;
                }
                average = average / ocenki.size();
                if (countPossition == granica) {
                    System.out.printf("%.2f", average);
                } else {
                    System.out.printf("%.2f, ", average);
                }
                countPossition++;
            }
            System.out.print("]");
            System.out.println();
        }
    }


}
