package Queue;


import java.util.Scanner;

//不懂点在为什么要预留一个位置
public class CircleArrayQueueDemo {
    public static void main(String[] args) {

        CircleArray array = new CircleArray(4);
        array.addQueue(10);
        array.addQueue(20);
        array.addQueue(30);
        array.showQueue();
        System.out.println(array.getQueue());
        System.out.println("***************8");
        array.showQueue();
        System.out.println("***************8");
        array.addQueue(50);
        System.out.println("***************8");
        array.showQueue();
        System.out.println("***************8");
        array.getQueue();
        array.showQueue();

    }
}

    class CircleArray {
        private int maxSize;//定义最大容量
        //front 与前面的front不同，front指向队列的第一个元素，也就是arr[front]是队列的第一个元素
        //front的初始值为0，而不是-1

        private int front=0;

        //rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定
        //初始值为0,
        private int rear=0; //队列尾

        private int[] arr;  //用数组存放数据，模拟队列

        public CircleArray(int maxSize) {
            this.maxSize = maxSize;
            arr = new int[maxSize];
        }

        //判断队列是否满  不在是rear==maxSize-1
        //这里用到的是一个小算法   (rear + 1) % maxSize == front 如果rear=2，maxSize=3,
        // 那么arr[2]就不能存数据了，会判断已经满了
        public boolean isFull() {
            return (rear + 1) % maxSize == front;
        }

        //判断队列是否为空还是一样rear==front
        public boolean isNull() {
            return rear == front;
        }

        //添加数据
        public void addQueue(int n) {
            //判断是否满了
            if (isFull()) {
                System.out.println("队列满了");
            }

            //插入数据
            arr[rear] = n;
            //rear往后移 当移到约定区的时候，应该重新指向头部 0,1,2
            rear = (rear + 1) % maxSize;

        }

        public int getQueue() {
            // 判断队列是否空
            if (isNull()) {
                // 通过抛出异常
                throw new RuntimeException("队列空，不能取数据");
            }
            // 这里需要分析出 front 是指向队列的第一个元素
            // 1. 先把 front 对应的值保留到一个临时变量
            // 2. 将 front 后移, 考虑取模
            // 3. 将临时保存的变量返回
            int value = arr[front];
            front = (front + 1) % maxSize;
            return value;

        }

        //显示所有的数据
        public void showQueue() {
            //遍历
            if (isNull()) {
                System.out.println("队列为空");
                return;
            }


            //遍历过程比较复杂
            //fron和rear是动态变化的，怎么获取有效的个数，还要对应位置
            //rear+size -front % maxSize
            for (int i = 0; i < front + size(); i++) {
                System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
            }
        }

        public int size() { //求出当前有效的个数
            //rear =2
            //fron=1
            //maxSize=3
            return (rear + maxSize - front) % maxSize;
        }

        // 显示队列的头数据， 注意不是取出数据
        public int headQueue() {
// 判断
            if (isNull()) {
                throw new RuntimeException("队列空的，没有数据~~");
            }
            return arr[front];
        }
    }



