public class Student {

    private String name;
    private int age;
    private double gpa;

    public Student(String name){
        this.name = name;
    }

    public void setAge(int age){
        if(age>=0 && age<=150){
            this.age = age;
            System.out.println(name+"的年龄设置成功！");
        }
        else System.out.println(name+"的年龄设置失败");
    }

    public void setGpa(double gpa){
        if(gpa>=0 && gpa<=4){
            this.gpa = gpa;
            System.out.println(name+"的Gpa设置成功");
        }
        else System.out.println(name+"的Gpa设置失败");
    }

    //get就不写了

}
