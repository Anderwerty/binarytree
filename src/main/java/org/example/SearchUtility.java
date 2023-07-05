package org.example;

public class SearchUtility {

    public static int binarySearch(int[] items, int target) { // target is 42
        int minIndex = 0;
        int maxIndex = items.length - 1;

        while (minIndex <= maxIndex) {
            int midIndex = (minIndex + maxIndex) / 2;

            // if-else if-else
            if (items[midIndex] < target) {
                minIndex = midIndex + 1;
            } else if (items[midIndex] > target) {
                maxIndex = midIndex - 1;
            } else {
                return midIndex;
            }
        }

        return -(minIndex + 1);
    }


    public static void main(String[] args) {
        int[] items = {-100, -21, 1000, 0, 1, 2, 60, 61, 65, 79, 87, 93, 200};

        int index = binarySearch(items, 1000);
        System.out.println(index);
    }

}
