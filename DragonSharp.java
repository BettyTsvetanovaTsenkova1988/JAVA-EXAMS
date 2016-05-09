import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DragonSharp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String text = "";
        String instruction = "";
        boolean check = false;

        for (int i = 0; i < n; i++) {
            text = scan.nextLine();

            Pattern pat = Pattern.compile("(\\\")(\\w+?\\W+?\\w+?.+)(\\\")");//вади текста за печатане
            Matcher mac = pat.matcher(text);

            Pattern p = Pattern.compile("(\\ )([0-9])(\\ )");//вади числото за печатане на текста от първи ред на входа
            Matcher m = p.matcher(text);

            Pattern pattern = Pattern.compile("(\\()(\\d+)+([^0-9]+)+([0-9]+)()");//вади цифрите за сравнение
            Matcher matcher = pattern.matcher(text);


            while (matcher.find()) {
                instruction = (matcher.group(3));

                int one = Integer.parseInt(matcher.group(2));
                int two = Integer.parseInt(matcher.group(4));

                if (instruction.equals(">")) {
                    if (one > two) {
                        check = true;
                        while (mac.find()) {
                            System.out.println(mac.group(2));
                        }
                    } else continue;

                } else if (instruction.equals("<")) {
                    if (one < two) {
                        check = true;
                        while (mac.find()) {
                            System.out.println(mac.group(2));
                        }
                    } else continue;

                } else if (instruction.equals("==")) {
                    if (one == two) {
                        check = true;
                        while (mac.find()) {
                            while (m.find()) {
                                int num = Integer.parseInt(m.group(2));
                                for (int j = 0; j < num; j++) {
                                    System.out.println(mac.group(2));
                                }
                            }

                        }
                    } else continue;
                } else {
                    if (check == false) {
                        System.out.printf("Compile time error @ line %d",i);;
                    }else{
                        while (mac.find()) {
                            while (m.find()) {
                                int num = Integer.parseInt(m.group(2));
                                for (int j = 0; j < num; j++) {
                                    System.out.println(mac.group(2));
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}

