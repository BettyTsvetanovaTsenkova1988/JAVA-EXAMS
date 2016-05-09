import java.math.BigInteger;
import java.util.*;

public class Critical {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        LinkedHashMap<String, ArrayList<BigInteger>> lista = new LinkedHashMap<>();
        ArrayList<BigInteger> num = new ArrayList<>();
        String counter = "0";
        BigInteger rows = BigInteger.valueOf(0);
        int ROWS = 0;
        while (!input.equals("Break it.")) {
            String[] numbers = input.split(" ");

            BigInteger one = BigInteger.valueOf(Integer.parseInt(numbers[0]));
            BigInteger two = BigInteger.valueOf(Integer.parseInt(numbers[1]));
            BigInteger three = BigInteger.valueOf(Integer.parseInt(numbers[2]));
            BigInteger four = BigInteger.valueOf(Integer.parseInt(numbers[3]));

            lista.put(counter, new ArrayList<>());
            lista.get(counter).add(one);
            lista.get(counter).add(two);
            lista.get(counter).add(three);
            lista.get(counter).add(four);

            BigInteger criticRatio = ((four.add(three)).subtract(two.add(one))).abs();
            num.add(criticRatio);

            counter = (counter) + (1);
            rows = rows.add(BigInteger.ONE);
            ROWS++;
            input = scan.nextLine();
        }
        Collections.sort(num);
        boolean isEqual = false;

        BigInteger total = BigInteger.valueOf(0);

        for (int i = 0; i < num.size(); i++) {

            total = total.add(num.get(i));
        }
        BigInteger sized = new BigInteger(Integer.toString(num.size()));//obrushta razmera na arreya v bigint
        BigInteger average = total.divide(sized);//smqta srednata stoinost


        if (num.contains(BigInteger.ZERO)) {//ako ima nuli
            if (total == BigInteger.ZERO) {//ako ima samo nuli
                for (String s : lista.keySet()) {
                    int countPossition = 1;
                    System.out.print("Line: [");
                    ArrayList<BigInteger> spisuk = lista.get(s);
                    for (BigInteger integer : spisuk) {
                        if (countPossition == 4) {
                            System.out.print(integer + "]");
                        } else {
                            System.out.print(integer + ", ");
                        }
                        countPossition++;
                    }
                    System.out.println();
                }
                System.out.printf("Critical Breakpoint: 0");
                System.out.println();
            } else {

                while (num.get(0) == BigInteger.ZERO) {
                    num.remove(0);
                }

                for (int i = 0; i < num.size(); i++) {
                    for (int j = 1; j < num.size(); j++) {

                        if (num.get(i).compareTo(num.get(j)) != 0) {////ako ostanalite chisla bez nulite sa razlichni
                            isEqual = false;
                            System.out.println("Critical breakpoint does not exist.");
                            break;

                        } else {
                            isEqual = true;
                        }
                    }
                }
                if (isEqual = true) {//ima nuli i ednakvi dr chisla
                    BigInteger br = (num.get(0).pow(ROWS)).mod(rows); //smqta kritichnata tocka na purviq element/dr sa sushtite chisla kato purvoto
                    for (String s : lista.keySet()) {
                        int countPossition = 1;
                        System.out.print("Line: [");
                        ArrayList<BigInteger> spisuk = lista.get(s);
                        for (BigInteger integer : spisuk) {
                            if (countPossition == 4) {
                                System.out.print(integer + "]");
                            } else {
                                System.out.print(integer + ", ");
                            }
                            countPossition++;
                        }
                        System.out.println();
                    }
                    System.out.printf("Critical Breakpoint: %d", br);
                    System.out.println();
                }
            }

        } else {//kogato ima samo razl ot nula chisla
            for (int i = 0; i < num.size() - 1; i++) {
                for (int j = 1; j < num.size(); j++) {
                    if (num.get(i).compareTo(num.get(j)) != 0) {////ako sa razlichni
                        isEqual = false;
                        System.out.println("Critical breakpoint does not exist.");
                        return;
                    } else {
                        isEqual = true;
                    }
                }
            }
            if (isEqual = true) {
                BigInteger br = (num.get(0).pow(ROWS)).mod(rows); //smqta kritichnata tocka na purviq element/dr sa sushtite chisla kato purvoto
                for (String s : lista.keySet()) {
                    int countPossition = 1;
                    System.out.print("Line: [");
                    ArrayList<BigInteger> spisuk = lista.get(s);
                    for (BigInteger integer : spisuk) {
                        if (countPossition == 4) {
                            System.out.print(integer + "]");
                        } else {
                            System.out.print(integer + ", ");
                        }
                        countPossition++;
                    }
                    System.out.println();
                }
                System.out.printf("Critical Breakpoint: %d", br);
                System.out.println();
            }

        }

    }
}



