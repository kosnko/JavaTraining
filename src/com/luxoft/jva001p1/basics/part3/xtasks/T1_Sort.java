package com.luxoft.jva001p1.basics.part3.xtasks;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.*;

public class T1_Sort
{
    static int swap = 0;
    static int recursion = 0;
    static int sortType = 0;

    public static void main(String[] args) throws Exception
    {
        int[] numbers = getArrOfRandomInts(100);

        int[] copyToSort = Arrays.copyOf(numbers, numbers.length);

        long startTime = currentTimeMillis();
//        Arrays.sort(copyToSort);
//        swap(copyToSort, copyToSort.length -1, 0);

        sortAsc(copyToSort);

        long endTime = currentTimeMillis();

        out.println("-->" + (endTime - startTime));

        int[] copyToCheck = Arrays.copyOf(numbers, numbers.length);

        Arrays.sort(copyToCheck);
        out.println("Is numbers sorted: "
                + String.valueOf(Arrays.equals(copyToCheck, copyToSort)).toUpperCase());
    }

    private static int[] getArrOfRandomInts(int count)
    {
        int[] numbers = new int[count];

        Random r = new Random();
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = r.nextInt(1000);
        }
        return numbers;
    }

    /**
     *
     * Method should sort data array ascending order.
     *
     */
    public static void sortAsc(int[] data)
    {
        out.println(Arrays.toString(data));

        // TODO YOUR CODE HERE
        swap=0;
        if (sortType == 0) {
        //Shuttle Sort
            for(int i = 0; i < data.length-1; i++) {
                if (data[i] > data[i + 1]) {
                    swap(data, i, i + 1);
                    for (int j = i; j > 0; j--) {
                        if (data[j] < data[j - 1]) {
                            swap(data, j, j - 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        } else if (sortType == 1) {
            //Selection Sort
            for(int i = 0; i < data.length; i++) {
                int idxMin = i;
                for (int j = i + 1; j < data.length; j++) {
                    if (data[idxMin] > data[j]) {
                        idxMin = j;
                    }
                }
                if (idxMin != i) swap(data, i, idxMin);

            }
        } else if (sortType == 2) {
            //Quick Sort
            //possibly lead to Exception in thread "main" java.lang.StackOverflowError
            recursion = 0;
            quickSort(data, 0, data.length-1);
            System.out.println("recursion: "+recursion);
        } else if (sortType == 3) {
            //Merge Sort
            mergeSort(data, 0, data.length-1);
        }

        out.println(swap);

        out.println(Arrays.toString(data));

    }

    public static void quickSort(int[] data, int first, int last) {
        int leftBorder = first;
        int rightBorder = last;
        int partitionElement = data[(first + last) / 2];
        recursion++;
//        System.out.println("recursion: "+recursion);
//        System.out.println("first: "+first+", last: "+last);
//        System.out.println("partitionElement: "+partitionElement);
        while (leftBorder <= rightBorder) {
            if (data[leftBorder] < partitionElement) {
                leftBorder++;
            } else {
                if (data[rightBorder] > partitionElement) {
                    rightBorder--;
                } else {
                    if (leftBorder != rightBorder){
                        swap(data, leftBorder, rightBorder);
                    }
                    leftBorder++;
                    rightBorder--;
                }
            }
        }
//        System.out.println("leftBorder: "+leftBorder+", rightBorder: "+rightBorder);
//        System.out.println(Arrays.toString(data));
        if (first < rightBorder) {
            quickSort(data, first, rightBorder);
        }
        if (last > leftBorder) {
            quickSort(data, leftBorder, last);
        }
    }

    public static void mergeSort(int[] data, int left, int right)
    {
        int middle = (left + right)/2;
        if( (left+1) < right )
        {
            mergeSort(data, left, middle);
            mergeSort(data, middle + 1, right);
        }
        int[] buffer = new int[right - left + 1];
        int leftCursor = left, rightCursor = middle + 1;
        for (int i = 0; i < buffer.length; i++) {
            if (leftCursor <= middle && rightCursor <= right) {
                if (data[leftCursor] < data[rightCursor]) {
                    buffer[i] = data[leftCursor];
                    leftCursor++;
                } else {
                    buffer[i] = data[rightCursor];
                    rightCursor++;
                }
            }
            else  {
                if (leftCursor <= middle) {
                    buffer[i] = data[leftCursor];
                    leftCursor++;
                }
                else {
                    buffer[i] = data[rightCursor];
                    rightCursor++;
                }
            }
        }
        arraycopy(buffer, 0, data, left, buffer.length);
    }

    /**
     *
     * Method should exchange values with idx1 and idx2 in data array.
     *
     */
    public static void swap(int[] data, int idx1, int idx2)
    {
        // TODO SHOULD BE ALREADY IMPLEMENTED
        if(data[idx1] != data[idx2]){
            int temp2 = data[idx2];
            data[idx2] = data[idx1];
            data[idx1] = temp2;
            swap++;
        }
    }
}
