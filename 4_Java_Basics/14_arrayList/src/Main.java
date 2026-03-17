import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args){

        //这次我们要学的是ArrayList，动态数组
        //动态数组是一个可以调整大小的数组，用于存储对象
        //数组的大小是固定的，但ArrayList可以动态地改变大小

        //我们来创建一个ArrayList吧
        //顺便说一下使用ArrayList需要导入java.util.ArrayList，并且指定存储类型
        ArrayList<Integer> list = new ArrayList();

        //现在我们来使用add方法为list添加数字吧
        list.add(3);
        list.add(4);
        list.add(5);

        //现在我们打印看看吧
        System.out.println(list);

        //如果我们要删除元素时使用remove方法，我们需要指定索引，索引从0开始
        list.remove(1);
        System.out.println(list);

        //我们还可以使用set方法指定一个索引修改它的值
        list.set(0,55);
        System.out.println(list);

        //向获取具体的元素可以使用get方法指定索引获取
        System.out.println(list.get(1));

        //想要知道数组目前的长度需要使用size方法
        System.out.println(list.size());

        //想要对数组排序需要使用Collections框架
        //使用Collections需要导入java.util.Collections
        Collections.sort(list);
        System.out.println(list);

        //你也可以使用加强版for去遍历动态数组
        for(int num : list){
            System.out.println(num);
        }

        //以上就是ArrayList的创建和常用方法了

    }

}
