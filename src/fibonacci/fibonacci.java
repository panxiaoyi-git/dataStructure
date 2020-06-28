package fibonacci;

public class fibonacci {
    public static void main(String[] args) {
      System.out.println(fbnc(5));
        System.out.println(fbnc1(5));
        System.out.println(fbnc2(5));
    }
    public static int fbnc(int n)
    {
        if (n<1)
        {
            return -1;
        }
        if (n==1||n==2)
        {
            return 1;
        }
        else
        return fbnc(n-1)+fbnc(n-2);

    }
    public static long fbnc1(int n)
    {
        long[] arr=new long[n];

        if (n==1||n==2)
        {
            return 1;
        }
        arr[0]=arr[1]=(long)1;

        for (int i = 2; i <arr.length; i++) {
           arr[i]=arr[i-1]+arr[i-2];
        }

        return arr[n-1];
    }
    public static int fbnc2(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int c = 0;
        int a = 1;
        int b = 1;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
