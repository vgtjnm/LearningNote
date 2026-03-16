public class Car {

    //Car是一个类
    //下面这五个变量被视为属性

    String make = "Ford";
    String model = "Mustang";
    int year = 2026;
    double price = 60000.99;
    boolean isRunning = false;

    //现在让我们来写两个函数控制汽车是否启动

    void start(){
        isRunning = true;
        System.out.println("You start the engine");
    }
    void stop(){
        isRunning = false;
        System.out.println("You stop the engine");
    }

}
