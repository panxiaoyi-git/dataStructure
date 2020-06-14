package Queue;

public class QueueDemo {
    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(6);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);
        queue.addQueue(4);
        queue.addQueue(5);
        queue.addQueue(6);
        queue.addQueue(7);
        System.out.println(queue.getQueue());
        queue.showQueue();
    }
}
class  ArrayQueue{
    private int maxSize; //数组最大容量
    private  int front;//队列头
    private  int rear; //队列尾
    private int[] arr;// 存放数据，模拟队列


    //创建队列构造器  构建的一个空的队列
    public ArrayQueue(int arrmaxSize) {
        this.maxSize = maxSize;
        maxSize=arrmaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }
   //判断队列是否是满
    public boolean isFull(){
        return rear==maxSize-1;
    }
   //判断队列是否为空
    public boolean isNull(){
        return front ==rear;
    }

    //添加数据到队列
    public void addQueue(int n){
        if (isFull()) {
            System.out.println("队列已经满了");
            return;
        }
        rear++; //让rear后移
        arr[rear]=n;
        System.out.println("成功添加数据");
    }
    //获取队列数据
   public int getQueue(){
    if (isNull()){

        throw new RuntimeException("队列已经为空");
    }
    front++;//取数据从头开始取 front往后移
       return arr[front];
   }
   //显示队列的所有数据

    public void  showQueue(){
        if (isNull()){
            System.out.println("队列为空，没有数据");
            return;
        }
        //遍历
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }
    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {// 判断
        if (isNull()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front + 1];
    }
}
