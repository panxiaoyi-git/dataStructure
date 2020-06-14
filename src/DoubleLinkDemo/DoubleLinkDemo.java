package DoubleLinkDemo;


public class DoubleLinkDemo {
    public static void main(String[] args) {
        LinkNode2 node1 = new LinkNode2(4, "张飞");
        LinkNode2 node2 = new LinkNode2(2, "关羽");
        LinkNode2 node3 = new LinkNode2(3, "刘备");
        LinkNode2 node4 = new LinkNode2(5, "赵云");
        LinkNode2 node5 = new LinkNode2(5, "盖伦");
        LinkNode2 node6= new LinkNode2(1, "寒冰");

        DoubleLinkList linkList = new DoubleLinkList();
//        linkList.addnode(node1);
//        linkList.addnode(node2);
//        linkList.addnode(node3);
//        linkList.addnode(node4);

        linkList.addnode2(node1);
        linkList.addnode2(node4);
        linkList.addnode2(node3);
        linkList.addnode2(node2);
        linkList.update(node5);
        linkList.addnode2(node6);

        linkList.list();
        System.out.println("****************************");
        linkList.del(1);
        linkList.list();
    }
}
/*单向链表存在不足的地方，只能朝一个方向，双向可以向前向后都可以
*单向链表不能自我删除，需要靠辅助节点，需要找到删除节点的前一个节点
*  */
class DoubleLinkList {

    //还是初始化一个头结点，不给定值
    private LinkNode2 head = new LinkNode2(0, "孙尚香");

    public LinkNode2 getHead() {
        return head;
    }

    //双向链表的遍历
    public void list() {
        if (head.next == null) {

            System.out.println("此链表为空");
            return;
        }

        LinkNode2 temp = head.next;

        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }

    //双向链表的无序添加
    public void addnode(LinkNode2 node) {
        //把头结点给一个temp
        LinkNode2 temp = head;
        //定义一个flag 方便操作
        boolean flag = false;
        //开始添加
        while (true) {
            //遍历链表到末尾，跟单链表 一样
            if (temp.next == null) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //执行链表的添加操作
            temp.next = node;
            node.pre = temp;
        }
    }

    //双向链表的有序添加
    public void addnode2(LinkNode2 node) {
        //把头结点给一个temp
        LinkNode2 temp = head;

        //开始添加
        while (true) {
            //遍历链表到末尾，跟单链表 一样
            if (temp.next == null) {
                temp.next = node;
                node.pre = temp;
                break;
            }

            if (temp.next.no > node.no) {
                node.next = temp.next;
                temp.next.pre = node;
                temp.next = node;
                node.pre = temp;
                break;
            } else if (temp.next.no == node.no) {
                System.out.println("链表已经存在");
                break;
            }
            temp = temp.next;
        }
    }

    //双向链表的修改
    public void update(LinkNode2 node) {
        //思路跟单链表一样 根据no去寻找
        //先判断是否为空
        if (head.next == null) {
            System.out.println("链表为空链表");
            return;
        }

        //创建临时节点
        LinkNode2 temp = head.next;

        //定义 flag
        boolean flag = false;

        while (true) {
            if (temp == null)
                break;

            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag)
            temp.name = node.name;
        else
            System.out.println("没有找到该节点");


    }

    //从双向链表中删除节点
    /*
     * 对于删除节点，不用像单链表一样，必须找到前一个节点，双向链表能自己根据自己删除*/
    public void del(int no) {
        //判断是否是空链表
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //还是跟单链表一样
        LinkNode2 temp = head.next;

        //定义一个flag
        boolean flag = false;
        while (true) {
            if (temp == null)
                break;
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp != null) //这里为什么要判断一下，因为如果是删除最后一节点，temp.next=null  null.pre 会出现空指针异常
                temp.next.pre = temp.pre;
        } else System.out.println("没有找到要删除的节点");

    }
}

class LinkNode2 {
    public int no;
    public String name;
    public LinkNode2 next; //指向下一个节点 默认为null
    public LinkNode2 pre;//指向前一个节点

    public LinkNode2(int no, String name) {
        this.no = no;
        this.name = name;
    }


    @Override
    public String toString() {
        return "no: " + no + "  " + "name: " + name;
    }
}
