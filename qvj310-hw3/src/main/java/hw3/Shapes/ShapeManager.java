package hw3.Shapes;

import java.util.ArrayList;
import java.util.List;

public class ShapeManager {
    protected List<Shape> shapes = new ArrayList<>();
    private int nextID = 1;
    private int selectedShapeID = 0;

    //Used in ValidHandler to check if a shape is currently selected to properly
    //pass to the correct nextHandler
    public boolean validShapeID() {
        if(selectedShapeID == 0 || shapes == null || shapes.isEmpty()) {
            return false;
        }
        for(Shape shape: shapes) {
            if (shape.getShapeID() == selectedShapeID) {
                return true;
            }
        }
        return false;
    }
    public boolean isSelectable(int checkID) {
        for (Shape shape: shapes) {
            if (shape.getShapeID() == checkID) {
                return true;
            }
        }
        return false;
    }
    //DISPLAY SHAPES TOSTRINGS
    public void displayShapes() {
        for (Shape shape: shapes) {
            System.out.println(shape.toString());
        }
    }
    //CHANGE SHAPE'S ATTRIBUTES
    public void changeShapeColor(ShapeColors newColor) {
        getSelectedShape().setShapeColor(newColor);
    }
    public void changeShapeOrigin(int x, int y) {
        getSelectedShape().setOrigin(x, y);
    }
    // GETTERS AND SETTERS, SATISFIES DRAW,DRAWSCENE AND SELECT AND UNDO(SELECT).
    public List<Shape> getShapes() {
        return shapes;
    }

    public Shape getSelectedShape() {
        for(Shape shape: shapes) {
            if (this.selectedShapeID == shape.getShapeID()) {
                return shape;
            }
        }
        return null;
    }

    public int getSelectedShapeID() {
        return selectedShapeID;
    }
    
    public void setSelectedShapeID(int selectedShapeID) { 
        this.selectedShapeID = selectedShapeID;
    }
    //ADD AND REMOVE SHAPES FROM LIST, SATISFIES CREATES AND DELETE.
    public void addShape(Shape newShape) {
        shapes.add(newShape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }
    //USE WITH CREATE COMMAND TO ASSIGN THE CORRECT ID
    public void assignID(Shape shape) {
        //Shape ID should start at 1
        shape.setShapeID(nextID);
    }
    //USE WITH ASSIGNID WHEN CREATING A NEW SHAPE
    public void incrementID() {
        this.nextID ++;
    }
    //USE WHEN UNDOING CREATE SHAPE TO PROPERLY RESTORE ID
    public void decrementID() {
        this.nextID --;
    }
}
