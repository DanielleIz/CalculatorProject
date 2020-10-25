package CalculatorProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.application.Application;
import javafx.stage.Stage;

public class CalculatorApp extends Application {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void start(Stage stage) {
        logger.error("HEY YA");
        logger.warn("Woo hoo");
        logger.info("waht");
        logger.debug("no");
        CalculatorEngine engine = new CalculatorEngine();
        CalculatorUI ui = new CalculatorUI(engine);
        ui.populateStage(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}