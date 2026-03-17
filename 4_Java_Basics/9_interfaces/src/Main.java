public class Main {

    public static void main(String[] args){

        //这次我们要来学习接口
        //接口和抽象类是非常相似的，他们有很多重叠之处
        //很多时候两者都可以用，但他们存在一些核心区别
        //接口是类的蓝图，它定义了一组抽象方法，任何实现接口的类都必须定义这些方法
        //一个关键区别是通过使用接口，我们可以实现多重继承
        //通常继承中一个类只能有一个父类，但是用接口一个类可以有很多个父类
        //去创建Java Class那里直接创建Interface吧

        Rabbit rabbit = new Rabbit();
        Hawk hawk = new Hawk();

        rabbit.flee();
        hawk.hunt();

        //上面的两个类都继承自一个接口
        //但是接口最大的特点是可以继承多个，我们将在鱼类去实现它

        Fish fish = new Fish();

        fish.flee();
        fish.hunt();

        //总结：
        //接口是类的蓝图，它指定了一组类必须定义的抽象方法，并且它支持多重继承

    }

}
