package com.geek.algorithms.sort;

import java.util.Arrays;

/**
 *
 */
public class QuickSort {

  public static void quickSort(int[] arr){
    if(arr == null || arr.length<=1){
      return;
    }
    quickSortInternal(arr,0,arr.length-1);

  }
  public static void quickSortInternal(int[] arr, int s, int e){
    if(s >= e){
      // 递归结束条件
      return;
    }

    int i = partition(arr, s, e);
    quickSortInternal(arr,s,i-1);
    quickSortInternal(arr,i+1,e);
  }

  private static int partition(int[] arr, int s, int e) {
    int pivot = arr[e];
    int i = s;

    for (int j = s; j < e; j++) {
      if(arr[j] < pivot){
        if(i == j){
          i ++;
        }else {
          int temp = arr[i];
          arr[i++] = arr[j];
          arr[j] = temp;
        }
      }
    }
    int temp = arr[i];
    arr[i] = pivot;
    arr[s] = temp;
    return i;
  }

  public static void main(String[] args) {
    int [] A = {6,4,5,1,2,3};
    Arrays.stream(A).forEach(e -> System.out.println(e));
    System.out.println("---排序后数组---");
    quickSort(A);
    Arrays.stream(A).forEach(e -> System.out.println(e));
  }

}
