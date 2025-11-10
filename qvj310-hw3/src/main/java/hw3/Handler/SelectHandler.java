package hw3.Handler;

import hw3.Command.CommandList;
import hw3.Command.Select;
import hw3.Shapes.ShapeManager;

public class SelectHandler implements Handler {
    private Handler nextHandler;
    private Select selectCommand;
    private CommandList commandList;
    private ShapeManager receiver;

    public SelectHandler(ShapeManager receiver, CommandList commandList) {
        this.receiver = receiver;
        this.commandList = commandList;
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String[] input) {
        if(!input[0].equalsIgnoreCase("SELECT")) {
            nextHandler.handleRequest(input);
            return;
        }
        int checkID = Integer.parseInt(input[1]);
        if(!receiver.isSelectable(checkID)) {
            System.out.println("ERROR: invalid shape for SELECT");
            return;
        }
        int shapeID = Integer.parseInt(input[1]);
        selectCommand = new Select(receiver, shapeID);
        selectCommand.execute();
        commandList.pushCommand(selectCommand);
    }
    
}
