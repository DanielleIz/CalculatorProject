package CalculatorProject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculatorEngine {
    private static final Logger logger = LogManager.getLogger();

    // TODO: implement these methods
    public void init() {
        
    }

    public String getDisplayContent() {
        return null;
    }
    
	public void keyPressed(Key key) {
        logger.info("Key pressed: "+key.display);
	}
}
