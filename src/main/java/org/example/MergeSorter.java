package org.example;

import java.util.ArrayList;

public class MergeSorter implements Sorted {

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> inputList) {
        if (inputList.size() <= 1) {
            return inputList;
        }

        int middleIndex = inputList.size() / 2;
        ArrayList<Integer> leftList = new ArrayList<>(inputList.subList(0, middleIndex));
        ArrayList<Integer> rightList = new ArrayList<>(inputList.subList(middleIndex, inputList.size()));
        return merge(sort(leftList), sort(rightList));
    }

    private ArrayList<Integer> merge(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < leftList.size() && rightIndex < rightList.size()) {
            if (leftList.get(leftIndex) <= rightList.get(rightIndex)) {
                mergedList.add(leftList.get(leftIndex++));
            } else {
                mergedList.add(rightList.get(rightIndex++));
            }
        }

        while (leftIndex < leftList.size()) {
            mergedList.add(leftList.get(leftIndex++));
        }

        while (rightIndex < rightList.size()) {
            mergedList.add(rightList.get(rightIndex++));
        }
//
        return mergedList;
    }
}