import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShmoogleCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayList<String> doubleList = new ArrayList<String>();
        ArrayList<String> intList = new ArrayList<String>();


        while (!input.equals("//END_OF_CODE")) {
            Pattern pattern = Pattern.compile("(double|int)\\s([a-z][a-zA-Z]*)");
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String words = matcher.group(2);
                if (matcher.group(1).equals("double")) {
                    doubleList.add(matcher.group(2));
                } else if (matcher.group(1).equals("int")) {
                    intList.add(matcher.group(2));
                }
            }


            input = scan.nextLine();
        }
        Collections.sort(doubleList);
        Collections.sort(intList);

        System.out.printf("Doubles: %s\n", doubleList.size() > 0 ? String.join(", ", doubleList) : "None");

        System.out.printf("Ints: %s\n", intList.size() > 0 ? String.join(", ", intList) : "None");
    }

}


