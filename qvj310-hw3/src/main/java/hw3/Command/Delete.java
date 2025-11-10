package hw3.Command;

import hw3.Shapes.Shape;
import hw3.Shapes.ShapeManager;

public class Delete implements Command {
    private final ShapeManager receiver;
    private final Shape mementoShape;

    public Delete(ShapeManager receiver) {
        this.receiver = receiver;
        this.mementoShape = receiver.getSelectedShape();
    }

    @Override
    public void execute() {
        receiver.removeShape(receiver.getSelectedShape());
    }

    @Override
    public void undo() {
        receiver.addShape(mementoShape);        
    }
    
}
