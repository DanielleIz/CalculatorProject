package CalculatorProject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CalculatorUI {
    private static final Logger logger = LogManager.getLogger();
    private final CalculatorEngine engine;
    private TextField displayTextField;
    private VBox displayStack;

    // Useful tutorial on JavaFX: https://docs.oracle.com/javafx/2/get_started/jfxpub-get_started.htm
    // More info on JavaFX: https://fxdocs.github.io/docs/book.pdf
    // And even more: https://docs.oracle.com/javase/8/javase-clienttechnologies.htm
    public CalculatorUI(CalculatorEngine engine) {
        this.engine = engine;
    }

    private Button buttonForKey(final Key key) {
        Button button = new Button(key.display);
        button.setOnAction(evt -> {
            engine.keyPressed(key);
            updateDisplay();
        });
        return button;
    }

    private void updateDisplay() {
        String content = engine.getDisplayContent();
        if (content == null) {
            content = "ERR!";
        }
        if (displayTextField == null) {
            logger.error("no display text field");
        } else {
            displayTextField.setText(content);
        }
        if (displayStack == null) {
            logger.error("no stack display");
        } else {
            displayStack.getChildren().clear();
            displayStack.getChildren().add(new Text("Stack"));
            Iterator<Long> stackIterator = engine.iterateStack();
            while (stackIterator.hasNext()) {
                displayStack.getChildren().add(new Text(stackIterator.next().toString()));
            }
        }
    }

    public void populateStage(Stage stage) {
        stage.setTitle("This is a Calculator");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text scenetitle = new Text("Calculator App");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 4, 1);

        this.displayTextField = new TextField();
        updateDisplay();
        grid.add(displayTextField, 0, 1, 4, 1);

        Button clearButton = buttonForKey(Key.CLEAR);
        grid.add(clearButton, 3, 2);
        for (int row=0; row<3; ++row) {
            for (int col=0; col<3; ++col) {
                Key key = KeyMap.keyForCode((2-row)*3 + col + 1);
                Button numButton = buttonForKey(key);
                grid.add(numButton, col, row+3);
            }
        }
        for (int row = 0; row < 4; ++row) {
            Button operatorButton = buttonForKey(KeyMap.keyForCode(Key.PLUS.code + row));
            grid.add(operatorButton, 3, row + 3);
        }
        Button zeroButton = buttonForKey(Key.NUM_0);
        grid.add(zeroButton, 0, 6);
        Button negateButton = buttonForKey(Key.NEGATE);
        grid.add(negateButton, 1, 6);
        Button enterButton = buttonForKey(Key.ENTER);
        grid.add(enterButton, 3, 6);
        this.displayStack = new VBox();
        displayStack.setId("displayStack");
        displayStack.getChildren().add(new Text("Stack"));
        grid.add(displayStack, 4, 0, 1, 8);
        Scene scene = new Scene(grid, 300, 275);
        scene.getStylesheets().add(CalculatorUI.class.getResource("/calculator.css").toExternalForm());
        stage.setScene(scene);

    }


}
