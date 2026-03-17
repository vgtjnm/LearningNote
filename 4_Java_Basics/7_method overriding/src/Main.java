public class Main {

    public static void main(String[] args){

        //这次我们将学习方法重写
        //方法重写是指子类提供自己实现的方法，而不是使用从父类继承的方法
        //他允许代码重用，并且可以为方法提供特定的实现
        //我们先来写几个类吧

        //创建几个动物对象吧，他们全部继承自动物类
        Dog dog = new Dog();
        Cat cat = new Cat();
        Fish fish = new Fish();

        //来让他们动起来
        //但是如果方法没有修改，鱼就在跑步了，那可不行
        dog.move();
        cat.move();
        fish.move();

    }

}
