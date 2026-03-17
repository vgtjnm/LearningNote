public class Rectangle extends Shape{

    double length;
    double width;

    Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    //我们来实现Shape的抽象方法来不让我们变成抽象吧
    @Override
    double area(){
        return length * width;
    }

}
