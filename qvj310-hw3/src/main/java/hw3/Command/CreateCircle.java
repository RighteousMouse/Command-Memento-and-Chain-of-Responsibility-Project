package hw3.Command;

import hw3.Shapes.Circle;
import hw3.Shapes.ShapeManager;

public class CreateCircle implements Command {
    private final ShapeManager receiver;
    private final Circle newCircle;

    public CreateCircle(ShapeManager receiver, int radius) {
        this.receiver = receiver;
        this.newCircle = new Circle(0, radius);
    }

    @Override
    public void execute() {
        receiver.assignID(newCircle);
        receiver.addShape(newCircle);
        receiver.incrementID();
    }

    @Override
    public void undo() {
        receiver.removeShape(newCircle);   
        receiver.decrementID();     
    }
    
}
