package binarySearch;

public class binarySearch {
    public static void main(String[] args) {
   int[] arr={1,2,3,4,5,7,6,8,9};
   int num =5;
   System.out.println(binary3(arr, num));
        //System.out.println(binary1(arr, num));

        int[] answer ={1,2,3}; int[] gusse ={1,2,3};
        int flag =0;
        for (int i = 0; i < 3; i++) {

         if (answer[i]==gusse[i])
          flag++;
        }
        System.out.println(flag);
    }
     //改建的
    public static int binary1(int[] arr,int num){
        int start = 0 ;
        int end = arr.length-1;
        int mid ;
        while (start<=end){
            mid= start+(end-start) / 2;  // 防止溢出
            if (arr[mid]==num)
            {
                return mid;
            }
            else if (arr[mid]>num)
            {
                end=mid-1;
            }
            else {
                start = mid +1;
            }
        }
        return -1;
    }
    public static int binary(int[] arr,int num){
        int start = 3 ;
        int end = arr.length-1;
        int mid ;
        while (start<=end){
            mid= start+((end-start)>>>1);  //这句代码在 min 和 max 很大的时候，会出现溢出的情况，从而导致数组访问出错。
            if (arr[mid]==num)
            {
                return mid;
            }
            else if (arr[mid]>num)
            {
                end=mid-1;
            }
            else {
                start = mid +1;
            }
        }
        return -1;
    }
    public static int binary2(int[] arr,int num){
            int start = 0 ;
            int end = arr.length-1;
            int mid ;
            while (start<=end){
                mid= (start+end)>>>1;  //这句代码在 min 和 max 很大的时候，会出现溢出的情况，从而导致数组访问出错。
                if (arr[mid]==num)
                {
                    return mid;
                }
                else if (arr[mid]>num)
                {
                    end=mid-1;
                }
                else {
                    start = mid +1;
                }
            }
            return -1;
    }
    public static int binary3(int[] arr ,int num)
    {
        int start=0;
        int end=arr.length-1;
        int mid;
        while (start<=end)
        {
            mid=start+((end-start)>>>1);
            if (arr[mid]==num)
            {
                return mid;
            }
            if (arr[mid]>num)
            {
                end=mid-1;
            }
            if (arr[mid]<num)
            {
               start=mid+1;
            }
        }

        return -1;
    }
}
