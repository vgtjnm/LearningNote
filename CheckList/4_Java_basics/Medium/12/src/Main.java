public class Main {

    public static void main(String[] args){

        Animal dog = new Dog("kaka");
        Animal cat = new Cat("papa");

        Animal[] animals = {dog,cat};

        for(Animal animal : animals){
            animal.speak();
            if(animal instanceof Dog){
                ((Dog) animal).fetch();
            }
            else
                ((Cat) animal).purr();
        }

    }

}
