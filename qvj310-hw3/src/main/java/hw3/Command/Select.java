package hw3.Command;

import hw3.Shapes.ShapeManager;

public class Select implements Command {
    private final ShapeManager receiver;
    private final int newID;
    private final int mementoID;

    public Select(ShapeManager receiver, int newID) {
        this.receiver = receiver;
        this.newID = newID;
        this.mementoID = receiver.getSelectedShapeID();
    }

    @Override
    public void execute() {
        receiver.setSelectedShapeID(newID);
    }

    @Override
    public void undo() {
        receiver.setSelectedShapeID(mementoID);
    }
    
}
