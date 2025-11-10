package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import hw3.Command.*;
import hw3.Handler.OrderHandler;
import hw3.Shapes.*;

public class ShapeEditor {
    public static void main(String[] args) {
        LinkedList<Command> stackCommands = new LinkedList<>();
        String fileName = args[0];
        File inputFile = new File(fileName);
        
        ShapeManager mgr = new ShapeManager();
        CommandList commandList = new CommandList(stackCommands);
        OrderHandler orderHandler = new OrderHandler(mgr, commandList);

        try (Scanner scan = new Scanner(inputFile);){
            while(scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                orderHandler.handleInput(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("SCAN ERROR: file did not scan -> " + e.getMessage());
        }
    }
}
