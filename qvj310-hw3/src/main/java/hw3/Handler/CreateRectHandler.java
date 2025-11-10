package hw3.Handler;

import hw3.Command.CommandList;
import hw3.Command.CreateRectangle;
import hw3.Shapes.ShapeManager;

public class CreateRectHandler implements Handler {
    private Handler nextHandler;
    private CommandList commandList;
    private CreateRectangle createRecCommand;
    private ShapeManager receiver;

    public CreateRectHandler(ShapeManager receiver, CommandList commandList) {
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
            !input[1].equalsIgnoreCase("RECTANGLE")) {
            nextHandler.handleRequest(input);
            return;
        }

        int width = Integer.parseInt(input[2]);
        int height = Integer.parseInt(input[3]);

        createRecCommand = new CreateRectangle(receiver, width, height);
        createRecCommand.execute();
        commandList.pushCommand(createRecCommand);
    }

}