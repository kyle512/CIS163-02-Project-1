package project1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**********************************
 *
 * FX version
 */
public class GEOCDTGUIFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        String cssLayout = "-fx-border-color: Black;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n";

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.getChildren().add (new GEOCDTPanelFX());

        root.setSpacing(60);

        root.setStyle(cssLayout);
        primaryStage.setTitle("GEO Count Down Timer");
        primaryStage.setScene(new Scene(root, 1200, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}