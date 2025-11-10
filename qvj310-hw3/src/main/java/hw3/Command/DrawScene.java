package hw3.Command;

import hw3.Shapes.ShapeManager;

public class DrawScene implements Command {
    private final ShapeManager receiver;

    public DrawScene(ShapeManager receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.displayShapes();
    }

    @Override
    public void undo() {
        System.out.println("DrawScene: Undo does nothing...");
    }
    
}
