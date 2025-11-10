package hw3.Shapes;

public enum ShapeColors {
    RED("Red"),
    BLUE("Blue"),
    YELLOW("Yellow"),
    ORANGE("Orange"),
    GREEN("Green");

    private String color;

    private ShapeColors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public static ShapeColors setShapeColors(String color) {
        for(ShapeColors shapeColor: ShapeColors.values()) {
            if(shapeColor.getColor().equalsIgnoreCase(color)) {
                return shapeColor;
            }
        }
        return null;
    }

    public static boolean inShapeColors(String word) {
        for(ShapeColors color: ShapeColors.values()) {
            if(color.getColor().equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }
   
}
