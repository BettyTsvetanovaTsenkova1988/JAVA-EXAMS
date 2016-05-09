import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming2 {//Betty solution
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, Integer> vajni = new LinkedHashMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();
        vajni.put("fragments", 0);
        vajni.put("motes", 0);
        vajni.put("shards", 0);
        int quantity = 0;
        String item = "";
        String winner = "";

        while (true) {
            String[] text = scan.nextLine().toLowerCase().split(" ");
            for (int i = 0; i < text.length; i += 2) {
                quantity = Integer.parseInt(text[i]);
                item = text[i + 1];

                if (item.equals("shards") || item.equals("fragments") || item.equals("motes")) {//samo vajnite
                    if (vajni.containsKey(item)) {//vseki put slaga staroto kolichestvo + novoto/novite zapisi se slagat a starite prezapisvat s novite stoinosti
                        vajni.put(item, vajni.get(item) + quantity);
                    }
                    if (vajni.get(item) >= 250) {//gleda koi item purvi e dostignal do 250
                        vajni.put(item, vajni.get(item) - 250);//vzima elementa i vadi 250/po uslovie/
                        winner = item;
                        if (winner.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else if (winner.equals("fragments")) {
                            System.out.println("Valanyr obtained!");
                        } else {
                            System.out.println("Dragonwrath obtained!");
                        }
                        break;//kato nameri pobeditelq izliza ot for-a
                    }
                } else {//samo boklucite
                    if (!junk.containsKey(item)) {//ako go nqma
                        junk.put(item, quantity);
                    }else{
                        junk.put(item, junk.get(item) + quantity);//ako go ima prezapisva + novite stoinosti
                    }
                }
            }
            if (winner.length() > 0) {//ako ima pobeditel izliza ot while i minava kum eazpechatvaneto
                break;
            }
        }
        vajni.entrySet().stream()
                .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));

        junk.entrySet().forEach(j -> System.out.println(j.getKey() + ": " + j.getValue()));

    }
}






