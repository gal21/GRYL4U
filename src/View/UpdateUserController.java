package View;

import Model.User;

public class UpdateUserController extends UserController {
    public javafx.scene.control.Button update;
    public ReadUserController rUC;

    public void updateUserData() {
        String userName = "";//userName.getText();
        String password = userPassword.getText();
        String firstName = userFirstName.getText();
        String lastName = userLastName.getText();
        String userCity = ""; //userCity.getText();
        String userBirthDate = "";

        User updatedUser = new User(userName, password, firstName, lastName, userCity, userBirthDate);

    }
}