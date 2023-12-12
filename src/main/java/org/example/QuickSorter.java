package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSorter implements Sorted {

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        quickSort(input, 0, input.size() - 1);
        return input;
    }

    private void quickSort(ArrayList<Integer> array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(ArrayList<Integer> array, int low, int high) {
        int pivot = array.get(high);
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (array.get(j) < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return (i + 1);
    }

    private void swap(ArrayList<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}