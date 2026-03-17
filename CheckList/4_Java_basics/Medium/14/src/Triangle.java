public class Triangle extends Shape{

    double base;
    double height;

    Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    @Override
    public double area(){
        return 0.5 * base * height;
    }

    @Override
    public double perimeter(){
        return base * 3;//我们认为它是等边，非等边能写但是比较麻烦
    }

}
