package algorithms.sort;

import java.util.Arrays;

/*
 * 常见排序算法
 */
public class CommonSort {

    /*
     * 插入排序
     */
    public static int[] insertSort(int[] target){



        return null;
    }

    public static void bubbleSort(int[] target){
        int len = target.length;
        if(len <1){
            return ;
        }
        for (int i = 0; i < len; i++) {
            boolean breakFlag = false;
            for (int j = 0; j < len -1; j++) {
                if(target[j] > target[j+1]){
                    int temp = target[j];
                    target[j] = target[j+1];
                    target[j+1] = temp;
                    breakFlag = true;
                }
            }
            if(!breakFlag){
                break;
            }

        }

    }

    public static void main(String[] args) {
        int [] A = {6,4,5,1,2,3};
        Arrays.stream(A).forEach(e -> System.out.println(e));
        bubbleSort(A);
        Arrays.stream(A).forEach(e -> System.out.println(e));
    }

}
