import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Integer> keyMaterials = new LinkedHashMap<String, Integer>(); //важните
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        keyMaterials.put("shards", 0);
        int quantity = 0;
        String item = "";
        int maxScore = 250;
        String winner = "";

        TreeMap<String, Integer> junk = new TreeMap<String, Integer>();//боклуци

        while (true) {
            String things[] = scan.nextLine().toLowerCase().split(" ");
            for (int i = 0; i < things.length; i += 2) {
                quantity = Integer.parseInt(things[i]);
                item = things[i + 1];

                if (keyMaterials.containsKey(item)) { //ако намери съвпадение, прибавя стойността на намереното от входа
                    keyMaterials.put(item, keyMaterials.get(item) + quantity);
                    if (keyMaterials.get(item) >= 250) { //ако някой е достигнал 250точки от важното
                        keyMaterials.put(item, keyMaterials.get(item) - maxScore);//казва кой е победител и от точките се вадят 250/по условие/
                        winner = item;//извежда като стринг победителя
                        break;
                    }
                } else {
                    if (!junk.containsKey(item)) {//ако елемента го няма го добавя със стойност 0
                        junk.put(item, 0);
                    }
                    junk.put(item, junk.get(item) + quantity); //ако го има елемента, го взема и му прибавя новата стойноост
                }


            }
            if (winner.length() > 0) {
                break;
            }
        }
        System.out.println(getLegendary(winner) + " obtained!");

        keyMaterials.entrySet().stream()
                .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));

        junk.entrySet().forEach(j -> System.out.println(j.getKey() + ": " + j.getValue()));
    }

    private static String getLegendary(String material) {
        if (material.equals("shards")) return "Shadowmourne";
        if (material.equals("fragments")) return "Valanyr";

        return "Dragonwrath";
    }
}

