public class Main {

    public static void main(String[] args){

        MathUtils m = new MathUtils();

        for(double i=1;i<=5;i+=0.5){
            System.out.println("半径为"+i+"的圆形面积为："+MathUtils.circleArea(i));

        }

        System.out.println(MathUtils.callCount);

    }

}
