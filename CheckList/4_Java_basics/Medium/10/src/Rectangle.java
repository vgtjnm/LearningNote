public class Rectangle {

    int width;
    int height;

    Rectangle(int side){
        this(side,side);
        //效果等同于
        //this.width = side;
        //this.height = side;
    }

    Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int area(){
        return width * height;
    }

    public int perimeter(){
        return width * 2 + height * 2;
    }

}
