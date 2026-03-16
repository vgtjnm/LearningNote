public class Main {

    public static void main(String[] args){

        //这次我们来看构造函数
        //我们首先来创造一个学生类吧
        //创造完之后来创建我们的两个对象

//        Student student1 = new Student();
//        Student student2 = new Student();

        //我们打印他们的名字发现他们都叫汤姆，重名可能有巧合但是不可能每个人都叫汤姆
//        System.out.println(student1.name);
//        System.out.println(student2.name);

        //不过我们可以借助构造函数来让他们拥有不同的名字
        //有了构造函数之后，我们就可以在创建对象时，填入他们的属性
        //填入顺序和类里的属性顺序一样
        Student student1 = new Student("xiaoming", 22, 4.5);
        Student student2 = new Student("xiaohong", 21, 2.2);

        //我们再打印学生属性时就可以看到他们的不同了
        System.out.println(student1.name+" "+student1.age+" "+student1.gpa);
        System.out.println(student2.name+" "+student2.age+" "+student2.gpa);

        //我们来让学生们学习吧
        student1.study();
        student2.study();

    }
}
