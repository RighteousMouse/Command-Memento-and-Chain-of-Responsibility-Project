package hw3.Handler;


import hw3.Command.Color;
import hw3.Command.CommandList;
import hw3.Shapes.ShapeColors;
import hw3.Shapes.ShapeManager;

public class ColorHandler implements Handler {
    private Handler nextHandler;
    private ShapeManager receiver;
    private CommandList commandList;
    private Color colorCommand;

    public ColorHandler(ShapeManager receiver, CommandList commandList) {
        this.receiver = receiver;
        this.commandList = commandList;

    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String[] input) {
        if(!input[0].equalsIgnoreCase("COLOR")) {
            nextHandler.handleRequest(input);
            return;
        }

        if(!ShapeColors.inShapeColors(input[1])) {
            System.out.println("ERROR: Invalid color change attempted -> " + input[1]);
            return;
        }
            this.colorCommand = new Color(receiver,ShapeColors.setShapeColors(input[1]));
            colorCommand.execute();
            commandList.pushCommand(colorCommand);
    }    
}
