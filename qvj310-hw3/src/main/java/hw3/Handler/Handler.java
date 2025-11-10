package hw3.Handler;

public interface Handler {
    
    public void setNextHandler(Handler nextHandler);

    public void handleRequest(String[] input);
    
}
