package Stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
         ArrayStack stack =new ArrayStack(4);
         String key = "";
         boolean loop = true;
        Scanner sc =new Scanner(System.in);

        while (loop)
        {
            System.out.println("show:表示显示数据");
            System.out.println("exit:表示退出");
            System.out.println("push:表示添加数据");
            System.out.println("pop:表示取出数据");
            System.out.println("请输入你的选择");
            key= sc.next();

            switch (key)
            {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value=sc.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                  try {
                      int res =stack.pop();
                      System.out.println("出栈的数据："+res);
                  }catch (Exception e)
                  {
                      System.out.println(e.getMessage());
                  }
                    break;
                case "exit":
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序推出了");
    }
}
class ArrayStack{
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    private  int maxSize;
    private   int [] stack;
    private  int top =-1;

    //栈满
    public  boolean isfull()
    {
        return top ==maxSize-1;
    }

    //栈空
    public  boolean isEmpty(){
        return top==-1;
    }

    //入栈
    public  void push(int value)
    {
        if (isfull())
        {
            System.out.println("栈满了");
            return;
        }
        top++;
        stack[top]=value;
    }
    //出栈  将栈顶的数据返回
    public  int pop()
    {
       if (isEmpty())
       {
           //抛出异常
           throw  new RuntimeException("栈空，没有数据——");
       }
       int value =stack[top];
       top--;
       return  value;
    }

    //显示栈 从栈顶开始遍历
    //遍历时需要从栈顶开始
    public void list()
    {
        if (isEmpty())
        {
            System.out.println("栈空");
            return;
        }

        for (int i = top; i>=0 ; i--) {
            System.out.println(stack[i]);
        }
    }



}
