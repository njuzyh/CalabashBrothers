package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class StartPageController {
    @FXML
    private Button startBtn;
    @FXML
    private Button quitBtn;

    private CalabashWorldController calabashWorldController;

    public void init(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/StartPage.fxml"));
        root.getStylesheets().add(Objects.requireNonNull(getClass().getClassLoader().getResource("CSS/CalabashWorld.css")).toExternalForm());
        Scene scene = new Scene(root, 600, 650);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private void StartGame() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("FXML/CalabashWorld.fxml"));
        Parent root = fxmlLoader.load();
        calabashWorldController = fxmlLoader.getController();
        Scene scene = new Scene(root, 600, 650);
        Stage stage = (Stage)startBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> {
            System.out.println("监听到窗口关闭");
            System.exit(0);
            //calabashWorldController.killAllThread();
        });
        stage.show();
    }

    @FXML
    private void QuitGame() {
        System.out.println("按下了退出游戏");
        System.exit(0);
    }
}
