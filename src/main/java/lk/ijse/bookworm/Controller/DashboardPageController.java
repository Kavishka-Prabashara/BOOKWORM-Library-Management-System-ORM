package lk.ijse.bookworm.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class DashboardPageController implements Initializable {

    @FXML
    private JFXButton btnBookManagement;

    @FXML
    private JFXButton btnBranchManagement;

    @FXML
    private JFXButton btnSettings;

    @FXML
    private JFXButton btnUserManagement;

    @FXML
    private Hyperlink hypLogout;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private Text txtBookCount;

    @FXML
    private Text txtBranchCount;

    @FXML
    private Text txtMemberCount;
    @FXML
    private Label lblUserName;
    @FXML
    private AnchorPane pane;

    @FXML
    private AnchorPane root;

    public void initialize() throws IOException {
        Parent load= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Dashboard.fxml")));
        pane.getChildren().clear();
        pane.getChildren().add(load);
    }


    public void btnBookManagementOnAction(ActionEvent actionEvent) throws IOException {
        Parent load= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/bookManage.fxml")));
        pane.getChildren().clear();
        pane.getChildren().add(load);

    }

    public void btnUserManagement(ActionEvent actionEvent) throws IOException {
        Parent load= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/memberManage.fxml")));
        pane.getChildren().clear();
        pane.getChildren().add(load);

    }

    public void btnBranchManagementOnAction(ActionEvent actionEvent) throws IOException {
        Parent load= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/branchManage.fxml")));
        pane.getChildren().clear();
        pane.getChildren().add(load);

    }

    public void btnBorrowOnAction(ActionEvent actionEvent) throws IOException {
        Parent load= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/borrowManage.fxml")));
        pane.getChildren().clear();
        pane.getChildren().add(load);


    }

    public void hypLogoutOnAction(ActionEvent actionEvent) throws IOException {

        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        Optional<ButtonType> result = new Alert(Alert.AlertType.INFORMATION, "Are you sure to Logout?", yes, no).showAndWait();

        if (result.orElse(no) == yes) {

        Parent load= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/login-page.fxml")));
        root.getChildren().clear();
        root.getChildren().add(load);


        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize date and time
        generateDate();
        generateTime();

        // Create a Timeline to update date and time every second
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            generateDate();
            generateTime();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void generateTime() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        lblTime.setText(LocalTime.now().format(timeFormatter));
    }

    private void generateDate() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        lblDate.setText(LocalDate.now().format(dateFormatter));
    }

    public void btnDashBoardManagementOnAction(ActionEvent actionEvent) throws IOException {
        Parent load= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Dashboard.fxml")));
        pane.getChildren().clear();
        pane.getChildren().add(load);
    }
}
