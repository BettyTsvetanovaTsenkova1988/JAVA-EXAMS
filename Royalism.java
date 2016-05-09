import java.util.ArrayList;
import java.util.Scanner;

public class Royalism {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] text = scan.nextLine().split(" ");
        ArrayList<String> royal = new ArrayList<>();
        ArrayList<String> nonRoyal = new ArrayList<>();

        String royalist = "";
        String nonRoyalist = "";
        String word = "";
        int counterR = 0;
        int counterNonR = 0;

        for (int i = 0; i < text.length; i++) {
            int total = 0;
            word = text[i];

            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                int ascii = (int) c;


                total += ascii;
                if (total>26){
                    while (total > 26) {
                        total = total - 26;
                    }
                }

            }
            if (total == 18) {
                counterR++;
                royal.add(word);
            } else {
                counterNonR++;
                nonRoyal.add(word);
            }

        }

        if (counterR >= counterNonR) {
            System.out.printf("Royalists - %d", counterR);
            System.out.println();
            for (String s : royal) {
                System.out.println(s);
            }
            System.out.println("All hail Royal!");
        } else {
            for (String s : nonRoyal) {
                System.out.println(s);
            }
            System.out.println("Royalism, Declined!");
        }


    }
}
