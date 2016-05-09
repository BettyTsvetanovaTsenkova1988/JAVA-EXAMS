import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Events {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, TreeMap<String, ArrayList<String>>> lista = new TreeMap<String, TreeMap<String, ArrayList<String>>>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String text = scan.nextLine();
            Pattern pat = Pattern.compile("(#*[a-zA-Z]+:).*?(@[a-zA-Z]+).*?([0-9]+:[0-9]+)");
            Matcher mach = pat.matcher(text);
            while (mach.find()) {
                String name = mach.group(1);
                name = name.substring(1, name.length() - 1);
                String town = mach.group(2);
                town = town.substring(1, town.length());
                String hour = mach.group(3);
                String[] hm = hour.split(":");
                int h = Integer.parseInt(hm[0]);
                int m = Integer.parseInt(hm[1]);

                if (h < 0 || h > 23 || m < 0 || m > 59) {
                    continue;
                }
                if (!lista.containsKey(town)) {
                    lista.put(town, new TreeMap<String, ArrayList<String>>());
                    lista.get(town).put(name, new ArrayList<String>());
                    lista.get(town).get(name).add(hour);
                } else if (!lista.get(town).containsKey(name)) {
                    lista.get(town).put(name, new ArrayList<String>());
                    lista.get(town).get(name).add(hour);
                } else {
                    lista.get(town).get(name).add(hour);
                }

            }
        }
        String[] location = scan.nextLine().split(",");

        for (String town : lista.keySet()) {

            int possition = 1;
            for (int i = 0; i < location.length; i++) {
                if (town.equals(location[i])) {
                    System.out.println(town + ":");
                    for (String name : lista.get(town).keySet()) {
                        int counter = 1;
                        System.out.printf("%d. " + name + " -> ", possition);
                        possition++;
                        ArrayList<String> hoursList = lista.get(town).get(name);
                        Collections.sort(hoursList);
                        for (String hour : hoursList) {
                            if (counter == hoursList.size()) {
                                System.out.print(hour);
                            } else {
                                System.out.print(hour + ", ");
                            }
                            counter++;
                        }
                        System.out.println();

                    }


                }
                // counter++;
                //  System.out.println();
            }
        }
    }
}
