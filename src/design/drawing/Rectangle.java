package design.drawing;

import java.util.List;

public class Rectangle extends Shape{

    int widht;
    int height;

    public Rectangle(List<Cordinates> cordinatesList){
        super(cordinatesList,"");
        enrichProperies();
    }

    @Override
    void enrichProperies() {

    }

    @Override
    String print() {
        return null;
    }
}
