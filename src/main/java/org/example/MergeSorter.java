package org.example;
import java.util.ArrayList;

public class MergeSorter implements Sorted {

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        if (input.size() <= 1) {
            return input;
        }

        int middle = input.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(input.subList(0, middle));
        ArrayList<Integer> right = new ArrayList<>(input.subList(middle, input.size()));
        ArrayList<Integer> result = merge(sort(left), sort(right));


        return result;
    }

    private ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        while (i < left.size()) {
            result.add(left.get(i++));
        }

        while (j < right.size()) {
            result.add(right.get(j++));
        }

        return result;
    }
}