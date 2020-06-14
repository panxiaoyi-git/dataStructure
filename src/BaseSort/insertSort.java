package BaseSort;


import java.util.Arrays;

public class insertSort {
    public static void main(String[] args) {
        int[] arr = {100, 3, 28, 4, 56, 74, 13};
        insertSort(arr);
    }
//    public static int[] insertSort(int[] arr)
//    {
//
//        int insertVal=0;
//        int insertIndex=0;
//        //定义循环的层数,第一个作为有序数组，所以直接从第二个数开始
//        for (int i = 1; i <arr.length ; i++) {
//            insertVal=arr[i];
//           insertIndex=i-1;
//
//            //给待插入的值找下标，如果比比前一个数小，把前一个数后移一位
//            while (insertIndex>=0&&insertVal<arr[insertIndex]){
//                arr[insertIndex+1]=arr[insertIndex];//后移一位
//                insertIndex--;
//            }
//
//            //判断是否发生了交换，如果交换了，交换值
//            if (insertIndex+1!=i)
//            {
//                arr[insertIndex+1]=insertVal;
//            }
//
//            System.out.println("第" + i + "轮排序后:  " + Arrays.toString(arr));
//
//        }
//        return arr;
//    }

    /**
     * 插入排序
     */
//    public  static  int[] insertSort(int[] arr){
//
//        //插入排序，把第一个当成有序，后面的依次跟前一个比较，如果小，把前一个的值，后移到当前位置，继续判断，寻找最终的位置
//        //定义初始的 待插入的值 和 前一个数的下标
//        int insertVal =0;
//        int insertIndex =0;
//        for (int i = 1; i <arr.length ; i++) {
//            insertVal=arr[i];
//            insertIndex=i-1;
//
//            //2.待插入的值跟前一面的数依次比较，如果小于前面的数就把前面的数后移，最终找到位置
//            while (insertIndex>=0 &&insertVal<arr[insertIndex])// insertinsex>=0，防止下标越界
//            {
//                arr[insertIndex+1]=arr[insertIndex];//将数后移一位
//                insertIndex--;//继续判断是否还小
//            }
//
//            //3.判断是否发生了交换，如果的交换的 insertIndex+1 ！=i 那么将待插入的值放进插入的位置
//            if (insertIndex+1!=i){
//                arr[insertIndex+1]=insertVal;
//            }
//            System.out.println("第" + i + "轮排序后:  " + Arrays.toString(arr));
//        }
//        return arr;
//    }
//    public static  int [] insertSort(int[] arr){
//        int insertVal =0;
//        int insertIndex=0;
//        for (int i = 1; i < arr.length; i++) {
//
//            insertVal=arr[i];
//            insertIndex=i-1;
//
//            while (insertIndex>=0&& insertVal<arr[insertIndex])
//            {
//                arr[insertIndex+1]=arr[insertIndex];
//                insertIndex--;
//            }
//
//            if (insertIndex+1!=i)
//            {
//                arr[insertIndex+1]=insertVal;
//            }
//            System.out.println("第" + i + "轮排序后:  " + Arrays.toString(arr));
//        }
//        return arr;
//    }
//    public static int[] insertSort(int[] arr)
//    {
//        //把第一个数当成了有序的
//        int insertVal=0;
//        int insertIndex=0;
//        for (int i = 1; i <arr.length ; i++) {
//            insertVal =arr[i];
//            insertIndex=i-1;
//
//            //循环查找插入的位置
//            while (insertIndex>=0&&insertVal<arr[insertIndex])
//            {
//                arr[insertIndex+1]=arr[insertIndex];
//                insertIndex--;
//            }
//
//            if (insertIndex+1!=i)//判断是否发生值的交换
//            {
//                arr[insertIndex+1]=insertVal;
//            }
//            System.out.println("第" + i + "轮排序后:  " + Arrays.toString(arr));
//        }
//        return arr;
//    }
    public static int[] insertSort(int[] arr) {
        //把第一个数当成有序队列
        for (int i = 1; i < arr.length; i++) {
            int interval = arr[i];
            int index = i - 1;

            while (index >= 0 && interval < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }

            if (index + 1 != i) {
                arr[index + 1] = interval;
            }


            System.out.println("第" + i + "轮排序后:  " + Arrays.toString(arr));
        }
        return arr;
    }

}

