package id.ac.upj.tif.pbo_uas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
public class login_aplikasi {
    public login_aplikasi() {

    }

    @FXML
    private Button button_start;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField text_username;
    @FXML
    private PasswordField text_password;



    public void OnClickButtonStart(ActionEvent event) throws IOException {
        checkLogin();

    }

    private void checkLogin() throws IOException {
        HelloApplication m = new HelloApplication();
        if(text_username.getText().toString().equals("HabibAlhuda") && text_password.getText().toString().equals("123")) {
            m.changeScene("hello-view.fxml");
        }

    }
}
