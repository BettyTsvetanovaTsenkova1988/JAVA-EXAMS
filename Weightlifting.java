import java.util.*;

public class Weightlifting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        TreeMap<String, TreeMap<String, Long>> mapPeople = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] text = scan.nextLine().split(" ");
            String name = text[0];
            String program = text[1];
            Long kg = Long.parseLong(text[2]);

            if (!mapPeople.containsKey(name)) {
                mapPeople.put(name, new TreeMap<String, Long>());//ако човека го няма го добавя като ново име и му прави нова листа за програма и кг
                mapPeople.get(name).put(program, kg);// вземи името и към него сложи програмата и кг
            } else {
                if (!mapPeople.get(name).containsKey(program)) { //ако човека си е там, провери дали вече има вкарана програма
                    mapPeople.get(name).put(program, kg);
                } else { //ако човека вече си има вкарано име и програма, само сумирай килцата за всяка програма
                    Long previousKg = mapPeople.get(name).get(program); //така се достъпват килцата
                    mapPeople.get(name).put(program, previousKg + kg);//само се добавят килцата
                }
            }
        }
        Set<String> keyNames = mapPeople.keySet(); //прави сет от имената, за да може да се превъртят всичките при печатането

        for (String keyName : keyNames) {
            TreeMap<String, Long> program = mapPeople.get(keyName);
            System.out.print(keyName + " : ");


            Set<String> keyPrograms = program.keySet(); //прави сет от имената на програмите, за да ги извърти и отпечата
            boolean isThereMoreDataForSeparatingWhitComma = true;
            for (String keyProgram : keyPrograms) {
                if (isThereMoreDataForSeparatingWhitComma == false) {//ако има още елементи за печатане, за печата и , като разделител
                    System.out.print(", ");
                }
                isThereMoreDataForSeparatingWhitComma = false;
                System.out.printf(keyProgram + " - %d kg", program.get(keyProgram));
            }
            System.out.println();
        }
    }
}
