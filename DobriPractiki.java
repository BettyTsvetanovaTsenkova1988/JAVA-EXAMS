import java.util.Scanner;

public class DobriPractiki {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text= scanner.nextLine().trim().split("");

        for (int i = 0; i <text.length; i++) {
            System.out.println(text[i]);
        }
    }
}
