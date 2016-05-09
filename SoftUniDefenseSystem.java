import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniDefenseSystem {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int totalAlchohol = 0;
        while (!input.equals("OK KoftiShans")) {

            Pattern paternAlcoholName = Pattern.compile("([A-Z][a-z]+).*?([A-Z][a-z]*[A-Z]).*?(\\d+)L");
            Matcher matcher = paternAlcoholName.matcher(input);

            while (matcher.find()) {
                String name = matcher.group(1);
                String alchoholName = matcher.group(2).toLowerCase();
                int litters = Integer.parseInt(matcher.group(3));
                System.out.printf("%s brought %d liters of %s!", name, litters, alchoholName);
                System.out.println();
                totalAlchohol += litters;
            }
            input = scan.nextLine();
        }
        System.out.printf("%.3f softuni liters", totalAlchohol / 1000.0);
    }
}
