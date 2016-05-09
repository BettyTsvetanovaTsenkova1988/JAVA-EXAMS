import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nuts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Pattern patt = Pattern.compile("(\\w+).*?(\\w+).*?([0-9]+)");
        TreeMap<String, LinkedHashMap<String, ArrayList<Integer>>> lista = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String text = scan.nextLine();
            Matcher mach = patt.matcher(text);
            if (mach.find()) {
                String company = mach.group(1);
                String nuts = mach.group(2);
                int kg = Integer.parseInt(mach.group(3));

                if (!lista.containsKey(company)) {
                    lista.put(company, new LinkedHashMap<>());
                    lista.get(company).put(nuts, new ArrayList<>());
                    lista.get(company).get(nuts).add(kg);
                } else if (!lista.get(company).containsKey(nuts)) {
                    lista.get(company).put(nuts, new ArrayList<>());
                    lista.get(company).get(nuts).add(kg);
                } else {
                    lista.get(company).get(nuts).add(kg);
                }
            }
        }

        for (String company : lista.keySet()) {
            int counter = 1;
            System.out.print(company + ": ");
            for (String nuts : lista.get(company).keySet()) {
                ArrayList<Integer> kilograms = lista.get(company).get(nuts);
                int count=0;
                for (Integer kilogram : kilograms) {

                    count+=kilogram;
                }
                if (counter == lista.get(company).size()) {
                    System.out.print(nuts + "-" + count + "kg");
                } else {
                    System.out.print(nuts + "-" + count + "kg, ");
                }
                counter++;
            }
            System.out.println();
        }
    }
}
