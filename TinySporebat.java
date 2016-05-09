import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TinySporebat {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        int life = 5800;
        int glowcaps = 0;
        int totalGlowcaps = 0;


        while (!line.equals("Sporeggar")) {
            glowcaps = line.charAt(line.length() - 1) - '0';
            char[] enemies = line.substring(0, line.length() - 1).toCharArray();//реже входа от 0 до предпоследен символ/без цифрата
            for (char enemy : enemies) {
                if (enemy != 'L') {
                    life -= enemy;
                    if (life <= 0) { //ако свърши живота и преждевременно примре
                        System.out.printf("Died. Glowcaps: %d", totalGlowcaps);
                        return;
                    }
                } else {
                    life += 200;
                }
            }


            totalGlowcaps += glowcaps;

            line = scan.nextLine();
        }
        System.out.printf("Health left: %d", life);
        System.out.println();

        if (totalGlowcaps >= 30) {
            System.out.printf("Bought the sporebat. Glowcaps left: %d", Math.abs(totalGlowcaps - 30));
        } else {
            System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.", Math.abs(totalGlowcaps - 30));
        }
    }
}
