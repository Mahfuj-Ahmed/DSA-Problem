import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        IcpcBallon obj1 = new IcpcBallon();
        obj1.getInput();
        obj1.getNumber();
    }
}

class IcpcBallon{

    Scanner sc= new Scanner(System.in);
    ArrayList<Integer> strLen = new ArrayList<>(100);
    ArrayList<String> solvedProblem = new ArrayList<>(100);
    int testCase;

    IcpcBallon(){}


    public void getInput(){
        testCase= sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            strLen.add(sc.nextInt());
            sc.nextLine();
            solvedProblem.add(sc.nextLine());

        }
    }

    public void getNumber(){
        int count = 0;
        for (int i = 0; i < testCase; i++) {

            int tempLength = strLen.get(i);
            String tempString = solvedProblem.get(i);
            String stringConcate="";

            char ch;
            for (int j = 0; j < tempLength; j++) {
                int stringCount = 0;
                for(int l = 0; l < stringConcate.length(); l++){
                    if(stringConcate.charAt(l) == tempString.charAt(j)){
                        stringCount++;
                    }
                }
                if(stringCount != 0)
                    continue;
                else {
                    int tempCount = 0;
                    ch = tempString.charAt(j);
                    for (int k = 0; k < tempString.length(); k++) {
                        if (tempString.charAt(k) == ch) {
                            tempCount++;
                            stringConcate = stringConcate + ch ;
                        }
                    }
                    if (tempCount == 1) {
                        count = count + 2;
                    } else if (tempCount > 1) {
                        count = count + (tempCount + 1);
                    }
                }
            }
            System.out.println(count);
            count = 0;
        }

    }
}