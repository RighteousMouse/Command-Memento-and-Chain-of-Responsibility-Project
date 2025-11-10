package hw3.Command;

import java.util.LinkedList;

public class CommandList {
    private LinkedList<Command> commands; 

    public CommandList(LinkedList<Command> commands) {
        this.commands = new LinkedList<>();
    }

    public void undoCommand() {
        commands.getLast().undo();
        popCommand();
    }

    public void pushCommand(Command command) {
        commands.addLast(command);
    }

    public void popCommand() {
        commands.removeLast();
    }
    
}
