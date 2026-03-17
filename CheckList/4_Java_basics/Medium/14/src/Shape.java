public abstract class Shape {

    abstract public double area();
    abstract public double perimeter();

    void describe(){
        System.out.println(area());
        System.out.println(perimeter());
    }

}
