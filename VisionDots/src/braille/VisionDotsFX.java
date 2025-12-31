package braille;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VisionDotsFX extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("VISION DOTS");
        title.setFont(Font.font(28));

        Label subtitle = new Label("Text to Braille Conversion System");

        TextArea input = new TextArea();
        input.setPromptText("Enter text here...");
        input.setPrefHeight(100);

        TextArea output = new TextArea();
        output.setEditable(false);
        output.setPrefHeight(200);

        Button convert = new Button("Convert to Braille");
        convert.setPrefWidth(220);

        convert.setOnAction(e -> {
            try {
                TextToBraille tb = new TextToBraille();
                output.setText(tb.convertText(input.getText()));
            } catch (Exception ex) {
                output.setText("Error: " + ex.getMessage());
            }
        });

        VBox layout = new VBox(15, title, subtitle, input, convert, output);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: #F8FAFC;");

        stage.setTitle("Vision Dots – JavaFX");
        stage.setScene(new Scene(layout, 720, 540));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
