package CalculatorProject;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculatorEngine {
    private static final Logger logger = LogManager.getLogger();
    private long currentValue;

    private Deque<Long> stack;
    private boolean isError;

    public CalculatorEngine() {
        this.stack = new LinkedList<Long>();
        clear();
    }

    public void clear() {
        // TODO: when we clear the state of the calculator, what needs to happen?
    }

    public Iterator<Long> iterateStack() {
        return stack.iterator();
    }

    public String getDisplayContent() {
        if (isError) {
            return "ERROR";
        } else {
            return Long.toString(currentValue);
        }
    }

    private void controlKeyPressed(Key key) {
        switch (key) {
            case CLEAR:
                // TODO: What should we do when the user hits the CLR button?
                break;
            case ENTER:
                // TODO: What should we do when the user hits the Enter button?
                break;
            case NEGATE:
                // TODO: What should we do when the user hits the +/- button?
                break;
            default:
                logger.error("unexpected control key: "+key);
        }
    }

    private void operatorKeyPressed(Key key) {
        // Operators need a value on the stack to apply to the currentValue
        if (stack.isEmpty()) {
            logger.error("Attempting to pop empty stack");
            isError = true;
            currentValue = 0;
            return;
        }
        long operand = stack.pop();
        switch (key) {
            case PLUS:
                // TODO: What should we do when the user hits +?
                break;
            case MINUS:
                // TODO: What should we do when the user hits -?
                break;
            case TIMES:
                // TODO: What should we do when the user hits *?
                break;
            case DIVIDE:
                // TODO: What should we do when the user hits /?
                break;
            default:
                logger.error("unexpected operator key: "+key);
        }
    }
    public void keyPressed(Key key) {
        logger.debug("Key pressed: " + key.display);
        switch (key.keyType) {
            case DIGIT:
                // TODO: What should we do when the user hits a digit key?
                break;
            case OPERATOR:
                operatorKeyPressed(key);
                break;
            case CONTROL:
                controlKeyPressed(key);
                break;
            default:
                logger.error("Unhandled case");
        }
    }
}
