import java.util.ArrayList;
import java.util.Scanner;


public class Histogram {

    private static void bubbleSort(ArrayList<Integer> AL, char[] arr){
        int size = arr.length;

        for(int i = 0; i < size - 1; i++){
            for(int j = 0; j < size - i - 1; j++){
                if(AL.get(j) > AL.get(j+1)){
                    int temp = AL.get(j);
                    char arrTemp = arr[j];

                    AL.set(j, AL.get(j+1));
                    arr[j] = arr[j+1];

                    AL.set(j+1, temp);
                    arr[j+1] = arrTemp;
                }
            }
        }
    }

    private static void printVerticalDiagram(ArrayList<Integer> letterList, char[] letters){

        int max;

        bubbleSort(letterList, letters);
        max = letterList.get(letterList.size()-1);
        System.out.println("\n=================== Vertical Bar ======================");

        for(int i = max; i > 0; i--) {
            System.out.printf("|\t%d\t|", i);
            for (int j = 0; j < letters.length; j++) {
                if (letterList.get(j) >= i) {
                    System.out.print("\t*");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
        System.out.println("=======================================================");
        System.out.print("|\tNo\t|");
        for(char c : letters){
            System.out.printf("\t%c", c);
        }
        System.out.println("\n=======================================================");
    }

    private static void printOccur(ArrayList<Integer> letterList, char[] letters){
        System.out.println("\nChar Occurance");
        for(int i = 0; i < letterList.size(); i++) {

            if(letterList.get(i) != 0) {
                System.out.printf(" %c\t\t%d\n", letters[i], letterList.get(i));
            }
        }
    }

    public static void main (String[] args){

        ArrayList<Integer> letterList = new ArrayList<>();
        Scanner stdin = new Scanner(System.in);
        char character;
        int position;
        char[] letters = {'A','B','C','D','E','F','G','H','I','J','K'};

        for(int i = 0; i < letters.length; i++){
            letterList.add(0);
        }

        while (stdin.hasNext()){
            character = stdin.next().charAt(0);
            position = (character - 65);
            letterList.ensureCapacity(12);
            letterList.set(position, letterList.get(position) + 1);
        }

        printOccur(letterList, letters);
        printVerticalDiagram(letterList, letters);
    }
}
