package hw3.Handler;

import hw3.Command.CommandList;
import hw3.Command.CreateCircle;
import hw3.Shapes.ShapeManager;

public class CreateCircHandler implements Handler {
    private Handler nextHandler;
    private CommandList commandList;
    private CreateCircle createCirCommand;
    private ShapeManager receiver;

    public CreateCircHandler(ShapeManager receiver, CommandList commandList) {
        this.receiver = receiver;
        this.commandList = commandList;
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String[] input) {
        if (!input[0].equalsIgnoreCase("CREATE") || 
            !input[1].equalsIgnoreCase("CIRCLE")) {
            nextHandler.handleRequest(input);
            return;
        }

        int radius = Integer.parseInt(input[2]);

        createCirCommand = new CreateCircle(receiver, radius);
        createCirCommand.execute();
        commandList.pushCommand(createCirCommand);
    }
    
}
