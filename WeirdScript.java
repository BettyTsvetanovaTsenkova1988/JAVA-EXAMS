import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeirdScript {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int keyNumber = Integer.parseInt(scan.nextLine());
        keyNumber = keyNumber - 1;
        int charCode = keyNumber % 26;

        char keyLetter = (keyNumber / 26) % 2 == 0 ? (char) ('a' + charCode) : Character.toUpperCase((char) ('a' + charCode));

        String key = "" + keyLetter + keyLetter;
        StringBuilder sb = new StringBuilder();

        String line = scan.nextLine();
        while (!line.equals("End")) {
            sb.append(line);
            line = scan.nextLine();
        }

        String message = sb.toString();
        String pattern = key + "(.*?)" + key;
        Pattern pat = Pattern.compile(pattern);
        Matcher match = pat.matcher(message);

        while (match.find()) {
            if (match.group(1).length() > 0) {
                System.out.println(match.group(1));
            }
        }
    }
}