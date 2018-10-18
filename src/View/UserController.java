package View;

import javafx.scene.control.Alert;

import java.time.LocalDate;

public class UserController {
    public javafx.scene.control.TextField userName = null;
    public javafx.scene.control.TextField userPassword;
    public javafx.scene.control.TextField userFirstName;
    public javafx.scene.control.TextField userLastName;
    public javafx.scene.control.TextField userCity = null;
    public javafx.scene.control.DatePicker userBirthDate;
    public javafx.scene.control.Button show;
    public javafx.scene.control.Button clear;

    // Validation checks for the typed user name
    public void validateUserName() {
        show.setDisable(true);
        clear.setDisable(true);
        String name = null;
        try {
            name = userName.getText();
        }
        catch (Exception e)
        {
            if (name == null)
            {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("You didn't entered user name");
                a.show();
                return;
            }
        }
        searchUserData(name);
    }

    // Search the user name string and if exist in the database display the user data
    public void searchUserData(String name)
    {
        // User userDetails = controller.searchUserData(name);
        return;
    }

    // clear all fields from user data, to start new search
    public void clearUserData() {
        userName.clear();
        userPassword.clear();
        userFirstName.clear();
        userLastName.clear();
        userCity.clear();
        userBirthDate.setValue(LocalDate.of(2000, 01, 01));
    }
}
