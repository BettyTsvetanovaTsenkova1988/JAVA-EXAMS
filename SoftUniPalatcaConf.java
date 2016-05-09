import java.util.Scanner;


public class SoftUniPalatcaConf {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numberOfPeople = scan.nextInt();
        int n = scan.nextInt();
        int beds = 0;
        int food = 0;


        for (int i = 0; i <= n; i++) {
            String[] instruction = scan.nextLine().split(" ");
            if (instruction[0].equals("tents")) {
                switch (instruction[2]) {
                    case "normal":
                        beds += (Integer.parseInt(instruction[1]) * 2);
                        break;
                    case "firstClass":
                        beds += (Integer.parseInt(instruction[1]) * 3);
                        break;
                }
            } else if (instruction[0].equals("rooms")) {
                switch (instruction[2]) {
                    case "single":
                        beds += (Integer.parseInt(instruction[1]) * 1);
                        break;
                    case "double":
                        beds += (Integer.parseInt(instruction[1]) * 2);
                        break;
                    case "triple":
                        beds += (Integer.parseInt(instruction[1]) * 3);
                        break;
                }
            } else if (instruction[0].equals("food")) {
                switch (instruction[2]) {
                    case "musaka":
                        food += (Integer.parseInt(instruction[1]) * 2);
                        break;
                    case "zakuska":
                        food += (Integer.parseInt(instruction[1])*0);
                        break;
                }
            }
           // scan.nextLine();
        }
        if (beds >= numberOfPeople) {
            System.out.printf("Everyone is happy and sleeping well. Beds left: %d\n", (beds - numberOfPeople));
        } else if ((beds < numberOfPeople)) {
            System.out.printf("Some people are freezing cold. Beds needed: %d\n", Math.abs(beds - numberOfPeople));
        }
        if (food >= numberOfPeople) {
            System.out.printf("Nobody left hungry. Meals left: %d\n", Math.abs(food - numberOfPeople));
        } else if (food < numberOfPeople) {
            System.out.printf("People are starving. Meals needed: %d\n", Math.abs(food - numberOfPeople));
        }
    }
}
