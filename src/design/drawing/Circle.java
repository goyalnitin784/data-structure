package design.drawing;

import java.util.List;

public class Circle extends Shape{

    int radius;

    public Circle(List<Cordinates> cordinatesList,String shapeName){
        super(cordinatesList,shapeName);
        enrichProperies();
    }

    @Override
    void enrichProperies() {
        if(cordinates!=null && cordinates.size()>1){
            this.radius = cordinates.get(1).getY()-cordinates.get(0).getY();
            validShape = true;
        }else{
            validShape = false;
        }

    }

    @Override
    String print() {
        if(validShape){
            return "";
        }else{
            return "";
        }
    }
}
