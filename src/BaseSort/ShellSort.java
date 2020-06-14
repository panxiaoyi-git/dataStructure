package BaseSort;

import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.logging.Level;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
    }

//    public static int[] shellSort(int[] arr) {
//        int temp = 0;
//        int count=0;
//        //第一层循环 ，分组 10个数 第一次分成 5组 ，第二次分成5/2=2组，第三次分成 2/2=1组
//        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
//            for (int i = gap; i < arr.length; i++) { //对每一组进行比较，交换值
//
//                for (int j = i - gap; j >= 0; j -= gap) {
//
//                    if (arr[j] > arr[j + gap]) {
//                        temp = arr[j];
//                        arr[j] = arr[j + gap];
//                        arr[j + gap] = temp;
//                    }
//                }
//            }
//            System.out.println("第"+(++count)+"轮的排序结果：" + Arrays.toString(arr));
//
//        }
//        return arr;
//    }

    /**
     * 希尔
     */
//    public  static  int[] shellSort(int[] arr)
//    {
//        int temp =0;
//        int count =0;
//        //先分组
//        for (int gap = arr.length/2; gap >0 ; gap/=2) {
//
//            //对每一组进行操作
//            for (int i = gap; i <arr.length; i++) {
//                for (int j = i-gap; j >=0 ; j-=gap) {
//                    if (arr[j]>arr[j+gap])
//                    {
//                        //交换值
//                        temp = arr[j];
//                        arr[j]=arr[j+gap];
//                        arr[j+gap]=temp;
//                    }
//                }
//            }
//            System.out.println("第" + (++count) + "轮的排序结果为：" + Arrays.toString(arr));
//        }
//        return  arr;
//    }

   public static  int [] shellSort(int [] arr)
   {
       int temp =0;
       int count = 0;
       for (int gap = arr.length/2; gap >0 ; gap/=2) {

           for (int i = gap; i <arr.length ; i++) {

               for (int j = i-gap; j >=0; j-=gap) {

                   if (arr[j]>arr[j+gap])
                   {
                       temp=arr[j];
                       arr[j]=arr[j+gap];
                       arr[j+gap]=temp;
                   }
               }

           }
           System.out.println("第" + (++count) + "轮的排序结果为：" + Arrays.toString(arr));
       }
       return arr;
   }

}
