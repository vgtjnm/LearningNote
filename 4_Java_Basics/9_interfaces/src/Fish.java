public class Fish implements Prey, Predator{

    //我们的鱼既可以躲避大鱼的追杀又可以吃小鱼

    @Override
    public void flee(){
        System.out.println("*The fish is swimming away*");
    }

    @Override
    public void hunt(){
        System.out.println("*The fish is hunting*");
    }

}
