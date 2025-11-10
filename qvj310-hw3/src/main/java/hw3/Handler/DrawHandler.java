package hw3.Handler;

import hw3.Command.CommandList;
import hw3.Command.Draw;
import hw3.Shapes.ShapeManager;

public class DrawHandler implements Handler {
    private Handler nextHandler;
    private Draw drawCommand;
    private CommandList commandList;
    private ShapeManager receiver;

    public DrawHandler(ShapeManager receiver, CommandList commandList) {
        this.receiver = receiver;
        this.commandList = commandList;
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String[] input) {
        if (!input[0].equalsIgnoreCase("DRAW")) {
            nextHandler.handleRequest(input);
            return;
        }
        drawCommand = new Draw(receiver);
        drawCommand.execute();
        commandList.pushCommand(drawCommand);

    }
    
}
