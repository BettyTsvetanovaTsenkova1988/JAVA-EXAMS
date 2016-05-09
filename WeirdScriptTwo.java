import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeirdScriptTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        n = n - 1;
        int codeOfChar = n % 26;
        char letter = (n / 26) % 2 == 0 ? (char) ('a' + codeOfChar) : Character.toUpperCase((char) ('a' + codeOfChar));
        String key = "" + letter + letter;
        StringBuilder sb = new StringBuilder();

        while (!input.equals("End")) {
            sb.append(input);
            input = scan.nextLine();
        }

        String rezult = sb.toString();//лепи се със билдъра, защото трябва да се търси текст муежду ключа, даже и ако ключа започва на един ред и свършва на друг!!! Може да не е само на един ред
        String pattern = key + "(.*?)" + key;//хваща всичко между двата ключа
        Pattern pat = Pattern.compile(pattern);
        Matcher match = pat.matcher(rezult);//проверява дали патърна го има в редадовете

        while (match.find()) {
            System.out.println(match.group(1));
        }
    }
}