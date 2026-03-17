public class Main {

    public static void main(String[] args){

        //这次我们来用Java解释一下多态性
        //多态一词源于希腊语，多种形态或形状的概念
        //就像一只狗它可以是动物也可以是生物体还可以是对象，它可以被识别为多种事物
        //让我们先来创建几个类吧

        Car car = new Car();
        Bike bike = new Bike();
        Boat boat = new Boat();

        car.go();
        bike.go();
        boat.go();

        //现在我们来尝试创建一个对象数组
        //Car[] cars = {car,bike,boat};
        //好吧我们失败了，类型不兼容
        //但是我们却可以用Vehicle类型创建，因为他们都继承自Vehicle
        Vehicle[] vehicles = {car,bike,boat};

        //能够创建成功的原因是他们都继承自抽象类Vehicle，这样我们就可以让他们进行一些操作

        for(Vehicle vehicle : vehicles){
            vehicle.go();//让我们的车辆动起来
        }

        //但如果Vehicle不是抽象类而是接口呢？
        //我们把Vehicle改成接口以后，用其他类去实现接口，发现也可以创建对象数组，所以通过接口也可以实现多态性
        //对了补充一个点，类叫做继承，接口叫做实现，它继承这个抽象类，它实现这个接口
        //实现自接口的方法需要修饰符来公开或私人来决定是否可以使用

        //总结：
        //多态性意味着多种形态，对象既可以识别自身，也可以识别其它对象
        //对象可以被视为某个共同超类的对象

    }

}
