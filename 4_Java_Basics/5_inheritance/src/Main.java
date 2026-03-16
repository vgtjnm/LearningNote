public class Main {

    public static void main(String[] args){

        //这次我们来学习一个很重要的内容：继承
        //我们在python也接触过，指的是一个类继承另一个类的属性和方法
        //就像孩子可以从父母那里继承特征一样
        //我们先来创建几个类吧

        //我们的Cat和Dog继承自Animal，我们来创建一下吧
        Dog dog = new Dog();
        Cat cat = new Cat();

        //我们来检测一下他们的情况
        System.out.println(dog.isAlive);
        System.out.println(cat.isAlive);

        dog.eat();
        cat.eat();

        //现在我们来给他们写上一些独特的方法和属性
        //下面我们就来使用它吧
        System.out.println(dog.lives);
        System.out.println(cat.lives);

        dog.speak();
        cat.speak();

        //继承也可以多次，子类继承父类，父类继承爷类

    }

}
