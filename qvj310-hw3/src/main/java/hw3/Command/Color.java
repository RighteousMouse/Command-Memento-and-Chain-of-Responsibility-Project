package hw3.Command;

import hw3.Command.CommandList;
import hw3.Shapes.ShapeColors;
import hw3.Shapes.ShapeManager;

public class Color implements Command {
    private final ShapeColors mementoColor;
    private final ShapeColors newColor;
    private final ShapeManager receiver;

    public Color(ShapeManager receiver, ShapeColors newColor) {
        this.receiver = receiver;
        this.mementoColor = receiver.getSelectedShape().getShapeColor();
        this.newColor = newColor;
    }

    @Override
    public void execute() {
        receiver.changeShapeColor(newColor);
    }

    @Override
    public void undo() {
        receiver.changeShapeColor(mementoColor);        
    }
    
}
