package com.geek.algorithms.sort;

import java.util.Arrays;

/*
 * 常见排序算法
 */
public class CommonSort {

    /*
     * 插入排序
     */
    public static void insertSort(int[] arr){
       int len;
       if(arr == null || (len = arr.length) <= 1){
           return;
       }
        for (int i = 1; i < len; i++) {
            int val = arr[i];
            // 已经有序的数组最大下标 = 外层循环的下标 -1
            int j = i-1;
            for (; j >= 0; j--) {
                if(arr[j] > val){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            // 将外层循环的第一个元素放到了正确的位置
            arr[j+1] = val;
        }

    }

    public static void bubbleSort(int[] arr){
        int len;
        if(arr == null || (len = arr.length) <= 1) return;
        for (int i = 0; i < len; i++) {
            boolean breakFlag = false;
            for (int j = 0; j < len-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    breakFlag = true;
                }
            }
            if(!breakFlag){
                break;
            }
        }


    }

    /**
     * 快排的思想是这样的：如果要排序数组中下标从 p 到 r 之间的一组数据，我们选择 p 到 r 之间的任意一个数据作为 pivot（分区点）。
     * 我们遍历 p 到 r 之间的数据，将小于 pivot 的放到左边，将大于 pivot 的放到右边，将 pivot 放到中间。经过这一步骤之后，
     * 数组 p 到 r 之间的数据就被分成了三个部分，前面 p 到 q-1 之间都是小于 pivot 的，中间是 pivot，后面的 q+1 到 r 之间是大于 pivot 的。
     * 根据分治、递归的处理思想，我们可以用递归排序下标从 p 到 q-1 之间的数据和下标从 q+1 到 r 之间的数据，直到区间缩小为 1，就说明所有的数据都有序了。
     * @param arr
     * @author linxin
     * @return void
     * @date 2020/9/22 16:42
     */
    public static void quickSort(int[] arr){
        int len;
        if(arr == null ||  (len = arr.length) <= 1){
            return ;
        }
        quickSortInternal(arr,0,len-1);

    }

    /***
     * 快排核心方法
     * @param arr
     * @param startIndex
     * @param endIndex
     * @author linxin
     * @return void
     * @date 2020/9/22 16:41     
     */
    private static void quickSortInternal(int[] arr, int startIndex, int endIndex){
        if(startIndex >= endIndex){
            return;
        }
        int pivot = partition(arr,startIndex,endIndex);
        quickSortInternal(arr,startIndex,pivot-1);
        quickSortInternal(arr,pivot+1,endIndex);
    }

    /***
     * 快速排序分区函数,分区函数需要将当前数租根据分区点分为大于分区点和小于分区点的两部分数据
     * @param arr
     * @param sIndex
     * @param eIndex
     * @author linxin
     * @return int
     * @date 2020/9/22 16:41     
     */
    private static int partition(int[] arr, int sIndex,int eIndex){
       int pivot = arr[eIndex];
       int index = sIndex;
        for (int i = sIndex; i < eIndex; i++) {
            if(arr[i] < pivot){
                if(i == index){

                   index ++;
                }else {
                    int temp = arr[index];
                    arr[index++] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        int temp = arr[index];
        arr[index] = pivot;
        arr[eIndex] = temp;
        return index;
    }

    public static void main(String[] args) {
        int [] A = {6,4,5,1,2,3};
        Arrays.stream(A).forEach(e -> System.out.println(e));
        System.out.println("---排序后数组---");
        quickSort(A);
        Arrays.stream(A).forEach(e -> System.out.println(e));
    }

}
