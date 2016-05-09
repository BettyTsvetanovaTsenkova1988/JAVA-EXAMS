import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text;
        Pattern pattern = Pattern.compile("\\[\\\"(.*?)\\\"\\].+?\\[\\\"(.*?)\\\"\\].+?\\[\\\"(.*?)\\\"\\]");
        TreeMap<String, TreeMap<String, ArrayList<String>>> lista = new TreeMap<>();
        TreeMap<String, Integer> countTotalErrors = new TreeMap<>();


        while (!(text = scan.nextLine()).equals("END")) {
            Matcher matcher = pattern.matcher(text);


            if (matcher.find()) {
                String project = matcher.group(1);
                String type = matcher.group(2);
                String message = matcher.group(3);
                if (!lista.containsKey(project)) {
                    lista.put(project, new TreeMap<>());
                    lista.get(project).put(type, new ArrayList<>());
                    lista.get(project).get(type).add(message);
                    countTotalErrors.put(project, 1);

                } else if (!lista.get(project).containsKey(type)) {
                    lista.get(project).put(type, new ArrayList<>());
                    lista.get(project).get(type).add(message);

                } else {
                    lista.get(project).get(type).add(message);
                    countTotalErrors.put(project, countTotalErrors.get(project) + 1);
                }


            }
            text = scan.nextLine();
        }
        lista.entrySet().stream()
                .sorted((r1, r2) -> Integer.compare(countTotalErrors.get(r2.getKey()), countTotalErrors.get(r1.getKey())))
                .forEach(pair -> {
                    System.out.println(pair.getKey() + ":");
                    ArrayList<String> critic = pair.getValue().get("Critical");
                    ArrayList<String> warning = pair.getValue().get("Warning");
                    System.out.println("Total Errors: " + (critic.size() + warning.size()));
                    System.out.println("Critical: " + critic.size());
                    System.out.println("Warnings: " + warning.size());
                    System.out.println("Critical Messages:");


//                    System.out.println(entrys.getKey() + ":");
//                    System.out.printf("Total Errors: %d", lista.size());
//                    System.out.println();
//                    System.out.printf("Critical: %d", lista.get(entrys).get("Critical").size());
//                    System.out.println();
//                    System.out.printf("Warnings: %d", lista.get("Warning").size());
//                    System.out.println();
//                    System.out.println("Critical Messages:");


//                    // entrys.getValue().entrySet().values.stream().sorted((m1,m2)-> Integer.compare(m1.le))
//                    // entrys.getValue().values().stream().forEach(k->{
//                    //          k.
//                    entrys.getValue().values().stream().sorted((m1, m2) -> Integer.compare(m1.size(), m2.size()));
                });
    }

    private static void printList(ArrayList<String> list) {
        if (list.size() < 1) {
            System.out.println("--->None");
            return;
        }

        list.stream().sorted((e1, e2) -> {
            if (e1.length() != e2.length()) {
                return Integer.compare(e1.length(), e2.length());
            }
            return e1.compareTo(e2);
        }).forEach(e1 -> {
            System.out.println("--->" + e1);
        });
    }
}

