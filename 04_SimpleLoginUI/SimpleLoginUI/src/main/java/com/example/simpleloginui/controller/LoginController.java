package com.example.simpleloginui.controller;

import com.example.simpleloginui.index;
import com.example.simpleloginui.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    TextField tf_username;
    @FXML
    PasswordField pf_password;
    @FXML
    Label lb_error;

    ArrayList<User> listUser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listUser = new ArrayList<>();
        listUser.add(new User("levietthanh", "123456"));
    }

    public void onLoginClick(ActionEvent actionEvent) throws IOException {
        String username = tf_username.getText();
        String password = pf_password.getText();
        if(username.trim().equals("")){
            lb_error.setText("Hãy nhập tên đăng nhập!");
            return;
        }
        if(password.trim().equals("")){
            lb_error.setText("Hãy nhập mật khẩu!");
            return;
        }

        for(int i = 0; i < listUser.size(); i++){
            User user = listUser.get(i);
            if(!username.equals(user.getUsername())){
                lb_error.setText("Tên đăng nhập không tồn tại!");
                pf_password.setText("");
                return;
            }
            else if (!password.equals(user.getPassword())){
                lb_error.setText("Nhập sai mật khẩu!");
                pf_password.setText("");
                return;
            }
            else{
                Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(index.class.getResource("home-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 700, 500);
                stage.setTitle("Home");
                stage.setScene(scene);
                stage.show();
            }
        }
    }
}
