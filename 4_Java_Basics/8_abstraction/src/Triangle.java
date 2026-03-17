public class Triangle extends Shape{

    double base;
    double height;

    Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    //我们来实现Shape的抽象方法来不让我们变成抽象吧
    @Override
    double area(){
        return base * height / 2;
    }

}
