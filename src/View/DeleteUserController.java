package View;

import javafx.scene.control.Alert;

public class DeleteUserController extends UserController {
    public javafx.scene.control.TextField userName;
    public javafx.scene.control.TextField userPassword;
    public javafx.scene.control.Button delete;
    public javafx.scene.control.Button clear;

    public boolean userAuthentication()
    {
        return true;
        //return userAuthentication(userName.getText(), userPassword.getText()); // of controller
    }

    public void deleteUser() {
        if (searchUserData(userName.getText()) != null)
        {
            deleteUser(); // of controller
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("The user is deleted.");
            a.show();
        }
        else
        {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("You entered user that not exist, please enter again");
            a.show();
            return;
        }
        return;
    }
}
