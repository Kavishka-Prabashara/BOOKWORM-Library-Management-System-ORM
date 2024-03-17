package lk.ijse.bookworm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/login-page.fxml"))));
        stage.centerOnScreen();
        stage.setTitle("Library Management System");
        stage.fullScreenProperty();
        stage.setResizable(false);

        stage.show();

    }
}
