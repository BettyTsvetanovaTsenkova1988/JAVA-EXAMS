import java.util.Arrays;
import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] text = scan.nextLine().split("\\s+");

        double sum = 0.00;
        double number = 0.00;

        for (String s : text) {
            char c = (s.charAt(0));
            number = Integer.parseInt(s.substring(1, s.length() - 1));

            if (Character.isUpperCase((s.charAt(0)))) { //гледа дали първата буква  е главна
                sum += (number / Possition(c));
            } else if (Character.isLowerCase((s.charAt(0)))) {
                sum += (number * Possition(c));
            }

            if (Character.isUpperCase((s.charAt(s.length() - 1)))) { //дали последната буква е главна
                sum -= Possition((s.charAt(s.length() - 1)));
            } else if (Character.isLowerCase((s.charAt(s.length() - 1))) &&
                    !Character.isDigit(s.charAt(s.length() - 1))) {//дали последната буква е малка
                sum += Possition((s.charAt(s.length() - 1)));
            }
        }
        System.out.printf("%.2f",sum);

    }

    public static int Possition(char c) {
        if (Character.isUpperCase(c)) {
            return ((int) c - (int) 'A') + 1;
        } else {
            return ((int) c - (int) 'a') + 1;
        }
    }
}


