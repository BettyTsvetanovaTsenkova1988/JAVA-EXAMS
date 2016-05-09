import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class OfficeStuff {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        TreeMap<String, LinkedHashMap<String, ArrayList<Integer>>> lista = new TreeMap<String, LinkedHashMap<String, ArrayList<Integer>>>();

        for (int i = 0; i < n; i++) {
            String[] text = scan.nextLine().trim().split("\\s+-");
            String company = text[0].substring(1, text[0].length());
            int amount = Integer.parseInt(text[1].substring(1, text[1].length()).toString());
            String product = text[2].substring(1, text[2].length() - 1);

            if (!lista.containsKey(company)) {//ako izobshto go nqma
                lista.put(company, new LinkedHashMap<String, ArrayList<Integer>>());
                lista.get(company).put(product, new ArrayList<Integer>());
                lista.get(company).get(product).add(amount);

            } else if (!lista.get(company).containsKey(product)) {//ako firmata q ima no nqma nov vid product
                lista.get(company).put(product, new ArrayList<Integer>());
                lista.get(company).get(product).add(amount);
            } else {//ako vsichko sio go ima
                lista.get(company).get(product).add(amount);
            }

        }
        for (String name : lista.keySet()) {
            System.out.print(name + ": ");
            int counter = 1;
            for (String product : lista.get(name).keySet()) {
                int total = 0;
                ArrayList<Integer> quantity = lista.get(name).get(product);
                for (Integer integer : quantity) {
                    total += integer;
                }
                if (counter == lista.get(name).size()) {
                    System.out.print(product + "-" + total);
                } else {
                    System.out.print(product + "-" + total + ", ");
                }
                counter++;
            }
            System.out.println();
        }

    }
}
