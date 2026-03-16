public class Main{

    public static void main(String[] args){

        //学到java的面向对象了
        //我们先来复习一遍对象的概念吧
        //对象存储的数据被视为属性，可以执行的操作视为方法
        //对象可以有东西也可以做事情
        //现在让我们先来写一个Car类吧

        //我们的Car类已经写好了，现在来让我们创建一个对象吧

        Car car = new Car(); //创建需要分配内存

        //如果我们直接打印我们的对象，你会得到它的内存地址
        System.out.println(car);

        //如果你想打印它的属性那么则需要加上'.'来访问
        System.out.println(car.isRunning);

        //想要更改对象的属性也是一个道理
        car.isRunning = true;
        System.out.println(car.isRunning);

        //使用我们在Car上的方法来控制车的启动
        System.out.println(car.isRunning);
        car.stop();
        System.out.println(car.isRunning);
        car.start();
        System.out.println(car.isRunning);

    }
}