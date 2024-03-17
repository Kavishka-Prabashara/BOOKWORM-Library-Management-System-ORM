package lk.ijse.bookworm.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.bookworm.Bo.BoFactory;
import lk.ijse.bookworm.Bo.Custom.AdminBo;
import lk.ijse.bookworm.Dto.AdminDto;

import java.io.IOException;
import java.util.Objects;

public class SignUpController {

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private Hyperlink hypLogin;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtConfirmPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private Text txtID;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;


    private AdminBo adminBo = (AdminBo) BoFactory.getBoFactory().getBo(BoFactory.BOTypes.ADMIN);

    public void initialize(){

        genarateNextAdminId();
    }

    private void genarateNextAdminId() {

        try{

            String id = adminBo.genarateNextAdminId();
            txtID.setText(id);

        }catch (Exception e){

        }
    }



    @FXML
    void nameOnAction(ActionEvent event) {
        txtPassword.requestFocus();

    }




    public void btnSignUpOnAction(ActionEvent actionEvent) {
        String email= txtEmail.getText();
        String name = txtUserName.getText();
        String password = txtPassword.getText();
        String id = txtID.getText();

        /*System.out.println(name);*/

        if(name.equals("") || password.equals("")){
            new Alert(Alert.AlertType.ERROR,"fields are empty").show();
            return;
        }

        try{

            boolean isSaved = adminBo.saveCustomer(new AdminDto(id,name,password));

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION,"Saved successfully").show();
                initialize();
                Parent load= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/login-page.fxml")));
                root.getChildren().clear();
                root.getChildren().add(load);


                String subject = "Welcome to BookWorm Library!";
                String body = "\t\t\tCongratulation! "+email +"Your account has been successfully created!"+"\n\nYour User Name is :" +name+"\n"+"Your Password is :"+password;
                EmailServiceController.sendEmail(email, subject, body);
            }else{
                new Alert(Alert.AlertType.ERROR,"Saved failed").show();
            }

        }catch (Exception e){

        }

    }

    public void hypLoginOnAction(ActionEvent actionEvent) throws IOException {
        Parent load= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/login-page.fxml")));
        root.getChildren().clear();
        root.getChildren().add(load);
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Parent load= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/login-page.fxml")));
        root.getChildren().clear();
        root.getChildren().add(load);
    }
}