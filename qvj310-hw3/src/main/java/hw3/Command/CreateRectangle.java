package hw3.Command;

import hw3.Shapes.Rectangle;
import hw3.Shapes.ShapeManager;

public class CreateRectangle implements Command {
    private final ShapeManager receiver;
    private final Rectangle newRectangle;

    public CreateRectangle(ShapeManager receiver, int width, int height) {
        this.receiver = receiver;
        newRectangle = new Rectangle(0, width, height);
    }

    @Override
    public void execute() {
        receiver.assignID(newRectangle);
        receiver.addShape(newRectangle);  
        receiver.incrementID();      
    }

    @Override
    public void undo() {
        receiver.removeShape(newRectangle);
        receiver.decrementID(); 
    }
    
}
