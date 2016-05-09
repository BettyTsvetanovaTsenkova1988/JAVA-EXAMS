import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PetyoPrimer {
    public static void main(String[] args) {

        TreeMap<String, TreeMap<String, ArrayList<Integer>>> classes = new TreeMap<>();

        TreeMap<String, Integer> alo = new TreeMap<>();
//one
        alo.put("Ivan", 6);
        alo.put("Iva", 2);
        alo.put("Gosho", 3);
        alo.put("Radka", 5);

        alo.entrySet().stream()//при потоците getKey означава да се вземе само ключа, а при маповете се взима всичко, което е вързано към ключа
                .sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
                .forEach(t1 -> {


                    System.out.printf(t1.getKey() + " : " + t1.getValue());
                    System.out.println();

                });
        System.out.println("***********");

        //two
        String nameEx = "Java Fun";
        String nameStud = "Goshoooo";

        classes.put(nameEx, new TreeMap<>());
        classes.get(nameEx).put(nameStud, new ArrayList<>());
        classes.get(nameEx).get(nameStud).add(6);
        classes.get(nameEx).get(nameStud).add(3);
        classes.get(nameEx).get(nameStud).add(4);
        classes.get(nameEx).get(nameStud).add(5);

        String nameEx2 = "CSharp Fun";
        String nameStud2 = "Petyuuuuur";

        classes.put(nameEx2, new TreeMap<>());
        classes.get(nameEx2).put(nameStud2, new ArrayList<>());
        classes.get(nameEx2).get(nameStud2).add(1);
        classes.get(nameEx2).get(nameStud2).add(2);
        classes.get(nameEx2).get(nameStud2).add(6);

        String nameEx3 = "Pytho Fun";
        String nameStud3 = "Ivan";

        classes.put(nameEx3, new TreeMap<>());
        classes.get(nameEx3).put(nameStud3, new ArrayList<>());
        classes.get(nameEx3).get(nameStud3).add(1);
        classes.get(nameEx3).get(nameStud3).add(2);
        classes.get(nameEx3).get(nameStud3).add(8);

        classes.entrySet().stream()
                .sorted((t1, t2) -> {
                    //sortirane po broi na ocenki sus stream api
                    int sumSize1 = t1.getValue().entrySet().stream().collect(Collectors.summingInt(value -> value.getValue().size()));
                    int sumSize2 = t2.getValue().values().stream().collect(Collectors.summingInt(value -> value.size()));

                    if (sumSize1 == sumSize2) {

                        //sortirae po duljina na imeto
//                        int len1=t1.getValue().entrySet().stream().collect(Collectors.summingInt(a->a.getKey().length()));
//                        int len2=t2.getValue().entrySet().stream().collect(Collectors.summingInt(a->a.getKey().length()));

                        //vtori na4in za sortirane po duljina na imeto
                        int len1 = 0;
                        for (String imena : t1.getValue().keySet()) {
                            len1 += imena.length();
                        }
                        int len2 = 0;
                        for (String imena : t2.getValue().keySet()) {
                            len2 = imena.length();
                        }
                        //return
                        return Integer.compare(len2, len1);

                    }
                    return Integer.compare(sumSize2, sumSize1);
                    //ili vtori na4in za sort po broi na ocenki
//                    int sumSize=0;
//                    for (ArrayList listoveOcenki : t1.getValue().values()) {
//                      sumSize+= listoveOcenki.size();
//                    }
//                    int sumSize2=0;
//                    for (ArrayList<Integer> listoveOcenki2 : t2.getValue().values()) {
//                        sumSize2+=listoveOcenki2.size();
//                    }
//                    return Integer.compare(sumSize,sumSize2);
//


                }).forEach(pair -> {
            System.out.println(pair.getKey());
            //minavme prez vsi4ki kolekcii ot ocenki i pootdelno gi sortirame
            for (ArrayList<Integer> ocenki : pair.getValue().values()) {
                Collections.sort(ocenki, Comparator.reverseOrder());
            }

            for (Map.Entry<String, ArrayList<Integer>> imenaListove : pair.getValue().entrySet()) {
                System.out.print(imenaListove.getKey() + " ima ");
//                int counter=1;
//                for (Integer ocenki : imenaListove.getValue()) {
//                    if(counter<imenaListove.getValue().size()){
//                        System.out.printf("%d, ",ocenki);
//                    }else {
//                        System.out.printf("%d",ocenki);
//                    }
//                    counter++;
//
//
//                }

//                System.out.println();
//                Iterator itr=imenaListove.getValue().iterator();
//                while (itr.hasNext()){
//                    if(itr.hasNext()){
//                        System.out.printf("%d, ",itr.next());
//                    }else {
//                        System.out.printf("%d ",itr.next());
//                    }
//
//
//                }

            }


        });


        //zadsha s premestvane na chisla v daden list na daden index
//        List<Integer> nums = new ArrayList<>();
//
////        List<Integer> razni=new ArrayList<>();
////        razni.add(6);
//        nums.addAll(Arrays.asList(1, 2, 3, 4, 5));
//        // nums.addAll(razni);
//        System.out.println(nums);
//
//        int index = 2;
//        List<Integer> numArray = new ArrayList<>();
//        for (int i = index + 1; i < nums.size(); i++) {
//            numArray.add(nums.get(i));
//
//        }
//
//        nums.removeAll(numArray);
//        nums.addAll(0,numArray);
//
//        //numArray.addAll(index,nums);
//        System.out.println(numArray);
//        System.out.println(nums);
    }
}
