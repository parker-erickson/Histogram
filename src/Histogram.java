/*
 * Class: CST 338 - Software Design
 *
 * Assignment: WK02HW02 -- Histogram.java
 *
 * Written by: Parker Erickson
 *
 * September 2019
 *
 * ABOUT: This is meant to take in a file within the directory that contains a single uppercase letter per line
 * and it takes that data, counts the instances of each letter and outputs a Histogram and data chart depicting
 * how many instances the letters appeared.
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Histogram {

    /* bubbleSort:
     *
     * general implementation of BubbleSort;
     *
     * Sorts the ArrayList of instances, and reflects the sort on the
     * array of letters to create the sorted Vertical Bar diagram .
     *
     */
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

    /* printVerticalDiagram:
     *
     * Meant to print the vertical bar diagram required for the output from an
     * ArrayList, and a character array.
     *
     */
    private static void printVerticalDiagram(ArrayList<Integer> letterList, char[] letters){

        int max;

        bubbleSort(letterList, letters);
        max = letterList.get(letterList.size()-1);
        System.out.println("\n================== Vertical Bar ==================");

        for(int i = max; i > 0; i--) {
            System.out.printf("|%3d |", i);
            for (int j = 0; j < letters.length; j++) {
                if (letterList.get(j) >= i) {
                    System.out.print("   *");
                } else {
                    System.out.print("    ");
                }
            }
            System.out.println();
        }
        System.out.println("==================================================");
        System.out.print("| No |");
        for(char c : letters){
            System.out.printf("   %c", c);
        }
        System.out.println("\n==================================================");
    }

    /* printOccur:
     *
     * meant to print out a chart with the amount of times each letter occurs.
     *
     */
    private static void printOccur(ArrayList<Integer> letterList, char[] letters){
        System.out.println("\nChar Occurrence");
        for(int i = 0; i < letterList.size(); i++) {

            if(letterList.get(i) != 0) {
                System.out.printf(" %c\t\t%d\n", letters[i], letterList.get(i));
            }
        }
    }

    //MAIN
    public static void main (String[] args){

        ArrayList<Integer> letterList = new ArrayList<>();
        char character;
        int position;
        char[] letters = {'A','B','C','D','E','F','G','H','I','J','K'};
        Scanner usr = new Scanner(System.in);
        String fileName;

        System.out.print("input filename: ");
        fileName = usr.nextLine().trim();
        File file = new File(fileName.trim());
        try {
            usr = new Scanner(file);
        }catch(FileNotFoundException e){
            System.out.print("File not found" + e);
        }
        for(int i = 0; i < letters.length; i++){
            letterList.add(0);
        }

        while (usr.hasNext()){
            character = usr.next().charAt(0);
            position = (character - 65);
            letterList.ensureCapacity(12);
            letterList.set(position, letterList.get(position) + 1);
        }

        printOccur(letterList, letters);
        printVerticalDiagram(letterList, letters);
    }
}
