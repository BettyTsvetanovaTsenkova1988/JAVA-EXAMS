
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class logParserTrue {
    public static void main(String[] args) {

        Map<String, Map<String, ArrayList<String>>> lista = new TreeMap<>();
        Pattern pat = Pattern.compile("\"Project\":\\s+\\[\"(.*?)\"\\],\\s+\"Type\":\\s+\\[\"(.*?)\"\\],\\s+\"Message\":\\s+\\[\"(.*?)\"\\]");

        String line;
        Scanner scn = new Scanner(System.in);
        while (!(line = scn.nextLine()).equals("END")) {
            Matcher match = pat.matcher(line);
            match.find();
            String project = match.group(1);
            String type = match.group(2);
            String message = match.group(3);

            if (!lista.containsKey(project)) {
                lista.put(project, new TreeMap<>());
                lista.get(project).put("Critical", new ArrayList<>());
                lista.get(project).put("Warning", new ArrayList<>());
            }

            if (type.equals("Critical")) {
                lista.get(project).get("Critical").add(message);
            } else {
                lista.get(project).get("Warning").add(message);
            }
        }

        lista.entrySet().stream()
                .sorted((e1, e2) -> {
                    int total2 = (e2.getValue().get("Critical").size() + e2.getValue().get("Warning").size());
                    int total1 = (e1.getValue().get("Critical").size() + e1.getValue().get("Warning").size());

                    if (total1 != total2) {//pri razlichni sumi sortira v descending order
                        return Integer.compare(total2, total1);
                    }
                   return e1.getKey().compareTo(e2.getKey());//ako sumite sa ravni po abc
                })
                .forEach(project -> {//zapochva da sortira po proecta s celite listi za vs project v nego
                    System.out.println(project.getKey() + ":");//pechata projecta
                    ArrayList<String> critical = project.getValue().get("Critical");//smqta kolko messages ima v listata
                    ArrayList<String> warnings = project.getValue().get("Warning");//smqta kolko messages ima v listata
                    Collections.sort(critical);//sortira po abc mess
                    Collections.sort(warnings);
                    System.out.println("Total Errors: " + (critical.size() + warnings.size()));
                    System.out.println("Critical: " + critical.size());
                    System.out.println("Warnings: " + warnings.size());

                    System.out.println("Critical Messages:");
                    if (critical.size() == 0) {
                        System.out.println("--->None");
                    } else {
                        critical.stream().sorted((o1, o2) -> Integer.compare(o1.length(), o2.length()))
                                .forEach(e1 -> System.out.println("--->" + e1));
                    }

                    System.out.println("Warning Messages:");
                    if (warnings.size() == 0) {
                        System.out.println("--->None");
                    } else {
                        warnings.stream().sorted((o1, o2) -> Integer.compare(o1.length(), o2.length()))
                                .forEach(e1 -> System.out.println("--->" + e1));
                    }

                    System.out.println();
                });
    }
}