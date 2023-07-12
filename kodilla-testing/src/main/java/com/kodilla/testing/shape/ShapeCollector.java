package com.kodilla.testing.shape;


import com.kodilla.testing.shape.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    Shape shape;
    private List<Shape> shapeList = new ArrayList<>();

    public ShapeCollector(Shape shape) {
        this.shape = shape;
    }

    public Shape getShape() {
        return shape;
    }

    public void addFigure(Shape shape) {
        shapeList.add(getShape());
    }
    public boolean removeFigure(Shape shape) {
       boolean result = false;
       if (shapeList.contains(getShape())) {
           shapeList.remove(getShape());
           result = true;
       }
       return result;
    }

    public Shape getFigure(int shapeNumber) {

        if (shapeNumber >= 0 && shapeNumber < shapeList.size()) {
            return shapeList.get(shapeNumber);
        }
        return shapeList.get(shapeNumber);
    }
    public boolean showFigures() {
        boolean print = false;
        if(shapeList.size()>0) {
            for (Shape figure : shapeList) {
                this.shape.getShapeName();
                this.shape.getField();
            }
            print = true;
        }
        return print;
    }


    public int getFigureQuantity() {
        return shapeList.size();
    }
}
