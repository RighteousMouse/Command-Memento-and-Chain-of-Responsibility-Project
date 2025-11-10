package hw3.Shapes;

public class Circle extends Shape {
    private int radius;

    public Circle(int shapeId, int radius) {
        super(shapeId,0, 0, ShapeColors.BLUE);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle, " + super.toString() + " Radius: " + getRadius();
    }

    
    
}
