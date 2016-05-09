import java.util.Scanner;

public class RoyalFlush {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String text = "";
//        char[] correct = new char[5];
//        correct[0] = 10;
//        correct[1] = 'J';
//        correct[2] = "Q";
//        correct[3] = "K";
//        correct[4] = "A";
        String newString = "";
        int counter = 1;
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            text += input;
        }
        // for (int i = 0; i < text.length() - 2; i++) {
        int index = text.indexOf("10");
        text = text.substring(index, text.length());
        for (int j = 0; j < text.length(); j++) {
            // text = text.substring(index, text.length());
            // newString = text.substring(index,text.length());
            //   char face = newString.charAt(3);
            // String face2 = Character.toString(face);
            char boq = text.charAt(2);
            String boq2 = Character.toString(boq);
            if (text.charAt(3) == 'J' && text.charAt(5) == 'Q' && text.charAt(7) == 'K' && text.charAt(9) == 'A'
                    && boq == text.charAt(4) && boq == text.charAt(6) && boq == text.charAt(8) && boq == text.charAt(10)) {//vsichkite sa pod red bez problemi

                switch (boq) {
                    case 'c':
                        System.out.println("Royal Flush Found - Clubs");
                        break;
                    case 's':
                        System.out.println("Royal Flush Found - Spades");  // newString.substring(2,newString.length());
                        break;
                    case 'd':
                        System.out.println("Royal Flush Found - Diamonds");
                        break;
                    case 'h':
                        System.out.println("Royal Flush Found - Hearts");
                        break;
                }
            }

            text = text.substring(1, text.length());
            if (text.contains("10")) {
                counter++;
                text = text.substring(text.indexOf("10"), text.length());
            }


        }
        System.out.printf("Royal's Royal Flushes - %d.", counter);

    }


}

