package View;

import Model.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.time.LocalDate;

public class UpdateUserController extends UserController {

    public javafx.scene.control.TableColumn t_userName;

    public static User currentUser ;

    public void show(){
        userPassword.setText("123");
        userFirstName.setText(currentUser.getFirst_name());
        userLastName.setText(currentUser.getLast_name());
        userCity.setText(currentUser.getCity());
        userBirthDate.setValue(LocalDate.parse(currentUser.getDate()));
    }

    public void updateUserData() {
        String password = userPassword.getText();
        String firstName = userFirstName.getText();
        String lastName = userLastName.getText();
        String city = userCity.getText();
        String birthDate = userBirthDate.getValue().toString();
        User updatedUser = new User(userName.getText(), password, firstName, lastName,city , birthDate);
        updatedUser.printUser();
        //controller.updateUser(updatedUser);
    }


}