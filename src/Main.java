import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public void fun2(int n){

    }
    public static void main(String[] args){

        Advantage obj = new Advantage();

    }
}

class Advantage {
      Scanner sc = new Scanner(System.in);

      Advantage(){}

      int totalTestCase = 0;
      ArrayList<Integer> participantScore = new ArrayList<>();
      ArrayList<ArrayList<Integer>> participantTeam = new ArrayList<>();

      public void getAllParticipant(){
          totalTestCase = sc.nextInt();

          for(int i=0; i<totalTestCase; i++){
              participantScore.add(sc.nextInt());
              participantTeam.add(new ArrayList<>());
                  for(int j=0; j<participantScore.get(i); j++){
                       participantTeam.get(i).add(sc.nextInt());
                  }
          }
      }

      public void processAllScore(){
        ArrayList<Integer> tempScore = new ArrayList<>();

        for(int i=0; i<participantTeam.size(); i++){
            tempScore.addAll(participantTeam.get(i));
            int count = 0;
            int firstMax= Collections.max(tempScore);
            int firstMaxIndex = tempScore.indexOf(firstMax);
            int secondMax = 0;
                for(int j=0; j<tempScore.size(); j++){
                    if((firstMaxIndex !=j) && (tempScore.get(j) == firstMax)){
                        secondMax = tempScore.get(j);
                        count++;
                    }else if((tempScore.get(j) < firstMax) && (secondMax <= tempScore.get(j))){
                         secondMax = tempScore.get(j);
                         count++;
                     }
                }
            printAllScore(tempScore, firstMax, secondMax, count);
            tempScore.clear();
        }
      }

      public void printAllScore(ArrayList<Integer> tempScore, int firstMax, int secondMax, int count){
          ArrayList<Integer> getScore = tempScore;
          int firstScore = firstMax;
          int secondScore = secondMax;
          int counter = count;

          for(int i=0; i<getScore.size(); i++){
              if(counter == 0){
                  System.out.print(firstScore - tempScore.get(i) +" ");
              }
             else if(getScore.get(i) == firstScore) {
                  System.out.print(tempScore.get(i) - secondScore +" ");
              } else{
                  System.out.print(tempScore.get(i) - firstScore +" ");
              }
          }
          firstScore = 0;
          secondScore = 0;
          System.out.println();

      }


}
