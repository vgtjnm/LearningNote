public class Main {

    public static void main(String[] args){

        //这次我们来学super关键字
        //super在所有情况下都表示父类
        //super关键字用于构造函数和方法重写
        //我们使用super关键字来调用父构造函数来初始化内容

        Person person = new Person("John", "Smith");
        Student student = new Student("Mei", "Li", 5.0);
        Employee employee = new Employee("Li", "Hua", 225);


        student.showGPA();
        employee.showSalary();


    }

}
