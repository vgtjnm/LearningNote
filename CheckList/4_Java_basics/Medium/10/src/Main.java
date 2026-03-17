public class Main {

    public static void main(String[] args){

        Rectangle square = new Rectangle(4);
        Rectangle rectangle = new Rectangle(3,5);

        System.out.println("正方形的面积是："+square.area()+"，周长是："+square.perimeter());
        System.out.println("长方形的面积是："+rectangle.area()+"，周长是："+rectangle.perimeter());
    }

}
