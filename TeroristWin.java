import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TeroristWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Pattern pattern = Pattern.compile("(\\|(.*?)\\|)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String bomb = matcher.group(2);
            int sum = 0;
            for (int i = 0; i < bomb.length(); i++) {

                sum += (int) bomb.charAt(i);
            }
            String number = Integer.toString(sum);
            number = number.substring(number.length() - 1, number.length());
            int n = Integer.parseInt(number);
            int start = text.indexOf(bomb) - 1;
            int end = start + bomb.length() + 1;
            String replace = text.substring(start - n, end + n + 1);

            StringBuilder sb = new StringBuilder();
            for (int i = start - n; i < end + n+1; i++) {

                sb.append(".");
            }
            String dots = sb.toString();
            text = text.replace(replace, sb.toString());


        }
        System.out.println(text);
    }
}
