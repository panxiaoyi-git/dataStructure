package SingleLinked;


import java.util.Stack;

public class SingleLinkedList {

    //创建头结点
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的 next 指向 新的节点

    //添加节点
    public void add(HeroNode heroNode) {
        //因为 head 节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {//
                break;
            }
            //如果没有找到最后, 将将 temp 后移
            temp = temp.next;
        }
        //当退出 while 循环时，temp 就指向了链表的最后
        //将最后这个节点的 next 指向 新的节点
        temp.next = heroNode;
    }

    //指定位置添加节点
    public void add1(HeroNode heroNode) {
        //因为 head 节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        //遍历链表，找到最后
        boolean flag = false;
        while (true) {
            //找到链表的最后
            if (temp.next == null) {//说明已经在最后
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {

                flag = true;
                break;
            }
            //如果没有找到最后, 将将 temp 后移
            temp = temp.next;
        }
        //当退出 while 循环时，temp 就指向了链表的最后
        //将最后这个节点的 next 指向 新的节点
        if (flag) {
            System.out.println("编号已经存在");
        } else {
            //添加这里只能向把temp的下一个值替换掉，否则将是死循环
            heroNode.next = temp.next;
            temp.next = heroNode;

        }
    }
    //链表修改
    public  void  update(HeroNode heronode){
        if (head.next==null)
        {
            System.out.println("链表是空的");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;

        while (true){
            if (temp==null)
                break; //没找到或者为空
            if (temp.no==heronode.no)
            {
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag)
        {
            temp.name=heronode.name;
            temp.nickname=heronode.nickname;
        }else {
            System.out.println("链表不存在该节点");
        }
    }

    //链表的遍历
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //临时temp存放节点的信息
        HeroNode temp = head.next;

        while (true) {
            //输出节点信息
            System.out.println(temp);

            if (temp.next == null) {
                break;
            }
            //一定注意要将节点往后移
            temp = temp.next;


        }

    }

    //删除节点
    public  void  del(int no ){

        HeroNode temp = head;
        boolean flag = false;
        while (true)
        {
            if (temp.next==null)
            {break;}
            if (temp.next.no==no)
            {
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag)
        {
            temp.next=temp.next.next;
        }else {
            System.out.println("没有找到该节点，无法删除");
        }


    }
    //单链表的反转   利用stack实现

    public  void reverse(HeroNode head ){
        if(head.next==null)
        {
            System.out.println("链表为空，不能反转");
            return;
        }
        HeroNode temp = head.next;
        //将有值的节点，放入栈中
        Stack<HeroNode> nodes = new Stack<HeroNode>();
        while (temp==null)
        {
            nodes.add(temp);
            temp=temp.next;
        }
        System.out.println(nodes.pop());
    }

//    public void update(HeroNode newHeroNode) {
//        //判断链表是否为空
//        if (head.next == null) {
//            System.out.println("链表为空");
//            return;
//        }
//
//        //然后开始查找，根据no
//        //先把节点信息保存到temp
//        HeroNode temp = head.next;
//
//        //定义一个flag判断
//        boolean flag = false;
//
//        while (true) {
//            if (temp.next == null) {
//                break;
//            }
//            if (temp.no == newHeroNode.no) {
//                flag = true;
//                break;
//            }
//            temp = temp.next;
//        }
//
//        //然后根据flag判断是否需要找到修改的节点
//        if (flag = true) {
//            temp.name = newHeroNode.name;
//            temp.nickname = newHeroNode.nickname;
//        } else {
//            System.out.println("没有");
//        }
//
//    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }
}

class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero5 = new HeroNode(5, "赵信", "赵子龙");
        HeroNode hero1 = new HeroNode(-1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(-3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero5);
        singleLinkedList.add1(hero4);
        singleLinkedList.add1(hero5);
        singleLinkedList.add1(hero1);
        singleLinkedList.add1(hero2);
        singleLinkedList.add1(hero3);


        singleLinkedList.list();
        singleLinkedList.update(new HeroNode(2,"吕布","皇子"));
        System.out.println("----------------------------------");
        singleLinkedList.list();
        System.out.println("----------------------------------");
   singleLinkedList.del(-3);
        singleLinkedList.list();
    }
}
