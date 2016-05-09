import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoyalAccounting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //([a-zA-Z]+)\;(\d+)\;([0-9]+).+?([a-zA-Z]+) проблем само с дабъл
        //([a-zA-Z]+)\;(\d+)\;(.+?)\;([a-zA-Z]+) veren
        //([a-zA-Z]+)\;(\d+)\;(-?\d+\.?\d*)\;([a-zA-Z]+) ivan
        String text = scan.nextLine();
        Pattern pattern = Pattern.compile("^([A-Za-z]+)\\;(-?\\d+);(-?\\d+\\.?\\d*?)\\;([A-Za-z]+)$");
        TreeMap<String, TreeMap<String, ArrayList<Double>>> lista = new TreeMap<>();
        HashMap<String, Double> dopulnitelna = new HashMap<>();

        while (!text.equals("Pishi kuf i da si hodim")) {
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                String team = matcher.group(4);
                String name = matcher.group(1);
                int workHours = Integer.parseInt(matcher.group(2));
                double dailyPayment = Double.parseDouble(matcher.group(3));
                if (!lista.containsKey(team)) {
                    lista.put(team, new TreeMap<>());
                    lista.get(team).put(name, new ArrayList<>());
                    // lista.get(team).get(name).put(workHours, new ArrayList<>());
                    lista.get(team).get(name).add((double) workHours);
                    lista.get(team).get(name).add((dailyPayment * workHours) / 24);

                    dopulnitelna.put(team, (((dailyPayment * workHours) / 24) * 30));
                } else if (!lista.get(team).containsKey(name)) {
                    lista.get(team).put(name, new ArrayList<>());
                    lista.get(team).get(name).add((double) workHours);
                    lista.get(team).get(name).add((dailyPayment * workHours) / 24);
                    // dopulnitelna.put(team,(((dailyPayment * workHours) / 24)*30));
                    // classUnits.put(clas, classUnits.get(clas) + 1);
                    double newOne = ((dailyPayment * workHours) / 24) * 30;
                    dopulnitelna.put(team, dopulnitelna.get(team) + newOne);
                }

            }


            text = scan.nextLine();
        }

//        lista.entrySet().stream()
//                .sorted((r1, r2) -> {

//                    dopulnitelna.entrySet().stream().sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
//                            .forEach(entrys -> {
//                                System.out.println("Team - " + entrys);
//                                r1.getValue().entrySet().stream()
//                                        .sorted((m1, m2) -> Integer.compare(m2.getValue().firstEntry().getKey(), m1.getValue().firstEntry().getKey()))
//                                        .forEach(k -> {
//                                            System.out.print("$$$" + k.getKey() + " - ");
//                                            k.getValue().entrySet().stream().forEach(i -> {
//                                                System.out.print(i.getKey() + " - ");
//                                                i.getValue().stream().forEach(g -> {
//                                                    System.out.print(g);
//
//                                                });
//                                            });
//
//                                        });
//                            });
//                });

//        lista.entrySet().stream()
//                .sorted((r1, r2) -> Double.compare(dopulnitelna.get(), dopulnitelna.get(dopulnitelna.get(r2)))).forEach(entry -> {
//            System.out.println("Team - " + entry.getKey());
//
//
//            entry.getValue().entrySet().stream().sorted((m1, m2) -> Integer.compare(m2.getValue().firstEntry().getKey(), m1.getValue().firstEntry().getKey()))
//                    .forEach(k -> {
//                        System.out.print("$$$" + k.getKey() + " - ");
//                        k.getValue().entrySet().stream().forEach(i -> {
//                            System.out.print(i.getKey() + " - ");
//                            i.getValue().stream().forEach(g -> {
//                                System.out.printf("%.6f",g);
//
//                            });
//                        });
//                        System.out.println();
//                    });
//            System.out.println();
//        });

        lista.entrySet().stream()
                .sorted((r1, r2) -> {
                    Collection<ArrayList<Double>> list1 = r1.getValue().values();
                    Collection<ArrayList<Double>> list2 = r2.getValue().values();
                    long one = 0L;
                    long two = 0L;
                    for (ArrayList<Double> doubles : list1) {
                        ArrayList<Double> new1 = doubles;
                        one += new1.get(1) * 30;
                    }
                    for (ArrayList<Double> doubles : list2) {
                        ArrayList<Double> new2 = doubles;
                        two += new2.get(1) * 30;
                    }

                    return Double.compare(two, one);

                }).forEach(entry -> {
            System.out.println("Team - " + entry.getKey());

            entry.getValue().entrySet().stream().sorted((m1, m2) -> {
                Double doubleNumber1 = m1.getValue().get(1);
                Double doubleNumber2 = m2.getValue().get(1);
                Double hours1 = m1.getValue().get(0);
                Double hours2 = m2.getValue().get(0);

                if (doubleNumber1 != doubleNumber2) {
                    return Double.compare(hours2, hours1);
                }

                return Double.compare(doubleNumber2, doubleNumber1);

            })
                    .forEach(k -> {
                        System.out.print("$$$" + k.getKey() + " - ");
                        ArrayList<Double> printNubers = k.getValue();
                        double hours = printNubers.get(0);
                        double neshtoSi = printNubers.get(1);
                        System.out.printf("%.0f", hours);
                        System.out.print(" - ");
                        System.out.printf("%.6f", neshtoSi);
                        System.out.println();
                    });
            // System.out.println();

        });
    }
}


