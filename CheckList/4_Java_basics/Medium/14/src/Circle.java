public class Circle extends Shape{

    double radius;
    final double pi = 3.1415926;

    Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double area(){
        return pi * radius * radius;
    }

    @Override
    public double perimeter(){
        return 2 * pi * radius;
    }

}
