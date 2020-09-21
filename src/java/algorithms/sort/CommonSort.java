package algorithms.sort;

import java.util.Arrays;

/*
 * 常见排序算法
 */
public class CommonSort {

    /*
     * 插入排序
     */
    public static void insertSort(int[] target){
        int len;
        if(target == null || (len =  target.length) <= 1) return ;
        for (int i = 1; i < len; i++) {
            int val = target[i];
            int j = i - 1;
            // 思路是把 i - 1 之前的数组认定是有序的，第一次从第二个元素开始，也可以认为素组是有序的 只有一个元素
            // 将第i个元素跟已经有序的数组从后往前比较（升序）
            for ( ; j >= 0; j--) {
                if(target[j] > val){ // 需要向后移动已经有序的数组元素
                    target[j+1] = target[j];
                }else{
                    break;
                }
            }
            target[j + 1] = val;
        }

    }

    public static void bubbleSort(int[] target){
        int len ;
        if(target == null ||  (len = target.length) <= 1){
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
        System.out.println("---排序后数组---");
        bubbleSort(A);
        Arrays.stream(A).forEach(e -> System.out.println(e));
    }

}
