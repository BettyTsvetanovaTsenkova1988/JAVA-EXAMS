import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int demage = 0;
        int health = 0;
        int armor = 0;
        int counter = 1;
        LinkedHashMap<String, TreeMap<String, ArrayList<Integer>>> lista = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] text = scan.nextLine().split(" ");
            String type = text[0];
            String name = text[1];
            if (text[2].equals("null")) {
                demage = 45;
            } else {
                demage = Integer.parseInt(text[2]);
            }
            if (text[3].equals("null")) {
                health = 250;
            } else {
                health = Integer.parseInt(text[3]);
            }
            if (text[4].equals("null")) {
                armor = 10;
            } else {
                armor = Integer.parseInt(text[4]);
            }
            ArrayList<Integer> numbers = new ArrayList<>();
            numbers.add(demage);
            numbers.add(health);
            numbers.add(armor);
            numbers.add(counter);
            if (!lista.containsKey(type)) {
                lista.put(type, new TreeMap<>());
                lista.get(type).put(name, new ArrayList<>());
                lista.get(type).get(name).addAll(numbers);
            } else if (!lista.get(type).containsKey(name)) {
                lista.get(type).put(name, new ArrayList<>());
                lista.get(type).get(name).addAll(numbers);
            } else {
                ArrayList<Integer> oldNumbers = lista.get(type).get(name);//vzema starite stoinosti ot listata
                int four = oldNumbers.get(3) + numbers.get(3);//obnovqva broqcha
                lista.get(type).get(name).remove(0);//maha starite redove i na tqhno mqsto slaga novite zashtoto po uslovie se iska da se pazi samo posledniq zapis na edno i sushto ime
                lista.get(type).get(name).remove(0);
                lista.get(type).get(name).remove(0);
                lista.get(type).get(name).remove(0);
                lista.get(type).get(name).add(demage);
                lista.get(type).get(name).add(health);
                lista.get(type).get(name).add(armor);
                lista.get(type).get(name).add(four);//broqcha ne mi trqbva. polzva se ako trqbvashe da se pazqt vsichkite redove a ne samo posledniq. srednata stoinost shteshe da se izchislqva delena na tozi broqch
            }
        }

        for (String type : lista.keySet()) {
            double totalDemage = 0;
            double totalHealth = 0;
            double totalArmor = 0;
            int numberRows = 0;
            for (String name : lista.get(type).keySet()) {//obikalq samo za srednite stoinosti
                ArrayList<Integer> num = lista.get(type).get(name);
                totalDemage += num.get(0);
                totalHealth += num.get(1);
                totalArmor += num.get(2);
                numberRows=num.get(3);
            }
            totalDemage = totalDemage / lista.get(type).size();
            totalHealth = totalHealth / lista.get(type).size();
            totalArmor = totalArmor / lista.get(type).size();
            System.out.printf(type + "::(%.2f/%.2f/%.2f)", totalDemage, totalHealth, totalArmor);
            System.out.println();

            for (String namePrint : lista.get(type).keySet()) {
                ArrayList<Integer> numbersPrint = lista.get(type).get(namePrint);

                System.out.printf("-" + namePrint + " -> damage: %d, health: %d, armor: %d",
                        numbersPrint.get(0), numbersPrint.get(1), numbersPrint.get(2));
                System.out.println();
            }
        }
    }
}
