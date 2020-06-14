package BaseSort;

import java.util.Arrays;
import java.util.Random;


//冒泡排序

/**
 * 一共进行数组大小的n-1次的循环
 * 每次排序的次数在减少
 *
 * 优化 ：如果发现 一次没有交换 提前结束
 */
public class BubbleSort {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();//获取当前时间
        Random random = new Random();
        int[] arr =new int[10];
        for (int i = 0; i < 10; i++) {
            int num= random.nextInt(123);
            arr[i]=num;
        }

        int[] sortarr = bubbleSort(arr);
        for (int i = 0; i <sortarr.length-1 ; i++) {
            System.out.println(sortarr[i]);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间："+(endTime-startTime)+"ms");
    }


   /** public static  int[]  bubbleSort(int[] arr)
    {
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr.length-1-i ; j++) {
                if (arr[j]>arr[j+1])
                {
                    int temp =arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }*/
//   public static  int[]  bubbleSort(int[] arr){
//
//       int temp  = 0;
//       boolean flag=false;
//       for (int i = 0; i <arr.length-1 ; i++) {
//
//           for (int j = 0; j <arr.length-1-i ; j++) {
//
//               if (arr[j]>arr[j+1]) {
//                   flag=true;
//                   temp = arr[j];
//                   arr[j] = arr[j + 1];
//                   arr[j + 1] = temp;
//               }
//
//           }
//           if (!flag)
//           {break;}
//           else{
//               flag=true;
//           }
//           System.out.println("第"+(i+1)+"次交换"+Arrays.toString(arr));
//       }
//       return arr;
//   }
//public static  int[] bubbleSort(int[] arr)
//{
//    int temp =0;
//    boolean flag =false;
//    for (int i = 0; i <arr.length-1 ; i++) {
//
//        for (int j = 0; j < arr.length-1-i; j++) {
//            if (arr[j]>arr[j+1])
//            {
//                temp=arr[j];
//                arr[j]=arr[j+1];
//                arr[j+1]=temp;
//                flag=true;
//            }
//        }
//        if (!flag){
//            break;
//        }else {
//            flag=true;
//        }
//    }
//    return arr;
//}

public static  int[] bubbleSort(int[] arr)
{
    int temp =0;
    boolean flag=false;
    for (int i = 0; i < arr.length-1; i++) {

        for (int j = 0; j < arr.length-i-1; j++) {

            if (arr[j]>arr[j+1])
            {
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
                flag=true;
            }
        }
        if (!flag)
        {
          break;
        }else {
            flag=false;
        }
    }
    return arr;
}
}
