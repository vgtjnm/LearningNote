public class MathUtils {

    static final double PI = 3.14159;
    static int callCount;

    static double circleArea(double r){
        callCount++;
        return r*r*PI;
    }

}
