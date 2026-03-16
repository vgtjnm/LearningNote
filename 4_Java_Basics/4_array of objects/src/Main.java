public class Main {

    public static void main(String[] args){

        //这次我们来学习如何创建对象数组，某些情况下这非常有用
        //我们先来写一个Car类

        //我们来创建三个汽车对象
        Car car1 = new Car("Mustang", "Red");
        Car car2 = new Car("Mustang", "Blue");
        Car car3 = new Car("Mustang", "Black");

        //现在我们来创建一个对象数组更好地管理这三个对象吧
        //创建的方式也很简单，有两种
        //Car[] cars = new Car[3];//内存分配要写清楚数量
        Car[] cars = {car1, car2, car3};

        //现在有了对象数组，我们就可以配合for循环使用方法
        for(int i = 0;i < cars.length; i++){
            cars[i].drive();
        }

        //我们也可以使用增强for循环来对每个对象使用方法
        //这个循环的意思是对cars数组的每个对象都执行这个方法，作用和上面是一样的
        for(Car car : cars){
            car.drive();
        }

        //我们也可以这样直接创建cars对象数组
        Car[] cars2 = {new Car("Mustang", "Red"),
                       new Car("Mustang", "Blue")};

    }

}
