import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        StringBuilder sb = new StringBuilder();
        String ip = "";
        String ipFinal = "";
        String message = "";
        String messageFinal = "";
        String user = "";
        String userFinal = "";
        // Integer counter = new Integer(1);
        int sz = 0;
        TreeMap<String, LinkedHashMap<String, ArrayList<String>>> logList = new TreeMap<String, LinkedHashMap<String, ArrayList<String>>>();
        while (!input.equals("end")) {

            String[] text = input.split(" ");
            ip = text[0];
            message = text[1];
            user = text[2];
            ipFinal = ip.substring(3, ip.length());
            messageFinal = message.substring(9, message.length() - 2);
            userFinal = user.substring(5, user.length());


            if (messageFinal.equals("") || messageFinal.equals(null)) {
                messageFinal = "something";
            }
            if (!logList.containsKey(userFinal)) { //ako usera go nqma
                logList.put(userFinal, new LinkedHashMap<>());
                logList.get(userFinal).put(ipFinal, new ArrayList<>());//purviq put broqcha go slagam s 1-ca
                logList.get(userFinal).get(ipFinal).add(messageFinal);
                sz++;
            } else if (!logList.get(userFinal).containsKey(ipFinal)) { //ako ima user no ima novo ip
                logList.get(userFinal).put(ipFinal, new ArrayList<>());//purviq put broqcha go slagam s 1-ca
                logList.get(userFinal).get(ipFinal).add(messageFinal);
                sz++;
            } else {
                logList.get(userFinal).get(ipFinal).add(messageFinal);

                ; //ako veche ima vsichko
            }


            input = scan.nextLine();
        }
        // System.out.println(sz);

        for (String userPrint : logList.keySet()) {
            int countPossition = 1;
            System.out.println(userPrint + ": ");
            for (String ipPrint : logList.get(userPrint).keySet()) {
                ArrayList<String> counterList = logList.get(userPrint).get(ipPrint);
                int count = counterList.size();
                int distance = logList.get(userPrint).size();

                if (countPossition == distance) {//така не работи правилно!!!
                    System.out.print(ipPrint + " => " + count + ". ");
                } else {
//                    if (countPossition==logList.get(userPrint).get(ipPrint).size()) {
//                        System.out.print(ipPrint + " => " + count + ".");
//                    }
                    System.out.print(ipPrint + " => " + count + ", ");
                }

                countPossition++;
            }
            System.out.println();

        }
    }

}

