package lk.ijse.bookworm.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Optional;

public class DashboardController {

    public AnchorPane anchorPane;
    @FXML
    private Text txtBookCount;

    @FXML
    private Text txtBranchCount;

    @FXML
    private Text txtMemberCount;



    public void mouseClickOnAction(MouseEvent mouseEvent) {
        Stage stage = (Stage) txtBookCount.getScene().getWindow();
        stage.close();
    }

    public void logoutOnAction(MouseEvent mouseEvent) throws IOException {
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        Optional<ButtonType> result = new Alert(Alert.AlertType.INFORMATION, "Are you sure to Logout?", yes, no).showAndWait();

        if (result.orElse(no) == yes) {
            Parent rootNode =FXMLLoader.load(getClass().getResource("/view/loginPage.fxml"));
            Stage stage = (Stage) txtBookCount.getScene().getWindow();

            Scene scene=new Scene(rootNode);
            stage.setScene(scene);
            stage.centerOnScreen();

        }
    }

    public void historyOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootNOde = FXMLLoader.load(getClass().getResource("/view/historyManage.fxml"));
        Scene scene = new Scene(rootNOde);
        Stage stage = (Stage) txtBookCount.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void timeOutOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootNOde = FXMLLoader.load(getClass().getResource("/view/timeOutManage.fxml"));
        Scene scene = new Scene(rootNOde);
        Stage stage = (Stage) txtBookCount.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
