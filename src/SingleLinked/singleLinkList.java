package SingleLinked;

import java.util.Stack;

public class singleLinkList {
    //创建头结点
    LinkNode head = new LinkNode(0, "");

    //返回头节点
    public LinkNode getHead() {
        return head;
    }

    //增加节点
    public void add(LinkNode newnode) {
        //创建临时变量替换head
        LinkNode temp = head;

        //循环遍历找到链表的末尾
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = newnode;
    }

    //添加节点的第二种方法 //按顺序存取
    public void add2(LinkNode node) {
        //将头结点 赋值给temp
        LinkNode temp = head;
        //定义一个flag来 管理状态
        boolean flag = false;
        //
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;

        }
        if (flag) {
            System.out.println("节点" + node.no + "已经存在");
        } else {
            node.next = temp.next;
            temp.next = node;
        }

    }

    //链表的修改
    public void update(LinkNode node) {
        if (head.next == null) {
            System.out.println("这是一个空链表");
            return;
        }
        LinkNode temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;

        }
        if (flag) {
            temp.name = node.name;
        } else {
            System.out.println("没有找到该节点");
        }

    }

    //链表的删除
    public void del(int no) {
        LinkNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有该节点");
        }
    }

    //链表的遍历
    public void list() {
        if (head.next == null) {
            System.out.println("此链表为空链表");
            return;
        }
        LinkNode temp = head.next;
        while (true) {

            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }
}

//创建节点
class LinkNode {
    public int no;
    public String name;
    public LinkNode next; //指向下一个节点

    public LinkNode(int no, String name) {
        this.no = no;
        this.name = name;
    }


    @Override
    public String toString() {
        return "no: " + no + "  " + "name: " + name;
    }
}

class Demo {
    public static void main(String[] args) {
        LinkNode node1 = new LinkNode(4, "张飞");
        LinkNode node2 = new LinkNode(2, "关羽");
        LinkNode node3 = new LinkNode(3, "刘备");
        LinkNode node4 = new LinkNode(5, "赵云");
        singleLinkList singleLinkList = new singleLinkList();
        singleLinkList.add2(node1);
        singleLinkList.add2(node2);
        singleLinkList.add2(node3);
        singleLinkList.add2(node4);
        singleLinkList.list();
       System.out.println("******************************");
//        System.out.println(getLength(singleLinkList.head));
//        System.out.println(findIndexNode(singleLinkList.head, 1));

        System.out.println("******************************");

        //链表的反转
        //1.遍历
      // reversetList(singleLinkList.getHead());
        //2.递归
       LinkNode link= reverseList(singleLinkList.getHead());
       while (link!=null)
       {
           System.out.println(link);
           link = link.next;

       }

//        singleLinkList.update(node4);
//        singleLinkList.del(1);
//        singleLinkList.list();

    }

    /**
     * @param head 链表的头结点
     * @return 返回链表的长度
     */
    //单链表面试题  带头节点不统计头结点
    public static int getLength(LinkNode head) {
        int length = 0;
        if (head.next == null) {
            return 0;
        }
        LinkNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * @param head  头结点
     * @param index 倒数值
     * @return
     */
    //统计倒数第一个节点
    public static LinkNode findIndexNode(LinkNode head, int index) {
        int size = getLength(head);

        int nodenum = size - index;
        LinkNode temp = head;   //指针应该从头结点开始位移  nodenum代表的是指针移动几下 从head。next移动会多移一个

        if (nodenum > size && nodenum < 0) {
            return null;
        } else {
            for (int i = 0; i < nodenum; i++) {

                temp = temp.next;
            }
        }
        return temp;
    }

    //用stack实现链表的反转
    public static void  reverse(LinkNode head){
        if(head.next==null){
            System.out.println("链表为空，不能打印");
            return;
        }
        //创建一个栈存放节点

        Stack<LinkNode> nodes = new Stack<LinkNode>();

        //遍历数据，先将头节点用临时变量代替
       LinkNode temp = head.next;

        while (temp!=null)
        {
             //将节点添加进stack，
            temp=temp.next;
        }

                while (nodes.size()>0) {
                    System.out.println(nodes.pop());//stack先进后出 打印
                }
    }

    public static void reversetList(LinkNode head) {
     //首先 如果链表的为空或者只有一个值不用反转
        if (head.next==null||head.next.next==null)
            return;

        //给定义一个变量，用于遍历链表
        LinkNode cur = head.next;
        //给定一个变量先保存当前节点的而下一个节点，因为把当前节点移除了无法找到下一个节点
        LinkNode tempnext =null;

        //创建一个新的链表
        LinkNode newhead =new LinkNode(0,"");

        //这种方式链表的反转，我理解为遍历取出原来的链表，然后取出来的节点插入新链表的最前端（头结点后面）
        //这样的话，就类似于单链表的第二种添加方式
        while (cur!=null){
            //因为每遍历一个节点，需要取出该节点，当前节点的next将指向新链表的最前端
            // 所以需要保存当前该的节点的下一个节点，
            // 方便当前节点节点取出后调到下一个节点
            tempnext =cur.next;
            cur.next = newhead.next;
            newhead.next =cur;
            cur =tempnext;
        }
        //将原来的链表的头节点指向新链表头结点后面的节点
        head.next = newhead.next;

    }
   /* public static void reversetList(LinkNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if(head.next == null || head.next.next == null) {
            return ;
        }

        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        LinkNode cur = head.next;
        LinkNode next = null;// 指向当前节点[cur]的下一个节点
        LinkNode reverseHead = new LinkNode(0, "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端

        while(cur != null) {
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur; //将cur 连接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }*/

    public static LinkNode reverseList( LinkNode header) {

        if (header == null || header.next == null)
            return header;

        LinkNode temp = header.next;
        LinkNode newHead = reverseList(header.next);
        temp.next = header;
        header.next = null;
        return newHead;
    }
}
