package Josepfu;

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkList circleSingleLinkList = new CircleSingleLinkList();

        circleSingleLinkList.addBoy(5);
      //  circleSingleLinkList.list();
        circleSingleLinkList.countBoy(1,2,5);
    }
}

//创建环形单向链表
class  CircleSingleLinkList{

   private Boy first =null; //相当于单链表中的head节点，不能动，用于做标记

    //添加小孩
    public void  addBoy(int nums){

        if (nums<1)//先判断一下添加的个数是否大于1
        {
            System.out.println("添加节点数必须大于1");
            return;
        }
   //辅助指针帮助构建环形链表  跟单链表中的temp指针一样用于挪动的

        Boy curboy = null;

        //循环添加当前节点的个数
        for (int i = 1; i <=nums ; i++) {

            //先标记first节点 ，取第一个做forst
            Boy boy = new Boy(i);
            if (i==1) {
                first = boy;
               first.setNext(first);
               curboy =first;
            }else
            {
                curboy.setNext(boy); //将节点连起来
                boy.setNext(first);  //添加的节点的next 指向first ，形成环状 ，
                curboy=boy;  //辅助指针后移
            }

        }
    }

    //遍历当前环形链表
    public  void  list(){
        if (first==null)
        {
            System.out.println("该环形链表为空");
            return;
        }
//        添加辅助指针
        Boy curboy=first;

        while (true)
        {
            System.out.println(curboy);

            if (curboy.getNext()==first) //当前的节点的next如果为first 就说明已经遍历完成了
            {
                break;
            }
            curboy=curboy.getNext();   //指针后移
        }
    }

    //约瑟夫问题数小孩

    /**
     *
     * @param startnum 开始从第几个孩子数
     * @param countnum  数到第几个孩子出列
     *
     * @param nums  一共有多少个孩子
     */
    public void countBoy(int startnum,int countnum ,int nums)
    {
        //先进行校验
        if (startnum<1|| first==null||startnum>nums)
        {
            System.out.println("参数输入有误");
            return;
        }
        //创建辅助指针,帮助完成小孩出圈
        Boy  helper = first;
        while (true) //让helper指向最后一个节点
        {
            if (helper.getNext()==first) //说明helpe已经指向最后
            {
                break;
            }
            helper=helper.getNext();
        }

        // 报数前，先让first helper 移动到开始报数的小孩节点上 移动startnum-1 次
        for (int i = 0; i <startnum-1 ; i++) {
            first =first.getNext();
            helper=helper.getNext();
        }

        //然后开始报数，出圈，知道只有一个节点
        while (true)
        {
            if (helper==first)//说明圈中只有一个人
            {
                break;
            }

            //开始移动countnum -1次

            for (int i = 0; i <countnum-1; i++) {
                first =first.getNext(); //first现在的节点就是要出圈的节点
               helper=helper.getNext(); //helper指向要出圈节点的后一个节点
            }
            //打印出圈的节点
            System.out.println("小孩->" + first + "出圈");
            first=first.getNext();
             helper.setNext(first);
        }
        System.out.println("最后一个出圈的小孩->" + first + "出圈");

    }

}

class Boy {

    private Boy next;
    private  int no;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "boyno=" + no ;

    }
}
