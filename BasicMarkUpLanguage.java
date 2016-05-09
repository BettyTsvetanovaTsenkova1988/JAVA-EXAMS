import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicMarkUpLanguage {//   \s*<*\s*([a-z+]+)*\s*([a-z+]+)*\s*=*\s*"*\s*(\d+)*\s*"*\s*([a-z+]+)*\s*=*\s*"*\s*([a-zA-Z0-9*\s*a-zA-Z0-9*]*)*\s*"*\s*\/*>*\t*

    public static void main(String[] args) { //остава да се гледа за празни места между камите думи
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().trim();
        String command = "";
        int n = 0;
        String word = "";
        int counter = 0;
        String one = "\\<\\s*([\\w]+)\\s+content\\s*\\=\\s*\"(.+)\\s*\"\\s*\\/\\>";
        String two = "\\<\\s*([\\w]+)\\s+value\\s*\\=\\s*\"([0-9]+)\"\\s*content\\s*\\=\\s*\"(.+)\\s*\"\\s*\\/\\s*\\>";
        Pattern first = Pattern.compile(one);
        Pattern second = Pattern.compile(two);

        while (!text.equals("<stop/>")) {
            StringBuilder sbword = new StringBuilder();//polzvam SB z ada moga po lesno da obrushtam dumata
            StringBuilder sbChars = new StringBuilder();
            Matcher matcherOne = first.matcher(text);
            Matcher matcherTwo = second.matcher(text);

            if (matcherOne.find()) {
                command = matcherOne.group(1);
                word = matcherOne.group(2);//dumata za rabota
                sbword.append(word);

                if (command.equals("reverse")) {
                    counter++;
                    sbword.reverse();
                    System.out.print(counter + ". ");
                    System.out.println(sbword.toString());
                } else if (command.equals("inverse")) {//vzemam si dumata char po char i obrushtam na obratno
                    counter++;
                    System.out.print(counter + ". ");
                    for (int i = 0; i < word.length(); i++) {
                        if (Character.isLowerCase(sbword.charAt(i))) {
                            char c = word.charAt(i);
                            c = Character.toUpperCase(c);
                            sbChars.append(c);
                        } else {
                            char c = word.charAt(i);
                            c = Character.toLowerCase(c);
                            sbChars.append(c);
                        }
                    }
                    System.out.print(sbChars.toString());
                    System.out.println();
                }
            } else if (matcherTwo.find()) {
                command = matcherTwo.group(1);
                String number = matcherTwo.group(2);
                n = Integer.parseInt(number);
                word = matcherTwo.group(3);//dumata za rabota
                sbword.append(word);
                if (command.equals("repeat")) {
                    for (int i = 0; i < n; i++) {
                        counter++;
                        System.out.print(counter + ". ");
                        System.out.println(word);
                    }
                }
            }
            text = scanner.nextLine();
        }
    }
}
