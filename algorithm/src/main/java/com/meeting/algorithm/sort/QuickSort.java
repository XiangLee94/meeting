package com.meeting.algorithm.sort;

public class QuickSort {

    public static void main(String[] args) {

    }
    private static void quickSort(int[] arr) {
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int mid = partitionBy(arr, lo, hi);
        quickSort(arr, lo, mid - 1);
        quickSort(arr, mid + 1, hi);
    }

    private static int partitionBy(int[] arr, int lo, int hi) {
        int val = arr[lo];
        int i = lo;
        int j = hi;
        while (i < j) {
            while (arr[i++] < val) {if (i == hi) break;}
            while (arr[j--] > val) {if (j == lo) break;}
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[j] = val;
        return j;
    }
}
