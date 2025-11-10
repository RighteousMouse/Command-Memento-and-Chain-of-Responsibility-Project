package hw3.Command;

import hw3.Shapes.ShapeManager;

public class Move implements Command {
    private final ShapeManager receiver;
    private final int newX;
    private final int newY;
    private final int mementoX;
    private final int mementoY;

    public Move(ShapeManager receiver, int newX, int newY) {
        this.receiver = receiver;
        this.newX = newX;
        this.newY = newY;
        this.mementoX = receiver.getSelectedShape().getOriginX();
        this.mementoY = receiver.getSelectedShape().getOriginY(); 
    }

    @Override
    public void execute() {
        receiver.changeShapeOrigin(newX, newY);
    }

    @Override
    public void undo() {
        receiver.changeShapeOrigin(mementoX, mementoY);
    }
    
}
