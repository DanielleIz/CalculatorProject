package CalculatorProject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    @Override
    public void start(Stage stage) {
        CalculatorEngine engine = new CalculatorEngine();
        CalculatorUI ui = new CalculatorUI(engine);
        ui.populateStage(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}