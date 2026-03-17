public class Fish extends Animal{

    //我们的鱼可不能跑步，所以我们需要一个独特的方法
    //我们需要重新定义move并使用Override注解
    @Override//这个是方面别人阅读你的代码知道这个是重写方法
    void move(){
        System.out.println("This animal is swimming");
    }

}
