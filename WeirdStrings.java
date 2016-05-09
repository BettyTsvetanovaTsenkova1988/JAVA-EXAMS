import java.util.Scanner;

public class WeirdStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        text = text.replaceAll("[\\/\\|\\(\\)\\s]+", "");
        String[] rezult = text.split("[^a-zA-Z]+");
        String[] print = new String[2];//po uslovie se iska po dvoiki

        int maxTotal = 0;

        for (int i = 0; i < rezult.length - 1; i ++) {//ne e prez dve zashtoto po uslovie vsqka duma se stikova susu sledvashtata
            int total = 0;
            String together = (rezult[i] + rezult[i + 1]).toLowerCase();
            for (int j = 0; j < together.length(); j++) {//vzema obshtata duljina na dva elementa

                total += together.charAt(j) - ('a' - 1);//ako se sloji + dava 90/100
            }
            if (total > maxTotal) {
                maxTotal = total;
                print[0]=rezult[i];
                print[1]=rezult[i+1];

            }
        }
        for (String s : print) {
            System.out.println(s);
        }

    }
}

