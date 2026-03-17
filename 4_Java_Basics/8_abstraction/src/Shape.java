public abstract class Shape {

    //使用abstract关键字的类无法创造对象
    //但是我们可以创造类去继承它

    //现在我们来定义一个抽象方法，使用abstract关键字
    //当我们定义抽象方法时，继承抽象类的类，必须为抽象类或者实现抽象方法
    abstract double area(); //abstract method

    //下面我将创建一个具体方法
    //具体方法会被我们的Circle，Triangle，Rectangle继承，但是我们并不需要实现它
    void display(){
        System.out.println("This is a shape");
    }

}
