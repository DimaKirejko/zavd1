package less1;

import java.util.*;

public class Main {

    private static final int LIST_SIZE = 100_000;
    private static final int INSERT_COUNT = 1_000;

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        fillList(arrayList, LIST_SIZE, "ArrayList");
        fillList(linkedList, LIST_SIZE, "LinkedList");

        testRandomAccess(arrayList, "ArrayList");
        testRandomAccess(linkedList, "LinkedList");

        testSequentialAccess(arrayList, "ArrayList");
        testSequentialAccess(linkedList, "LinkedList");

        testInsertAtStart(arrayList, INSERT_COUNT, "ArrayList");
        testInsertAtStart(linkedList, INSERT_COUNT, "LinkedList");

        testInsertAtEnd(arrayList, INSERT_COUNT, "ArrayList");
        testInsertAtEnd(linkedList, INSERT_COUNT, "LinkedList");

        testInsertAtMiddle(arrayList, INSERT_COUNT, "ArrayList");
        testInsertAtMiddle(linkedList, INSERT_COUNT, "LinkedList");
    }

    private static void fillList(List<Integer> list, int count, String listType) {
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(count));
        }
        printExecutionTime("Fill " + listType, startTime);
    }

    private static void testRandomAccess(List<Integer> list, String listType) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
        }
        printExecutionTime("Random access in " + listType, startTime);
    }

    private static void testSequentialAccess(List<Integer> list, String listType) {
        long startTime = System.currentTimeMillis();
        for (Integer ignored : list) {
            // Performing some operation to prevent optimization
        }
        printExecutionTime("Sequential access in " + listType, startTime);
    }

    private static void testInsertAtStart(List<Integer> list, int count, String listType) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(0, i);
        }
        printExecutionTime("Insert at start of " + listType, startTime);
    }

    private static void testInsertAtEnd(List<Integer> list, int count, String listType) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        printExecutionTime("Insert at end of " + listType, startTime);
    }

    private static void testInsertAtMiddle(List<Integer> list, int count, String listType) {
        long startTime = System.currentTimeMillis();
        int middleIndex = list.size() / 2;
        for (int i = 0; i < count; i++) {
            list.add(middleIndex, i);
        }
        printExecutionTime("Insert in the middle of " + listType, startTime);
    }

    private static void printExecutionTime(String action, long startTime) {
        System.out.printf("%s: %s(ms)\n", action, System.currentTimeMillis() - startTime);
    }
}
