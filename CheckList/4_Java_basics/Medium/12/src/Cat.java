public class Cat extends Animal{

    Cat(String name){
        super(name);
    }

    @Override
    public void speak(){
        System.out.println("喵！");
    }

    public void purr(){
        System.out.println(name+"很舒服地发出呼噜呼噜的声音");
    }

}
