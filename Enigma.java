import java.util.Scanner;

public class Enigma {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String text = input.replaceAll("[0-9\\s]+", "");//маха цифрите и интервалите, за да се изкара дължината
            int m = (text.length()) / 2;

            for (int j = 0; j < input.length(); j++) {//върти текста от входа и смята сума за букви и специални символи(интервалите и цифрите не се променят!!!)
                if (input.charAt(j) == ' ' || Character.isDigit(input.charAt(j))) {
                    System.out.print(input.charAt(j));
                    continue;
                }
                int sum = (int) input.charAt(j) + m;
                char c = (char) sum;
                System.out.print(c);
            }
            System.out.println();
        }
    }
}

