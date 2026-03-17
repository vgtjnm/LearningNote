public class Circle extends Shape{

    double radius;

    Circle(double radius){
        this.radius = radius;
    }

    //我们来实现Shape的抽象方法来不让我们变成抽象吧
    @Override
    double area(){
        return Math.PI * radius * radius;
    }

}
