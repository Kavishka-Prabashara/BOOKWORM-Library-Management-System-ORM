package lk.ijse.bookworm.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.bookworm.Bo.BoFactory;
import lk.ijse.bookworm.Bo.Custom.AdminBo;
import lk.ijse.bookworm.Bo.Custom.impl.AdminBoImpl;
import lk.ijse.bookworm.Dto.AdminDto;

import java.io.IOException;
import java.util.Objects;

public class LoginPageControllar {
    @FXML
    private JFXButton btnLogin;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtPasswordLogin;

    @FXML
    private TextField txtUserNameLogin;

    public AnchorPane AnchorPane;


    AdminBo adminBo = (AdminBo) BoFactory.getBoFactory().getBo(BoFactory.BOTypes.ADMIN);


    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        String name = txtUserNameLogin.getText();
        String password = txtPasswordLogin.getText();


        if (name.isEmpty() || password.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"fields are empty").show();
            return;
        }


        boolean isTrue = false;
        try {
            isTrue = adminBo.check(new AdminDto("",name,password));
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Check UserName or Password").show();
            throw new RuntimeException(e);
        }

        if (isTrue) {
            Parent load= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/dashboard-page.fxml")));
            root.getChildren().clear();
            root.getChildren().add(load);
        }else{
            new Alert(Alert.AlertType.ERROR,"Check USerName or Password").show();
        }
    }

    @FXML
    void hypForgetPassword(ActionEvent event) throws IOException {
        Parent load= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Dashboard.fxml")));
        root.getChildren().clear();
        root.getChildren().add(load);

    }

    @FXML
    void hypSignUp(ActionEvent event) throws IOException {
        Parent load= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/signUp-page.fxml")));
        root.getChildren().clear();
        root.getChildren().add(load);

    }







}