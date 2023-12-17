package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public enum SortingType{
        BUBBLE,
        SHELL,
        MERGE,
        QUICK
    }
    public static void fill(ArrayList<Integer> list, int size) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(size));
        }
    }

    public static void sortingTime(ArrayList<Integer> input, SortingType type, long startTime, long currentTime){
        System.out.printf("%s spent %d milliseconds\n",type.toString().toLowerCase() , currentTime - startTime);
    }

    public static Sorted createSorter(SortingType type){
        Sorted sorter = null;
        switch (type) {
            case BUBBLE:
                sorter = new BubbleSorter();
                break;
            case SHELL:
                sorter = new ShellSorter();
                break;
            case MERGE:
                sorter = new MergeSorter();
                break;
            case QUICK:
                sorter = new QuickSorter();
                break;
        }
        return sorter;
    }


    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int[] counts = {10, 1_000, 10_000, 1_000_000};
        for (int count : counts) {
            System.out.println("\nSorting list with " + count + " elements");
            fill(arrayList, count);
            for (SortingType type: SortingType.values()) {
                long time = System.currentTimeMillis();
                ArrayList<Integer> outputList;
                Sorted sorted = createSorter(type);
                outputList = sorted.sort(new ArrayList<>(arrayList));
                for (int i = 0; i < 50 && i < outputList.size(); i++) {
                    System.out.print(outputList.get(i) + ",");
                }
                sortingTime(outputList, type, time, System.currentTimeMillis());
            }
        }
    }
}