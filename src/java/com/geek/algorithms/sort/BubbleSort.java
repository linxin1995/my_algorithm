package com.geek.algorithms.sort;

import sun.text.resources.cldr.ii.FormatData_ii;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Objects;

/**
 * @Description: 冒泡排序
 * @author：linxin
 * @ClassName: BubbleSort
 * @Date: 2024-03-13 22:41
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1,4,2,3,6,7};
        sort(arr);
        Arrays.stream(arr).forEach(e -> System.out.println(e));
    }

    public static void sort(int[] arr){
        if (Objects.isNull(arr)){
            return;
        }
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            boolean exitFlag = false;
            for (int j = 0; j < (n-i-1); ++ j) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    exitFlag = true;
                }

            }
            if (!exitFlag){
                return;
            }
        }
    }

}
