package BaseSort;

import java.util.Arrays;
import java.util.Random;

public class SelectSort {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();//获取当前时间
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(123);
            arr[i] = num;
        }

        int[] sortarr = selectSort(arr);
        for (int i = 0; i < sortarr.length; i++) {
            System.out.println(sortarr[i]);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
    /**
     * 选择排序
     */
//    public static int[] selectSort(int[] arr)
//    {
//
//        for (int i = 0; i <arr.length-1 ; i++) {
//            int min=arr[i];
//            int minIndex=i;
//            for (int j = i+1; j <arr.length; j++) {
//                if (min>arr[j])
//                {
//                    min=arr[j];
//                    minIndex=j;
//                }
//            }
//
//            if (minIndex!=i)
//            {
//                arr[minIndex]=arr[i];
//                arr[i]=min;
//            }
//            System.out.println("第"+(i+1)+"轮"+ Arrays.toString(arr));
//        }
//        return arr;
//    }

    /**
     * 选择排序
     */
//    public  static  int [] selectSort(int[] arr){
//        //循环的层数
//        for (int i = 0; i <arr.length-1 ; i++) {
//
//            //从第一个值定义最小值和下标索引值
//
//            int min=arr[i];
//            int minIndex=i;
//
//            for (int j = i+1; j < arr.length; j++) {
//                //遍历后面的值与最小的值的大小，如果小，记录值和下标
//                if (min>arr[j])
//                {
//                    min=arr[j];
//                    minIndex=j;
//                }
//
//            }
//            //判断minIndex 的值是否发生改变，如果改变，那说明找到了最小值
//            if (minIndex!=i)
//            {
//                //交换最小值
//
//                arr[minIndex]=arr[i];
//                arr[i]=min;
//
//            }
//            System.out.println("第" + (i + 1) + "排序结果: "+Arrays.toString(arr));
//        }
//        return arr;
//    }

    /**
     * 选择排序
     */
//    public static int[] selectSort(int[] arr) {
//        //把第一个当成最小的
//        int min = 0;
//        int minIndex = 0;
//        for (int i = 0; i < arr.length - 1; i++) {
//            min = arr[i];
//            minIndex = i;
//            for (int j = i+1; j < arr.length; j++) {
//                if (min > arr[j]) {
//                    min = arr[j];
//                    minIndex = j;
//                }
//            }
//            if (minIndex!=i)
//            {
//                arr[minIndex]=arr[i];
//                arr[i]=min;
//            }
//            System.out.println("第" + (i + 1) + "排序结果: "+ Arrays.toString(arr));
//        }
//        return arr;
//    }
    /*
    选择排序，把第一个当成最小的，并记录值和下标
     */
    public static int[] selectSort(int[] arr)
    {
        for (int i = 0; i < arr.length-1; i++) {
            int min=arr[i];
            int minIndex=i;
            for (int j = i+1; j <arr.length ; j++) {
                if (min>arr[j])
                {
                    min=arr[j];
                    minIndex=j;
                }
            }
            if (minIndex!=i)
            {
                arr[minIndex]=arr[i];
                arr[i]=min;

            }
            System.out.println("第" + (i + 1) + "排序结果: "+ Arrays.toString(arr));
        }
        return arr;
    }
}
