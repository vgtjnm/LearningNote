import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args){

        ArrayList<String> list = new ArrayList<>();

        list.add("apple");
        list.add("banana");
        list.add("peach");
        list.add("noodle");

        System.out.println(list);

        //想根据值来删除而不是索引可以使用remove方法
        list.remove("banana");

        System.out.println(list);

        //想要知道某个值是否存在可以使用contains方法
        if(list.contains("apple"))
            System.out.println("有苹果");

        else
            System.out.println("没苹果");

        //想要对动态数组排序需要Collections框架
        Collections.sort(list);
        System.out.println(list);

    }

}
