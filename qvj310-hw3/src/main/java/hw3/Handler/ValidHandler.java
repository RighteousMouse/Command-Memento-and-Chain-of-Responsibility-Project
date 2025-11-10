package hw3.Handler;

import hw3.Handler.*;
import hw3.Shapes.ShapeManager;
/*
 * ValidHandler will choose two possible chains, either a chain that would require a shape to be
 * selected or a chain that does not require a shape to be selected.
 */
public class ValidHandler implements Handler {
    private Handler nextHandler;
    private Handler selectChain;
    private Handler nonSelectChain;
    private ShapeManager receiver;
    private Chains chains;

    public ValidHandler(ShapeManager receiver,Handler selectChain, Handler nonSelectChain) {
        this.receiver = receiver;
        this.chains = new Chains();
        this.selectChain = selectChain;
        this.nonSelectChain = nonSelectChain;
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String[] input) {

        if (chooseChain(input[0])) {
            setNextHandler(selectChain);
        } else {
            setNextHandler(nonSelectChain);
        }
        nextHandler.handleRequest(input);
    }
    // return TRUE if a shape IS required
    // return FALSE if a shape IS NOT required
    public boolean chooseChain(String word) {
        if(chains.inSelectChain(word)) {
            if(!shapeSelected()) {
            throw new IllegalArgumentException("ERROR: invalid shape SELECTED");
        }
            return true;
        }
        if(chains.inNonSelectChain(word)) {
            return false;
        }
        throw new IllegalArgumentException("ValidHandler: unknown command word detected ->" + word); 
    }

    public boolean shapeSelected() {
        return receiver.validShapeID();
    }

}
