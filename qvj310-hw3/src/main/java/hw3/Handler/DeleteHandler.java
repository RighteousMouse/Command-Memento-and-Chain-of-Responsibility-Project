package hw3.Handler;

import hw3.Command.CommandList;
import hw3.Command.Delete;
import hw3.Shapes.ShapeManager;

public class DeleteHandler implements Handler{
    private Handler nextHandler;
    private CommandList commandList;
    private Delete deleteCommand;
    private ShapeManager receiver;

    public DeleteHandler(ShapeManager receiver, CommandList commandList) {
        this.receiver = receiver;
        this.commandList = commandList;
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String input[]) {
        if(!input[0].equalsIgnoreCase("DELETE")) {
            nextHandler.handleRequest(input);
            return;
        }

        deleteCommand = new Delete(receiver);
        deleteCommand.execute();
        commandList.pushCommand(deleteCommand);
    }
    
}
