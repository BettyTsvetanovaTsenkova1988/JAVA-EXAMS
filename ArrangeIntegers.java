import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ArrangeIntegers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, String> lista = new TreeMap<String, String>();

        String[] text = scanner.nextLine().split(", ");

        for(String num : text){
            String numbersAsWord = "";

            for (int i = 0; i < num.length(); i++) {
                if(i != 0){
                    numbersAsWord += "-";
                }

                switch(num.charAt(i)){
                    case '0':
                        numbersAsWord += "zero";
                        break;
                    case '1':
                        numbersAsWord += "one";
                        break;
                    case '2':
                        numbersAsWord += "two";
                        break;
                    case '3':
                        numbersAsWord += "three";
                        break;
                    case '4':
                        numbersAsWord += "four";
                        break;
                    case '5':
                        numbersAsWord += "five";
                        break;
                    case '6':
                        numbersAsWord += "six";
                        break;
                    case '7':
                        numbersAsWord += "seven";
                        break;
                    case '8':
                        numbersAsWord += "eight";
                        break;
                    case '9':
                        numbersAsWord += "nine";
                        break;
                }
            }

            if(lista.containsKey(numbersAsWord)){
                String newValue = lista.get(numbersAsWord) + ", " + num;
                lista.replace(numbersAsWord, newValue);
            }
            else{
                lista.put(numbersAsWord, num);
            }
        }
        String output = String.join(", ", lista.values());

        System.out.println(output);
    }
}