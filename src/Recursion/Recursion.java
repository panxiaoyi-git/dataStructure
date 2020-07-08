package Recursion;

/**
 * 递归就是自己调用自己
 * 打印问题
 * 阶层问题
 * 重点理解 递归的入栈调用图  跟栈的思想类似
 * 规则：执行每一个方法都会独立的开辟一个栈空间（底层还是栈）
 * 每个方法的（局部变量是独立的），不会相互影响
 * 如果的方法中使用的是引用类型（比如数组），这会共享该变量
 * todo 写递归的时候的一定要向退出的递归条件逼近，否则可能造成StackOverFlowError
 * 当一个方法执行完毕，或者遇到return 就会返回，遵循谁调用，就将结果返回给谁，同时当方法执行完毕或者返回，该方法执行完毕
 * 解决什么样的问题：8皇后、汉诺塔、阶乘、迷宫、球和篮子、数、图、最短生成路径，排序、归并
 * 涉及的很广
 *
 */
public class Recursion {
    public static void main(String[] args) {
        test(5);
    }
    public  static void test(int n){
        if (n>2)
        {
            test(n-1);

        }
        System.out.println(n);
        System.out.println(22222);
    }
}
