import java.util.Scanner;

public class CollectResourcesBetty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] text = scan.nextLine().split(" ");
        int textLenght = text.length;
        int n = Integer.parseInt(scan.nextLine());
        int maxQuantity = 0;

        for (int i = 0; i < n; i++) {
            int total = 0;
            int start = scan.nextInt();
            int step = scan.nextInt();
            String[] text2 = text.clone();//klonira se vhoda zashtoto inache dobaveniq ! se natrupva sled vseki red a trqbva da se chistqt vsichki ! za da e veren rezulatata
            for (int j = start; true; j = (j + step) % text.length) { //zapochva da obikalq ot starta i vurti do kraq na teksta, a ako izleze izvun nego zapochva pak otnachalo
                //obikalq ot dadenoto po uslovie nachalo do bezkrai prez dadenata po uslovie stupka
                String[] items = text2[j].split("_");
                if (text2[j].contains("!")) {//ako resursa veche e subran izliza ot cikula i pravi proverka za sledvashtite start i stupka zada nameri koe e po-golqmo
                    break;
                }
                if (items[0].equals("stone") || items[0].equals("gold") || items[0].equals("wood") || items[0].equals("food")) {
                    if (items.length == 1) {
                        total += 1;
                        text2[j] = text2[j] + "!";//ako mine prez item-a mu dobavq ! za da se znae che veche e minato ot tam
                    } else {
                        total += Integer.parseInt(items[1]);
                        text2[j] = text2[j] + "!";//ako mine prez item-a mu dobavq ! za da se znae che veche e minato ot tam
                    }
                }
            }
            if (total > maxQuantity) {
                maxQuantity = total;
            }
        }
        System.out.println(maxQuantity);
    }
}
