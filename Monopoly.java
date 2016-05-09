import java.util.Scanner;

public class Monopoly { //pri obrushtaneto na redovete na nechetna poziciq se razmestvat indecsite i ot tam 70/100!!!
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numbers = scan.nextLine().split(" ");
        int n = Integer.parseInt(numbers[0]);
        int money = 50;
        int countSteps = 0;
        int hotels = 0;
        int moneySpend = 0;


        for (int i = 0; i < n; i++) {
            String text = scan.nextLine();
            if (i % 2 != 0) {
                String sb = new StringBuilder(text).reverse().toString();
                text = sb;
            }
            for (int j = 0; j < text.length(); j++) {

                switch (text.charAt(j)) {
                    case 'J':
                        System.out.printf("Gone to jail at turn %d.", countSteps);
                        System.out.println();
                        //purvo kazva kolko sa stupkite do momenta i sled tova slaga i novite
                        countSteps += 2;//dva puti stoi na mqsro i uvelichava broqcha
                        money += (hotels * 10) * 2;
                        break;
                    case 'H':
                        hotels++;
                        System.out.printf("Bought a hotel for %d. Total hotels: %d.", money, hotels);
                        System.out.println();
                        money = 0;
                        break;
                    case 'S':
                        moneySpend = (i + 1) * (j + 1);
                        if (money >= moneySpend) {
                            money -= moneySpend;
                            System.out.printf("Spent %d money at the shop.", moneySpend);
                            System.out.println();
                        } else {
                            System.out.printf("Spent %d at the shop.", money);
                            System.out.println();
                            money = 0;
                        }
                        break;
                }
                countSteps++;
                money += hotels * 10;
            }
        }
        System.out.printf("Turns %d", countSteps);
        System.out.println();
        System.out.printf("Money %d", money);
    }
}