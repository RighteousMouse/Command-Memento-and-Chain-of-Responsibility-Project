package hw3.Shapes;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int shapeID, int width, int height) {
        super(shapeID, 0, 0, ShapeColors.RED);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle, " + super.toString() + " Width: " + getWidth() + ", Height: " + getHeight();
    }

   

    

    
}
