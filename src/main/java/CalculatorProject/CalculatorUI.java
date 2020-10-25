package CalculatorProject;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CalculatorUI {
    private final CalculatorEngine engine;
    
    public CalculatorUI(CalculatorEngine engine) {
        this.engine = engine;
    }

    private Button buttonForKey(Key key) {
        Button button = new Button(key.display);

        return button;
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

        TextField displayTextField = new TextField();
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

        Scene scene = new Scene(grid, 300, 275);
        stage.setScene(scene);

    }


}
