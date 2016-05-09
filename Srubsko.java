import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Srubsko {
    public static void main(String[] args) { //(.*?)\s@(.*?) (\d+) (\d+) testvai
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Map<String, Integer>> lista = new LinkedHashMap<>();

        while (!input.equals("End")) {
            StringBuilder town = new StringBuilder();
            String[] arr = input.split("@");
            String name = arr[0];
            if(name.charAt(name.length()-1)!=' '){
                input = scan.nextLine();
                continue;
            }
            String[] townMoney = arr[1].split(" ");
            if (townMoney.length <= 2) {
                input = scan.nextLine();
                continue;
            }

            int price = Integer.parseInt(townMoney[townMoney.length - 2]);
            int ticketCount = Integer.parseInt(townMoney[townMoney.length - 1]);
            int total = price * ticketCount;


            for (int i = 0; i < townMoney.length - 2; i++) {

                town.append(townMoney[i] + " ");
                town.toString().substring(0, town.length() - 1);
            }
            String city = town.toString();
            if (!lista.containsKey(city)) {
                lista.put(city, new LinkedHashMap<String, Integer>());
                lista.get(city).put(name, total);
                lista.get(city).get((name) + total);

            } else if (!lista.get(city).containsKey(name)) {
                lista.get(city).put(name, total);
                lista.get(city).get((name) + total);

            } else {
                lista.get(city).put(name, lista.get(city).get(name) + total);
            }


            input = scan.nextLine();
        }


        for (Map.Entry<String, Map<String, Integer>> print : lista.entrySet()) {
            System.out.println(print.getKey());
            print.getValue().entrySet().stream()
                    .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                    .forEach((enty) -> {
                        System.out.printf("#  %s-> %d", enty.getKey(), enty.getValue());
                        System.out.println();
                    });
        }
    }


}





