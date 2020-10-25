package CalculatorProject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculatorEngine {
    private static final Logger logger = LogManager.getLogger();
    private double currentValue;
    private boolean isError;

    public CalculatorEngine() {
        clear();
    }

    public void clear() {
        currentValue = 0.0;
        isError = false;
    }

    public String getDisplayContent() {
        if (isError) {
            return "ERROR";
        } else {
            return Double.toString(currentValue);
        }
    }

	public void keyPressed(Key key) {
        logger.debug("Key pressed: "+key.display);
	}
}
