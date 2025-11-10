package hw3.Handler;


import hw3.Command.CommandList;
import hw3.Command.DrawScene;
import hw3.Shapes.ShapeManager;

public class DrawSceneHandler implements Handler {
    private Handler nextHandler;
    private DrawScene drawSceneCommand;
    private CommandList commandList;
    private ShapeManager receiver;

    public DrawSceneHandler(ShapeManager receiver, CommandList commandList) {
        this.receiver = receiver;
        this.commandList = commandList;
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String[] input) {

        if(!input[0].equalsIgnoreCase("DRAWSCENE")) {
            nextHandler.handleRequest(input);
            return;
        }

        drawSceneCommand = new DrawScene(receiver);
        drawSceneCommand.execute();
        commandList.pushCommand(drawSceneCommand);
    }
    
}
