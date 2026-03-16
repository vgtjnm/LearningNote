public class Student {

    String name = "Tom";
    int age;
    double gpa;
    boolean isEnrolled;

    //现在我们要创建构造函数，构造函数是一种特殊方法
    //要设置构造函数我们需要输入类名
    //我们用户创建对象赋值的顺序就和这个函数的参数顺序一样
    Student(String name, int age, double gpa){
        //我们使用this关键字来给属性赋值
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.isEnrolled = true;
    }

    //我们来写个函数让学生们学习
    void study(){
        //在使用属性时，可以用this
        System.out.println(this.name+" is studying");
    }

}
