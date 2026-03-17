public class Dog extends Animal{

    Dog(String name){
        super(name);
    }

    @Override
    public void speak(){
        System.out.println("汪！");
    }

    void fetch(){
        System.out.println(name+"在跟你玩捡球游戏");
    }

}
