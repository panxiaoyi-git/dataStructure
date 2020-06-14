package fibonacci;

public class fibonacci {
    public static void main(String[] args) {
      System.out.println(fbnc(3));
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
}
