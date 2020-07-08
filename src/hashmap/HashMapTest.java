package hashmap;


import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {

       HashMap hm=  new HashMap<>();
       hm.put("张三",23);
        Object zhangsan = hm.get("张三");
        System.out.println(zhangsan.toString());
        System.out.println("杨小洲是煞笔");
        System.out.println(zhangsan.toString());
        System.out.println("杨小洲是煞笔");
        System.out.println(1111);
        System.out.println(2222);

    }
}
