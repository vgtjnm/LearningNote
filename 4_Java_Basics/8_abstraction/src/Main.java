public class Main {

    public static void main(String[] args){

        //这次我们来学习抽象，总的来说抽象指的是
        //隐藏实现细节，只展示基本功能的过程，就像一辆车我们只需要学会油门和刹车
        //我们将使用abstract关键字将类和方法抽象化
        //抽象类可以包含抽象方法和具体方法
        //抽象方法是指其子类必须实现的方法


        //你会发现我们无法直接创造被抽象的类的对象，或者说无法创造抽象类的对象
        //Shape shape = new Shape();

        //但是我们可以创建继承它的类的对象
        Circle circle = new Circle(3);
        Triangle triangle = new Triangle(3,1.5);
        Rectangle rectangle = new Rectangle(6,6);

        //我们来使用一下他们继承自抽象类重写的抽象方法吧
        System.out.println(circle.area());
        System.out.println(triangle.area());
        System.out.println(rectangle.area());

        //我们来使用一下他们继承自抽象类的具体方法吧
        circle.display();
        triangle.display();
        rectangle.display();

    }

}
