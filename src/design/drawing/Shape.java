package design.drawing;

import java.util.List;

public abstract class Shape {

    List<Cordinates> cordinates;
    String shapeName;
    Color color;
    boolean validShape;

    public Shape(List<Cordinates> cordinates,String shapeName){
        this.cordinates = cordinates;
        this.shapeName = shapeName;
    }

    void fillColor(String strokeColor, String fillColor){
        Color color = new Color();
        color.setFillColor(fillColor);
        color.setStrokeColor(strokeColor);
        this.color = color;
    }
    abstract void enrichProperies();

    abstract String print();
}
