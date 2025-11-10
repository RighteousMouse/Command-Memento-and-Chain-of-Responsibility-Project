package hw3.Command;

import hw3.Shapes.ShapeManager;

public class Draw implements Command {
    private final ShapeManager receiver;

    public Draw(ShapeManager receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println(receiver.getSelectedShape().toString());        
    }

    @Override
    public void undo() {
        System.out.println("Draw: Undo does nothing...");   
    }
    
}
