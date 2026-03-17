import java.util.HashMap;

public class Main {

    public static void main(String[] args){

        //这次我们要来学习map了
        //听说这是个很复杂难以理解，但原理和用法非常简单

        //所以map到底是什么？它的作用是什么？它代表什么？
        //最基本的map就是一组键值对，举个例子
        //想象一下，你经营一家公司，有很多员工，他们都有各自的工号
        //我可能需要一个功能输入员工姓名就能获取他们的工号，这就是map的作用
        //那不就是哈希表吗？有什么难的

        //现在就让我们来实现它吧
        //使用HashMap需要导入java.util.HashMap
        //并且告诉他映射的类型，我们是从字符串映射数字
        HashMap<String, Integer> empIds = new HashMap<>();

        //问题来了为什么这里要用HashMap而不是Map
        //在Java中，这个映射实际上是一种接口，映射接口规定实际的映射实现必须支持哪些方法
        //映射接口有多种不同的实现方式，HashMap只是其中一种，它也可能是程序员最常用的映射实现

        //下面我们就来使用put方法来放入映射表吧
        empIds.put("Tom",12345);
        empIds.put("Karl",44123);
        empIds.put("Kim",28482);

        //我们来打印映射表吧
        //映射表有个特点是不保证特点的顺序，他只是存储键值
        System.out.println(empIds);

        //想要打印映射表对应元素就这样做
        System.out.println(empIds.get("Karl"));

        //我们可以使用containsKey方法来判断Key的存在
        System.out.println(empIds.containsKey("John"));

        //我们还可以使用containsValue来判断值是否存在
        System.out.println(empIds.containsValue(5));

        //顺带说一下如果你重复put一个已经存在的Key，那么就会直接覆盖
        //有个类似的方法叫做replace，replace和put有些区别
        //如果一个Key在表中不存在，那么replace不会执行
        empIds.replace("JJJ",23213);//JJJ不存在所以不会执行
        System.out.println(empIds);

        //还有一个方法叫做putIfAbsent
        //它可以添加一对键值到你的表中，前提是它不存在
        empIds.putIfAbsent("JJJ",23213);//如果添加的是Tom那么不能运行

        //如果你想从表中删除一个键值，使用remove方法
        //使用remove方法需要传入被删除的值，直接输入Key就行
        empIds.remove("Tom");
        System.out.println(empIds);

        //总结：
        //HashMap，哈希表是一个强大的映射表，可以帮助我们解决需要映射的问题

    }

}
