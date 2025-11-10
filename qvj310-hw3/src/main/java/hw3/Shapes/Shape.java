package hw3.Shapes;

public class Shape {
    private int shapeID;
    private int originX;
    private int originY;
    private ShapeColors color;

     public Shape(int shapeID, int originX, int originY, ShapeColors color) {
        this.shapeID = shapeID;
        this.originX = originX;
        this.originY = originY;
        this.color = color;
    }
    public int getShapeID() {
        return shapeID;
    }
    public void setShapeID(int shapeID) {
        this.shapeID = shapeID;
    }
     public int getOriginX() {
        return this.originX;
    }
    public int getOriginY() {
        return this.originY;
    }
    public void setOrigin(int x, int y) {
        this.originX = x;
        this.originY = y;
    }
    public ShapeColors getShapeColor() {
        return this.color;
    }
    public void setShapeColor(ShapeColors newColor) {
        this.color = newColor;
    }

    public String displayOrigin() {
        String origin = "(" + originX + "," + originY + ")";
        return origin;
    }
    @Override
    public String toString() {
        return "Color: " + getShapeColor().getColor() + ", Origin: " + displayOrigin() + "," ;
    }

    
    
}
