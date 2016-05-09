import java.util.Scanner;

public class MirrorNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] text = scan.nextLine().trim().split(" ");
        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {

                String element = (text[i]);
                String sb = new StringBuilder(text[j]).reverse().toString();
                int nextElement = Integer.parseInt(sb);

                if (element.equals(sb)) {
                    System.out.printf("%s<!>%s", element, text[j]);
                    System.out.println();
                    counter++;
                    break;
                }
            }


        }
        if (counter == 0) {
            System.out.println("No");
        }

    }
}
