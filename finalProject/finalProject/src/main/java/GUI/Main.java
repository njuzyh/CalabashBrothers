package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("葫芦娃");
        /*
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/FXML/CalabashWorld.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setScene(new Scene(root, 600, 650));
        primaryStage.show();*/
        primaryStage.setResizable(false);
        StartPageController startPageController = new StartPageController();
        startPageController.init(primaryStage);
    }
}
