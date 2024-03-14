package com.geek.algorithms.sort;

import java.util.Arrays;

/**
 * @Description : TODO
 * @Author : LinXin
 * @ClassName : SortTest
 * @Date: 2020-10-01 13:07
 */
public class  SortTest {


    public static void quickSort(int[] arr){

        quickSortInternal(arr, 0, arr.length -1 );

    }

    private static void quickSortInternal(int[] arr, int sIndex, int eIndex){
        if(sIndex >= eIndex){
            return;
        }

        int p = partition(arr, sIndex, eIndex);
        quickSortInternal(arr, sIndex, p -1);
        quickSortInternal(arr, p +1, eIndex);
    }

    private static int partition(int[] arr, int sIndex, int eIndex){
        // 选取分区点
        int pivot = arr[eIndex];
        int index = sIndex;

        for (int i = sIndex; i < eIndex; i++) {
            if(arr[i] < pivot){
                if(index == i){
                    index ++;
                }else{
                    int temp = arr[index];
                    arr[index++] = arr[i];
                    arr[i] = temp;
                }

            }
        }
        int temp = arr[eIndex];
        arr[eIndex] = arr[index];
        arr[index] = temp;
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {6,5,4,1,2,3,4,7,8,0,11,12,13,19,18};
        quickSort(arr);
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }

}
