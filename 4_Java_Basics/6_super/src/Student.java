public class Student extends Person{

    double gpa;


    //如果我们直接在构造函数里的参数里写父类的属性，那么java会丢给我们错误
    //这时我们就需要使用super关键字，super就是我们把参数传给父类构造函数的钥匙
    Student(String first, String last, double gpa){
        //this.first = first;
        //this.last = last;
        super(first,last);
        this.gpa = gpa;
    }

    void showGPA(){
        System.out.println(this.first+"'s gpa is:"+this.gpa);
    }

}
