package hw3.Handler;

import hw3.Command.CommandList;
import hw3.Shapes.ShapeManager;

public class OrderHandler {
    private CommandList commandList;
    private ShapeManager receiver;
    private Handler firstHandler;

    public OrderHandler(ShapeManager receiver, CommandList commandList) {
        this.receiver = receiver;
        this.commandList = commandList;

        CreateCircHandler createCircleHandler = new CreateCircHandler(receiver, commandList);
        CreateRectHandler createRectangleHandler = new CreateRectHandler(receiver, commandList);
        SelectHandler selectHandler = new SelectHandler(receiver, commandList);
        MoveHandler moveHandler = new MoveHandler(receiver, commandList);
        ColorHandler colorHandler = new ColorHandler(receiver, commandList);
        DrawHandler drawHandler = new DrawHandler(receiver, commandList);
        DrawSceneHandler drawSceneHandler = new DrawSceneHandler(receiver, commandList);
        DeleteHandler deleteHandler = new DeleteHandler(receiver, commandList);
        //UNDO does not require access to ShapeManager AKA the "receiver"
        UndoHandler undoHandler = new UndoHandler(commandList);

        //validHandler will determine if input is valid and send to one of two chains
        //Either a chain that will require a shape to be selected or a chain that does not
        //require a shape to be selected
        ValidHandler validHandler = new ValidHandler(receiver, moveHandler,createCircleHandler);
        this.firstHandler = validHandler;

        //first Chain: if Select is required validHandler will setNextHandler to Move 
        moveHandler.setNextHandler(colorHandler);
        colorHandler.setNextHandler(drawHandler);
        drawHandler.setNextHandler(deleteHandler);
        deleteHandler.setNextHandler(null);
        

        //second Chain: if Select is NOT required, validHandler will setNextHandler to CreateCircle
        createCircleHandler.setNextHandler(createRectangleHandler);
        createRectangleHandler.setNextHandler(selectHandler);
        selectHandler.setNextHandler(undoHandler);
        undoHandler.setNextHandler(drawSceneHandler);
        drawSceneHandler.setNextHandler(null);
    }
    //String[] will contain each string separated by one or more spaces at each index
    public void handleInput(String input) {
        input = input.trim();
        String[] words = input.split("\\s+");
        firstHandler.handleRequest(words);
    }
    
}
