public class Rabbit implements Prey{

    //使得我们这次使用的是implements关键字来实现Prey接口
    //但是我们得先定义flee这个方法
    @Override
    public void flee(){
        System.out.println("*The rabbit is running away*");
    }

}
