
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class LegoBlocks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        ArrayList<ArrayList<Integer>> list1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> list2 = new ArrayList<ArrayList<Integer>>();
        int counter = 0;
        String str = "";

        for (int i = 0; i < n; i++) {
            list1.add(new ArrayList<Integer>());//dobavq nova lista
            String[] text = scan.nextLine().trim().split("\\s+");

            for (String s : text) {
                list1.get(i).add(Integer.parseInt(s));//parsva chisloto i go add-va kum listata
            }
            counter += list1.get(i).size();
        }

        for (int i = 0; i < n; i++) {
            list2.add(new ArrayList<Integer>());//dobavq nova lista
            String[] text = scan.nextLine().trim().split("\\s+");
            for (String ss : text) {
                list2.get(i).add(Integer.parseInt(ss));//parsva chisloto i go add-va kum listata
            }
            counter += list2.get(i).size();
            Collections.reverse(list2.get(i));
        }


        if (list1.get(0).size() + list2.get(0).size() != list1.get(1).size() + list2.get(1).size()) {
            System.out.println("The total number of cells is: " + counter);
        } else {
            int iterate = list1.get(0).size() + list2.get(0).size();


            for (int i = 0; i < n; i++) {
                str = "";
                System.out.print("[");
                list1.get(i).addAll(list2.get(i));
                str = list1.get(i).toString().replaceAll("^\\D+", "");
                System.out.println(str);
            }
        }
    }
}


