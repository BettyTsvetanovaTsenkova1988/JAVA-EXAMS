import java.math.BigInteger;
import java.util.Scanner;

public class SoftuniNumerals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        StringBuilder numbers = new StringBuilder();
        StringBuilder txt = new StringBuilder(text);
        while (txt.length() != 0) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb1.append(txt.charAt(0));
            sb1.append(txt.charAt(1));
            if (txt.length() >= 3) {
                sb2.append(txt.charAt(0));
                sb2.append(txt.charAt(1));
                sb2.append(txt.charAt(2));
            }
            String first = sb1.toString();
            String second = sb2.toString();

            if (first.equals("aa")) {
                numbers.append("0");
                if (txt.length() >= 2) {
                    txt.delete(0, 2);
                } else {
                    break;
                }
            } else if (first.equals("cc")) {
                numbers.append("3");
                if (txt.length() >= 2) {
                    txt.delete(0, 2);
                } else {
                    break;
                }
            }
            if (second.equals("aba")) {
                numbers.append("1");
                if (txt.length() >= 3) {
                    txt.delete(0, 3);
                } else {
                    break;
                }
            } else if (second.equals("bcc")) {
                numbers.append("2");
                if (txt.length() >= 3) {
                    txt.delete(0, 3);
                } else {
                    break;
                }
            } else if (second.equals("cdc")) {
                numbers.append("4");
                if (txt.length() >= 3) {
                    txt.delete(0, 3);
                } else {
                    break;
                }
            }
        }
        BigInteger num = new BigInteger(numbers.toString(), 5);
        System.out.println(num);
    }
}
