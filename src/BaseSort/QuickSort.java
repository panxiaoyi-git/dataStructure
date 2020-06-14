package BaseSort;


import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,6};
        System.out.println("排序后:  " + Arrays.toString(quickSort(arr,0,arr.length-1)));


    }
//    public  static  int[] quickSort(int [] arr,int left,int right)
//    {
//        //第一步 定义左右下标
//        int l= left;
//        int r =right;
//        int pivot=arr[(left+right)/2];
//        int temp =0;
//
//        //第二步使用while循环分出小的在左边，大的在右边
//        while (l<r)
//        {
//            //在pivot的左边找比pivot大的数
//            while (arr[l]<pivot)
//            {
//                l+=1;
//            }
//
//            //在pivot的右边找比pivot小的数
//            while (arr[r]>pivot)
//            {
//                r-=1;
//            }
//            if (l>=r)
//            {
//                break;
//            }
//
//            temp=arr[l];
//            arr[l]=arr[r];
//            arr[r]=temp;
//
//            if (arr[l]==pivot)
//            {
//                r-=1;
//            }
//            if (arr[r]==pivot)
//            {
//                l+=1;
//            }
//
//        }
//
//        if (l==r)
//        {
//            l+=1;
//            r-=1;
//        }
//        if (left<r)
//        {
//            quickSort(arr,left,r);
////        }
//        if (right>l)
//        {
//            quickSort(arr,l,right);
//        }
//
//        return arr;
//    }
//    public static int[] quickSort(int[] arr,int left,int right)
//    {
//        int l=left;
//        int r=right;
//        int pivot=arr[(left+right)/2];
//        int temp=0;
//
//        while (l<r)
//        {
//            while (arr[l]<pivot)
//            {
//                l+=1;
//            }
//            while (arr[r]>pivot)
//            {
//                r-=1;
//            }
//
//            if (l>=r)
//            {
//                break;
//            }
//            temp=arr[l];
//            arr[l]=arr[r];
//            arr[r]=temp;
//            if (arr[l]==pivot)
//            {
//                l+=1;
//            }
//            if (arr[r]==pivot)
//            {
//                r-=1;
//            }
//        }
//
//        if (l==r)
//        {
//            l+=1;
//            r-=1;
//        }
//        if (left<r)
//        {
//            quickSort(arr,left,r);
//
//        }
//        if (right>l)
//        {
//            quickSort(arr,l,right);
//        }
//        return arr;
//    }
    public static  int[] quickSort(int[] arr ,int left,int right)
    {
        int l =left;
        int r=right;
        int pivot=arr[(left+right)/2];
        int temp=0;
        while (l<r)
        {
            while (arr[l]<pivot)
            {
                l+=1;
            }
            while (arr[r]>pivot)
            {
                r-=1;
            }
            if (l>=r)
            {
                break;
            }
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            if (arr[l]==pivot)
            {
                l+=1;
            }
            if (arr[r]==pivot)
            {
                r-=1;
            }

        }
        if (r==l)
        {
            l+=1;
            r-=1;
        }
        if (left<r)
        {
            quickSort(arr,left,r);
        }
        if (right>l)
        {
            quickSort(arr,l,right);
        }
        return arr;
    }
}
