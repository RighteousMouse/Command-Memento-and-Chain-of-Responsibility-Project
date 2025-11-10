package hw3.Handler;

import hw3.Command.CommandList;

public class UndoHandler implements Handler {
    private Handler nextHandler;
    private CommandList commandList;

    public UndoHandler(CommandList commandList) {
        this.commandList = commandList;
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String[] input) {
        if(!input[0].equalsIgnoreCase("UNDO")) {
            nextHandler.handleRequest(input);
            return;
        }
        commandList.undoCommand();
    }
    
}
