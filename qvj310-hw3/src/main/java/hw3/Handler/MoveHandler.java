package hw3.Handler;

import hw3.Command.CommandList;
import hw3.Command.Move;
import hw3.Shapes.ShapeManager;

public class MoveHandler implements Handler {
    private Handler nextHandler;
    private Move moveCommand;
    private CommandList commandList;
    private ShapeManager receiver;

    public MoveHandler(ShapeManager receiver, CommandList commandList) {
        this.receiver = receiver;
        this.commandList = commandList;
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String[] input) {

        if(!input[0].equalsIgnoreCase("MOVE")) {
            nextHandler.handleRequest(input);
            return;
        }

        int xOrigin = Integer.parseInt(input[1]);
        int yOrigin = Integer.parseInt(input[2]);

        moveCommand = new Move(receiver, xOrigin, yOrigin);
        moveCommand.execute();
        commandList.pushCommand(moveCommand);
    }
    
}
